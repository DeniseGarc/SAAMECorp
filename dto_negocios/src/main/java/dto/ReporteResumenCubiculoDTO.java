/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author erika
 */
public class ReporteResumenCubiculoDTO {
    /**
     * Nombre del cubiculo
     */
    private String nombreCubiculo;
    
    /**
     * Total de cita del cubiculo
     */
    private int totalCitas;
    
    /**
     * Total de ingresos del cubiculo
     */
    private double totalIngresos;
    
    /**
     * porcentaje de usos del cubiculo
     */
    private double porcentajeUso;
    
    /**
     * Constructor que inicializa todos los parametros
     * @param nombreCubiculo Nombre del cubiculo
     * @param totalCitas Total de citas del cubiculo
     * @param totalIngresos total de ingresos del cubiculo
     * @param porcentajeUso Porcentade de usos del cubiculo
     */
    public ReporteResumenCubiculoDTO(String nombreCubiculo, int totalCitas, double totalIngresos, double porcentajeUso) {
        this.nombreCubiculo = nombreCubiculo;
        this.totalCitas = totalCitas;
        this.totalIngresos = totalIngresos;
        this.porcentajeUso = porcentajeUso;
    }
    
    /**
     * Constructor vacio 
     */
    public ReporteResumenCubiculoDTO() {
    }
    
    /**
     * Metodo para obtener el nombre del cubiculo 
     * @return nombre del cubiculo
     */
    public String getNombreCubiculo() {
        return nombreCubiculo;
    }
    
    /**
     * Metodo para establecer el metodo del cubiculo
     * @param nombreCubiculo Nombre del cubiculo
     */
    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }
    
    /**
     * Metodo para obtener el total de citas del cubiculo
     * @return total de citas del cubiculo
     */
    public int getTotalCitas() {
        return totalCitas;
    }
    
    /**
     * Metodo para establecer el total de citas
     * @param totalCitas total de citas del cubiculo
     */
    public void setTotalCitas(int totalCitas) {
        this.totalCitas = totalCitas;
    }
    
    /**
     * Metodo para obtener el total de ingresos
     * @return total de ingresos del cubiculo
     */
    public double getTotalIngresos() {
        return totalIngresos;
    }
    
    /**
     * Metodo para establecer el total de ingresos del cubiculo
     * @param totalIngresos 
     */
    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }
    
    /**
     * Metodo para obtener el porcentaje de uso del cubiculo
     * @return porcentaje de uso del cubiculo
     */
    public double getPorcentajeUso() {
        return porcentajeUso;
    }
    
    /**
     * Metodo para establecer  el porcentaje de uso del cubiculo
     * @param porcentajeUso 
     */
    public void setPorcentajeUso(double porcentajeUso) {
        this.porcentajeUso = porcentajeUso;
    }
    
    
}
