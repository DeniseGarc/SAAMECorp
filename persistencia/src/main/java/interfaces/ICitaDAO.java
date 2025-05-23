/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que establece los metodos para la clase de CitaDAO
 *
 * @author erika
 */
public interface ICitaDAO {

    /**
     * Metodo que obtiene la disponibilidad de un psicolo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     * @throws excepciones.PersistenciaException
     */
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, Psicologo psicologo) throws PersistenciaException;

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     * @throws excepciones.PersistenciaException
     */
    public List<Cubiculo> obtenerCubiculosNoDisponibles(Calendar fecha) throws PersistenciaException;

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     * @throws excepciones.PersistenciaException
     */
    public Cita guardarCita(Cita cita) throws PersistenciaException;

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     * @throws excepciones.PersistenciaException
     */
    public List<Calendar> obtenerFechasConCitaAgendada() throws PersistenciaException;

    /**
     * Metodo para consultar si un cubiculo ya tiene citas registradas en un dia
     * dao
     *
     * @param cubiculo Cubiculo a consultar
     * @param fecha Fecha a consult
     * @return True hay horas disponibles
     * @throws excepciones.PersistenciaException
     */
    public boolean cubiculoTieneHorasDisponiblesDia(Cubiculo cubiculo, Calendar fecha) throws PersistenciaException;

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     * @throws excepciones.PersistenciaException
     */
    public List<Cita> obtenerCitas() throws PersistenciaException;

    /**
     * Metodo para validar que no exista otra cita que tenga la misma fechaHora
     * y cubiculo igual
     *
     * @param citaARegistrar
     * @return true si no existe otra cita igual, false si existe otra
     * @throws excepciones.PersistenciaException
     */
    public boolean validarExistenciaCitaRepetida(Cita citaARegistrar) throws PersistenciaException;

    /**
     * Metodo para obtener las horas disponibles que coinciden de un cubiculo y
     * un psicologo
     *
     * @param psicologo psicologo del cual se requieren las horas
     * @param idCubiculo cubiculo del cual se requieren las horas
     * @param fecha fecha en la cual sera la cita
     * @return lista de la horas disponibles coincidentes
     * @throws excepciones.PersistenciaException
     */
    public List<LocalTime> obtenerHorasDisponibles(Psicologo psicologo, ObjectId idCubiculo, LocalDate fecha) throws PersistenciaException;

    /**
     * Método para actualizar una cita existente
     *
     * @param citaActualizada La cita con los nuevos datos
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws PersistenciaException si ocurre un error en la base de datos
     */
    public boolean actualizarCita(Cita citaActualizada) throws PersistenciaException;
}
