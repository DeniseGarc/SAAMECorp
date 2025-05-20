package interfaces;

import java.util.List;

import entidades.Pago;
import entidades.Psicologo;
import excepciones.PersistenciaException;

/**
 * Interfaz que define los métodos para la gestión de pagos en la base de datos.
 * ESTA CLASE SE ENCUENTRA EN ESTADO MOCK.
 * 
 * @author Alici
 */
public interface IPagoDAO {
    /**
     * Método para consultar los pagos realizados por un psicólogo en los ultimos 30
     * dias.
     *
     * @return Psicologo objeto que contiene la información del psicólogo.
     * @throws PersistenciaException Si ocurre un error al consultar los pagos.
     */
    public List<Pago> consultarPagosMesPsicologo(Psicologo psicologo) throws PersistenciaException;

    /**
     * Método para registrar un nuevo pago en la base de datos.
     *
     * @param pago Objeto Pago que contiene la información del pago a registrar.
     * @return Pago objeto que contiene la información del pago registrado.
     * @throws PersistenciaException Si ocurre un error al registrar el pago.
     */
    public Pago registrarPago(Pago pago) throws PersistenciaException;
}
