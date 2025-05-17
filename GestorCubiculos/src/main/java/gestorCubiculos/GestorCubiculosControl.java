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
    
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(CUBICULO);
    
    public List<CubiculoDTO> ObtenerCubiculosPorEstado(boolean estado) throws GestorCubiculosException{
        try{
           return cubiculoBO.obtenerCubiculosPorEstado(estado);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al obtener los cubiculos: "+e.getMessage());
            
        }
    }
    
    public List<CubiculoDTO> obtenerCubiculos()throws GestorCubiculosException{
        try{
           return cubiculoBO.obtenerCubiculos();
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al obtener los cubiculos: "+e.getMessage());
            
        }
    }
    
    public boolean AgregaeCubiculo(CubiculoDTO cubiculo) throws GestorCubiculosException{
        try{
            return cubiculoBO.agregarCubiculo(cubiculo);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    
    public boolean ModificarCubiculo(CubiculoDTO cubiculoModificar ) throws GestorCubiculosException{
        try{
            return cubiculoBO.modificarCubiculo(cubiculoModificar);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    
    public boolean ModificarEstado(CubiculoDTO cubiculo)throws GestorCubiculosException{
        try{
            return cubiculoBO.actualizarEstadoCubiculo(cubiculo);
        }catch(NegocioException e ){
            throw new GestorCubiculosException("Eror al agregar:"+e.getMessage());
            
        }
    }
    
}
