/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Cubiculo;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

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
     
     /**
      * Metodo que obtiene todos los cubiculos con el estado dado
      * @param estado Estado a busacr
      * @return Cubiculos con el estado dado
      * @throws PersistenciaException  
      */
     public List<Cubiculo> obtenerCubiculoPorEstado(boolean estado) throws PersistenciaException;
     /**
      * Metodo para actualizar los dato de un Cubiculo
      * @param cubiculoModificar Cubiculo a modificae
      * @return True si se actualizo correctamente, false si no 
      * @throws PersistenciaException 
      */
     public boolean ModificarCubiculo(Cubiculo cubiculoModificar) throws PersistenciaException;
     
     /**
      * Metodo para Modificar el estado de un cubicculo, si es true se cambia a false
      * @param CubiculoModificar Cubiculo a modificar 
      * @return True si se actualizo correctamente, false si no
      * @throws PersistenciaException 
      */
     public boolean ModificarEstadoCubiculo(Cubiculo CubiculoModificar) throws PersistenciaException;
     
     /**
      * Metodo para agregar un nuevo cubiculo
      * @param cubiculoAgregar Cubiculo a agregar a la base de datoss
      * @return True si se agrego correctamente, false si no
      * @throws PersistenciaException 
      */
     public boolean AgregarCubiculo(Cubiculo cubiculoAgregar) throws PersistenciaException;
     
     /**
      * Metodo para buscar un cubiculo dado su nombre
     * @param nomrbe Nombre del cubiculo a buscar
      * @return Cubiculo encontrado
      * @throws PersistenciaException 
      */
     public Cubiculo buscarCubiculoPorNombre(String nomrbe) throws PersistenciaException;
     
     /**
      * Metodo para obtener todos los cubiculos Registrados
      * @return
      * @throws PersistenciaException 
      */
    public List<Cubiculo> buscarCubiculos() throws PersistenciaException;
    
    /**
     * Metodo para obtener un cubiculo dado su id
     * @param id id del cubiculo
     * @return cubiculo encontrado
     * @throws PersistenciaException 
     */
    public Cubiculo buscarCubiculoPorId(ObjectId id) throws PersistenciaException;

}
