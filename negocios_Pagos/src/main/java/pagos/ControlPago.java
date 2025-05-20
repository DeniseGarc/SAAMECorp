package pagos;

import java.util.List;
import dto.PagoDTO;
import dto.PsicologoDTO;
import enumeradores.TipoBO;
import excepciones.NegocioException;
import excepciones.PagosException;
import interfaces.IPagoBO;
import manejadorBO.ManejadorBO;

/**
 * Clase que representa el controlador para la fachada de pagos.
 * ESTA CLASE ES UN MOCK
 * 
 * @author Alici
 */
public class ControlPago {
    /**
     * Atributo que representa la lógica de negocio para los pagos.
     */
    private IPagoBO pagoBO = (IPagoBO) ManejadorBO.crearBO(TipoBO.PAGO);

    /**
     * Método para obtener los psicólogos registrados en el sistema.
     * 
     * @return Lista de objetos PsicologoDTO que representan los psicólogos.
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los psicólogos.
     */
    protected List<PsicologoDTO> obtenerPsicologos() throws PagosException {
        List<PsicologoDTO> psicologos;
        try {
            psicologos = pagoBO.obtenerPsicologos();
        } catch (NegocioException e) {
            throw new PagosException("Error al obtener los psicólogos: " + e.getMessage(), e);
        }
        return psicologos;
    }

    /**
     * Metodo para obtener los pagos realizados hace 30 dias de un psicologo.
     * 
     * @param psicologo PsicologoDTO que representa el psicologo.
     * @return Lista de objetos PagoDTO que representan los pagos realizados.
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los pagos.
     * 
     */
    protected List<PagoDTO> obtenerPagosMesAnterior(PsicologoDTO psicologo) throws PagosException {
        List<PagoDTO> pagos;
        try {
            pagos = pagoBO.obtenerPagosDelMesPsicologo(psicologo);
        } catch (NegocioException e) {
            throw new PagosException("Error al obtener los pagos: " + e.getMessage(), e);
        }
        return pagos;
    }
}
