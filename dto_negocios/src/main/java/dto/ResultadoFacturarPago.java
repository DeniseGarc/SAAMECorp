package dto;

/**
 * Clase que representa el resultado de la facturación de un pago.
 * Contiene la información de la factura generada y un indicador de si el correo
 * fue enviado correctamente.
 * 
 * @author Alici
 */
public class ResultadoFacturarPago {
    /**
     * DTO de la factura generada.
     */
    private FacturaDTO factura;
    /*
     * Indicador de si el correo fue enviado correctamente.
     */
    private boolean correoEnviado;

    /**
     * Constructor que inicializa la factura y el indicador de correo enviado.
     * 
     * @param factura
     */
    public ResultadoFacturarPago(FacturaDTO factura, boolean correoEnviado) {
        this.factura = factura;
        this.correoEnviado = correoEnviado;
    }

    /**
     * Constructor vacío.
     */
    public ResultadoFacturarPago() {
        // Constructor vacío
    }

    /**
     * Obtiene el DTO de la factura generada.
     * 
     * @return DTO de la factura generada.
     */
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     * Establece el DTO de la factura generada.
     * 
     * @param factura DTO de la factura generada.
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    /**
     * Verifica si el correo fue enviado correctamente.
     * 
     * @return true si el correo fue enviado, false en caso contrario.
     */
    public boolean isCorreoEnviado() {
        return correoEnviado;
    }

    /**
     * Establece el indicador de si el correo fue enviado correctamente.
     * 
     * @param correoEnviado true si el correo fue enviado, false en caso contrario.
     */
    public void setCorreoEnviado(boolean correoEnviado) {
        this.correoEnviado = correoEnviado;
    }
}
