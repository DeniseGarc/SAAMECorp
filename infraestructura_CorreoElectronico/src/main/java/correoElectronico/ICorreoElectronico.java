package correoElectronico;

/**
 * Interfaz que define el comportamiento del sistema de correo electrónico.
 *
 * @author Alici
 */
public interface ICorreoElectronico {

    /**
     * Método que envía un correo electrónico a la dirección de correo dada.
     * Envia el mensaje ingresado.
     *
     * @param correo Dirección de correo electrónico a la que se va a enviar el
     * mensaje.
     * @param mensaje Mensaje del correo electrónico.
     * @return
     */
    public boolean mandarCorreo(String correo, String mensaje);
}
