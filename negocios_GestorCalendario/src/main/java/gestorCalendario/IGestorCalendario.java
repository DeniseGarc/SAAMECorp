/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorCalendario;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IGestorCalendario {

    public List<Date> diasAgendaLlena();

    public List<Date> diasConReservas();

    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha);
}
