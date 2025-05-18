/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorCubiculos;

import dto.CubiculoDTO;
import static enumeradores.TipoBO.CUBICULO;
import excepciones.GestorCubiculosException;
import excepciones.NegocioException;
import interfaces.ICubiculoBO;
import java.util.List;
import manejadorBO.ManejadorBO;

/**
 *Clase que define los metodos del subsistema de Gestion de Cubiculos
 * 
 * @author erika
 */
public class GestorCubiculosControl {
    /**
     * Instancia de la clase CubiculoBO
     */
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(CUBICULO);
    
    /**
     * Metodo para obtener los cubiculos dado su estado
     * @param estado Estado a buscar
     * @return Lista de cubiculos encontrados con el estado dado
     * @throws GestorCubiculosException 
     */
    public List<CubiculoDTO> ObtenerCubiculosPorEstado(boolean estado) throws GestorCubiculosException{
        try{
           return cubiculoBO.obtenerCubiculosPorEstado(estado);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al obtener los cubiculos: "+e.getMessage());
            
        }
    }
    
    /**
     * Metodo para obtener todos los cubiculos
     * @return Lista de cubiculos
     * @throws GestorCubiculosException 
     */
    public List<CubiculoDTO> obtenerCubiculos()throws GestorCubiculosException{
        try{
           return cubiculoBO.obtenerCubiculos();
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al obtener los cubiculos: "+e.getMessage());
            
        }
    }
    
    /**
     * Metodo para agregar un cubiculo
     * @param cubiculo cubiculo a agregar
     * @return True si se agrego correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean AgregaeCubiculo(CubiculoDTO cubiculo) throws GestorCubiculosException{
        try{
            return cubiculoBO.agregarCubiculo(cubiculo);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    /**
     * Metodo para modificar los datos de un cubiculo
     * @param cubiculoModificar Cubiculo con lo datos a modificar
     * @return True si se agrego correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean ModificarCubiculo(CubiculoDTO cubiculoModificar ) throws GestorCubiculosException{
        try{
            return cubiculoBO.modificarCubiculo(cubiculoModificar);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    
    /**
     * Metodo para modificar el estado de un cubiculo
     * @param cubiculo cubiculo a modificar el estado
     * @return True si se agrego correctamente, false si no
     * @throws GestorCubiculosException 
     */
    public boolean ModificarEstado(CubiculoDTO cubiculo)throws GestorCubiculosException{
        try{
            return cubiculoBO.actualizarEstadoCubiculo(cubiculo);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    
}
