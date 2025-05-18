/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IReporteCubiculoBO {
  /**
   * Metodo para ganerar un reporte de uso de cubiculos 
   * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el reportes
   * @return Reporte de uso de cubiculo
   * @throws NegocioException 
   */ 
  public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws NegocioException;
  
  /**
   * Metodo que genera un reporte estadistico sobre los cubiculos registrados
   * @return reporte estadistico
     * @throws excepciones.NegocioException
   */
  public List<ReporteResumenCubiculoDTO> generarReporteEstadisticoResumen() throws NegocioException;
  
  /**
   * Metodo para obtener un reporte de ingresos de un cubiculo especifico
   * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el cubiculo
   * @return Reporte de ingresos de cubiculo
   * @throws NegocioException 
   */
  public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws NegocioException;
}
