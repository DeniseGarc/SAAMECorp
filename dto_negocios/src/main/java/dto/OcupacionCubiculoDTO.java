/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author erika
 */
public class OcupacionCubiculoDTO {
    
    private String nombreCubiculo;
    private int totalDiasOcupado;
    private int totalDiasPeriodo;
    private double porcentajeOcupacion;

    public OcupacionCubiculoDTO() {
    }

    public OcupacionCubiculoDTO(String nombreCubiculo, int totalDiasOcupado, int totalDiasPeriodo, double porcentajeOcupacion) {
        this.nombreCubiculo = nombreCubiculo;
        this.totalDiasOcupado = totalDiasOcupado;
        this.totalDiasPeriodo = totalDiasPeriodo;
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

    public String getNombreCubiculo() {
        return nombreCubiculo;
    }

    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }

    public int getTotalDiasOcupado() {
        return totalDiasOcupado;
    }

    public void setTotalDiasOcupado(int totalDiasOcupado) {
        this.totalDiasOcupado = totalDiasOcupado;
    }

    public int getTotalDiasPeriodo() {
        return totalDiasPeriodo;
    }

    public void setTotalDiasPeriodo(int totalDiasPeriodo) {
        this.totalDiasPeriodo = totalDiasPeriodo;
    }

    public double getPorcentajeOcupacion() {
        return porcentajeOcupacion;
    }

    public void setPorcentajeOcupacion(double porcentajeOcupacion) {
        this.porcentajeOcupacion = porcentajeOcupacion;
    }
    
    
}
