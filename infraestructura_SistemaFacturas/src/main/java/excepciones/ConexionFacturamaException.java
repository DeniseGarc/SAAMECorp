package excepciones;

/**
 * Clase que hereda de Exception la cual representa una excepción de conexion
 * con la API Facturama.
 *
 * @author Alici
 */
public class ConexionFacturamaException extends Exception {

    /**
     * Constructor que crea una excepción con mensaje personalizado.
     *
     * @param message Mensaje de la excepción.
     */
    public ConexionFacturamaException(String message) {
        super(message);
    }

    /**
     * Constructor que crea una excepción con mensaje y causa.
     *
     * @param message Mensaje de la excepción.
     * @param cause Causa de la excepción.
     */
    public ConexionFacturamaException(String message, Throwable cause) {
        super(message, cause);
    }

}
