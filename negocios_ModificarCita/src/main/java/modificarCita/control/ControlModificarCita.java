/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modificarCita.control;

import dto.CitaRegistradaDTO;
import static enumeradores.TipoBO.CITA;
import interfaces.ICitaBO;
import java.util.Calendar;
import java.util.List;
import manejadorBO.ManejadorBO;

/**
 * Clase control para la comunicacion entre el subsistema y objetos negocio
 * u otro servicio externo
 * @author Maryr
 */
public class ControlModificarCita {
    
    ICitaBO citaBO = (ICitaBO) ManejadorBO.crearBO(CITA);
    
//    public List<CitaRegistradaDTO> obtenerCitasDia(Calendar fecha) {
//        return;
//    }
    
}
