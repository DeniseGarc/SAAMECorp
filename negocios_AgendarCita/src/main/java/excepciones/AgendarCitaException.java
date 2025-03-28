/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Alici
 */
public class AgendarCitaException extends Exception {

    public AgendarCitaException(String message) {
        super(message);
    }

    public AgendarCitaException(String message, Throwable cause) {
        super(message, cause);
    }

}
