/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.CubiculoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define los metodos para implementar los metodos de negocio para Cubiculos
 * @author erika
 */
public interface ICubiculoBO {
    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     * @return Lista de cubiculosDTO disponibles
     * @throws excepciones.NegocioException
     */
     public List<CubiculoDTO> obtenerCubiculosEstadoDisponible() throws NegocioException;
    
     /**
      * Metodo para obtener todos los cubiculos con el estado dado
      * @param estado Estado a busacar
      * @return Lista de Cubiculos con el estado indicado
      * @throws NegocioException  
      */
     public List<CubiculoDTO> obtenerCubiculosPorEstado(boolean estado) throws NegocioException; 
     /**
      * Metodo para obtener todos los cubiculos registrados
      * @return Lista de cubiculos registrados
      * @throws NegocioException 
      */
     public List<CubiculoDTO> obtenerCubiculos() throws NegocioException;
     /**
      * Metodo para registrar un cubiculo nuevo
      * @param cubiculo cubiculo a registrar
      * @return True si se registro correctamente, False si no 
      * @throws NegocioException 
      */
     public boolean agregarCubiculo(CubiculoDTO cubiculo) throws NegocioException; 
     /**
      * Metodo para actualizar el estado de un cubiculo
      * @param estado estado nuevo a actualizar
      * @param cubiculoAgregar Cubiculo al que se le desea modificar el estado
      * @return True si se actualizo correctamente, False si no 
      * @throws NegocioException 
      */
     public boolean actualizarEstadoCubiculo(boolean estado, CubiculoDTO cubiculoAgregar) throws NegocioException; 
     /**
      * Metodo para modificar los datos de un cubiculo
      * @param cubiculoModificar cubiculo con los datos a modificar
      * @return True si se actualizo correctamente, False si no 
      * @throws NegocioException 
      */
     public boolean modificarCubiculo (CubiculoDTO cubiculoModificar) throws NegocioException;
     /**
      * Metodo para obtener un cubiculo dado su id
      * @param id Id del cubiculo a obtener
      * @return Cubiculo encontrado
      * @throws NegocioException 
      */
     public CubiculoDTO obtenerCubiculoPorID(Long id) throws NegocioException;
}
