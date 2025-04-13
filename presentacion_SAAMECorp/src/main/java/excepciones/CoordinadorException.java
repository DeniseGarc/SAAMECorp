package excepciones;

/**
 * Clase que lanza excepciones cuando sucede un error en coordinador.
 *
 * @author Alici
 */
public class CoordinadorException extends Exception {

    /**
     * Constructor con mensaje.
     *
     * @param message Mensaje de la excepción
     */
    public CoordinadorException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param message Mensaje de la excepción
     * @param cause Causa de la excepción
     */
    public CoordinadorException(String message, Throwable cause) {
        super(message, cause);
    }

}
