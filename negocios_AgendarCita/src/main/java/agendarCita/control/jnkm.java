/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agendarCita.control;

import java.util.Calendar;

/**
 *
 * @author Maryr
 */
public class jnkm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlAgendarCita agendarCita = new ControlAgendarCita();
        System.out.println(agendarCita.obtenerCubiculosDisponiblesHorario(Calendar.getInstance()));
    }
    
}
