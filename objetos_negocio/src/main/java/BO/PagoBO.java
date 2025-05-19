package BO;

import java.util.List;
import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.NegocioException;
import interfaces.IPagoBO;

/**
 * Clase que implementa la lógica de negocio para los pagos.
 * MOCK
 * 
 * @author Alici
 */
public class PagoBO implements IPagoBO {
    /**
     * Valida si el pago ya ha sido facturado.
     * 
     * @param pagoDTO Objeto que contiene la información del pago a validar.
     * @return true si el pago ya ha sido facturado, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante la validación.
     */
    @Override
    public List<PagoDTO> obtenerPagosDelMesPsicologo(PsicologoDTO psicologoDTO) throws NegocioException {
        // Implementación de la lógica para obtener los pagos del mes del psicólogo
        return null;
    }
    /**
     * Registra un nuevo pago en el sistema.
     * 
     * @param pagoDTO Objeto que contiene la información del pago a registrar.
     * @return true si el pago se registró correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante el registro.
     */
    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) throws NegocioException {
        // Implementación de la lógica para registrar el pago
        return null;
    }

}
