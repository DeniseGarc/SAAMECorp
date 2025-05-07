/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.CubiculoDAO;
import dto.CubiculoDTO;
import entidades.Cubiculo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ICubiculoBO;
import interfaces.ICubiculoDAO;
import java.util.LinkedList;
import java.util.List;
import mappers.CubiculoMapper;

/**
 * Clase que define la logica de negocio para Cubiculos
 *
 * @author erika
 */
public class CubiculoBO implements ICubiculoBO {

    private static final ICubiculoDAO cubiculoDAO = new CubiculoDAO();

    CubiculoMapper mapper = new CubiculoMapper();

    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     *
     * @return Lista de cubiculosDTO disponibles
     */
    @Override
    public List<CubiculoDTO> obtenerCubiculosEstadoDisponible() throws NegocioException {
        try {
            List<Cubiculo> cubiculos = cubiculoDAO.obtenerCubiculosEstadoDisponible();
            return mapper.toDTOList(cubiculos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los cubiculos disponibles: " + e.getMessage());
        }
    }

}
