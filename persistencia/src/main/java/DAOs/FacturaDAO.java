package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexion.ConexionBD;
import entidades.Factura;  
import entidades.Pago;
import excepciones.PersistenciaException;
import interfaces.IFacturaDAO;

/**
 * Clase FacturaDAO que implementa la interfaz IFacturaDAO. Esta clase es un
 * singleton y se encarga de la persistencia de las facturas.
 *
 * @author Alici
 */
public class FacturaDAO implements IFacturaDAO {

    /**
     * Instancia única de la clase FacturaDAO (singleton). Se utiliza para
     * asegurar que solo haya una instancia de esta clase en toda la aplicación.
     */
    private static FacturaDAO instance;
    private final MongoCollection<Pago> coleccionPagos;

    /**
     * Constructor privado para evitar la instanciación directa de la clase. Se
     * utiliza en el patrón singleton.
     */
    private FacturaDAO() {
        this.coleccionPagos = ConexionBD.getDatabase().getCollection("Pagos", Pago.class);
    }

    /**
     * Método estático para obtener la instancia única de la clase FacturaDAO.
     * Si la instancia no existe, se crea una nueva.
     *
     * @return La instancia única de FacturaDAO.
     */
    public static FacturaDAO getInstance() {
        if (instance == null) {
            instance = new FacturaDAO();
        }
        return instance;
    }

    /**
     * Método para consultar una factura asociada a un pago.
     *
     * @param pago El objeto Pago del cual se desea consultar la factura.
     * @return La factura asociada al pago.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Factura consultarFactura(Pago pago) throws PersistenciaException {
        try {
            Pago pagoEncontrado = (Pago) coleccionPagos.find(Filters.eq("pagoId", pago.getId())).first();
            if (pagoEncontrado != null) {
                if (pagoEncontrado.getDetallesFactura() == null) {
                    return null;
                }
                Factura factura = new Factura(
                        pagoEncontrado.getDetallesFactura().getIdFactura(),
                        pagoEncontrado.getDetallesFactura().getFolio(),
                        pagoEncontrado.getDetallesFactura().getFechaHora());
                return factura;
            } else {
                throw new PersistenciaException("Pago no encontrado.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los pagos del psicologo: " + e.getMessage());
        }
    }

    /**
     * Método para guardar una factura en la base de datos.
     *
     * @param pago
     * @param factura El objeto Factura que se desea guardar.
     * @return true si la factura se guardó correctamente, false en caso
     *         contrario.
     * @throws PersistenciaException Si ocurre un error durante el guardado.
     */
    @Override

    public boolean guardarFactura(Pago pago, Factura factura) throws PersistenciaException {
        try {
            coleccionPagos.updateOne(Filters.eq("_id", pago.getId()), Updates.set("detallesFactura", factura));
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al guardar la factura: " + e.getMessage());
        }
    }

}
