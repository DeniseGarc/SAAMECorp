/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorCalendario;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestorCalendario implements IGestorCalendario {

    @Override
    public List<Date> diasAgendaLlena() {
//        List<Date> diasConAgendaLlena = new ArrayList<>();
//        LocalDate fechaActual = LocalDate.now();
//        for (int i = 0; i < 5; i++) {
//            LocalDate fecha = fechaActual.plusDays(i);
//            diasConAgendaLlena.add(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        }
//        return diasConAgendaLlena;
        // Fechas azules (no seleccionables)
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2025, Calendar.MARCH, 23);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2025, Calendar.APRIL, 5);
        List<Date> fechasAzules = List.of(cal3.getTime(), cal4.getTime());
        return fechasAzules;
    }

    @Override
    public List<Date> diasConReservas() {
//        List<Date> diasConReservas = new ArrayList<>();
//        LocalDate fechaActual = LocalDate.now().plusDays(10);
//        for (int i = 0; i < 5; i++) {
//            LocalDate fecha = fechaActual.plusDays(i);
//            diasConReservas.add(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        }
// Fechas rojas (seleccionables)
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2025, Calendar.MARCH, 25);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2025, Calendar.APRIL, 10);
        List<Date> fechasNaranjas = List.of(cal1.getTime(), cal2.getTime());
        return fechasNaranjas;

    }

    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha) {

        return true;
    }
}
