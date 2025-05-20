/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import excepciones.NegocioException;
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
     * @throws excepciones.NegocioException
     */
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, PsicologoCitaDTO psicologo) throws NegocioException;

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     * @throws excepciones.NegocioException
     */
    public List<CubiculoDTO> obtenerCubiculosNoDisponibles(Calendar fecha) throws NegocioException;

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     * @throws excepciones.NegocioException
     */
    public CitaNuevaDTO guardarCita(CitaNuevaDTO cita) throws NegocioException;

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     * @throws excepciones.NegocioException
     */
    public List<Calendar> obtenerFechasConCitaAgendada() throws NegocioException;

    /**
     * Metodo para consultar si un cubiculo ya tiene citas registradas en un dia
     * dao
     *
     * @param cubiculo Cubiculo a consultar
     * @param fecha Fecha a consult
     * @return True hay horas disponibles
     * @throws excepciones.NegocioException
     */
    public boolean cubiculoTieneHorasDisponiblesDia(CubiculoDTO cubiculo, Calendar fecha) throws NegocioException;

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     * @throws excepciones.NegocioException
     */
    public List<CitaDTO> obtenerCitas() throws NegocioException;
    
    /**
     * Metodo para obtener las citas con todos sus datos
     * @return una lista de las citas registradas y todos su datos
     * @throws NegocioException 
     */
    public List<CitaRegistradaDTO> obtenerCitasCompletas() throws NegocioException;

    /**
     * Metodo para validar que no exista otra cita que tenga la misma fechaHora
     * y cubiculo igual
     *
     * @param citaARegistrar
     * @return true si no existe otra cita igual, false si existe otra
     * @throws excepciones.NegocioException
     */
    public boolean validarExistenciaCitaRepetida(CitaNuevaDTO citaARegistrar) throws NegocioException;
    
    /**
     * Metodo para obtener las horas disponibles que coinciden de un cubiculo y
     * un psicologo
     *
     * @param psicologo psicologo del cual se requieren las horas
     * @param idCubiculo cubiculo del cual se requieren las horas
     * @param fecha fecha en la cual sera la cita
     * @return lista de la horas disponibles coincidentes
     * @throws excepciones.NegocioException
     */
    public List<LocalTime> obtenerHorasDisponibles(PsicologoCitaDTO psicologo, String idCubiculo, Calendar fecha) throws NegocioException;
}
