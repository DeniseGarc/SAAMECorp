package dto;

import java.util.Calendar;

/**
 * Clase que representa una nueva cita a registrar en el sistema.
 *
 * <p>
 * Este DTO (Data Transfer Object) encapsula toda la información necesaria para
 * registrar una nueva cita, incluyendo la fecha y hora, cubículo asignado,
 * psicólogo que atenderá, datos del paciente y cualquier adeudo
 * relacionado.</p>
 *
 * <p>
 * Es utilizado por las capas del sistema que gestionan la creación de citas
 * nuevas, como parte del flujo de registro de pacientes y programación de
 * sesiones.</p>
 *
 * @author Alici
 */
public class CitaNuevaDTO {

    /**
     * Fecha y hora en que se llevará a cabo la cita.
     */
    private Calendar fechaHora;

    /**
     * Identificador del cubículo donde se llevará a cabo la cita.
     */
    private String cubiculo;

    /**
     * Psicólogo asignado a la cita.
     */
    private String psicologo;

    /**
     * Nombre completo del paciente.
     */
    private String nombrePaciente;

    /**
     * Teléfono de contacto del paciente.
     */
    private String telefonoPaciente;

    /**
     * Correo electrónico del paciente.
     */
    private String correoPaciente;

    /**
     * Información del adeudo asociado a la cita, si existe.
     */
    private AdeudoCitaDTO adeudo;

    /**
     * Constructor vacío. Crea un objeto {@code CitaNuevaDTO} sin valores
     * definidos.
     */
    public CitaNuevaDTO() {
    }

    /**
     * Constructor que inicializa todos los campos de la cita.
     *
     * @param fechaHora Fecha y hora de la cita.
     * @param cubiculo Cubículo asignado.
     * @param psicologo Psicólogo que atenderá.
     * @param nombrePaciente Nombre del paciente.
     * @param telefonoPaciente Teléfono del paciente.
     * @param correoPaciente Correo del paciente.
     * @param adeudo Adeudo asociado a la cita.
     */
    public CitaNuevaDTO(Calendar fechaHora, String cubiculo, String psicologo,
            String nombrePaciente, String telefonoPaciente, String correoPaciente,
            AdeudoCitaDTO adeudo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     *
     * @return Fecha y hora de la cita.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     *
     * @param fechaHora Nueva fecha y hora.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el cubículo asignado para la cita.
     *
     * @return Identificador del cubículo.
     */
    public String getCubiculo() {
        return cubiculo;
    }

    /**
     * Establece el cubículo asignado para la cita.
     *
     * @param cubiculo Nuevo cubículo.
     */
    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    /**
     * Obtiene el psicólogo asignado a la cita.
     *
     * @return Objeto {@code PsicologoCitaDTO} con los datos del psicólogo.
     */
    public String getPsicologo() {
        return psicologo;
    }

    /**
     * Establece el psicólogo asignado a la cita.
     *
     * @param psicologo Psicólogo a asignar.
     */
    public void setPsicologo(String psicologo) {
        this.psicologo = psicologo;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return Nombre del paciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param nombrePaciente Nombre del paciente.
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * Obtiene el teléfono del paciente.
     *
     * @return Teléfono del paciente.
     */
    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    /**
     * Establece el teléfono del paciente.
     *
     * @param telefonoPaciente Teléfono del paciente.
     */
    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    /**
     * Obtiene el correo del paciente.
     *
     * @return Correo del paciente.
     */
    public String getCorreoPaciente() {
        return correoPaciente;
    }

    /**
     * Establece el correo del paciente.
     *
     * @param correoPaciente Correo del paciente.
     */
    public void setCorreoPaciente(String correoPaciente) {
        this.correoPaciente = correoPaciente;
    }

    /**
     * Obtiene el adeudo asociado a la cita.
     *
     * @return Objeto {@code AdeudoCitaDTO} con los datos del adeudo.
     */
    public AdeudoCitaDTO getAdeudo() {
        return adeudo;
    }

    /**
     * Establece el adeudo asociado a la cita.
     *
     * @param adeudo Objeto con la información del adeudo.
     */
    public void setAdeudo(AdeudoCitaDTO adeudo) {
        this.adeudo = adeudo;
    }

}
