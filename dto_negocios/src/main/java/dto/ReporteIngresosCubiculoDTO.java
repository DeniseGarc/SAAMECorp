/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author erika
 */
public class ReporteIngresosCubiculoDTO {
    /**
     * Nombre del cubiculo
     */
    private String nombreCubiculo;
    
    /**
     * Total de  ingresos del cubiculo
     */
    private double totalIngresos;
    
    /**
     * Citas pagadas del cubiculo
     */
    private int citasConPago;
    /**
     * Citas con pago pendiente del cubiculo
     */
    private int citasPendientes;
    
    /**
     * Constructor vacio
     */
    public ReporteIngresosCubiculoDTO() {
    }
    
    /**
     * Constructor con todos los elementos 
     * @param nombreCubiculo nombre del cubiculpo
     * @param totalIngresos total de ingresos del cubiculo
     * @param citasConPago citas pagadas
     * @param citasPendientes citas pendientes
     */
    public ReporteIngresosCubiculoDTO(String nombreCubiculo, double totalIngresos, int citasConPago, int citasPendientes) {
        this.nombreCubiculo = nombreCubiculo;
        this.totalIngresos = totalIngresos;
        this.citasConPago = citasConPago;
        this.citasPendientes = citasPendientes;
    }
    
    /**
     * Obtiene el nombre del cubiculo
     * @return Nombre del cubiculo
     */
    public String getNombreCubiculo() {
        return nombreCubiculo;
    }
    /**
     * Establece el nombre del cubiculo
     * @param nombreCubiculo nombre del cubiculo
     */
    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }
    
    /**
     * Obtiene el total de ingresos del cubiculo
     * @return total de ingresos del cubiculo
     */
    public double getTotalIngresos() {
        return totalIngresos;
    }
    
    /**
     * Establece el total de ingresos del cubiculo
     * @param totalIngresos total de ingresos del cubiculo
     */
    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }
    
    /**
     * Obtiene las citas pagadas del cubiculo
     * @return citas pagadas del cubiculo
     */
    public int getCitasConPago() {
        return citasConPago;
    }
    
    /**
     * Establece las citas pagadas del cubiculo
     * @param citasConPago citas pagadas del cubiculo
     */
    public void setCitasConPago(int citasConPago) {
        this.citasConPago = citasConPago;
    }
    
    /**
     * Obtiene las citas proximas del cubiculo
     * @return citas proximas del cubiculo
     */
    public int getCitasPendientes() {
        return citasPendientes;
    }
    
    /**
     * Establece las citas proximas del cubiculo
     * @param citasPendientes citas proximas del cubiculo
     */
    public void setCitasPendientes(int citasPendientes) {
        this.citasPendientes = citasPendientes;
    }
    
    
    
}
