package interfaces;

import entidades.Factura;
import entidades.Pago;
import excepciones.PersistenciaException;

public interface IFacturaDAO {
    public Factura consultarFactura(Pago pago) throws PersistenciaException;

    public boolean guardarFactura(Pago pago, Factura factura) throws PersistenciaException;
}
