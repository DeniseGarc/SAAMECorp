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

    public CitaRegistradaDTO() {
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public CubiculoDTO getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(CubiculoDTO cubiculo) {
        this.cubiculo = cubiculo;
    }

    public PsicologoCitaDTO getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(PsicologoCitaDTO psicologo) {
        this.psicologo = psicologo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getCorreoPaciente() {
        return correoPaciente;
    }

    public void setCorreoPaciente(String correoPaciente) {
        this.correoPaciente = correoPaciente;
    }

    public AdeudoCitaDTO getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(AdeudoCitaDTO adeudo) {
        this.adeudo = adeudo;
    }

}
