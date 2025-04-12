/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;

/**
 *
 * @author Alici
 */
public class CitaRegistradaDTO {

    private String id;
    private Calendar fechaHora;
    private String cubiculo;
    private PsicologoDTO psicologo;
    private String nombrePaciente;
    private String telefonoPaciente;
    private String correoPaciente;
    private AdeudoDTO adeudo;

    public CitaRegistradaDTO() {
    }

    public CitaRegistradaDTO(String id, Calendar fechaHora, String cubiculo, PsicologoDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente, AdeudoDTO adeudo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }

    public CitaRegistradaDTO(Calendar fechaHora, String cubiculo, PsicologoDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente, AdeudoDTO adeudo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }

    public AdeudoDTO getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(AdeudoDTO adeudo) {
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
