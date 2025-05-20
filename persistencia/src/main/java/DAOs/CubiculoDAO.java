/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionBD;
import entidades.Cubiculo;
import excepciones.PersistenciaException;
import interfaces.ICubiculoDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que define los metodos en Persistencia para Cubiculos
 *
 * @author erika
 */
public class CubiculoDAO implements ICubiculoDAO {

    private final MongoCollection<Cubiculo> coleccionCubiculos;
    /**
     * Instancia unica de la clase
     */
    private static CubiculoDAO instanciaCubiculoDAO;

    /**
     * Constructor privado
     */
    private CubiculoDAO() {
        MongoDatabase database = ConexionBD.getDatabase();
        this.coleccionCubiculos = database.getCollection("Cubiculos", Cubiculo.class);
    }

    /**
     * Metodo para obtener la instancia unica de la clase CubiculoDAO
     *
     * @return Instancia Unica de la clase CubiculoDAO
     */
    public static CubiculoDAO getInstanciaDAO() {
        if (instanciaCubiculoDAO == null) {
            instanciaCubiculoDAO = new CubiculoDAO();
        }
        return instanciaCubiculoDAO;
    }

    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     *
     * @return Lista de cubiculosDTO disponibles
     */
    @Override
    public List<Cubiculo> obtenerCubiculosEstadoDisponible() throws PersistenciaException {
        try {
            return coleccionCubiculos.find(eq("estado", true)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los cubículos disponibles: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para obtener los cubiculos registrados dado su estado
     *
     * @param estado estado a buscar
     * @return Lista de cubiculos con el estado dado
     * @throws PersistenciaException
     */
    @Override
    public List<Cubiculo> obtenerCubiculoPorEstado(boolean estado) throws PersistenciaException {
        try {
            return coleccionCubiculos.find(eq("estado", estado)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener cubículos por estado: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para modificar los datos de un cubiculo
     *
     * @param cubiculoModificar cubiculo con los datos a modificar
     * @return true si se actualizo correctamente, false si no
     * @throws PersistenciaException
     */
    @Override
    public boolean ModificarCubiculo(Cubiculo cubiculoModificar) throws PersistenciaException {
        try {
            UpdateResult result = coleccionCubiculos.replaceOne(

                eq("_id", cubiculoModificar.getObjectString()), cubiculoModificar

            );
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al modificar el cubículo: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para modificar el estado de un cubiculo dado
     *
     * @param CubiculoModificar cubiculo a modificar
     * @return true si se actualizo correctamente, false si no
     * @throws PersistenciaException
     */
    @Override
    public boolean ModificarEstadoCubiculo(Cubiculo CubiculoModificar) throws PersistenciaException {
        try {

        // Buscar el cubículo actual por su ID
        Cubiculo cubiculoActual = coleccionCubiculos.find(eq("_id", CubiculoModificar.getObjectString())).first();

        if (cubiculoActual == null) {
            throw new PersistenciaException("No se encontró el cubículo con ID: " + CubiculoModificar.getObjectString());
        }


            // Invertir el estado actual
            boolean nuevoEstado = !cubiculoActual.isEstado();


        // Actualizar solo el campo "estado"
        UpdateResult resultado = coleccionCubiculos.updateOne(
            eq("_id", CubiculoModificar.getObjectString()),
            set("estado", nuevoEstado)
        );


            return resultado.getModifiedCount() > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al modificar el estado del cubículo: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para agregar un cubiculo
     *
     * @param cubiculoAgregar cubiculo a agregar
     * @return true si se agrego correctamente, false si no
     * @throws PersistenciaException
     */
    @Override
    public boolean AgregarCubiculo(Cubiculo cubiculoAgregar) throws PersistenciaException {
        try {
            coleccionCubiculos.insertOne(cubiculoAgregar);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar cubículo: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para buscar un cubiculo dado su nombre
     *
     * @param nombre nombre del cubiculo a buscar
     * @return cubiculo encontrado
     * @throws PersistenciaException
     */
    @Override
    public Cubiculo buscarCubiculoPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccionCubiculos.find(eq("nombre", nombre)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar cubículo por nombre: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo que regresa todos los cubiculos
     *
     * @return Lista de todos los cubiculos registrados
     * @throws PersistenciaException
     */
    @Override
    public List<Cubiculo> buscarCubiculos() throws PersistenciaException {
        try {
            return coleccionCubiculos.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de cubículos: " + e.getMessage(), e);
        }
    }
    /**
     * Metodo para obtener un cubiculo dado su id
     * @param id id del cubiculo
     * @return cubiculo encontrado
     * @throws PersistenciaException 
     */
    @Override
    public Cubiculo buscarCubiculoPorId(ObjectId id) throws PersistenciaException {
    try {
        return coleccionCubiculos.find(eq("_id", id)).first();
    } catch (Exception e) {
        throw new PersistenciaException("Error al buscar cubículo por ID: " + e.getMessage(), e);
    }
}

}
