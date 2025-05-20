/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author erika
 */
public class DetalleCitaCubiculoDTO {
    /**
     * Fecha y hora de la cita
     */
    private LocalDateTime fechaHora;
    /**
     * Nombre del psicologo
     */
    private String nombrePsicologo;
    /**
     * Estado del pago
     */
    private String estadoPago;
    /**
     * Monto del pago
     */
    private double monto;
    
    /**
     * Constructor que inicializa todos sus atributos
     * @param fechaHora
     * @param nombrePsicologo
     * @param estadoPago
     * @param monto 
     */
    public DetalleCitaCubiculoDTO(LocalDateTime fechaHora, String nombrePsicologo, String estadoPago, double monto) {
        this.fechaHora = fechaHora;
        this.nombrePsicologo = nombrePsicologo;
        this.estadoPago = estadoPago;
        this.monto = monto;
    }
    /**
     * Constructor vacio
     */
    public DetalleCitaCubiculoDTO() {
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombrePsicologo() {
        return nombrePsicologo;
    }

    public void setNombrePsicologo(String nombrePsicologo) {
        this.nombrePsicologo = nombrePsicologo;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
    
    
}
