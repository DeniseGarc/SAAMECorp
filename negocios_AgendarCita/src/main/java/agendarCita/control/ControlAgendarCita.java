package agendarCita.control;

import correoElectronico.FCorreoElectronico;
import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CorreoCitaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import static enumeradores.TipoBO.*;
import excepciones.AgendarCitaException;
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
import manejadorBO.ManejadorBO;
import mapper.CorreoMapper;

/**
 * Clase control que se encarga de la comunicación entre la fachada del
 * subsistema AgendarCita, los objetos negocio y servicios externos.
 *
 * @author Alici
 */
public class ControlAgendarCita {

    IPsicologoBO psicologoBO = (IPsicologoBO) ManejadorBO.crearBO(PSICOLOGO);
    ICitaBO citaBO = (ICitaBO) ManejadorBO.crearBO(CITA);
    IAdeudoBO adeudoBO = (IAdeudoBO) ManejadorBO.crearBO(ADEUDO);
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(CUBICULO);

    /**
     * Método que obtiene a los psicologos registrados y sus horarios
     * disponibles para el día de la cita seleccionada.
     *
     * @param fechaCita Fecha de la cita seleccionada.
     * @return Lista de todos los psicólogos registrados y sus horarios.
     * @throws excepciones.AgendarCitaException
     */
    public List<PsicologoCitaDTO> obtenerPsicologos(Calendar fechaCita) throws AgendarCitaException {
        try {
            List<PsicologoCitaDTO> psicologosDisponibles = psicologoBO.obtenerPsicologos();
            return psicologosDisponibles;
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al obtener los psicólogos y sus horarios", e);
        }
    }

    /**
     * Obtiene la cantidad de adeudo del psicólogo indicado.
     *
     * @param psicologo Psicólogo a obtener su total de adeudo.
     * @return Regresa la cantidad total de adeudo que tiene el psicólogo
     * indicado.
     * @throws excepciones.AgendarCitaException
     */
    public double obtenerCantidadAdeudoPsicologo(PsicologoCitaDTO psicologo) throws AgendarCitaException {
        try {
            PsicologoDTO dto = new PsicologoDTO(
                    psicologo.getNombre(),
                    psicologo.getApellidoPaterno(),
                    psicologo.getApellidoMaterno(),
                    psicologo.getCorreo(),
                    null
            );

            return adeudoBO.consultarAdeudoTotalPsicologo(dto);
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al obtener la cantidad de adeudo total del psicólogo", e);
        }
    }

    /**
     * Obtiene los cubiculos que se encuentra disponibles en la fecha y hora
     * seleccionados.
     *
     * @param fechaHoraCita Fecha y hora seleccionados para la cita.
     * @return Cubiculos que se encuentran disponibles para la fecha y hora
     * seleccionados.
     * @throws excepciones.AgendarCitaException
     */
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(Calendar fechaHoraCita) throws AgendarCitaException {
        try {
            List<CubiculoDTO> cubiculosDisponibles = cubiculoBO.obtenerCubiculosEstadoDisponible();
            List<CitaDTO> citasRegistradas = citaBO.obtenerCitas();
            List<CubiculoDTO> cubiculosFiltrados = new LinkedList<>();
            for (CubiculoDTO cubiculo : cubiculosDisponibles) {
                boolean cubiculoOcupado = false;
                for (CitaDTO cita : citasRegistradas) {
                    if (cubiculo.getNombre().equals(cita.getCubiculo())
                            && cita.getFechaHora().get(Calendar.YEAR) == fechaHoraCita.get(Calendar.YEAR)
                            && cita.getFechaHora().get(Calendar.MONTH) == fechaHoraCita.get(Calendar.MONTH)
                            && cita.getFechaHora().get(Calendar.DAY_OF_MONTH) == fechaHoraCita.get(Calendar.DAY_OF_MONTH)
                            && cita.getFechaHora().get(Calendar.HOUR_OF_DAY) == fechaHoraCita.get(Calendar.HOUR_OF_DAY)
                            && cita.getFechaHora().get(Calendar.MINUTE) == fechaHoraCita.get(Calendar.MINUTE)) {
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
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurido un error al intentar obtener los cubiculos disponibles en el horario seleccionado", e);
        }
    }

    /**
     * Método que se encarga de agendar la cita en el sistema una vez que se han
     * realizado todas las válidaciones necesarias.
     *
     * @param citaNueva Cita nueva a registrar en el sistema.
     * @return regresa los datos de la cita agendada, null en caso de no ser
     * posible agendar la cita.
     * @throws excepciones.AgendarCitaException
     */
    public CitaNuevaDTO agendarCita(CitaNuevaDTO citaNueva) throws AgendarCitaException {
        try {
            return citaBO.guardarCita(citaNueva);
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al intentar guardar la cita", e);
        }
    }

    /**
     * Método que valida que no exista una cita registrada dentro del sistema
     * que tenga misma fecha, hora y cubiculo.
     *
     * @param citaARegistrar Cita a registrar dentro del sistema
     * @return true si no existe una cita repetida, false en caso contrario.
     * @throws excepciones.AgendarCitaException
     */
    public boolean validarFechaCitaRepetida(CitaNuevaDTO citaARegistrar) throws AgendarCitaException {
        try {
            return citaBO.validarExistenciaCitaRepetida(citaARegistrar);
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al intentar validar si hay otra cita en la misma fecha, hora y cubiculo", e);
        }
    }

    /**
     * Método que se conecta con el servicio externo para mandar un correo
     * electrónico al correo ingresado.
     *
     * @param cita de la cual se enviará confirmación
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean mandarCorreo(CitaNuevaDTO cita) {
        try {
            FCorreoElectronico correoInfra = new FCorreoElectronico();
            PsicologoCitaDTO pcdto = psicologoBO.obtenerPsicologoPorIdentificador(cita.getPsicologo());
            CubiculoDTO cdto = cubiculoBO.buscarCubiculoPorId(cita.getCubiculo());
            String fechaCitaFormateada = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(cita.getFechaHora().getTime());
            String nombrePsicologo = pcdto.getNombre() + " " + pcdto.getApellidoPaterno() + " " + pcdto.getApellidoMaterno();
            CorreoCitaDTO correoCita = new CorreoCitaDTO(pcdto.getCorreo(), cdto.getNombre(), fechaCitaFormateada, nombrePsicologo, cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente());
            CorreoMapper correoMapper = new CorreoMapper();
            boolean enviado = correoInfra.mandarCorreo(correoMapper.toDTO(correoCita));
            return enviado;
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.WARNING, "Error al enviar el correo: ", e);
            System.err.println("Error al enviar el correo: " + e.getMessage());
            return false;
        }

    }

    /**
     * Método que se utiliza para obtener los datos del psicólogo y sus horarios
     * a partir de un identificador.
     *
     * @param identificador Identificador por el cual se va a obtener al
     * psicologo correspondiente.
     * @param fechaCita Fecha de la cita seleccionada
     * @return Datos y horarios del psicólogo encontrado.
     * @throws AgendarCitaException Si ocurre un error al consultar los datos.
     */
    public PsicologoCitaDTO obtenerPsicologo(String identificador, Calendar fechaCita) throws AgendarCitaException {
        try {
            return psicologoBO.obtenerPsicologoPorIdentificador(identificador);
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al intentar consultar el psicólogo y sus horas disponibles", e);
        }
    }
}
