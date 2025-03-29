/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionCitas;

import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestionCitas implements IGestionCitas {

    // todavia no se utiliza por lo que no se mockea
    @Override
    public CitaRegistradaDTO agendarCita(CitaNuevaDTO cita) {
        return new CitaRegistradaDTO();
    }

    // devuelve la lista de dias con cita 
    @Override
    public List<Date> obtenerDiasConCita() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2025, Calendar.MARCH, 25);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2025, Calendar.APRIL, 10);
        List<Date> diasConCita = List.of(cal1.getTime(), cal2.getTime());
        return diasConCita;
    }

    // devuelve la lista de dias que tienen agenda llena
    @Override
    public List<Date> obtenerDiasConAgendaLlena() {

        Calendar cal3 = Calendar.getInstance();
        cal3.set(2025, Calendar.MARCH, 23);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2025, Calendar.APRIL, 5);
        List<Date> diasConAgendaLlena = List.of(cal3.getTime(), cal4.getTime());
        return diasConAgendaLlena;
    }

    @Override
    public boolean validarFechaCitaRepetida(CitaNuevaDTO citaNueva) {
        return false;
    }

}
