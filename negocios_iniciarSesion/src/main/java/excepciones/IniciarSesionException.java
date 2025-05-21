package excepciones;

/**
 * Exceción personalizada para la clase IniciarSesion.
 * @author Alici
 */
public class IniciarSesionException extends Exception {

    /**
     * Constructor con mensaje.
     */
    public IniciarSesionException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     */
    public IniciarSesionException(String message, Throwable cause) {
        super(message, cause);
    }

}
