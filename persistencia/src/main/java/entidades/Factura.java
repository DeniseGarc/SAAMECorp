package entidades;

import java.time.LocalDateTime;

/**
 * Clase que representa una factura en el sistema.
 *
 * @author Alici
 */
public class Factura {
    /**
     * Identificador único de la factura en el sistema de Facturama.
     */
    private String idFactura;
    /**
     * Folio de la factura.
     */
    private String folio;
    /**
     * Fecha y hora de emisión de la factura.
     */
    private LocalDateTime fechaHora;

    /**
     * Constructor por defecto.
     */
    public Factura() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param idFactura Identificador único de la factura en el sistema de
     *                  Facturama.
     * @param folio     Folio de la factura.
     * @param fechaHora Fecha y hora de emisión de la factura.
     */
    public Factura(String idFactura, String folio, LocalDateTime fechaHora) {
        this.idFactura = idFactura;
        this.folio = folio;
        this.fechaHora = fechaHora;
    }

    /**
     * Método que devuelve el identificador único de la factura en el sistema
     * de Facturama.
     * 
     * @return Identificador único de la factura.
     */
    public String getIdFactura() {
        return idFactura;
    }

    /**
     * Método que establece el identificador único de la factura en el sistema
     * de Facturama.
     * 
     * @param idFactura Identificador único de la factura.
     */
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * Método que devuelve el folio de la factura.
     * 
     * @return Folio de la factura.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Método que establece el folio de la factura.
     * 
     * @param folio Folio de la factura.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Método que devuelve la fecha y hora de emisión de la factura.
     * 
     * @return Fecha y hora de emisión de la factura.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Método que establece la fecha y hora de emisión de la factura.
     * 
     * @param fechaHora Fecha y hora de emisión de la factura.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

}
