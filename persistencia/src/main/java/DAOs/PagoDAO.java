package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.ConexionBD;
import entidades.Pago;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IPagoDAO;

/*
 * Clase que implementa la interfaz IPagoDAO para gestionar los pagos en la base de datos.
 * Esta clase es un singleton, lo que significa que solo puede haber una instancia de ella en la aplicación.
 *  
 * @author Alici  
 */
public class PagoDAO implements IPagoDAO {
    /**
     * Instancia unica de la clase
     */
    private static PagoDAO instancia;

    /**
     * Constructor vacio
     */
    private PagoDAO() {
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
    public Psicologo consultarPagosMesPsicologo(Pago pago) throws PersistenciaException {
        try {
            MongoDatabase bd = ConexionBD.getDatabase();
            MongoCollection<Pago> coleccionPagos = bd.getCollection("pagos", Pago.class);
            // Aqui se debe implementar la logica para consultar los pagos del psicologo
            // en el mes actual
            // Se debe retornar el psicologo que realizo el pago
            return null;
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
