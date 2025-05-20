package DAOs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import conexion.ConexionBD;
import entidades.Pago;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IPagoDAO;

/*
 * Clase que implementa la interfaz IPagoDAO para gestionar los pagos en la base de datos.
 * Esta clase es un singleton, lo que significa que solo puede haber una instancia de ella en la aplicación.
 * 
 * ESTA CLASE ES UN MOCK
 *  
 * @author Alici  
 */
public class PagoDAO implements IPagoDAO {
    /**
     * Instancia unica de la clase
     */
    private static PagoDAO instancia;
    private final MongoCollection<Pago> coleccionPagos;

    private PagoDAO() {
        this.coleccionPagos = ConexionBD.getDatabase().getCollection("Pagos", Pago.class);

    }

    /**
     * Metodo para obtener la instancia unica de PagoDAO Si no existe una la
     * crea
     *
     * @return instancia unida de PagoDAO
     */
    public static PagoDAO getInstancia() {
        if (instancia == null) {
            instancia = new PagoDAO();
        }
        return instancia;
    }

    /**
     * Metodo para consultar los pagos realizados por un psicologo en los
     * ultimos 30 dias.
     * 
     * 
     * @param pago Objeto Pago que contiene la información del psicólogo.
     * @return Psicologo objeto que contiene la información del psicólogo.
     * @throws PersistenciaException Si ocurre un error al consultar los pagos.
     */
    @Override
    public List<Pago> consultarPagosMesPsicologo(Psicologo psicologo) throws PersistenciaException {
        if (psicologo == null) {
            throw new PersistenciaException("El psicologo no puede ser nulo");
        }
        if (psicologo.getId() == null) {
            throw new PersistenciaException("El id del psicologo no puede ser nulo");
        }
        try {
            List<Pago> pagosFiltrados = coleccionPagos.find(Filters.and(
                    Filters.eq("idPsicologo", psicologo.getId()),
                    Filters.gte("fechaHora", LocalDate.now().minusDays(30)))).into(new ArrayList<>());
            return pagosFiltrados;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los pagos del psicologo: " + e.getMessage());
        }
    }

    /**
     * Metodo para guardar un pago en la base de datos
     *
     * @param pago Pago a guardar
     * @return true si se guardo correctamente, false en caso contrario
     */
    @Override
    public Pago registrarPago(Pago pago) throws PersistenciaException {
        try {
            MongoDatabase bd = ConexionBD.getDatabase();
            MongoCollection<Pago> coleccionPagos = bd.getCollection("pagos", Pago.class);
            coleccionPagos.insertOne(pago);
            return pago;
        } catch (Exception e) {
            throw new PersistenciaException("Error al guardar el pago: " + e.getMessage());
        }
    }

}
