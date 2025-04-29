package excepciones;

/**
 * Clase que representa una excepción general del subsistema AgendarCita.
 *
 * @author Alici
 */
public class AgendarCitaException extends Exception {

    /**
     * Constructor por mensaje.
     *
     * @param message mensaje de la excepción
     */
    public AgendarCitaException(String message) {
        super(message);
    }

    /**
     * Constructor por mensaje y causa.
     *
     * @param message mensaje de la excepción
     * @param cause causa de la excepción
     */
    public AgendarCitaException(String message, Throwable cause) {
        super(message, cause);
    }

}
