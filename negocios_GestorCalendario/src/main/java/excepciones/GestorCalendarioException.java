package excepciones;

/**
 * Clase que herada de Exception, representa una excepción general en el
 * subsistema Gestor de calendario.
 *
 * @author Alici
 */
public class GestorCalendarioException extends Exception {

    /**
     * Constructor con mensaje.
     *
     * @param message Mensaje de la excepción
     */
    public GestorCalendarioException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param message Mensaje de la excepción.
     * @param cause Causa de la excepción.
     */
    public GestorCalendarioException(String message, Throwable cause) {
        super(message, cause);
    }

}
