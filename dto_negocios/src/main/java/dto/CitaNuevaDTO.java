/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author Alici
 */
public class CitaNuevaDTO {

    private LocalDateTime fechaHora;
    private String cubiculo;
    private PsicologoDTO psicologo;
    private String nombrePaciente;
    private String telefonoPaciente;
    private String correoPaciente;

    public CitaNuevaDTO() {
    }

    public CitaNuevaDTO(LocalDateTime fechaHora, String cubiculo, PsicologoDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public PsicologoDTO getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(PsicologoDTO psicologo) {
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

}
