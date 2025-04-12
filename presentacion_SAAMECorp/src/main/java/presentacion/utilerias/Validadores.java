/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import dto.CitaNuevaDTO;

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
