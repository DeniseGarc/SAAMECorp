/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import interfaces.ICitaBO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
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
        List<LocalTime> horasDisponibles = new LinkedList<>();

        horasDisponibles.add(LocalTime.of(9, 0));
        horasDisponibles.add(LocalTime.of(11, 0));
        horasDisponibles.add(LocalTime.of(14, 0));
        horasDisponibles.add(LocalTime.of(17, 30));

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
    public CitaNuevaDTO guardarCita(CitaNuevaDTO cita) {
        return cita;
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
    public List<CitaDTO> obtenerCitas() {
        List<CitaDTO> citas = new LinkedList<>();
        // Citas simuladas
        citas.add(new CitaDTO(toCalendar(LocalDateTime.of(2025, 5, 1, 9, 0)), "Cubiculo 1"));
        citas.add(new CitaDTO(toCalendar(LocalDateTime.of(2025, 5, 5, 11, 0)), "Cubiculo 2"));
        citas.add(new CitaDTO(toCalendar(LocalDateTime.of(2025, 5, 10, 14, 0)), "Cubiculo 3"));
        citas.add(new CitaDTO(toCalendar(LocalDateTime.of(2025, 4, 15, 17, 30)), "Cubiculo 4"));

        return citas;
    }
    
    /**
     * Metodo para validar que no exista otra cita que tenga la misma fechaHora
     * y cubiculo igual
     *
     * @param citaARegistrar
     * @return true si no existe otra cita igual, false si existe otra
     */
    @Override
    public boolean validarExistenciaCitaRepetida(CitaNuevaDTO citaARegistrar) {
        //esto debería acceder a una dao, hacer una consulta y regresar un boolean 
        //si es que se encuentran resultados con la misma informacion
        List<CitaDTO> citasRegistradas = obtenerCitas();
        for (CitaDTO cita : citasRegistradas) {
            if (cita.getFechaHora().equals(citaARegistrar.getFechaHora())
                    && cita.getCubiculo().equals(citaARegistrar.getCubiculo())) {
                return false;
            }
        }
        return true;
    }


    // Métodos auxiliares
    private Calendar toCalendar(LocalDateTime dateTime) {
        return GregorianCalendar.from(dateTime.atZone(ZoneId.systemDefault()));
    }

    private Calendar toCalendar(LocalDate date) {
        return GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
    }
}
