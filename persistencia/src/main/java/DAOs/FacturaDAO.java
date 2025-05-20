package DAOs;

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

    /**
     * Constructor privado para evitar la instanciación directa de la clase. Se
     * utiliza en el patrón singleton.
     */
    private FacturaDAO() {
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
        // Implementación del método para consultar una factura
        return null; // Cambiar por la implementación real
    }

    /**
     * Método para guardar una factura en la base de datos.
     *
     * @param factura El objeto Factura que se desea guardar.
     * @return true si la factura se guardó correctamente, false en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante el guardado.
     */
    @Override
    public boolean guardarFactura(Factura factura) throws PersistenciaException {
        // Implementación del método para guardar una factura
        return false; // Cambiar por la implementación real
    }

    /**
     * Método para consultar una factura asociada a un pago.
     *
     * @param pago El objeto Pago del cual se desea consultar la factura.
     * @return La factura asociada al pago.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Factura consultarFacturaPago(Pago pago) throws PersistenciaException {
        // Implementación del método para consultar una factura por pago
        return null; // Cambiar por la implementación real
    }

}
