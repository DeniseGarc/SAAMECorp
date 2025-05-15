/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepcion Personalizada para el subsistema de gestion de cubiculos
 * @author erika
 */
public class GestorCubiculosException extends Exception {
    /**
     * Constructor con mensaje.
     *
     * @param message Mensaje de la excepción
     */
    public GestorCubiculosException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param message Mensaje de la excepción.
     * @param cause Causa de la excepción.
     */
    public GestorCubiculosException(String message, Throwable cause) {
        super(message, cause);
    }
}
