/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 * DTO para crear reportes de uso de cubiculo
 * @author erika
 */
public class ReporteUsoCubiculoDTO {
    
    /**
     * Nombre del cubiculo
     */
    private String nombreCubiculo;
  
    /**
     * Tipo de terapia 
     */
    private String tipoTerapia;
    /**
     * Capacidad del cubiculo
     */
    private int capacidad;
    /**
     * Notas
     */
    private String notas;
    /**
     * Lista de citas del cubiculo
     */
    private List<DetalleCitaCubiculoDTO> citas;
    /**
     * Total de citas del cubiculo
     */
    private int totalCitas;
    /**
     * Citas con adeudo del cubiculo
     */
    private int citasConAdeudo;
    
    /**
     * Constructor vacio
     */
    public ReporteUsoCubiculoDTO() {
    }
    private String detalleReporte;

    public ReporteUsoCubiculoDTO(String nombreCubiculo, int cantidadDeUsos, String detalleReporte) {
        this.nombreCubiculo = nombreCubiculo;
        this.totalCitas = cantidadDeUsos;
        this.detalleReporte = detalleReporte;
    }

    public String getDetalleReporte() {
        return detalleReporte;
    }

    public void setDetalleReporte(String detalleReporte) {
        this.detalleReporte = detalleReporte;
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

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public List<DetalleCitaCubiculoDTO> getCitas() {
        return citas;
    }

    public void setCitas(List<DetalleCitaCubiculoDTO> citas) {
        this.citas = citas;
    }


    public int getTotalCitas() {
        return totalCitas;
    }

    public void setTotalCitas(int totalCitas) {
        this.totalCitas = totalCitas;
    }

    public int getCitasConAdeudo() {
        return citasConAdeudo;
    }

    public void setCitasConAdeudo(int citasConAdeudo) {
        this.citasConAdeudo = citasConAdeudo;
    }
    
    
    
}
