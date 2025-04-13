package agendarCita.control;

import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import excepciones.AgendarCitaException;
import interfaces.IAdeudoBO;
import interfaces.ICitaBO;
import interfaces.IPsicologoBO;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorBO.ManejadorBO;

/**
 * Clase control que se encarga de la comunicación entre la fachada del
 * subsistema AgendarCita, los objetos negocio y servicios externos.
 *
 * @author Alici
 */
public class ControlAgendarCita {

    IPsicologoBO psicologoBO = ManejadorBO.crearPsicologoBO();
    ICitaBO citaBO = ManejadorBO.crearCitaBO();
    IAdeudoBO adeudoBO = ManejadorBO.crearAdeudoBO();
    
    
    
    /**
     * Método que obtiene a los psicologos registrados y sus horarios
     * disponibles para el día de la cita seleccionada.
     *
     * @param fechaCita Fecha de la cita seleccionada.
     * @return Lista de todos los psicólogos registrados y sus horarios.
     */
    public List<PsicologoCitaDTO> obtenerPsicologos(Calendar fechaCita) {
      List<PsicologoCitaDTO> psicologosDisponibles = new LinkedList<>();
        List<PsicologoDTO> psicologos = psicologoBO.obtenerPsicologos();

        for (PsicologoDTO psicologo : psicologos) {
            // Obtener horas disponibles de este psicólogo para la fecha seleccionada
            List<LocalTime> horasDisponibles = citaBO.obtenerHorasDisponiblesPorFechaYPsicologo(fechaCita, psicologo);

            // Crear el DTO extendido con las horas disponibles
            PsicologoCitaDTO dto = new PsicologoCitaDTO(
                psicologo.getNombre(),
                psicologo.getApellidoPaterno(),
                psicologo.getApellidoMaterno(),
                psicologo.getCorreo(),
                horasDisponibles
            );

            psicologosDisponibles.add(dto);
        }

        return psicologosDisponibles;  
    }

    /**
     * Obtiene la cantidad de adeudo del psicólogo indicado.
     *
     * @param psicologo Psicólogo a obtener su total de adeudo.
     * @return Regresa la cantidad total de adeudo que tiene el psicólogo
     * indicado.
     */
    public double obtenerCantidadAdeudoPsicologo(PsicologoCitaDTO psicologo) {
        PsicologoDTO dto = new PsicologoDTO(
        psicologo.getNombre(),
        psicologo.getApellidoPaterno(),
        psicologo.getApellidoMaterno(),
        psicologo.getCorreo()
    );

    return adeudoBO.consultarAdeudoTotalPsicologo(dto);
    }

    /**
     * Obtiene los cubiculos que se encuentra disponibles en la fecha y hora
     * seleccionados.
     *
     * @param fechaHoraCita Fecha y hora seleccionados para la cita.
     * @return Cubiculos que se encuentran disponibles para la fecha y hora
     * seleccionados.
     */
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(Calendar fechaHoraCita) {
        return null;
    }

    /**
     * Método que se encarga de agendar la cita en el sistema una vez que se han
     * realizado todas las válidaciones necesarias.
     *
     * @param citaNueva Cita nueva a registrar en el sistema.
     * @return regresa los datos de la cita agendada, null en caso de no ser
     * posible agendar la cita.
     */
    public CitaNuevaDTO agendarCita(CitaNuevaDTO citaNueva) {
        return null;
    }

    /**
     * Método que valida que no exista una cita registrada dentro del sistema
     *
     * @param citaARegistrar
     * @return
     */
    public boolean validarFechaCitaRepetida(CitaNuevaDTO citaARegistrar) {
        return false;
    }

    /**
     * Método que se conecta con el servicio externo para mandar un correo
     * electrónico al correo ingresado.
     *
     * @param correo Correo electrónico al que se le va a enviar el mensaje.
     * @param mensaje Mensaje del correo.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean mandarCorreo(String mensaje, String correo) {
        return true;
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
            PsicologoDTO psicologoEncontrado = psicologoBO.obtenerPsicologoPorIdentificador(identificador);
            List<LocalTime> horasPsicologo = citaBO.obtenerHorasDisponiblesPorFechaYPsicologo(fechaCita, psicologoEncontrado);
            return new PsicologoCitaDTO(psicologoEncontrado, horasPsicologo);
        } catch (Exception e) {
            Logger.getLogger(ControlAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Ha ocurrido un error al intentar consultar si psicólogo y sus horas disponibles", e);
        }
    }
}
