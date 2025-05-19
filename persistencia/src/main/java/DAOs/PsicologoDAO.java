/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IPsicologoDAO;
import java.util.LinkedList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * Clase que implementa los metodos para Psicologos en la capa de persistencia
 *
 * @author erika
 */
public class PsicologoDAO implements IPsicologoDAO {

    private static PsicologoDAO instanciaPsicologoDAO;
    private final MongoCollection<Psicologo> coleccion;

    /**
     * Constructor privado
     */
    private PsicologoDAO() {
        MongoDatabase database = ConexionBD.getDatabase();
        this.coleccion = database.getCollection("Psicologos", Psicologo.class);
    }

    /**
     * Metodo para obtener la instancia unica de PsicologoDAO
     *
     * @return instancia unica de la clase PsicologoDAO
     */
    public static PsicologoDAO getInstanciaDAO() {
        if (instanciaPsicologoDAO == null) {
            instanciaPsicologoDAO = new PsicologoDAO();
        }
        return instanciaPsicologoDAO;

    }

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<Psicologo> obtenerPsicologos() throws PersistenciaException {
        try {
            List<Psicologo> lista = new LinkedList<>();
            for (Psicologo p : coleccion.find()) {
                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los psicólogos: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener un Psicologo especificp por su identificador
     *
     * @param identificador Identificador unico del Psicologo a buscar
     * @return Psicologo encontrado
     */
    @Override
    public Psicologo obtenerPsicologoPorIdentificador(String identificador) throws PersistenciaException {
        try {
            Bson filtro = eq("correo", identificador);
            Psicologo psicologo = coleccion.find(filtro).first();
            if (psicologo == null) {
                throw new PersistenciaException("No se encontró un psicólogo con el correo: " + identificador);
            }
            return psicologo;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el psicólogo: " + e.getMessage());
        }
    }

}
