/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.util.ArrayList;
import java.util.List;

import dto.PagoDTO;
import dto.PsicologoDTO;
import entidades.Pago;

/**
 *
 * @author Alici
 */
public class PagoMapper {

    public Pago toEntity(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setObjectString(pagoDTO.getId());
        pago.setMonto(pagoDTO.getMonto());
        pago.setCondicionesPago(pagoDTO.getCondicionesPago());
        pago.setFechaHora(pagoDTO.getFechaHora());
        pago.setFormaPago(pagoDTO.getFormaPago());
        return pago;
    }

    public List<PagoDTO> toDTOList(List<Pago> pagos) {
        List<PagoDTO> pagosDTO = new ArrayList<>();
        for (Pago pago : pagos) {
            pagosDTO.add(toDTO(pago));
        }
        return pagosDTO;
    }

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
