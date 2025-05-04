/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dto.CubiculoDTO;
import entidades.Cubiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class CubiculoMapper {
    
    public CubiculoDTO toDTO(Cubiculo cubiculo) {
        return new CubiculoDTO(cubiculo.getNombre(), cubiculo.isEstado());
    }
    
    public Cubiculo toEntity(CubiculoDTO cubiculo) {
        return new Cubiculo(cubiculo.getNombre(), cubiculo.isEstado());
    }
    
    public List<CubiculoDTO> toDTOList(List<Cubiculo> cubiculos) {
        List<CubiculoDTO> cubiculosDTO = new ArrayList<>();
        for (Cubiculo cubiculo : cubiculos) {
            cubiculosDTO.add(new CubiculoDTO(cubiculo.getNombre(), cubiculo.isEstado()));
        }
        return cubiculosDTO;
    }
}
