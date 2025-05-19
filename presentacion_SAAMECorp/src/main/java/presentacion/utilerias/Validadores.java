package presentacion.utilerias;

import dto.CitaNuevaDTO;
import dto.FacturaDTO;

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
     *         caso contrario.
     */
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{1,10}");
    }

    /**
     * Método que valida el formato del correo electrónico ingresado.
     *
     * @param correo cadena de texto con el correo ingresado.
     * @return true si el correo esta en formato nombreusuario@dominio.algo,
     *         false en caso contrario
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
     *         por letras mayúsculas, minúsculas y acentos, false en caso contrario.
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
     *         validación.
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

    /**
     * Método que valida el formato del código postal ingresado.
     *
     * @param codigoPostal cadena de texto con el código postal ingresado.
     * @return true si el código postal es de 5 dígitos, false en caso contrario.
     */
    public static boolean validarCodigoPostal(String codigoPostal) {
        return codigoPostal.matches("\\d{5}");
    }

    /**
     * Método que valida los datos de la factura.
     *
     * @param factura DTO de la factura a validar.
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    public static String validarDatosFactura(FacturaDTO factura) {
        if (factura.getCurrency() == null || factura.getCurrency().isBlank()) {
            return "Debe de indicar una moneda";
        }
        if (factura.getExpeditionPlace() == null || factura.getExpeditionPlace().isBlank()) {
            return "Debe de indicar un lugar de expedición";
        }
        if (factura.getPaymentConditions() == null || factura.getPaymentConditions().isBlank()) {
            return "Debe de indicar una condición de pago";
        }
        if (factura.getCfdiType() == null || factura.getCfdiType().isBlank()) {
            return "Debe de indicar un tipo de CFDI";
        }
        if (factura.getPaymentForm() == null || factura.getPaymentForm().isBlank()) {
            return "Debe de indicar una forma de pago";
        }
        if (factura.getPaymentMethod() == null || factura.getPaymentMethod().isBlank()) {
            return "Debe de indicar un método de pago";
        }
        if (factura.getRfcReceiver() == null || factura.getRfcReceiver().isBlank()) {
            return "Debe de indicar un RFC receptor";
        }
        if (factura.getNameReceiver() == null || factura.getNameReceiver().isBlank()) {
            return "Debe de indicar un nombre receptor";
        }
        if (factura.getEmailReceiver() == null || factura.getEmailReceiver().isBlank()) {
            return "Debe de indicar un correo electrónico receptor";
        }
        if (factura.getCfdiUse() == null || factura.getCfdiUse().isBlank()) {
            return "Debe de indicar un uso de CFDI";
        }
        if (factura.getFiscalRegime() == null || factura.getFiscalRegime().isBlank()) {
            return "Debe de indicar un régimen fiscal";
        }
        if (factura.getTaxZipCode() == null || factura.getTaxZipCode().isBlank()) {
            return "Debe de indicar un código postal fiscal";
        }
        if (factura.getProductCode() == null || factura.getProductCode().isBlank()) {
            return "Debe de indicar un código de producto";
        }
        if (factura.getDescription() == null || factura.getDescription().isBlank()) {
            return "Debe de indicar una descripción";
        }
        if (factura.getUnit() == null || factura.getUnit().isBlank()) {
            return "Debe de indicar una unidad";
        }
        if (factura.getUnitCode() == null || factura.getUnitCode().isBlank()) {
            return "Debe de indicar un código de unidad";
        }
        if (factura.getUnitPrice() <= 0) {
            return "Debe de indicar un precio unitario mayor a 0";
        }
        if (factura.getQuantity() <= 0) {
            return "Debe de indicar una cantidad mayor a 0";
        }
        if (factura.getSubtotal() <= 0) {
            return "Debe de indicar un subtotal mayor a 0";
        }
        if (factura.getTotal() <= 0) {
            return "Debe de indicar un total mayor a 0";
        }
        if (factura.getTaxObject() == null || factura.getTaxObject().isBlank()) {
            return "Debe de indicar un objeto de impuesto";
        }
        if (!validarCodigoPostal(factura.getTaxZipCode())) {
            return "El código postal fiscal debe ser de 5 dígitos";
        }
        if (!validarCorreo(factura.getEmailReceiver())) {
            return "El formato del correo electrónico receptor debe ser válido";
        }

        return null; // Todos los campos son válidos
    }
}
