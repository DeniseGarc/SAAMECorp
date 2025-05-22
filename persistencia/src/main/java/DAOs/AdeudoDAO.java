/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Cita;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IAdeudoDAO;
import org.bson.conversions.Bson;

/**
 *
 * @author erika
 */
public class AdeudoDAO implements IAdeudoDAO {

    /**
     * Instancia unica de la clase
     */
    private static AdeudoDAO instancia;
    private final MongoCollection<Cita> coleccionCitas;

    /**
     * Constructor privado
     */
    private AdeudoDAO() {
        MongoDatabase bd = ConexionBD.getDatabase();
        coleccionCitas = bd.getCollection("Citas", Cita.class);
    }

    /**
     * Metodo para obtener la instancia unica de AdeudoDAO Si no existe una la
     * crea
     *
     * @return instancia unida de AdeudoDAO
     */
    public static AdeudoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AdeudoDAO();
        }
        return instancia;
    }

    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     *
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     * @throws excepciones.PersistenciaException
     */
    @Override
    public double consultarAdeudoTotalPsicologo(Psicologo psicologo) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.eq("idPsicologo", psicologo.getId()),
                    Filters.eq("detallesAdeudo.estado", true)
            );
            double total = 0.0;
            for (Cita cita : coleccionCitas.find(filtro)) {
                total += cita.getDetallesAdeudo().getCantidad();
            }
            return total;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el adeudo total: " + e.getMessage());
        }
    }

}
