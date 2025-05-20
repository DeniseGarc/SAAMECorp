/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.PagoDTO;
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

}
