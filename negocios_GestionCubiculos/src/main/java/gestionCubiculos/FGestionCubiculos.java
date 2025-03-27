/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionCubiculos;

import dto.CubiculoDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erika
 */
public class FGestionCubiculos implements IGestionCubiculos{

    
    /**
     * Obtiene una lista de cubiculos disponibles en la fecha y hora dada
     * @param fecha que se desea consultae
     * @return lista de CubiculosDTO
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(LocalDateTime fecha) {
        
        List<CubiculoDTO> cubiculos = new ArrayList<>();
        cubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 3", true));
        return cubiculos;
    }
    
}
