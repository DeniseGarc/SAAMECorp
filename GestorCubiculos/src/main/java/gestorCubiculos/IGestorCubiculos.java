/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorCubiculos;

import dto.CubiculoDTO;
import excepciones.GestorCubiculosException;
import java.util.List;

/**
 * Interfaz que define el acceso y los metodos del subsistema de Gestion de cubiculos
 * 
 * @author erika
 */
public interface IGestorCubiculos {
    /**
     * Metodo que permite obtener los cubiculos dado su estado
     * @param estado Estado a buscar
     * @return Lista de cubiculos con el estado dado
     * @throws GestorCubiculosException 
     */
    public List<CubiculoDTO> obtenerCubiculosPorEstado(boolean estado) throws GestorCubiculosException; 
    
    /**
     * Metodo que obtiene todos los cubiculos registrados
     * @return Lista de cubiculos registrados
     * @throws GestorCubiculosException 
     */
    public List<CubiculoDTO> obtenerCubiculos() throws GestorCubiculosException;
    
    /**
     * Metodo para agregar un nuevo cubiculo 
     * @param cubiculo cubiculo a agregar
     * @return true si el cubiculo se agrego correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean agregarCubiculo(CubiculoDTO cubiculo) throws GestorCubiculosException;
    
    /**
     * Metodo para actualizar el estado de un cubiculo
     * @param cubiculoAgregar cubiculo a modificar
     * @return true si el cubiculo se modifico correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean actualizarEstadoCubiculo( CubiculoDTO cubiculoAgregar) throws GestorCubiculosException;
    
    /**
     * Metodo para modificar los datos de un cubiculo 
     * @param cubiculoModificar cubiculo con datos modificados
     * @return rue si el cubiculo se modifico correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean modificarCubiculo (CubiculoDTO cubiculoModificar) throws GestorCubiculosException;
}
