/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class FGestorReportes implements IGestorReportes{
    
    GestorReportesControl control = new GestorReportesControl();
    
    /**
     * Metodo que llama al controlador para generar un reporte de uso de cubiculo
     * @param nombreCubiculo Nombre del cubiculo del que se va a realizar el reporte
     * @return ReporteUsoCubiculoDTO
     * @throws GestorReportesException 
     */
    @Override
    public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws GestorReportesException {
       return control.generarReporteUsoCubiculo(nombreCubiculo);
    }
    
    /**
     * Metodo que llama al controlador para generar un reporte estadistico de cubiculos
     * @return reporte estadistico de cubiculos
     * @throws GestorReportesException 
     */
    @Override
    public List<ReporteResumenCubiculoDTO> generarReporteEstadisticoResumen() throws GestorReportesException {
        return control.generarReporteEstadisticoResumen();
    }
    /**
     * Metodo que llama al controlador para generar un reporte de ingresos de cubiculo
     * @param nombreCubiculo Nombre del cubiculo del que se va a realizar el reporte
     * @return ReporteIngresosCubiculoDTO
     * @throws GestorReportesException 
     */
    @Override
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws GestorReportesException {
        return control.generarReporteIngresosPorCubiculo(nombreCubiculo);
    }
    
}
