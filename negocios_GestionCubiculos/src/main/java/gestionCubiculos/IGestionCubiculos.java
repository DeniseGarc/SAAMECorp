/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionCubiculos;

import dto.CubiculoDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IGestionCubiculos {
    public List<CubiculoDTO> obtenerCubiculosDisponiblesHorario(LocalDateTime fecha);
}
