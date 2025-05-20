/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modificarCita;

import dto.AdeudoCitaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import excepciones.ModificarCitaException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IModificarCita {

    /**
     * Metodo para filtrar las citas por el dia
     *
     * @param fecha de la cual se quieren mostrar las citas
     * @return la lista con las citas filtradas
     * @throws excepciones.ModificarCitaException
     */
    public List<CitaRegistradaDTO> obtenerCitasDia(Calendar fecha) throws ModificarCitaException;

    /**
     * Metodo para obtener los cubiculos disponibles
     *
     * @param cita
     * @return lista con los cubiculos disponibles
     * @throws ModificarCitaException
     */
    public List<CubiculoDTO> mandarCubiculos(CitaRegistradaDTO cita) throws ModificarCitaException;

    /**
     * Metodo para obtener las horas disponibles que coinciden de un cubiculo y
     * un psicologo
     *
     * @param psicologo psicologo del cual se requieren las horas
     * @param idCubiculo cubiculo del cual se requieren las horas
     * @param fecha fecha en la cual sera la cita
     * @return lista de la horas disponibles coincidentes
     * @throws excepciones.ModificarCitaException
     */
    public List<LocalTime> mandarHorario(PsicologoCitaDTO psicologo, String idCubiculo, Calendar fecha) throws ModificarCitaException;

    public boolean actualizarCita(CitaRegistradaDTO cita) throws ModificarCitaException;

    public AdeudoCitaDTO verificarAdeudoCita(CitaRegistradaDTO cita) throws ModificarCitaException;

    public boolean aplicarCuota(CitaRegistradaDTO cita) throws ModificarCitaException;

}
