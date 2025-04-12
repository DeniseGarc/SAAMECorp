/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.CubiculoDTO;
import java.util.List;

/**
 * Interfaz que define los metodos para implementar los metodos de negocio para Cubiculos
 * @author erika
 */
public interface ICubiculoBO {
    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     * @return Lista de cubiculosDTO disponibles
     */
     public List<CubiculoDTO> obtenerCubiculosEstadoDisponible();
}
