/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepcion personalizada para subsistema modificar citas 
 * @author Maryr
 */
public class ModificarCitaException extends Exception {

    /**
     * Constructor para excepcion con mensaje de error
     * @param message  el mensaje de la excepcion
     */
    public ModificarCitaException(String message) {
        super(message);
    }

    /**
     * Constructor para excepcion con mensaje y causa de error
     * @param message el mensaje de la excepcion
     * @param cause la causa de la excepcion
     */
    public ModificarCitaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
