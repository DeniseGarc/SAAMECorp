package BO;

import java.util.List;

import DAOs.PsicologoDAO;
import dto.PagoDTO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IPagoBO;
import interfaces.IPsicologoDAO;
import mapper.PsicologoMapper;

/**
 * Clase que implementa la lógica de negocio para los pagos. MOCK
 *
 * @author Alici
 */
public class PagoBO implements IPagoBO {

    private IPsicologoDAO psicologoDAO = PsicologoDAO.getInstanciaDAO();
    private PsicologoMapper mapper = new PsicologoMapper();

    @Override
    public List<PagoDTO> obtenerPagosDelMesPsicologo(PsicologoDTO psicologoDTO) throws NegocioException {
        // Implementación de la lógica para obtener los pagos del mes del psicólogo
        return null;
    }

    /**
     * Registra un nuevo pago en el sistema.
     *
     * @param pagoDTO Objeto que contiene la información del pago a registrar.
     * @return true si el pago se registró correctamente, false en caso
     *         contrario.
     * @throws NegocioException Si ocurre un error de negocio durante el
     *                          registro.
     */
    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) throws NegocioException {
        // Implementación de la lógica para registrar el pago
        return null;
    }

    /**
     * Método para obtener todos los psicólogos registrados.
     * 
     * @return Lista de psicólogos registrados.
     * @throws NegocioException Si ocurre un error de negocio durante la
     *                          obtención de los psicólogos.
     */
    public List<PsicologoDTO> obtenerPsicologos() throws NegocioException {
        try {
            List<Psicologo> psicologos = psicologoDAO.obtenerPsicologos();
            return mapper.toDTOList2(psicologos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los psicólogos: " + e.getMessage());
        }
    }
}
