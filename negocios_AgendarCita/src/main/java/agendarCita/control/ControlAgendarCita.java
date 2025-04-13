package agendarCita.control;

import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

/**
 * Clase control que se encarga de la comunicación entre la fachada del
 * subsistema AgendarCita, los objetos negocio y servicios externos.
 *
 * @author Alici
 */
public class ControlAgendarCita {

    /**
     * Método que obtiene a los psicologos registrados y sus horarios
     * disponibles para el día de la cita seleccionada.
     *
     * @param fechaCita Fecha de la cita seleccionada.
     * @return Lista de todos los psicólogos registrados y sus horarios.
     */
    public List<PsicologoCitaDTO> obtenerPsicologos(Calendar fechaCita) {
        return null;
    }

    /**
     * Obtiene la cantidad de adeudo del psicólogo indicado.
     *
     * @param psicologo Psicólogo a obtener su total de adeudo.
     * @return Regresa la cantidad total de adeudo que tiene el psicólogo
     * indicado.
     */
    public double obtenerCantidadAdeudoPsicologo(PsicologoCitaDTO psicologo) {
        return 0;
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
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean agendarCita(CitaNuevaDTO citaNueva) {
        return false;
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
     * Método que se utiliza para obtener al psicólogo por un identificador.
     *
     * @param identificador Identificador por el cual se va a obtener al
     * psicologo correspondiente.
     * @return Datos y horarios del psicólogo encontrado.
     */
    public PsicologoCitaDTO obtenerPsicologo(String identificador) {
        return null;
    }
}
