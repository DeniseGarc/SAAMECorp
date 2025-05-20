package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IPsicologoDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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
            List<Psicologo> lista = new ArrayList<>();
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
     * @param id
     * @return Psicologo encontrado
     * @throws excepciones.PersistenciaException
     */
    @Override
    public Psicologo obtenerPsicologoPorIdentificador(String id) throws PersistenciaException {
        try {
            ObjectId o = new ObjectId(id);
            Psicologo psicologo = coleccion.find(eq("_id", o)).first();
            if (psicologo == null) {
                throw new PersistenciaException("No se encontró un psicólogo con ID: " + id);
            }
            return psicologo;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el psicólogo por ID: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para obtener un Psicologo especifico por su RFC.
     * 
     * @param psicologo Objeto Psicologo que contiene la información del
     *                  psicólogo.
     * @return Psicologo encontrado
     * @throws PersistenciaException Si ocurre un error al buscar el psicólogo.
     */
    public Psicologo obtenerPsicologoPorRfc(Psicologo psicologo) throws PersistenciaException {
        try {
            Bson filtro = eq("rfc", psicologo.getRfc());
            Psicologo psicologoEncontrado = coleccion.find(filtro).first();
            if (psicologoEncontrado == null) {
                throw new PersistenciaException("No se encontró un psicólogo con el RFC: " + psicologo.getRfc());
            }
            return psicologoEncontrado;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el psicólogo: " + e.getMessage());
        }
    }

}
