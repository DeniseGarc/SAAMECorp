package generarFactura;

import dto.FacturaDTO;
import dto.PagoDTO;
import dto.ResultadoFacturarPago;
import excepciones.GenerarFacturaException;

/**
 * Clase que representa la lógica de negocio para la generación de facturas.
 * Esta clase implementa la interfaz IGenerarFactura y contiene métodos para
 * generar y enviar facturas a través de la API de Facturama.
 * 
 * @author Alici
 */
public class FGenerarFactura implements IGenerarFactura {
    /**
     * Instancia del controlador de generación de facturas.
     */
    private ControlGenerarFactura controlGenerarFactura = new ControlGenerarFactura();

    /**
     * Método para generar una factura a partir de un DTO de factura.
     * 
     * @param factura DTO de la factura a generar
     * @return ResultadoFacturarPago que contiene la factura generada y el estado
     *         del envío por correo
     * @throws GenerarFacturaException si ocurre un error al generar la factura
     */
    public ResultadoFacturarPago facturarPago(FacturaDTO factura) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        FacturaDTO facturaTimbrada = controlGenerarFactura.timbrarFactura(factura);
        if (facturaTimbrada == null || facturaTimbrada.getId() == null) {
            throw new GenerarFacturaException("Error al timbrar la factura");
        }
        ResultadoFacturarPago resultadoFacturarPago = new ResultadoFacturarPago(facturaTimbrada,
                controlGenerarFactura.mandarFacturaCorreo(facturaTimbrada));
        return resultadoFacturarPago;
    }

    /**
     * Método para descargar el PDF de una factura.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el PDF
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta
     * @throws GenerarFacturaException si ocurre un error al descargar el PDF
     */
    public boolean descargarFacturaPDF(FacturaDTO factura, String filePath) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new GenerarFacturaException("La ruta del archivo no puede ser nula o vacía");
        }
        return controlGenerarFactura.descargarPDF(factura, filePath);
    }

    /**
     * Método para descargar el XML de una factura.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el archivo XML
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta
     * @throws GenerarFacturaException si ocurre un error al descargar el XML
     */
    public boolean descargarFacturaXML(FacturaDTO factura, String filePath) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new GenerarFacturaException("La ruta del archivo no puede ser nula o vacía");
        }
        return controlGenerarFactura.descargarXML(factura, filePath);
    }

    /**
     * Método para validar si un pago ha sido facturado.
     * 
     * @param pago DTO del pago a validar
     * @return true si el pago ha sido facturado, false en caso contrario
     * @throws GenerarFacturaException si ocurre un error al validar el pago
     */
    public boolean validarPagoFacturado(PagoDTO pago) throws GenerarFacturaException {
        if (pago == null) {
            throw new GenerarFacturaException("El pago no puede ser nulo");
        }
        return controlGenerarFactura.validarPagoFacturado(pago);
    }
}
