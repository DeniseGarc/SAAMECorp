/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modificarCita;

import dto.AdeudoCitaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import excepciones.ModificarCitaException;
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
     * @param cita
     * @return lista con los cubiculos disponibles
     * @throws ModificarCitaException 
     */
    public List<CubiculoDTO> mandarCubiculos(CitaRegistradaDTO cita) throws ModificarCitaException;
    
    public boolean actualizarCita(CitaRegistradaDTO cita) throws ModificarCitaException;

    

    public AdeudoCitaDTO verificarAdeudoCita(CitaRegistradaDTO cita) throws ModificarCitaException;

    public boolean aplicarCuota(CitaRegistradaDTO cita) throws ModificarCitaException;

}
