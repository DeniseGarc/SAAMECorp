/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción personalizada para manejar errores de negocio.
 * 
 * @author Maryr
 */
public class NegocioException extends Exception {
    /**
     * Construye una excepcion de negocio con el mensaje indicado.
     * 
     * @param message Mensaje de la excepcion.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Construye una excepcion de negocio con el mensaje y la causa indicados.
     * 
     * @param message Mensaje de la excepcion
     * @param cause   Causa de la excepcion.
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
