package sistemaFacturas;

import DTO.FacturaRegistroDTO;
import excepciones.ConexionFacturamaException;

/**
 * Interfaz que define los métodos para la conexión con la API de Facturama.
 *
 * @author Alici
 */
public interface ISistemaFacturas {

    /**
     * Método para timbrar la factura.
     *
     * @param factura DTO de la factura a timbrar
     * @return DTO de la factura timbrada
     * @throws ConexionFacturamaException si ocurre un error al timbrar la
     * factura.
     */
    public FacturaRegistroDTO timbrarFactura(FacturaRegistroDTO factura) throws ConexionFacturamaException;

    /**
     * Método para enviar la factura por correo.
     *
     * @param factura DTO de la factura a enviar por correo
     * @return true si se envió correctamente, false en caso contrario
     * @throws ConexionFacturamaException si ocurre un error al enviar la
     * factura por correo.
     */
    public boolean mandarFacturaCorreo(FacturaRegistroDTO factura) throws ConexionFacturamaException;

    /**
     * Método para descargar el PDF de la factura.
     *
     * @param factura DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el PDF
     * @return true si se descarga correctamente, false si se cancela la
     * selección de ruta.
     * @throws ConexionFacturamaException si ocurre un error al descargar el
     * PDF.
     */
    public boolean descargarPDF(FacturaRegistroDTO factura, String filePath) throws ConexionFacturamaException;

    /**
     * Método para descargar el XML de la factura.
     *
     * @param factura DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el archivo XML
     * @return true si se descarga correctamente, false si se cancela la
     * selección de ruta.
     * @throws ConexionFacturamaException si ocurre un error al descargar el
     * XML.
     */
    public boolean descargarXML(FacturaRegistroDTO factura, String filePath) throws ConexionFacturamaException;
}
