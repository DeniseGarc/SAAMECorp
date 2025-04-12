package dto;

/**
 * DTO que sirve para obtener el resultado de la operación de agendar una cita.
 *
 * @author Alici
 */
public class ResultadoAgendarCita {

    private boolean citaAgendada;
    private boolean correoEnviado;
    private String mensajeAdvertencia;

    public ResultadoAgendarCita(boolean citaAgendada, boolean correoEnviado, String mensajeAdvertencia) {
        this.citaAgendada = citaAgendada;
        this.correoEnviado = correoEnviado;
        this.mensajeAdvertencia = mensajeAdvertencia;
    }

    public boolean isCitaAgendada() {
        return citaAgendada;
    }

    public void setCitaAgendada(boolean citaAgendada) {
        this.citaAgendada = citaAgendada;
    }

    public boolean isCorreoEnviado() {
        return correoEnviado;
    }

    public void setCorreoEnviado(boolean correoEnviado) {
        this.correoEnviado = correoEnviado;
    }

    public String getMensajeAdvertencia() {
        return mensajeAdvertencia;
    }

    public void setMensajeAdvertencia(String mensajeAdvertencia) {
        this.mensajeAdvertencia = mensajeAdvertencia;
    }

}
