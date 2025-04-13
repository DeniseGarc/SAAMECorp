/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionCubiculos;

import com.objetos_negocio.Cita;
import com.objetos_negocio.Cubiculo;
import dto.CubiculoDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author erika
 */
public class FGestionCubiculos implements IGestionCubiculos{
    Cubiculo cubiculo = new Cubiculo();
    Cita cita = new Cita();
    
    /**
     * Obtiene una lista de cubiculos disponibles en la fecha y hora dada
     * @param fecha que se desea consultae
     * @return lista de CubiculosDTO
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(LocalDateTime fecha) {
        List<CubiculoDTO> cubiculosDisponibles = cubiculo.obtenerCubiculosEstadoDisponible();
        List<CubiculoDTO> cubiculosOcupadosFecha = cita.obtenerCubiculosNoDisponibles(fecha);
        cubiculosDisponibles.removeAll(cubiculosOcupadosFecha);
        return cubiculosDisponibles;
    }
    
}
