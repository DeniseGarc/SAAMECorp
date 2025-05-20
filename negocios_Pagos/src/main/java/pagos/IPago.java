package pagos;

import java.util.List;

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

}
