/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Excepcion Personalizada para el subsistema de Gestion de Reportes
 * 
 * @author erika
 */
public class GestorReportesException extends Exception {
    /**
     * Constructor con mensaje.
     *
     * @param message Mensaje de la excepción
     */
    public GestorReportesException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param message Mensaje de la excepción.
     * @param cause Causa de la excepción.
     */
    public GestorReportesException(String message, Throwable cause) {
        super(message, cause);
    }
}
