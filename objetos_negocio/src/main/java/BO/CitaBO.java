/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.CitaDAO;
import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import entidades.Cita;
import entidades.Cubiculo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ICitaBO;
import interfaces.ICitaDAO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.CubiculoMapper;
import mapper.CitaMapper;
import mapper.PsicologoMapper;

/**
 * Clase que implementa la logica de negocio para las citas
 *
 * @author erika
 */
public class CitaBO implements ICitaBO {

    private static final ICitaDAO citaDAO = CitaDAO.getInstancia();
    PsicologoMapper psicologoMapper = new PsicologoMapper();
    CitaMapper cItaMapper = new CitaMapper();
    CubiculoMapper cubiculoMapper = new CubiculoMapper();

    /**
     * Instancia unica de la clase
     */
    private static CitaBO instancia;

    /**
     * Constructor privado para evitar instanciacion externa
     */
    private CitaBO() {
    }

    /**
     * Metodo para obtener la instancia unica de CitaBO Si no existe una la crea
     *
     * @return instancia unida de CitaBO
     */
    public static CitaBO getInstancia() {
        if (instancia == null) {
            instancia = new CitaBO();
        }
        return instancia;
    }

    /**
     * Metodo que obtiene la disponibilidad de un psicólogo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     */
    @Override
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, PsicologoDTO psicologo) throws NegocioException {
        try {
            List<LocalTime> horasDisponibles = citaDAO.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psicologoMapper.toEntity2(psicologo));
            return horasDisponibles;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener las horas disponibles: " + e.getMessage());
        }
    }

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosNoDisponibles(Calendar fecha) throws NegocioException {
        try {
            List<Cubiculo> listaCubiculos = citaDAO.obtenerCubiculosNoDisponibles(fecha);
            return cubiculoMapper.toDTOList(listaCubiculos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener cubiculos llenos: " + e.getMessage());
        }
    }

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     */
    @Override
    public CitaNuevaDTO guardarCita(CitaNuevaDTO cita) throws NegocioException {
        try {
            Cita c = citaDAO.guardarCita(cItaMapper.toEntity(cita));
            return cItaMapper.toDTO(c);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la cita: " + e.getMessage());
        }
    }

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     */
    @Override
    public List<Calendar> obtenerFechasConCitaAgendada() throws NegocioException {
        try {
            return citaDAO.obtenerFechasConCitaAgendada();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener las fechas con cita agendada: " + e.getMessage());
        }
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
    public boolean cubiculoTieneHorasDisponiblesDia(CubiculoDTO cubiculo, Calendar fecha) throws NegocioException {
        try {
            return citaDAO.cubiculoTieneHorasDisponiblesDia(cubiculoMapper.toEntity(cubiculo), fecha);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener disponibilidad de cubiculo: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     */
    @Override
    public List<CitaDTO> obtenerCitas() throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();
            return cItaMapper.toDTOList2(citas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener las citas: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener las citas con todos sus datos
     *
     * @return una lista de las citas registradas y todos su datos
     * @throws NegocioException
     */
    @Override
    public List<CitaRegistradaDTO> obtenerCitasCompletas() throws NegocioException {
        try {
            List<Cita> citas = citaDAO.obtenerCitas();
            return cItaMapper.toDTOList3(citas);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al obtener las citas completas: ", ex);
        }
    }

    /**
     * Metodo para validar que no exista otra cita que tenga la misma fechaHora
     * y cubiculo igual
     *
     * @param citaARegistrar
     * @return true si no existe otra cita igual, false si existe otra
     */
    @Override
    public boolean validarExistenciaCitaRepetida(CitaNuevaDTO citaARegistrar) throws NegocioException {
        try {
            return citaDAO.validarExistenciaCitaRepetida(cItaMapper.toEntity(citaARegistrar));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al validar las citas repetidas: " + e.getMessage());
        }
    }

}
