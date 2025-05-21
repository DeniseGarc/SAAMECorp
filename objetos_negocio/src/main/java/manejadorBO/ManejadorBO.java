package manejadorBO;

import BO.AdeudoBO;
import BO.CitaBO;
import BO.CubiculoBO;
import BO.FacturaBO;
import BO.PagoBO;
import BO.PsicologoBO;
import BO.ReporteCubiculoBO;
import BO.UsuarioBO;
import enumeradores.TipoBO;
import interfaces.IAdeudoBO;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IFacturaBO;
import interfaces.IPagoBO;
import interfaces.IPsicologoBO;
import interfaces.IReporteCubiculoBO;
import interfaces.IUsuarioBO;

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
                IAdeudoBO adeudoBO = AdeudoBO.getInstancia();
                return adeudoBO;
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
                return reporteBO;
            case FACTURA:
                IFacturaBO facturaBO = FacturaBO.getInstancia();
                return facturaBO;
            case PAGO:
                IPagoBO pagoBO = PagoBO.getInstancia();
                return pagoBO;
            case USUARIO:
                IUsuarioBO usuarioBO = UsuarioBO.getInstancia();
                return usuarioBO;
            default:
                throw new IllegalArgumentException("Tipo de BO no soportado: " + tipo);
        }
    }
}
