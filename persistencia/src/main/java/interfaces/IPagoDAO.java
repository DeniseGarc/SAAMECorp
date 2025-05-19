package interfaces;

import entidades.Pago;
import entidades.Psicologo;
import excepciones.PersistenciaException;

public interface IPagoDAO {
    public Psicologo consultarPagosMesPsicologo(Pago pago) throws PersistenciaException;
    public Pago registrarPago(Pago pago) throws PersistenciaException;
}
