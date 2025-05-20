/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarCita.control;

import dto.CitaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import static enumeradores.TipoBO.ADEUDO;
import static enumeradores.TipoBO.CITA;
import static enumeradores.TipoBO.CUBICULO;
import static enumeradores.TipoBO.PSICOLOGO;
import excepciones.ModificarCitaException;
import excepciones.NegocioException;
import interfaces.IAdeudoBO;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IPsicologoBO;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import manejadorBO.ManejadorBO;

/**
 * Clase control para la comunicacion entre el subsistema y objetos negocio u
 * otro servicio externo
 *
 * @author Maryr
 */
public class ControlModificarCita {

    IPsicologoBO psicologoBO = (IPsicologoBO) ManejadorBO.crearBO(PSICOLOGO);
    ICitaBO citaBO = (ICitaBO) ManejadorBO.crearBO(CITA);
    IAdeudoBO adeudoBO = (IAdeudoBO) ManejadorBO.crearBO(ADEUDO);
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(CUBICULO);

    /**
     * Metodo para filtrar las citas por el dia
     *
     * @param fecha de la cual se quieren mostrar las citas
     * @return la lista con las citas filtradas
     */
    public List<CitaRegistradaDTO> obtenerCitasDia(Calendar fecha) {
        try {
            List<CitaRegistradaDTO> citas = citaBO.obtenerCitasCompletas();
            List<CitaRegistradaDTO> citasDelDia = citas.stream()
                    .filter(cita -> esMismaFecha(cita.getFechaHora(), fecha))
                    .collect(Collectors.toList());
            return citasDelDia;
        } catch (NegocioException ex) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Metodo de apoyo para filtrar las citas por la fecha
     *
     * @param fecha1
     * @param fecha2
     * @return true si coinciden false en caso contrario
     */
    private boolean esMismaFecha(Calendar fecha1, Calendar fecha2) {
        return fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR)
                && fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH)
                && fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Metodo para filtrar los cubiculos disponibles en cierta fecha y hora
     *
     * @param citaActualizar la cita que contiene la fecha y hora
     * @return lista de cubiculos disponibles en dicha fecha y hora
     * @throws ModificarCitaException
     */
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(CitaRegistradaDTO citaActualizar) throws ModificarCitaException {
        try {
            List<CubiculoDTO> cubiculosDisponibles = cubiculoBO.obtenerCubiculosEstadoDisponible();
            List<CitaRegistradaDTO> citasRegistradas = citaBO.obtenerCitasCompletas();
            List<CubiculoDTO> cubiculosFiltrados = new LinkedList<>();

            for (CubiculoDTO cubiculo : cubiculosDisponibles) {
                boolean cubiculoOcupado = false;

                for (CitaRegistradaDTO cita : citasRegistradas) {
                    boolean mismoDiaYHora
                            = cita.getFechaHora().get(Calendar.YEAR) == citaActualizar.getFechaHora().get(Calendar.YEAR)
                            && cita.getFechaHora().get(Calendar.MONTH) == citaActualizar.getFechaHora().get(Calendar.MONTH)
                            && cita.getFechaHora().get(Calendar.DAY_OF_MONTH) == citaActualizar.getFechaHora().get(Calendar.DAY_OF_MONTH)
                            && cita.getFechaHora().get(Calendar.HOUR_OF_DAY) == citaActualizar.getFechaHora().get(Calendar.HOUR_OF_DAY)
                            && cita.getFechaHora().get(Calendar.MINUTE) == citaActualizar.getFechaHora().get(Calendar.MINUTE);

                    if (mismoDiaYHora && cubiculo.getNombre().equals(cita.getCubiculo())
                            && !cita.getCubiculo().equals(citaActualizar.getCubiculo())) {
                        cubiculoOcupado = true;
                        break;
                    }
                }

                if (!cubiculoOcupado) {
                    cubiculosFiltrados.add(cubiculo);
                }
            }

            return cubiculosFiltrados;
        } catch (Exception e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Ha ocurrido un error al intentar obtener los cubículos disponibles en el horario seleccionado", e);
        }
    }

    /**
     * Obtiene la lista de psicólogos disponibles para una fecha específica.
     *
     * @param fechaCita la fecha para la cual se desean obtener los psicólogos disponibles
     * @return lista de objetos {@link PsicologoCitaDTO} con información de los psicólogos y sus horarios
     * @throws ModificarCitaException si ocurre un error al recuperar la información desde la capa de negocio
     */
    public List<PsicologoCitaDTO> obtenerPsicologos(Calendar fechaCita) throws ModificarCitaException {
        try {
            List<PsicologoCitaDTO> psicologosDisponibles = psicologoBO.obtenerPsicologos();
            return psicologosDisponibles;
        } catch (Exception e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Ha ocurrido un error al obtener los psicólogos y sus horarios", e);
        }
    }

}
