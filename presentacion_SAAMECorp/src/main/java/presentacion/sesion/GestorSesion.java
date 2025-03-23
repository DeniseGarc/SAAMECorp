/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.sesion;

/**
 *
 * @author Alici
 */
public class GestorSesion {

    private static String identificadorUsuario = "123";
    private static TipoUsuario tipoUsuario = TipoUsuario.ADMIN;

    public static String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public static void setIdentificadorUsuario(String identificadorUsuario) {
        GestorSesion.identificadorUsuario = identificadorUsuario;
    }

    public static TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(TipoUsuario tipoUsuario) {
        GestorSesion.tipoUsuario = tipoUsuario;
    }

    public static void borrarDatosSesion() {
        identificadorUsuario = null;
        tipoUsuario = null;
    }

}
