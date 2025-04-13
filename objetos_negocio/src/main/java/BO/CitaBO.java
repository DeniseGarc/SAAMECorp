/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import interfaces.ICitaBO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Clase que implementa la logica de negocio para las citas
 *
 * @author erika
 */
public class CitaBO implements ICitaBO {

    /**
     * Metodo que obtiene la disponibilidad de un psicólogo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     */
    @Override
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, PsicologoDTO psicologo) {
        List<Calendar> horasDisponibles = new LinkedList<>();

        int year = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH);
        int day = fecha.get(Calendar.DAY_OF_MONTH);

        // Simulamos las horas disponibles del psicólogo en el día dado
        int[][] horas = {
            {9, 0},
            {11, 0},
            {14, 0},
            {17, 30}
        };

        for (int[] horaMinuto : horas) {
            Calendar hora = Calendar.getInstance();
            hora.set(year, month, day, horaMinuto[0], horaMinuto[1], 0);
            hora.set(Calendar.MILLISECOND, 0);
            horasDisponibles.add(hora);
        }

        return horasDisponibles;
    }

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosNoDisponibles(Calendar fecha) {
        List<CubiculoDTO> listaCubiculos = new LinkedList<>();
        listaCubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 3", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 4", true));
        return listaCubiculos;
    }

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     */
    @Override
    public CitaRegistradaDTO guardarCita(CitaNuevaDTO cita) {
        String idGenerado = UUID.randomUUID().toString();

        return new CitaRegistradaDTO(
                idGenerado,
                cita.getFechaHora(),
                cita.getCubiculo(),
                cita.getPsicologo(),
                cita.getNombrePaciente(),
                cita.getTelefonoPaciente(),
                cita.getCorreoPaciente(),
                null // Adeudo inicializado como null
        );
    }

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     */
    @Override
    public List<Calendar> obtenerFechasConCitaAgendada() {
        List<Calendar> fechasAgendadas = new LinkedList<>();

        fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 1)));
        fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 5)));
        fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 10)));
        fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 15)));

        return fechasAgendadas;
    }

    /**
     * Metodo para consultar si un cubiculo ya tiene citas registradas en un dia
     * dao
     *
     * @param cubiculo Cubiculo a consultar
     * @param fecha Fecha a consult
     * @return True hay horas disponibles
     */
    @Override
    public boolean cubiculoTieneHorasDisponiblesDia(CubiculoDTO cubiculo, Calendar fecha) {
        // Simulación de disponibilidad
        return true;
    }

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     */
    @Override
    public List<CitaRegistradaDTO> obtenerCitas() {
        List<CitaRegistradaDTO> citas = new LinkedList<>();

        List<LocalTime> horario = List.of(
                LocalTime.of(8, 0),
                LocalTime.of(10, 30),
                LocalTime.of(13, 15),
                LocalTime.of(16, 45),
                LocalTime.of(19, 0)
        );

        PsicologoDTO jose = new PsicologoDTO("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com", horario);
        PsicologoDTO jorge = new PsicologoDTO("Jorge", "Blanco", "Verdugo", "jorge@gmail.com", horario);

        citas.add(new CitaRegistradaDTO("1", toCalendar(LocalDateTime.of(2025, 4, 1, 9, 0)), "Cubiculo 1", jose, "Paciente 1", "123456789", "paciente1@email.com", null));
        citas.add(new CitaRegistradaDTO("2", toCalendar(LocalDateTime.of(2025, 4, 5, 11, 0)), "Cubiculo 2", jorge, "Paciente 2", "987654321", "paciente2@email.com", null));
        citas.add(new CitaRegistradaDTO("3", toCalendar(LocalDateTime.of(2025, 4, 10, 14, 0)), "Cubiculo 3", jorge, "Paciente 3", "456123789", "paciente3@email.com", null));
        citas.add(new CitaRegistradaDTO("4", toCalendar(LocalDateTime.of(2025, 4, 15, 17, 30)), "Cubiculo 4", jose, "Paciente 4", "789321654", "paciente4@email.com", null));

        return citas;
    }

    // Métodos auxiliares
    private Calendar toCalendar(LocalDateTime dateTime) {
        return GregorianCalendar.from(dateTime.atZone(ZoneId.systemDefault()));
    }

    private Calendar toCalendar(LocalDate date) {
        return GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
    }
}
