/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorReportes;

import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import exception.GestorReportesException;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IGestorReportes {
    /**
     * Metodo para ganerar un reporte de uso de cubiculos 
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el reportes
     * @return Reporte de uso de cubiculo
     * @throws GestorReportesException 
     */
    public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws GestorReportesException;
    
    /**
     * Metodo que genera un reporte estadistico sobre los cubiculos registrados
     * @return reporte estadistico
     * @throws GestorReportesException 
     */
    public List<ReporteResumenCubiculoDTO> generarReporteEstadisticoResumen() throws GestorReportesException;
    
    /**
     * Metodo para obtener un reporte de ingresos de un cubiculo especifico
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el cubiculo
     * @return Reporte de ingresos de cubiculo
     * @throws GestorReportesException 
     */
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws GestorReportesException;
}
