/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.CitaDAO;
import DAOs.CubiculoDAO;
import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import entidades.Adeudo;
import entidades.Cita;
import entidades.Cubiculo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ICitaDAO;
import interfaces.ICubiculoDAO;
import interfaces.IReporteCubiculoBO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erika
 */
public class ReporteCubiculoBO implements IReporteCubiculoBO {

    /**
     * Instancia de la clase CitaDAO
     */
    ICitaDAO citaDAO = CitaDAO.getInstancia();

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
    private ReporteCubiculoBO() {
    }

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
     *
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el
     * reportes
     * @return Reporte de uso de cubiculo
     * @throws NegocioException
     */
    @Override
    public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();
            int usos = 0;

            for (Cita cita : citas) {
//                if (nombreCubiculo.equalsIgnoreCase(cita.getCubiculo())) {
//                    usos++;
//                }
            }

            return new ReporteUsoCubiculoDTO(nombreCubiculo, usos);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ReporteCubiculoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }

    /**
     * Metodo que genera un reporte estadistico sobre los cubiculos registrados
     *
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
//                String cubiculo = cita.getCubiculo();
//                double monto = (cita.getAdeudo() != null && cita.getAdeudo().isEstado())
//                        ? cita.getAdeudo().getCantidad() : 0;
//
//                totalCitas.put(cubiculo, totalCitas.getOrDefault(cubiculo, 0) + 1);
//                ingresos.put(cubiculo, ingresos.getOrDefault(cubiculo, 0.0) + monto);
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
        }
        return null;
    }

    private double calcularPorcentajeUso(String nombreCubiculo, int citasCubiculo) {
//        int diasLaborales = 22;
//        int horasDisponiblesPorDia = 8;
//
//        int totalPosiblesCitas = diasLaborales * horasDisponiblesPorDia;
//
//        if (totalPosiblesCitas == 0) {
//            return 0;
//        }
//
//        return (citasCubiculo * 100.0) / totalPosiblesCitas;
        return 0.0;
    }

    /**
     * Metodo para obtener un reporte de ingresos de un cubiculo especifico
     *
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el
     * cubiculo
     * @return Reporte de ingresos de cubiculo
     * @throws NegocioException
     */
    @Override
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws NegocioException {
//        try {
//            List<Cita> citas = citaDAO.obtenerCitas();
//            
//            double ingreso = 0.0;
//            int pagadas = 0;
//            int pendientes = 0;
//            
//            for (Cita cita : citas) {
//                if (nombreCubiculo.equalsIgnoreCase(cita.getCubiculo())) {
//                    Adeudo adeudo = cita.getAdeudo();
//                    if (adeudo != null) {
//                        if (adeudo.isEstado()) { 
//                            ingreso += adeudo.getCantidad();
//                            pagadas++;
//                        } else {
//                            pendientes++;
//                        }
//                    }
//                }
//            }
//            
//            return new ReporteIngresosCubiculoDTO(nombreCubiculo, ingreso, pagadas, pendientes);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(ReporteCubiculoBO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new NegocioException("Error al generar el reporte", ex);
//        }
        return null;
    }

}
