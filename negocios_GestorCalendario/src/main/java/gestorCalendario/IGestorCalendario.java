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
    public List<LocalDate> diasAgendaLlena();
    public List<LocalDate> diasConReservas();
    public boolean diaDisponiblePsicologo(PsicologoDTO psicologo, LocalDate fecha);
}
