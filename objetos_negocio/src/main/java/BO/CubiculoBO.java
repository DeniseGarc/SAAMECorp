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
import mapper.CubiculoMapper;

/**
 * Clase que define la logica de negocio para Cubiculos
 *
 * @author erika
 */
public class CubiculoBO implements ICubiculoBO {
    
    /**
     * Instancia unica de la clase 
     */
    private static CubiculoBO instancia; 
    
    private static final ICubiculoDAO cubiculoDAO = CubiculoDAO.getInstanciaDAO();
    
    CubiculoMapper mapper = new CubiculoMapper();
    
    /**
     * Constructor privado 
     */
    private CubiculoBO(){
        
    }
    
    /**
     * Metodo para obtener la instancia unica de CubiculoBO
     * Si no existe una la crea
     * @return instancia unida de CubiculoBO
     */
    public static CubiculoBO getInstancia(){
        if (instancia == null){
            instancia= new CubiculoBO();
        }
        return instancia; 
    }
    
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

    @Override
    public List<CubiculoDTO> obtenerCubiculosPorEstado(boolean estado) throws NegocioException {
        try{
            List<Cubiculo> cubiculos = cubiculoDAO.obtenerCubiculoPorEstado(estado);
            return mapper.toDTOList(cubiculos);
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al obtener los cubibulos: "+ e.getMessage());
        }
    }

    @Override
    public List<CubiculoDTO> obtenerCubiculos() throws NegocioException {
        try{
            List<Cubiculo> cubiculos = cubiculoDAO.buscarCubiculos();
            return mapper.toDTOList(cubiculos);
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al obtener los cubibulos: "+ e.getMessage());
        }
    }

    @Override
    public boolean agregarCubiculo(CubiculoDTO cubiculo) throws NegocioException {
        try{
            return cubiculoDAO.AgregarCubiculo(mapper.toEntity(cubiculo));
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al agregar el cubiculo: "+ e.getMessage());
        }
    }

    @Override
    public boolean actualizarEstadoCubiculo(CubiculoDTO cubiculoAgregar) throws NegocioException {
         try{
            return cubiculoDAO.ModificarEstadoCubiculo(mapper.toEntity(cubiculoAgregar));
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al actualizar el cubiculo: "+ e.getMessage());
        }
    }

    @Override
    public boolean modificarCubiculo(CubiculoDTO cubiculoModificar) throws NegocioException {
        try{
            return cubiculoDAO.ModificarCubiculo(mapper.toEntity(cubiculoModificar));
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al actualizar el cubiculo: "+ e.getMessage());
        }
    }

    @Override
    public CubiculoDTO obtenerCubiculoPorNombre(String nombre) throws NegocioException {
        try{
            Cubiculo cubiculoEntidad = cubiculoDAO.buscarCubiculoPorNombre(nombre);
            return mapper.toDTO(cubiculoEntidad);
        }catch(PersistenciaException e){
        throw new NegocioException ("Error al actualizar el cubiculo: "+ e.getMessage());
        }
    }

}
