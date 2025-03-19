/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorCalendario;

import dto.PsicologoDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestorCalendario implements IGestorCalendario{

    @Override
    public List<LocalDate> diasAgendaLlena() {
        List<LocalDate> diasConAgendaLlena = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            diasConAgendaLlena.add(fechaActual.plusDays(i));
        }
        return diasConAgendaLlena;
    }

    @Override
    public List<LocalDate> diasConReservas() {
        List<LocalDate> diasConReservas = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            diasConReservas.add(fechaActual.plusDays(i));
        }
        return diasConReservas;
    }

    @Override
    public boolean diaDisponiblePsicologo(PsicologoDTO psicologo, LocalDate fecha) {

        return false;
    }
}
