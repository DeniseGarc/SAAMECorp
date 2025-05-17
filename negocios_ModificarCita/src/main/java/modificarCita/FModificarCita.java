/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class FModificarCita implements IModificarCita {

    @Override
    public boolean actualizarCita(CitaRegistradaDTO cita) throws ModificarCitaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CubiculoDTO> mandarCubiculos(Calendar fecha) throws ModificarCitaException {
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
