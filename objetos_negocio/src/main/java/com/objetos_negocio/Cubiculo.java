/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetos_negocio;

import dto.CubiculoDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alexnieblas
 */
public class Cubiculo {
    
    public List<CubiculoDTO> obtenerCubiculosEstadoDisponible(){
        List<CubiculoDTO> cubiculos = new LinkedList<>();
        cubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 3", true));

        return cubiculos;
    }
}
