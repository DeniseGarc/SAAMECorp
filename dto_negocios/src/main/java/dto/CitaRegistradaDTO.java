/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;

/**
 *
 * @author Maryr
 */
public class CitaRegistradaDTO {

    /**
     * id del registro de la cita
     */
    private String id;

    /**
     * Fecha y hora en que se llevará a cabo la cita.
     */
    private Calendar fechaHora;

    /**
     * Identificador del cubículo donde se llevará a cabo la cita.
     */
    private CubiculoDTO cubiculo;

    /**
     * Psicólogo asignado a la cita.
     */
    private PsicologoCitaDTO psicologo;

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
     * Constructor vacio
     */
    public CitaRegistradaDTO() {
    }
    /**
     * Constructor que inicializa todos los atributos
     * @param id
     * @param fechaHora
     * @param cubiculo
     * @param psicologo
     * @param nombrePaciente
     * @param telefonoPaciente
     * @param correoPaciente
     * @param adeudo 
     */
    public CitaRegistradaDTO(String id, Calendar fechaHora, CubiculoDTO cubiculo, PsicologoCitaDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente, AdeudoCitaDTO adeudo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }
    /**
     * Obtiene el id
     * @return ID 
     */
    public String getId() {
        return id;
    }
    /**
     * Establece el id 
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene la fecha
     * @return fecha
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }
    /**
     * Establece la fecha y hora
     * @param fechaHora fecha y hora de la cita
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }
    /**
     * Obtiene el cubiculo
     * @return cubiculo
     */
    public CubiculoDTO getCubiculo() {
        return cubiculo;
    }
    /**
     * Establece el cubiculo de la cita
     * @param cubiculo cubiculo de la cita
     */
    
    public void setCubiculo(CubiculoDTO cubiculo) {
        this.cubiculo = cubiculo;
    }
    /**
     * Obtiene el psicologo de la cita
     * @return psicologo de la cita
     */
    public PsicologoCitaDTO getPsicologo() {
        return psicologo;
    }
    /**
     * Establece psicologo de la cita
     * @param psicologo psicologo de la cita
     */
    public void setPsicologo(PsicologoCitaDTO psicologo) {
        this.psicologo = psicologo;
    }
    /**
     * Obtiene el nombre del paciente
     * @return nombre del paciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    /**
     * Establece el nombre del paciente
     * @param nombrePaciente nombre del paciente
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    /**
     * Obtiene el telefono del paciente
     * @return telefono del paciente
     */
    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }
    /**
     * Establece el telefono del paciente
     * @param telefonoPaciente telefono del paciente
     */
    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }
    /**
     * Obtiene el correo del paciente
     * @return correo del paciente
     */
    public String getCorreoPaciente() {
        return correoPaciente;
    }
    /**
     * Establece el correo del paciente
     * @param correoPaciente correo del paciente
     */
    public void setCorreoPaciente(String correoPaciente) {
        this.correoPaciente = correoPaciente;
    }
    /**
     * Obtiene el adeudo de la cita
     * @return adeudo de la cita
     */
    public AdeudoCitaDTO getAdeudo() {
        return adeudo;
    }
    /**
     * Establece el adeudo de la cita
     * @param adeudo adeudo de la cita
     */
    public void setAdeudo(AdeudoCitaDTO adeudo) {
        this.adeudo = adeudo;
    }

}
