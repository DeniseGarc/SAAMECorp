package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.ConexionBD;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import static com.mongodb.client.model.Filters.eq;

/**
 * Clase que implementa los metodos para Usuarios en la capa de persistencia
 *
 * @author Alici
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * Instancia unica de la clase UsuarioDAO
     */
    private static UsuarioDAO instanciaUsuarioDAO;
    private final MongoCollection<Usuario> coleccion;

    /**
     * Constructor privado
     */
    private UsuarioDAO() {
        MongoDatabase database = ConexionBD.getDatabase();
        this.coleccion = database.getCollection("Usuarios", Usuario.class);
    }

    /**
     * Metodo para obtener la instancia unica de la clase
     */
    public static UsuarioDAO getInstance() {
        if (instanciaUsuarioDAO == null) {
            instanciaUsuarioDAO = new UsuarioDAO();
        }
        return instanciaUsuarioDAO;
    }

    /**
     * Metodo para iniciar sesion en el sistema, devuelve el usuario encontrado
     * o lanza una excepcion si el usuario no existe o la contraseña es
     * incorrecta
     *
     * @param usuario Usuario de la cuenta
     * @param contrasena Contraseña de la cuenta
     * @return entidad usuario con los datos del usuario que inicia sesion
     * @throws PersistenciaException Si ocurre un error al consultar so la
     * contraseña es incorrecta o el usuario no existe
     */
    @Override
    public Usuario iniciarSesion(String usuario, String contrasena) throws PersistenciaException {
        try {
            Usuario usuarioEncontrado = coleccion.find(eq("usuario", usuario)).first();
            if (usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena)) {
                return usuarioEncontrado;
            } else {
                throw new PersistenciaException("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al iniciar sesión: " + e.getMessage(), e);
        }
    }

}
