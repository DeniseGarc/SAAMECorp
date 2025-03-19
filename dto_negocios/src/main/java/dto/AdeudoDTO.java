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
public class AdeudoDTO {

    private double cantidad;
    private boolean estado;
    private PsicologoDTO psicologo;
    private LocalDateTime fechaHora;
    private CitaDTO cita;

    public AdeudoDTO() {
    }

    public AdeudoDTO(double cantidad, boolean estado, PsicologoDTO psicologo, LocalDateTime fechaHora, CitaDTO cita) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.psicologo = psicologo;
        this.fechaHora = fechaHora;
        this.cita = cita;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public PsicologoDTO getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(PsicologoDTO psicologo) {
        this.psicologo = psicologo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public CitaDTO getCita() {
        return cita;
    }

    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "AdeudoDTO{" + "cantidad=" + cantidad + ", estado=" + estado + ", psicologo=" + psicologo + ", fechaHora=" + fechaHora + ", cita=" + cita + '}';
    }

}
