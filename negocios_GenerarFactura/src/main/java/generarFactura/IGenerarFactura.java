package generarFactura;

import dto.FacturaDTO;
import dto.PagoDTO;
import dto.ResultadoFacturarPago;
import excepciones.GenerarFacturaException;

/* 
 * Interfaz que define los métodos para la generación de facturas.
 * Esta interfaz es utilizada por la clase FGenerarFactura para implementar la
 * lógica de negocio relacionada con la generación de facturas.
 * 
 * @author Alici 
 */
public interface IGenerarFactura {
    /**
     * Método para generar una factura a partir de un DTO de factura.
     * 
     * @param factura DTO de la factura a generar
     * @return ResultadoFacturarPago que contiene la factura generada y el estado
     *         del envío por correo
     * @throws GenerarFacturaException si ocurre un error al generar la factura
     */
    public ResultadoFacturarPago facturarPago(PagoDTO pago, FacturaDTO factura) throws GenerarFacturaException;

    /**
     * Método para descargar el PDF de una factura.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el PDF
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta
     * @throws GenerarFacturaException si ocurre un error al descargar el PDF
     */
    public boolean descargarFacturaPDF(FacturaDTO factura, String filePath) throws GenerarFacturaException;

    /**
     * Método para descargar el XML de una factura.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el XML
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta
     * @throws GenerarFacturaException si ocurre un error al descargar el XML
     */
    public boolean descargarFacturaXML(FacturaDTO factura, String filePath) throws GenerarFacturaException;

    /**
     * Método para validar si un pago ha sido facturado.
     * 
     * @param pago DTO del pago a validar
     * @return true si el pago ha sido facturado, false en caso contrario
     * @throws GenerarFacturaException si ocurre un error al validar el pago
     */
    public boolean validarPagoFacturado(PagoDTO pago) throws GenerarFacturaException;
}
