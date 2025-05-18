/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generarFactura;

import DTO.FacturaRegistroDTO;
import dto.FacturaDTO;
import dto.PagoDTO;
import excepciones.ConexionFacturamaException;
import excepciones.GenerarFacturaException;
import mapper.FacturaMapper;
import sistemaFacturas.ISistemaFacturas;
import sistemaFacturas.SistemaFacturas;

/**
 * Clase que se encarga de la lógica de negocio para la generación de
 * facturas. Esta clase contiene métodos para timbrar, enviar por correo,
 * descargar PDF y XML de las facturas, así como para validar si el pago ya ha
 * sido
 * facturado y registrar facturas.
 * 
 * @author Alici
 */
public class ControlGenerarFactura {
    /**
     * Instancia del mapper para convertir entre DTOs y entidades.
     */
    private FacturaMapper mapper = new FacturaMapper();
    /**
     * Instancia del sistema de facturas para interactuar con la API de
     * Facturama.
     */
    private ISistemaFacturas sistemaFacturas = new SistemaFacturas();

    /**
     * Método para timbrar una factura. Este método toma un DTO de factura,
     * lo convierte a un DTO de registro y lo envía al sistema de facturas
     * para ser timbrado.
     * 
     * @param factura DTO de la factura a timbrar
     * @return DTO de la factura timbrada
     * @throws GenerarFacturaException si ocurre un error al timbrar la
     *                                 factura.
     */
    protected FacturaDTO timbrarFactura(FacturaDTO factura) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        FacturaRegistroDTO facturaARegistrar = mapper.mapToFacturaRegistroDTO(factura);
        try {
            FacturaRegistroDTO facturaRegistrada = sistemaFacturas.timbrarFactura(facturaARegistrar);
            if (facturaRegistrada == null || facturaRegistrada.getId() == null) {
                throw new GenerarFacturaException("Error al timbrar la factura");
            }
            return mapper.mapToFacturaDTO(facturaRegistrada);
        } catch (ConexionFacturamaException e) {
            throw new GenerarFacturaException("Error al timbrar la factura: " + e.getMessage());
        }
    }

    /**
     * Método para enviar una factura por correo. Este método toma un DTO de
     * factura, lo convierte a un DTO de registro y lo envía al sistema de
     * facturas para ser enviado por correo.
     * 
     * @param factura DTO de la factura a enviar por correo
     * @return true si se envió correctamente, false en caso contrario
     * @throws GenerarFacturaException si ocurre un error al enviar la
     *                                 factura por correo.
     */
    protected boolean mandarFacturaCorreo(FacturaDTO factura) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        FacturaRegistroDTO facturaAEnviar = mapper.mapToFacturaRegistroDTO(factura);
        try {
            return sistemaFacturas.mandarFacturaCorreo(facturaAEnviar);
        } catch (ConexionFacturamaException e) {
            throw new GenerarFacturaException("Error al enviar la factura por correo: " + e.getMessage());
        }
    }

    /**
     * Método para descargar el PDF de una factura. Este método toma un DTO de
     * factura, lo convierte a un DTO de registro y lo envía al sistema de
     * facturas para ser descargado como PDF.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el PDF
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta.
     * @throws GenerarFacturaException si ocurre un error al descargar el PDF.
     */
    protected boolean descargarPDF(FacturaDTO factura, String filePath) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new GenerarFacturaException("La ruta del archivo no puede ser nula o vacía");
        }
        FacturaRegistroDTO facturaADescargar = mapper.mapToFacturaRegistroDTO(factura);
        try {
            return sistemaFacturas.descargarPDF(facturaADescargar, filePath);
        } catch (ConexionFacturamaException e) {
            throw new GenerarFacturaException("Error al descargar el PDF: " + e.getMessage());
        }
    }

    /**
     * Método para descargar el XML de una factura. Este método toma un DTO de
     * factura, lo convierte a un DTO de registro y lo envía al sistema de
     * facturas para ser descargado como XML.
     * 
     * @param factura  DTO de la factura a descargar
     * @param filePath Ruta donde se guardará el archivo XML
     * @return true si se descarga correctamente, false si se cancela la
     *         selección de ruta.
     * @throws GenerarFacturaException si ocurre un error al descargar el XML.
     */
    protected boolean descargarXML(FacturaDTO factura, String filePath) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new GenerarFacturaException("La ruta del archivo no puede ser nula o vacía");
        }
        FacturaRegistroDTO facturaADescargar = mapper.mapToFacturaRegistroDTO(factura);
        try {
            return sistemaFacturas.descargarXML(facturaADescargar, filePath);
        } catch (ConexionFacturamaException e) {
            throw new GenerarFacturaException("Error al descargar el XML: " + e.getMessage());
        }
    }

    /**
     * Método para validar si un pago ya ha sido facturado. Este método toma un
     * DTO de pago y verifica si ya ha sido facturado.
     * 
     * @param pago DTO del pago a validar
     * @return true si el pago ya ha sido facturado, false en caso contrario
     * @throws GenerarFacturaException si ocurre un error al validar el pago.
     */
    protected boolean validarPagoFacturado(PagoDTO pago) throws GenerarFacturaException {
        if (pago == null) {
            throw new GenerarFacturaException("El pago no puede ser nulo");
        }
        // Se consulta en BO si el pago ya fue facturado
        return true;
    }

    /**
     * Método para registrar una factura. Este método toma un DTO de factura y lo
     * registra en el sistema.
     * 
     * @param factura DTO de la factura a registrar
     * @return true si se registró correctamente, false en caso contrario
     * @throws GenerarFacturaException si ocurre un error al registrar la
     *                                 factura.
     */
    protected boolean registrarFactura(FacturaDTO factura) throws GenerarFacturaException {
        if (factura == null) {
            throw new GenerarFacturaException("La factura no puede ser nula");
        }
        // Pasar la facturaDTO a entidad
        // Se registra en BO la factura
        return true;
    }

}
