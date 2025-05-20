/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorBO;

import BO.AdeudoBO;
import BO.CitaBO;
import BO.CubiculoBO;
import BO.FacturaBO;
import BO.PsicologoBO;
import BO.ReporteCubiculoBO;
import DAOs.FacturaDAO;
import enumeradores.TipoBO;
import interfaces.IAdeudoBO;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IFacturaBO;
import interfaces.IPsicologoBO;
import interfaces.IReporteCubiculoBO;

/**
 * Clase que funciona como fábrica de objetos negocio.
 *
 * @author erika
 */
public class ManejadorBO {

    /**
     * Método genérico que crea y retorna la instancia del BO correspondiente al
     * tipo indicado.
     *
     * @param tipo el tipo de objeto BO requerido.
     * @return una instancia Singleton del BO correspondiente.
     */
    public static Object crearBO(TipoBO tipo) {
        switch (tipo) {
            case ADEUDO:
                IAdeudoBO audeudoBO = AdeudoBO.getInstancia();
                return audeudoBO;
            case CITA:
                ICitaBO citaBO = CitaBO.getInstancia();
                return citaBO;
            case CUBICULO:
                ICubiculoBO cubiculoBO = CubiculoBO.getInstancia();
                return cubiculoBO;
            case PSICOLOGO:
                IPsicologoBO psicologoBO = PsicologoBO.getInstancia();
                return psicologoBO;
            case REPORTE:
                IReporteCubiculoBO reporteBO = ReporteCubiculoBO.getInstancia();
            case FACTURA:
                IFacturaBO facturaBO = new FacturaBO();
                return facturaBO;

            default:
                throw new IllegalArgumentException("Tipo de BO no soportado: " + tipo);
        }
    }
}
