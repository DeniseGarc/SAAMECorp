package excepciones;

/**
 * Clase de excepción personalizada para manejar errores relacionados con la
 * generación de facturas.
 * @author Alici
 */
public class GenerarFacturaException extends Exception {

    /**
     * Constructor de la excepción GenerarFacturaException.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public GenerarFacturaException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción GenerarFacturaException con causa.
     *
     * @param message Mensaje de error que describe la excepción.
     * @param cause   Causa de la excepción.
     */
    public GenerarFacturaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
