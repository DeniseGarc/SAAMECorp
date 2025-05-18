/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorReportes;

import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import enumeradores.TipoBO;
import excepciones.NegocioException;
import exception.GestorReportesException;
import interfaces.IReporteCubiculoBO;
import java.util.List;
import manejadorBO.ManejadorBO;

/**
 *
 * @author erika
 */
public class GestorReportesControl {
    
    /**
     * Instancia de la clase Reporte Cubiculos BO para acceder a la logica de negocio
     */
    IReporteCubiculoBO reporteBO = (IReporteCubiculoBO) ManejadorBO.crearBO(TipoBO.REPORTE);
    
    /**
     * Metodo para ganerar un reporte de uso de cubiculos 
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el reportes
     * @return Reporte de uso de cubiculo
     * @throws GestorReportesException 
     */
    public ReporteUsoCubiculoDTO generarReporteUsoCubiculo(String nombreCubiculo) throws GestorReportesException{
        try{
            return reporteBO.generarReporteUsoCubiculo(nombreCubiculo);
        }catch(NegocioException e ){
            throw new GestorReportesException("Eror al agregar:"+e.getMessage());
        }
    }
    
    /**
     * Metodo que genera un reporte estadistico sobre los cubiculos registrados
     * @return reporte estadistico
     * @throws GestorReportesException 
     */
    public List<ReporteResumenCubiculoDTO> generarReporteEstadisticoResumen() throws GestorReportesException{
        try{
            return reporteBO.generarReporteEstadisticoResumen();
        }catch(NegocioException e ){
            throw new GestorReportesException("Eror al agregar:"+e.getMessage());
        }
    }
    
    /**
     * Metodo para obtener un reporte de ingresos de un cubiculo especifico
     * @param nombreCubiculo Nombre del cubiculo al que se le va a generar el cubiculo
     * @return Reporte de ingresos de cubiculo
     * @throws GestorReportesException 
     */
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(String nombreCubiculo) throws GestorReportesException{
        try{
            return reporteBO.generarReporteIngresosPorCubiculo(nombreCubiculo);
        }catch(NegocioException e ){
            throw new GestorReportesException("Eror al agregar:"+e.getMessage());
        }
    }
}
