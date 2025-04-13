/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Interfaz que define los metodos para implemenrar la logica de negiocio de
 * cita
 *
 * @author erika
 */
public interface ICitaBO {

    /**
     * Metodo que obtiene la disponibilidad de un psicolo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     */
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, PsicologoDTO psicologo);

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     */
    public List<CubiculoDTO> obtenerCubiculosNoDisponibles(Calendar fecha);

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     */
    public CitaRegistradaDTO guardarCita(CitaNuevaDTO cita);

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     */
    public List<Calendar> obtenerFechasConCitaAgendada();

    /**
     * Metodo para consultar si un cubiculo ya tiene citas registradas en un dia
     * dao
     *
     * @param cubiculo Cubiculo a consultar
     * @param fecha Fecha a consult
     * @return True hay horas disponibles
     */
    public boolean cubiculoTieneHorasDisponiblesDia(CubiculoDTO cubiculo, Calendar fecha);

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     */
    public List<CitaRegistradaDTO> obtenerCitas();
}
