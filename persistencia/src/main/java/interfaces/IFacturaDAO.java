package interfaces;

import entidades.Factura;
import entidades.Pago;
import excepciones.PersistenciaException;

/**
 * Interfaz que define los métodos para la gestión de facturas en la base de
 * datos.
 * 
 * @author Alici
 */

public interface IFacturaDAO {
    /**
     * Método para consultar si el pago ya tiene una factura asociada.
     * 
     * @param pago Pago a consultar
     * @return Factura asociada al pago
     * @throws PersistenciaException Si ocurre un error al consultar la factura.
     */
    public Factura consultarFactura(Pago pago) throws PersistenciaException;

    /**
     * Metodo para guardar en el sistema la factura.
     * 
     * @param pago    Pago que tiene la nueva factura asociada.
     * @param factura factura del pago
     * @return True si fue posible guardar la factura, false en caso contrario
     * @throws PersistenciaException Si ocurre un error al guardar la factura.s
     */
    public boolean guardarFactura(Pago pago, Factura factura) throws PersistenciaException;
}
