/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarCita.control;

import correoElectronico.FCorreoElectronico;
import dto.CitaDTO;
import dto.CitaRegistradaDTO;
import dto.CorreoCitaDTO;
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
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import manejadorBO.ManejadorBO;
import mapper.CorreoMapper;

/**
 * Clase control para la comunicacion entre el subsistema y objetos negocio u
 * otro servicio externo
 *
 * @author Maryr
 */
public class ControlModificarCita {

    ICitaBO citaBO = (ICitaBO) ManejadorBO.crearBO(CITA);
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
                    boolean mismoDiaYHora = cita.getFechaHora().get(Calendar.YEAR) == citaActualizar.getFechaHora()
                            .get(Calendar.YEAR)
                            && cita.getFechaHora().get(Calendar.MONTH) == citaActualizar.getFechaHora()
                                    .get(Calendar.MONTH)
                            && cita.getFechaHora().get(Calendar.DAY_OF_MONTH) == citaActualizar.getFechaHora()
                                    .get(Calendar.DAY_OF_MONTH)
                            && cita.getFechaHora().get(Calendar.HOUR_OF_DAY) == citaActualizar.getFechaHora()
                                    .get(Calendar.HOUR_OF_DAY)
                            && cita.getFechaHora().get(Calendar.MINUTE) == citaActualizar.getFechaHora()
                                    .get(Calendar.MINUTE);

                    if (mismoDiaYHora && cubiculo.getNombre().equals(cita.getCubiculo().getNombre()) && !cita.getCubiculo().getNombre().equals(citaActualizar.getCubiculo().getNombre())) {
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
            throw new ModificarCitaException(
                    "Ha ocurrido un error al intentar obtener los cubículos disponibles en el horario seleccionado", e);
        }
    }

    /**
     * Metodo para obtener las horas disponibles que coinciden de un cubiculo y
     * un psicologo
     *
     * @param psicologo  psicologo del cual se requieren las horas
     * @param idCubiculo cubiculo del cual se requieren las horas
     * @param fecha      fecha en la cual sera la cita
     * @return lista de la horas disponibles coincidentes
     * @throws excepciones.ModificarCitaException
     */
    public List<LocalTime> obtenerHorasDisponibles(PsicologoCitaDTO psicologo, String idCubiculo, Calendar fecha)
            throws ModificarCitaException {
        try {
            return citaBO.obtenerHorasDisponibles(psicologo, idCubiculo, fecha);
        } catch (NegocioException e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Error al obtener las horas disponible: ", e);
        }
    }

    /**
     * Método para actualizar una cita existente
     *
     * @param citaActualizada La cita con los nuevos datos
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws excepciones.ModificarCitaException
     */
    public boolean actualizarCita(CitaRegistradaDTO citaActualizada) throws ModificarCitaException {
        try {
            return citaBO.actualizarCita(citaActualizada);
        } catch (NegocioException e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Error al modificar la cita: ", e);
        }
    }

    /**
     * Método que se conecta con el servicio externo para mandar un correo
     * electrónico al correo ingresado.
     *
     * @param cita de la cual se enviará confirmación
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean mandarCorreo(CitaRegistradaDTO cita) {
        try {
            FCorreoElectronico correoInfra = new FCorreoElectronico();
            String fechaCitaFormateada = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(cita.getFechaHora().getTime());
            String nombrePsicologo = cita.getPsicologo().getNombre() + " " + cita.getPsicologo().getApellidoPaterno()
                    + " " + cita.getPsicologo().getApellidoMaterno();
            CorreoCitaDTO correoCita = new CorreoCitaDTO(cita.getPsicologo().getCorreo(),
                    cita.getCubiculo().getNombre(), fechaCitaFormateada, nombrePsicologo, cita.getNombrePaciente(),
                    cita.getTelefonoPaciente(), cita.getCorreoPaciente());
            CorreoMapper correoMapper = new CorreoMapper();
            boolean enviado = correoInfra.mandarCorreo(correoMapper.toDTO2(correoCita, cita.getAdeudo()));
            return enviado;
        } catch (Exception e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.WARNING,
                    "Error al enviar el correo a " + cita.getPsicologo().getCorreo(), e);
            return false;
        }

    }

}
