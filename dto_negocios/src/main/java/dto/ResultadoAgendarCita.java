package dto;

/**
 * DTO que representa el resultado de la operación de agendar una cita.
 *
 * <p>
 * Este objeto se utiliza para comunicar si la cita fue registrada exitosamente,
 * si se envió el correo de confirmación, y para proporcionar un mensaje
 * adicional en caso de advertencia o información relevante.</p>
 *
 * <p>
 * Es útil para manejar respuestas al usuario y controlar flujos condicionales
 * según el resultado de la operación.</p>
 *
 * @author Alici
 */
public class ResultadoAgendarCita {

    /**
     * Indica si la cita fue agendada exitosamente.
     */
    private boolean citaAgendada;

    /**
     * Indica si se envió el correo de confirmación.
     */
    private boolean correoEnviado;

    /**
     * Mensaje de advertencia o información adicional. Puede estar vacío o nulo.
     */
    private String mensajeAdvertencia;

    /**
     * Constructor que inicializa el resultado de la operación.
     *
     * @param citaAgendada true si la cita fue agendada correctamente; false en
     * caso contrario.
     * @param correoEnviado true si el correo fue enviado exitosamente; false en
     * caso contrario.
     * @param mensajeAdvertencia mensaje opcional con información o
     * advertencias.
     */
    public ResultadoAgendarCita(boolean citaAgendada, boolean correoEnviado, String mensajeAdvertencia) {
        this.citaAgendada = citaAgendada;
        this.correoEnviado = correoEnviado;
        this.mensajeAdvertencia = mensajeAdvertencia;
    }

    /**
     * Verifica si la cita fue agendada.
     *
     * @return true si la cita fue registrada; false en caso contrario.
     */
    public boolean isCitaAgendada() {
        return citaAgendada;
    }

    /**
     * Establece el estado de si la cita fue agendada.
     *
     * @param citaAgendada true si fue agendada exitosamente.
     */
    public void setCitaAgendada(boolean citaAgendada) {
        this.citaAgendada = citaAgendada;
    }

    /**
     * Verifica si el correo fue enviado.
     *
     * @return true si el correo de confirmación fue enviado; false en caso
     * contrario.
     */
    public boolean isCorreoEnviado() {
        return correoEnviado;
    }

    /**
     * Establece el estado del envío del correo.
     *
     * @param correoEnviado true si el correo fue enviado exitosamente.
     */
    public void setCorreoEnviado(boolean correoEnviado) {
        this.correoEnviado = correoEnviado;
    }

    /**
     * Obtiene el mensaje de advertencia o información adicional.
     *
     * @return mensaje de advertencia o información.
     */
    public String getMensajeAdvertencia() {
        return mensajeAdvertencia;
    }

    /**
     * Establece el mensaje de advertencia o información adicional.
     *
     * @param mensajeAdvertencia mensaje con advertencia o detalle adicional.
     */
    public void setMensajeAdvertencia(String mensajeAdvertencia) {
        this.mensajeAdvertencia = mensajeAdvertencia;
    }

}
