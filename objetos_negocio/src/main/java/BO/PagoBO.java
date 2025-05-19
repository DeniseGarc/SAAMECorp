package BO;

import java.util.List;

import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.NegocioException;
import interfaces.IPagoBO;

public class PagoBO implements IPagoBO {
    
    @Override
    public List<PagoDTO> obtenerPagosDelMesPsicologo(PsicologoDTO psicologoDTO) throws NegocioException {
        // Implementación de la lógica para obtener los pagos del mes del psicólogo
        return null;
    }

    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) throws NegocioException {
        // Implementación de la lógica para registrar el pago
        return null;
    }

}
