/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorCalendario;

import dto.PsicologoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IGestorCalendario {
    public abstract List<LocalDate> diasAgendaLlena();
    public abstract List<LocalDate> diasConReservas();
    public abstract boolean diaDisponiblePsicologo(PsicologoDTO psicologo, LocalDate fecha);
}
