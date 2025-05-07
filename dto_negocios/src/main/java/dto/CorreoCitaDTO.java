/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Maryr
 */
public class CorreoCitaDTO {

    private String correoDestino;
    private String cubiculo;
    private String fechaHora;
    private String nombrePsicologo;
    private String nombreCliente;
    private String telefonoCliente;
    private String correoCliente;

    public CorreoCitaDTO() {
    }

    public CorreoCitaDTO(String correoDestino, String cubiculo, String fechaHora, String nombrePsicologo, String nombreCliente, String telefonoCliente, String correoCliente) {
        this.correoDestino = correoDestino;
        this.cubiculo = cubiculo;
        this.fechaHora = fechaHora;
        this.nombrePsicologo = nombrePsicologo;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombrePsicologo() {
        return nombrePsicologo;
    }

    public void setNombrePsicologo(String nombrePsicologo) {
        this.nombrePsicologo = nombrePsicologo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

}
