package mapper;

import DTO.FacturaRegistroDTO;
import dto.FacturaDTO;

/**
 * Clase que se encarga de mapear las facturas de la capa de negocio a la capa
 * de infraestructura, y a entidades de factura.
 * 
 * @author Alici
 */
public class FacturaMapper {
    /**
     * Método para mapear un DTO de factura de la capa de negocio a un DTO de
     * registro de factura de infraestraestructura.
     *
     * @param factura DTO de negocio de la factura a mapear
     * @return DTO de registro de la factura
     */
    public FacturaRegistroDTO mapToFacturaRegistroDTO(FacturaDTO factura) {
        FacturaRegistroDTO facturaRegistroDTO = new FacturaRegistroDTO(
                factura.getId(),
                factura.getFolio(),
                factura.getFechaHoraEmision(),
                factura.getCurrency(),
                factura.getExpeditionPlace(),
                factura.getPaymentConditions(),
                factura.getCfdiType(),
                factura.getPaymentForm(),
                factura.getPaymentMethod(),
                factura.getRfcReceiver(),
                factura.getNameReceiver(),
                factura.getEmailReceiver(),
                factura.getCfdiUse(),
                factura.getFiscalRegime(),
                factura.getTaxZipCode(),
                factura.getProductCode(),
                factura.getDescription(),
                factura.getUnit(),
                factura.getUnitCode(),
                factura.getUnitPrice(),
                factura.getQuantity(),
                factura.getSubtotal(),
                factura.getTotal(),
                factura.getTaxObject());

        return facturaRegistroDTO;
    }

    /**
     * Método para mapear un DTO de registro de factura de infraestructura a un DTO
     * de factura de
     * negocio.
     *
     * @param facturaRegistroDTO DTO de registro de la factura a mapear
     * @return DTO de la factura
     */
    public FacturaDTO mapToFacturaDTO(FacturaRegistroDTO facturaRegistroDTO) {
        FacturaDTO factura = new FacturaDTO(
                facturaRegistroDTO.getId(),
                facturaRegistroDTO.getFolio(),
                facturaRegistroDTO.getFechaHoraEmision(),
                facturaRegistroDTO.getPaymentConditions(),
                facturaRegistroDTO.getPaymentForm(),
                facturaRegistroDTO.getPaymentMethod(),
                facturaRegistroDTO.getRfcReceiver(),
                facturaRegistroDTO.getNameReceiver(),
                facturaRegistroDTO.getEmailReceiver(),
                facturaRegistroDTO.getCfdiUse(),
                facturaRegistroDTO.getFiscalRegime(),
                facturaRegistroDTO.getTaxZipCode(),
                facturaRegistroDTO.getUnitPrice(),
                facturaRegistroDTO.getQuantity(),
                facturaRegistroDTO.getSubtotal(),
                facturaRegistroDTO.getTotal());
        return factura;
    }
}
