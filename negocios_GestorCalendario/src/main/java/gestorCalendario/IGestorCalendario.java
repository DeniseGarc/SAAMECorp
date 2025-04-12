/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorCalendario;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IGestorCalendario {

    public List<Calendar> diasAgendaLlena();

    public List<Calendar> diasConReservas();

    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Calendar fecha);
}
