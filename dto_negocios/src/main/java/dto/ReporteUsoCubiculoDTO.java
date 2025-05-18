/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * DTO para crear reportes de uso de cubiculo
 * @author erika
 */
public class ReporteUsoCubiculoDTO {
    
    /**
     * Nombre del cubiculo
     */
    private String nombreCubiculo;
    /*
    *Cantidad de usos del cubiculo
    */
    private int cantidadDeUsos;
    
    /**
     * Constructor vacio
     */
    public ReporteUsoCubiculoDTO() {
    }
    
    /**
     * Constructor para con todos los parametros
     * @param nombreCubiculo Nombre del cubiculo
     * @param cantidadDeUsos Cantidad de rentas del cubiculos
     */
    public ReporteUsoCubiculoDTO(String nombreCubiculo, int cantidadDeUsos) {
        this.nombreCubiculo = nombreCubiculo;
        this.cantidadDeUsos = cantidadDeUsos;
    }
    
    /**
     * Metodo para obtener el nombre del cubiculo
     * @return Nombre del cubiculo
     */
    public String getNombreCubiculo() {
        return nombreCubiculo;
    }
    
    /**
     * Metodo para establecer el nombre del cubiculo
     * @param nombreCubiculo Nombre del cubiculo
     */
    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }
    
    /**
     * Metodo para obtener la cantidad de usos del cubiculo
     * @return Cantidad de usos del cubiculo
     */
    public int getCantidadDeUsos() {
        return cantidadDeUsos;
    }
    
    /**
     * Metodo para establecer la cantidad de usos del cubiculo
     * @param cantidadDeUsos Cantidad de rentas del cubiculo
     */
    public void setCantidadDeUsos(int cantidadDeUsos) {
        this.cantidadDeUsos = cantidadDeUsos;
    }
    
    
}
