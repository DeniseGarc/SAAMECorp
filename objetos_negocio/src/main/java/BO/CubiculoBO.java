/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.CubiculoDTO;
import interfaces.ICubiculoBO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que define la logica de negocio para Cubiculos
 * @author erika
 */
public class CubiculoBO implements ICubiculoBO{
    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     * @return Lista de cubiculosDTO disponibles
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosEstadoDisponible() {
        List<CubiculoDTO> cubiculos = new LinkedList<>();
        cubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 3", true));

        return cubiculos;
    }
    
}
