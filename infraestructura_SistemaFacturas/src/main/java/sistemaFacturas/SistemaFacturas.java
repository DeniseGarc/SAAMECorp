package sistemaFacturas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.Facturama.sdk_java.Services.*;
import com.Facturama.sdk_java.Container.FacturamaApi;
import com.Facturama.sdk_java.Models.Request.CfdiType;
import com.Facturama.sdk_java.Models.Request.Item;
import com.Facturama.sdk_java.Models.Request.Receiver;
import com.Facturama.sdk_java.Models.Response.Cfdi;
import DTO.FacturaRegistroDTO;
import excepciones.ConexionFacturamaException;

/**
 * Clase que implementa la interfaz ISistemaFacturas. Esta clase se encarga de
 * la conexión con la API de Facturama para timbrar, enviar por correo y
 * descargar los archivos PDF y XML de las facturas.
 *
 * @author Alici
 */
public class SistemaFacturas implements ISistemaFacturas {

    /**
     * Instancia de la API de Facturama.
     */
    FacturamaApi instanciaFacturama = new FacturamaApi("ConsultorioAlleri", "6oUrDWr4eVoP3d8Ldybfyo", isDevMode);
    /**
     * Modo de desarrollo. Cambiar a false para modo de producción.
     */
    private static final boolean isDevMode = true;

    /**
     * Método para timbrar la factura.
     *
     * @param factura DTO de la factura a timbrar
     * @return DTO de la factura timbrada
     * @throws ConexionFacturamaException si ocurre un error al timbrar la
     * factura.
     */
    @Override
    public FacturaRegistroDTO timbrarFactura(FacturaRegistroDTO factura) throws ConexionFacturamaException {
        com.Facturama.sdk_java.Models.Request.Cfdi cfdi = new com.Facturama.sdk_java.Models.Request.Cfdi();
        // Establecer los datos de la factura
        cfdi.setCurrency(factura.getCurrency());
        cfdi.setExpeditionPlace(factura.getExpeditionPlace());
        cfdi.setPaymentConditions(factura.getPaymentConditions());
        cfdi.setCfdiType(CfdiType.Ingreso.getValue());
        cfdi.setPaymentForm(factura.getPaymentForm());
        cfdi.setPaymentMethod(factura.getPaymentMethod());
        // Establecer datos del receptor
        Receiver receiver = new Receiver();
        receiver.setRfc(factura.getRfcReceiver());
        receiver.setName(factura.getNameReceiver());
        receiver.setCfdiUse(factura.getCfdiUse());
        receiver.setFiscalRegime(factura.getFiscalRegime());
        receiver.setTaxZipCode(factura.getTaxZipCode());
        cfdi.setReceiver(receiver);
        // Establecer datos del producto o servicio
        List<Item> lstItems = new ArrayList<>();
        Item item = new Item();
        item.setProductCode(factura.getProductCode());
        item.setDescription(factura.getDescription());
        item.setUnit(factura.getUnit());
        item.setUnitCode(factura.getUnitCode());
        item.setUnitPrice(factura.getUnitPrice());
        item.setQuantity(factura.getQuantity());
        item.setTaxObject(factura.getTaxObject());
        item.setSubtotal(factura.getSubtotal());
        item.setTotal(factura.getTotal());
        lstItems.add(item);
        cfdi.setItems(lstItems);

        try {
            // Timbrar la factura
            Cfdi facturaCfdi = instanciaFacturama.Cfdis().Create3(cfdi);
            // Establecer los datos de la factura timbrada
            factura.setId(facturaCfdi.getId());
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            LocalDateTime fechaHora = LocalDateTime.parse(facturaCfdi.getDate(), formatter);
            factura.setFechaHoraEmision(fechaHora);

            return factura;
        } catch (Exception e) {
            Logger.getLogger(SistemaFacturas.class.getName()).log(Level.SEVERE, null, e);
            throw new ConexionFacturamaException("Error al timbrar la factura: " + e.getMessage(), e);
        }
    }

    /**
     * Método para enviar la factura por correo.
     *
     * @param factura DTO de la factura a enviar
     * @return true si se envía correctamente, false si ocurre un error.
     * @throws ConexionFacturamaException si ocurre un error al enviar el
     * correo.
     */
    @Override
    public boolean mandarFacturaCorreo(FacturaRegistroDTO factura) throws ConexionFacturamaException {
        try {
            instanciaFacturama.Cfdis().SendEmail(factura.getEmailReceiver(), CfdiService.InvoiceType.Issued,
                    factura.getId());
            return true;
        } catch (Exception e) {
            Logger.getLogger(SistemaFacturas.class.getName()).log(Level.SEVERE, null, e);
            throw new ConexionFacturamaException("Error al enviar la factura por correo: " + e.getMessage(), e);
        }
    }

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
    @Override
    public boolean descargarPDF(FacturaRegistroDTO factura, String filePath) throws ConexionFacturamaException {
        try {

            instanciaFacturama.Cfdis().SavePdf(filePath + ".pdf", factura.getId().toString());
            return true;
        } catch (Exception e) {
            Logger.getLogger(SistemaFacturas.class.getName()).log(Level.SEVERE, null, e);
            throw new ConexionFacturamaException("Error al descargar el PDF: " + e.getMessage(), e);
        }
    }

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
    @Override
    public boolean descargarXML(FacturaRegistroDTO factura, String filePath) throws ConexionFacturamaException {
        try {
            instanciaFacturama.Cfdis().SaveXml(filePath + ".xml", factura.getId().toString());
            return true;
        } catch (Exception e) {
            Logger.getLogger(SistemaFacturas.class.getName()).log(Level.SEVERE, null, e);
            throw new ConexionFacturamaException("Error al descargar el XML: " + e.getMessage(), e);
        }
    }

}
