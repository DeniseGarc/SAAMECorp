
package mapper;

import java.util.ArrayList;
import java.util.List;
import dto.PagoDTO;
import dto.PsicologoDTO;
import entidades.Pago;

/**
 * Clase para mappear a entidades y DTO de pagos.
 * ESTA CLASE ES UN MOCK.
 * 
 * @author Alici
 */
public class PagoMapper {

    /**
     * Metodo para convertir a entidad un pagoDTO
     * 
     * @param pagoDTO pagoDTO a convertir en entidad
     * @return Entidad pago con los valores de pagoDTO
     */
    public Pago toEntity(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setObjectString(pagoDTO.getId());
        pago.setMonto(pagoDTO.getMonto());
        pago.setCondicionesPago(pagoDTO.getCondicionesPago());
        pago.setFechaHora(pagoDTO.getFechaHora());
        pago.setFormaPago(pagoDTO.getFormaPago());
        return pago;
    }

    /**
     * Metodo para convertir una lista de entidades pago a una lista de DTOs
     * 
     * @param pagos lista de entidades pago
     * @return lista de DTOs de pagos
     */
    public List<PagoDTO> toDTOList(List<Pago> pagos) {
        List<PagoDTO> pagosDTO = new ArrayList<>();
        for (Pago pago : pagos) {
            pagosDTO.add(toDTO(pago));
        }
        return pagosDTO;
    }

    /**
     * Metodo para convertir una entidad pago a un DTO
     * 
     * @param pago entidad pago
     * @return DTO de pago
     */
    public PagoDTO toDTO(Pago pago) {
        // PsicologoDTO psicologoDTO = new PsicologoDTO();
        // psicologoDTO.setId(pago.getObjectPsicologoString());
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setId(pago.getObjectString());
        pagoDTO.setMonto(pago.getMonto());
        pagoDTO.setCondicionesPago(pago.getCondicionesPago());
        pagoDTO.setFechaHora(pago.getFechaHora());
        pagoDTO.setFormaPago(pago.getFormaPago());
        // pagoDTO.setPsicologo();
        return pagoDTO;
    }

}
