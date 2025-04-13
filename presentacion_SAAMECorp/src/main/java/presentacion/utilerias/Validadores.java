package presentacion.utilerias;

import dto.CitaNuevaDTO;

/**
 * Clase de validadores para determinados campos del sistema.
 *
 * @author Alici
 */
public class Validadores {

    /**
     * Método que válida el formato de teléfono ingresado.
     *
     * @param telefono cadena de texto con el teléfono ingresado.
     * @return true si el formato es de minimo 1 digito y máximo 10, false en
     * caso contrario.
     */
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{1,10}");
    }

    /**
     * Método que valida el formato del correo electrónico ingresado.
     *
     * @param correo cadena de texto con el correo ingresado.
     * @return true si el correo esta en formato nombreusuario@dominio.algo,
     * false en caso contrario
     */
    public static boolean validarCorreo(String correo) {
        if (correo.length() > 100) {
            return false;
        }
        return correo.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Método que valida el nombre completo del paciente.
     *
     * @param nombrePaciente cadena de texto con el nombre completo del paciente
     * @return true si el nombre no excede los 100 caracteres y esta compuesto
     * por letras mayúsculas, minúsculas y acentos, false en caso contrario.
     */
    public static boolean validarNombrePaciente(String nombrePaciente) {
        if (nombrePaciente.length() > 100) {
            return false;
        }
        return nombrePaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+");
    }

    /**
     * Método que valida que la cita tenga todos los campos ingresados y que
     * dichos campos cumplan con los formatos adecuados.
     *
     * @param cita cita a registrar.
     * @return String con el mensaje correspondiente si es que falló en alguna
     * validación.
     */
    public static String validarCita(CitaNuevaDTO cita) {
        if (cita.getPsicologo() == null) {
            return "Debe de seleccionar un psicólogo";
        }
        if (cita.getFechaHora() == null) {
            return "Ocurrió un error con la fecha";
        }
        if (cita.getCubiculo() == null || cita.getCubiculo().isBlank()) {
            return "Debe de seleccionar un cubículo";
        }
        if (cita.getNombrePaciente().isBlank()) {
            return "Debe de ingresar el nombre del paciente";
        }
        if (!validarNombrePaciente(cita.getNombrePaciente())) {
            return "El nombre del paciente no debe llevar caracteres especiales o dígitos";
        }
        if (cita.getCorreoPaciente().isBlank()) {
            return "Debe de ingresar un correo electrónico";
        }
        if (!validarCorreo(cita.getCorreoPaciente())) {
            return "El formato del correo electrónico debe ser válido";
        }
        if (cita.getTelefonoPaciente().isBlank()) {
            return "Debe de ingresar el número de teléfono del paciente";
        }
        if (!validarTelefono(cita.getTelefonoPaciente())) {
            return "El número de teléfono debe ser de 10 dígitos";
        }
        return null; // No hay errores
    }
}
