package correoElectronico;

import dto.CorreoDTO;

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
     * @param correo dto con los datos que se necesitan para el correo
     * @return true si el correo se envio exitosamente o false en caso contrario
     */
    public boolean mandarCorreo(CorreoDTO correo);
}
