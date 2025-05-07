/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Cubiculo;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos para la clase CubiculoDAO
 * @author erika
 */
public interface ICubiculoDAO {
    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     * @return Lista de cubiculosDTO disponibles
     * @throws excepciones.PersistenciaException
     */
     public List<Cubiculo> obtenerCubiculosEstadoDisponible() throws PersistenciaException;
}
