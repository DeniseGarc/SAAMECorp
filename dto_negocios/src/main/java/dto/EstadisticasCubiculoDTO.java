/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author erika
 */
public class EstadisticasCubiculoDTO {
    private String nombreCubiculo;
    private String tipoTerapia;
    private int capacidad;
    private int totalCitas;
    private int citasPagadas;
    private int citasPendientes;
    private double totalIngresos;
    private int totalHoras; 

    public EstadisticasCubiculoDTO(String nombreCubiculo, String tipoTerapia, int capacidad, int totalCitas, int citasPagadas, int citasPendientes, double totalIngresos, int totalHoras) {
        this.nombreCubiculo = nombreCubiculo;
        this.tipoTerapia = tipoTerapia;
        this.capacidad = capacidad;
        this.totalCitas = totalCitas;
        this.citasPagadas = citasPagadas;
        this.citasPendientes = citasPendientes;
        this.totalIngresos = totalIngresos;
        this.totalHoras = totalHoras;
    }

    public EstadisticasCubiculoDTO() {
    }

    public String getNombreCubiculo() {
        return nombreCubiculo;
    }

    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }

    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTotalCitas() {
        return totalCitas;
    }

    public void setTotalCitas(int totalCitas) {
        this.totalCitas = totalCitas;
    }

    public int getCitasPagadas() {
        return citasPagadas;
    }

    public void setCitasPagadas(int citasPagadas) {
        this.citasPagadas = citasPagadas;
    }

    public int getCitasPendientes() {
        return citasPendientes;
    }

    public void setCitasPendientes(int citasPendientes) {
        this.citasPendientes = citasPendientes;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }
    
    
}
