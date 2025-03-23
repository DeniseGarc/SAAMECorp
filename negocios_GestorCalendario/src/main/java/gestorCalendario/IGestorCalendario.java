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

    public abstract List<Date> diasAgendaLlena();

    public abstract List<Date> diasConReservas();

    public abstract boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha);
}
