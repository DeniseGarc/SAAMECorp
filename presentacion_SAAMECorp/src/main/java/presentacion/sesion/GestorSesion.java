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
    private static String identificadorUsuario;
    /**
     * Tipo de usuario
     */
    private static TipoUsuario tipoUsuario;
    /**
     * Nombre de usuario
     */
    private static String usuario;

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
     * Devuelve el nombre de usuario de la sesion.
     *
     * @return regresa el nombre de usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * Define el nombre de usuario de la sesión.
     *
     * @param usuario
     */
    public static void setUsuario(String usuario) {
        GestorSesion.usuario = usuario;
    }

    /**
     * Método que se utiliza para poder borrar los datos la sesión anterior
     * cuando se cierra sesión.
     */
    public static void borrarDatosSesion() {
        identificadorUsuario = null;
        tipoUsuario = null;
        usuario = null;
    }

}
