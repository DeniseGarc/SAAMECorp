package interfaces;

import java.util.List;
import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con los
 * pagos.
 * 
 * @author Alici
 */
public interface IPagoBO {
    /**
     * Obtiene los pagos del mes para un psicólogo específico.
     * 
     * @param psicologoDTO Objeto que contiene la información del psicólogo.
     * @return Lista de objetos PagoDTO que representan los pagos del mes.
     * @throws NegocioException Si ocurre un error de negocio durante la obtención
     *                          de los pagos.
     */
    public List<PagoDTO> obtenerPagosDelMesPsicologo(PsicologoDTO psicologoDTO) throws NegocioException;

    /**
     * Registra un nuevo pago en el sistema.
     * 
     * @param pagoDTO Objeto que contiene la información del pago a registrar.
     * @return Objeto PagoDTO que representa el pago registrado.
     * @throws NegocioException Si ocurre un error de negocio durante el registro
     *                          del pago.
     */
    public PagoDTO registrarPago(PagoDTO pagoDTO) throws NegocioException;

    public List<PsicologoDTO> obtenerPsicologos() throws NegocioException;
}
