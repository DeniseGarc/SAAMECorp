/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author Alici
 */
public class Validadores {

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{1,10}");
    }

    public static boolean validarCorreo(String correo) {
        if (correo.length() > 100) {
            return false;
        }
        return correo.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean validarNombrePaciente(String nombrePaciente) {
        if (nombrePaciente.length() > 100) {
            return false;
        }
        return nombrePaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+");
    }
}
