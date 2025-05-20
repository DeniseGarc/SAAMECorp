package presentacion;

import presentacion.control.CoordinadorAplicacion;

/**
 * Clase principal que inicializa la pantalla de inicio del sistema.
 *
 * @author erika
 */
public class inicio {

    /**
     * Método principal que le indica al coordinador de la aplicación que abra
     * la pantalla de inicio de sesión.
     *
     * @param args
     */
    public static void main(String[] args) {
        CoordinadorAplicacion control = CoordinadorAplicacion.getInstance();
        control.pantallaInicioSesion();
        

    }

}
