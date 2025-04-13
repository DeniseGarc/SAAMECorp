package presentacion.sesion;

/**
 * Clase estática que se va a encargar de gestionar la sesión del usuario.
 *
 * @author Alici
 */
public class GestorSesion {

    /**
     * Identificador de usuario
     */
    private static String identificadorUsuario = "123";
    /**
     * Tipo de usuario
     */
    private static TipoUsuario tipoUsuario;

    /**
     * Método para obtener el identificador del usuario.
     *
     * @return identificador del usuario.
     */
    public static String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    /**
     * Método que define el identificador del usuario.
     *
     * @param identificadorUsuario Identificador del usuario.
     */
    public static void setIdentificadorUsuario(String identificadorUsuario) {
        GestorSesion.identificadorUsuario = identificadorUsuario;
    }

    /**
     * Devuelve el tipo de usuario de la sesión.
     *
     * @return tipo de usuario que inició sesión.
     */
    public static TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Define el tipo de usuario de la sesión.
     *
     * @param tipoUsuario Tipo de usuario que inició sesión.
     */
    public static void setTipoUsuario(TipoUsuario tipoUsuario) {
        GestorSesion.tipoUsuario = tipoUsuario;
    }

    /**
     * Método que se utiliza para poder borrar los datos la sesión anterior
     * cuando se cierra sesión.
     */
    public static void borrarDatosSesion() {
        identificadorUsuario = null;
        tipoUsuario = null;
    }

}
