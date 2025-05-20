/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.logging.Level;
import java.util.logging.Logger;
import modificarCita.control.ControlModificarCita;

/**
 *
 * @author Maryr
 */
public class FModificarCita implements IModificarCita {

    private final ControlModificarCita control = new ControlModificarCita();

    /**
     * Metodo para filtrar las citas por el dia
     *
     * @param fecha de la cual se quieren mostrar las citas
     * @return la lista con las citas filtradas
     * @throws excepciones.ModificarCitaException
     */
    @Override
    public List<CitaRegistradaDTO> obtenerCitasDia(Calendar fecha) throws ModificarCitaException {
        if (fecha == null) {
            throw new ModificarCitaException("La fecha no es valida.");
        }
        try {
            return control.obtenerCitasDia(fecha);
        } catch (Exception e) {
            throw new ModificarCitaException("Error al obtener las citas del dia: ", e);
        }
    }

    /**
     * Metodo para obtener los cubiculos disponibles
     *
     * @param cita
     * @return lista con los cubiculos disponibles
     * @throws ModificarCitaException
     */
    @Override
    public List<CubiculoDTO> mandarCubiculos(CitaRegistradaDTO cita) throws ModificarCitaException {
        if (cita == null) {
            throw new ModificarCitaException("La cita no es valida.");
        }
        try {
            return control.obtenerCubiculosDisponiblesHorario(cita);
        } catch (ModificarCitaException e) {
            throw new ModificarCitaException(e.getMessage());
        }
    }

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
    @Override
    public List<LocalTime> mandarHorario(PsicologoCitaDTO psicologo, String idCubiculo, Calendar fecha) throws ModificarCitaException {
        try {
            return control.obtenerHorasDisponibles(psicologo, idCubiculo, fecha);
        } catch (ModificarCitaException e) {
            Logger.getLogger(ControlModificarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Error al obtener las horas disponible: ", e);
        }
    }

    @Override
    public boolean actualizarCita(CitaRegistradaDTO cita) throws ModificarCitaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AdeudoCitaDTO verificarAdeudoCita(CitaRegistradaDTO cita) throws ModificarCitaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean aplicarCuota(CitaRegistradaDTO cita) throws ModificarCitaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
