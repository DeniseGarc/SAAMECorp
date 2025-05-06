/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import entidades.Cita;
import entidades.Cubiculo;
import interfaces.ICitaBO;
import interfaces.ICitaDAO;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import mappers.CubiculoMapper;
import mappers.CItaMapper;
import mappers.PsicologoMapper;

/**
 * Clase que implementa la logica de negocio para las citas
 *
 * @author erika
 */
public class CitaBO implements ICitaBO {

    private static ICitaDAO citaDAO;
    PsicologoMapper psicologoMapper = new PsicologoMapper();
    CItaMapper cItaMapper = new CItaMapper();
    CubiculoMapper cubiculoMapper = new CubiculoMapper();

    /**
     * Metodo que obtiene la disponibilidad de un psicólogo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     */
    @Override
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, PsicologoDTO psicologo) {
        List<LocalTime> horasDisponibles = citaDAO.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psicologoMapper.toEntity2(psicologo));
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
        List<Cubiculo> listaCubiculos = citaDAO.obtenerCubiculosNoDisponibles(fecha);
        return cubiculoMapper.toDTOList(listaCubiculos);
    }

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     */
    @Override
    public CitaNuevaDTO guardarCita(CitaNuevaDTO cita) {
        Cita c = citaDAO.guardarCita(cItaMapper.toEntity(cita));
        return cItaMapper.toDTO(c);
    }

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     */
    @Override
    public List<Calendar> obtenerFechasConCitaAgendada() {
        return citaDAO.obtenerFechasConCitaAgendada();
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
        return citaDAO.cubiculoTieneHorasDisponiblesDia(cubiculoMapper.toEntity(cubiculo), fecha);
    }

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     */
    @Override
    public List<CitaDTO> obtenerCitas() {
        List<Cita> citas = citaDAO.obtenerCitas();
        return cItaMapper.toDTOList2(citas);
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
        return citaDAO.validarExistenciaCitaRepetida(cItaMapper.toEntity(citaARegistrar));
    }

}
