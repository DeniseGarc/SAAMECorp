package excepciones;

/**
 * Excepción personalizada para el módulo de pagos.
 * Esta clase extiende la clase Exception y se utiliza para manejar errores
 * específicos relacionados con la lógica de negocio de los pagos.
 *
 * @author Alici
 */
public class PagosException extends Exception {

    /**
     * Constructor que permite especificar un mensaje de error.
     * 
     * @param message Mensaje de error.
     */
    public PagosException(String message) {
        super(message);
    }

    /**
     * Constructor que permite especificar un mensaje de error y una causa.
     *
     * @param message Mensaje de error.
     * @param cause   Causa del error.
     */
    public PagosException(String message, Throwable cause) {
        super(message, cause);
    }

}
