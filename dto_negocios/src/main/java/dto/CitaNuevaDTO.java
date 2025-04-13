/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;

/**
 * DTO que se utiliza para registrar una nueva cita dentro del sistema.
 *
 * @author Alici
 */
public class CitaNuevaDTO {

    private Calendar fechaHora;
    private String cubiculo;
    private PsicologoCitaDTO psicologo;
    private String nombrePaciente;
    private String telefonoPaciente;
    private String correoPaciente;
    private AdeudoCitaDTO adeudo;

    public CitaNuevaDTO() {
    }

    public CitaNuevaDTO(Calendar fechaHora, String cubiculo, PsicologoCitaDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente, AdeudoCitaDTO adeudo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
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
