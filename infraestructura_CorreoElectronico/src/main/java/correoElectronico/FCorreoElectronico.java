package correoElectronico;

/**
 * Clase fachada que implementa la interfaz ICorreoElectrónico para el envío de
 * correos,
 *
 * @author Alici
 */
public class FCorreoElectronico implements ICorreoElectronico {

    @Override
    public boolean mandarCorreo(String correo, String mensaje) {
        return true;
    }

}
