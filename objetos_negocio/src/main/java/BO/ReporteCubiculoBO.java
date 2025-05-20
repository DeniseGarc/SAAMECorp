/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.CitaDAO;
import DAOs.CubiculoDAO;
import DAOs.PsicologoDAO;
import dto.DetalleCitaCubiculoDTO;
import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import entidades.Adeudo;
import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ICitaDAO;
import interfaces.ICubiculoDAO;
import interfaces.IPsicologoDAO;
import interfaces.IReporteCubiculoBO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author erika
 */
public class ReporteCubiculoBO implements IReporteCubiculoBO{
    
    /**
     * Instancia de la clase CitaDAO
     */
    ICitaDAO citaDAO = CitaDAO.getInstancia();
    
    IPsicologoDAO psicologoDAO = PsicologoDAO.getInstanciaDAO();
    
    /**
     * Instancia unica de la clase
     */
    private static ReporteCubiculoBO instancia;
    
    /**
     * Instancia de la clase CubiculoDAO
     */
    ICubiculoDAO cubiculoDAO = CubiculoDAO.getInstanciaDAO();
    
    /**
     * Constructor privado para evitar instancias externas
     */
    private ReporteCubiculoBO(){}
    
    /**
     * Metodo para obtener la instancia unica de CitaBO Si no existe una la crea
     *
     * @return instancia unida de CitaBO
     */
    public static ReporteCubiculoBO getInstancia() {
        if (instancia == null) {
            instancia = new ReporteCubiculoBO();
        }
        return instancia;
    }
    
    /**
   * Metodo para ganerar un reporte de uso de cubiculos 
   * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el reportes
   * @return Reporte de uso de cubiculo
   * @throws NegocioException 
   */
    @Override
    public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();
            List<Cita> citasFiltradas = new ArrayList<>();
            Cubiculo cubiculoSeleccionado = null;

            for (Cita cita : citas) {
                String nombre = obtenerNombreCubiculo(cita.getIdCubiculo());
                if (nombreCubiculo.equalsIgnoreCase(nombre)) {
                    citasFiltradas.add(cita);
                    if (cubiculoSeleccionado == null) {
                        cubiculoSeleccionado = cubiculoDAO.buscarCubiculoPorId(cita.getIdCubiculo().toHexString());
                    }
                }
            }

            // Validar si se encontró el cubículo
            if (cubiculoSeleccionado == null) {
                return new ReporteUsoCubiculoDTO(
                    nombreCubiculo,
                    0,
                    "No se encontraron citas para el cubículo seleccionado: " + nombreCubiculo
                );
            }

            // Construcción del reporte
            StringBuilder reporte = new StringBuilder();
            reporte.append("=== Reporte de Uso de Cubículo ===\n");
            reporte.append("Cubículo: ").append(nombreCubiculo).append("\n");
            reporte.append("Tipo de terapia: ").append(cubiculoSeleccionado.getTipoTerapia()).append("\n");
            reporte.append("Capacidad: ").append(cubiculoSeleccionado.getCapacidad()).append("\n");
            reporte.append("Notas: ").append(cubiculoSeleccionado.getNotas()).append("\n\n");
            reporte.append("Citas registradas:\n");

            int citasConAdeudoPendiente = 0;

            for (Cita cita : citasFiltradas) {
                Psicologo psicologo = psicologoDAO.obtenerPsicologoPorIdentificador(cita.getIdPsicologo().toHexString());
                Adeudo adeudo = cita.getDetallesAdeudo();

                String estadoAdeudo = adeudo.isEstado() ? "PAGADO" : "PENDIENTE";
                double cantidad = adeudo.getCantidad();

                if (!adeudo.isEstado()) {
                    citasConAdeudoPendiente++;
                }

                reporte.append("- ")
                    .append(formatFechaHora(cita.getFechaHora()))
                    .append(" | Psicólogo: ").append(psicologo.getNombre())
                    .append(" | Estado: ").append(estadoAdeudo)
                    .append(" | $").append(String.format("%.2f", cantidad))
                    .append("\n");
            }

            reporte.append("\nTotal de citas: ").append(citasFiltradas.size()).append("\n");
            reporte.append("Citas con adeudo pendiente: ").append(citasConAdeudoPendiente).append("\n");

            return new ReporteUsoCubiculoDTO(nombreCubiculo, citasFiltradas.size(), reporte.toString());

        } catch (PersistenciaException ex) {
            Logger.getLogger(ReporteCubiculoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al generar el reporte: " + ex.getMessage(), ex);
        }
    }

    private String formatFechaHora(Calendar fechaHora) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(fechaHora.getTime());
    }

    
    /**
   * Metodo que genera un reporte estadistico sobre los cubiculos registrados
   * @return reporte estadistico
     * @throws excepciones.NegocioException
   */
    @Override
    public List<ReporteResumenCubiculoDTO> generarReporteEstadisticoResumen() throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();
            List<Cubiculo> cubiculos = cubiculoDAO.buscarCubiculos();

            Map<String, Integer> totalCitas = new HashMap<>();
            Map<String, Double> ingresos = new HashMap<>();

            for (Cita cita : citas) {
                String nombre = obtenerNombreCubiculo(cita.getIdCubiculo());
                double monto = (cita.getDetallesAdeudo() != null && cita.getDetallesAdeudo().isEstado())
                        ? cita.getDetallesAdeudo().getCantidad()
                        : 0;

                totalCitas.put(nombre, totalCitas.getOrDefault(nombre, 0) + 1);
                ingresos.put(nombre, ingresos.getOrDefault(nombre, 0.0) + monto);
            }

            List<ReporteResumenCubiculoDTO> resumen = new ArrayList<>();
            for (Cubiculo cubiculo : cubiculos) {
                String nombre = cubiculo.getNombre();
                int citasCubiculo = totalCitas.getOrDefault(nombre, 0);
                double ingresoCubiculo = ingresos.getOrDefault(nombre, 0.0);
                double porcentajeUso = calcularPorcentajeUso(nombre, citasCubiculo);
                resumen.add(new ReporteResumenCubiculoDTO(nombre, citasCubiculo, ingresoCubiculo, porcentajeUso));
            }

            return resumen;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ReporteCubiculoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al generar reporte estadístico", ex);
        }
    }
    
    private double calcularPorcentajeUso(String nombreCubiculo, int citasCubiculo) {
        int diasLaborales = 22; 
        int horasDisponiblesPorDia = 8;

        int totalPosiblesCitas = diasLaborales * horasDisponiblesPorDia;

        if (totalPosiblesCitas == 0) return 0;

        return (citasCubiculo * 100.0) / totalPosiblesCitas;
    }

    /**
   * Metodo para obtener un reporte de ingresos de un cubiculo especifico
   * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el cubiculo
   * @return Reporte de ingresos de cubiculo
   * @throws NegocioException 
   */
    @Override
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();

            double ingreso = 0.0;
            int pagadas = 0;
            int pendientes = 0;

            for (Cita cita : citas) {
                String nombre = obtenerNombreCubiculo(cita.getIdCubiculo());
                if (nombreCubiculo.equalsIgnoreCase(nombre)) {
                    Adeudo adeudo = cita.getDetallesAdeudo();
                    if (adeudo != null) {
                        if (adeudo.isEstado()) {
                            ingreso += adeudo.getCantidad();
                            pagadas++;
                        } else {
                            pendientes++;
                        }
                    }
                }
            }

            return new ReporteIngresosCubiculoDTO(nombreCubiculo, ingreso, pagadas, pendientes);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ReporteCubiculoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }
    
    private String obtenerNombreCubiculo(ObjectId idCubiculo) throws PersistenciaException {
        Cubiculo cubiculo = cubiculoDAO.buscarCubiculoPorId(idCubiculo.toHexString());
        return cubiculo != null ? cubiculo.getNombre() : "Desconocido";
    }
    
}
