/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.CubiculoDTO;
import entidades.Cubiculo;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author erika
 */
public class CubiculoMapper {
    /**
     * Convierte de entidad cubiculo a cubiculoDTO
     * @param cubiculo cubiculo entidad a convertir
     * @return cubiculoDTO
     */
    public CubiculoDTO toDTO(Cubiculo cubiculo) {
        return new CubiculoDTO(
            cubiculo.getId() != null ? cubiculo.getId().toHexString() : null,
            cubiculo.getNombre(),
            cubiculo.isEstado(),
            cubiculo.getCapacidad(),
            cubiculo.getTipoTerapia(),
            cubiculo.getNotas()
        );
    }
    
    /**
     * Convierte de DTO a entidad
     * @param cubiculo
     * @return 
     */
    public Cubiculo toEntity(CubiculoDTO cubiculo) {
        Cubiculo entidad = new Cubiculo(
            cubiculo.getNombre(),
            cubiculo.isEstado(),
            cubiculo.getCapacidad(),
            cubiculo.getTipoTerapia(),
            cubiculo.getNotas()
        );
        // Setear el ID si viene desde el DTO
        if (cubiculo.getId() != null && !cubiculo.getId().isBlank()) {
            entidad.setId(new ObjectId(cubiculo.getId()));
        }
        return entidad;
    }
    
    /**
     * Convierte lista de cubiculos a lista de cubiculosDTO
     * @param cubiculos
     * @return 
     */
    public List<CubiculoDTO> toDTOList(List<Cubiculo> cubiculos) {
        List<CubiculoDTO> cubiculosDTO = new ArrayList<>();
        for (Cubiculo cubiculo : cubiculos) {
            cubiculosDTO.add(toDTO(cubiculo));
        }
        return cubiculosDTO;
    }
}

