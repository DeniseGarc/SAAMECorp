package pagos;

import java.util.List;

import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.PagosException;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con
 * los pagos.
 * 
 * @author Alici
 */
public interface IPago {
    /**
     * Obtiene los psicologos registrados en el sistema.
     * 
     * @return Lista de objetos PsicologoDTO que representan los psicologos
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los
     *                        psicologos.
     */
    public List<PsicologoDTO> obtenerPsicologos() throws PagosException;

    /**
     * Obtiene los pagos del mes anterior de un psicologo específico.
     * 
     * @param psicologo Objeto PsicologoDTO que representa al psicologo
     * @return Lista de objetos PagoDTO que representan los pagos del mes anterior
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los
     *                        pagos.
     */
    public List<PagoDTO> obtenerPagosMesAnterior(PsicologoDTO psicologo) throws PagosException;

}
