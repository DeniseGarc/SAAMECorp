package BO;

import dto.FacturaDTO;
import dto.PagoDTO;
import excepciones.NegocioException;
import interfaces.IFacturaBO;

/**
 * Clase que implementa la lógica de negocio para la gestión de facturas.
 * 
 * @author Alici
 */
public class FacturaBO implements IFacturaBO {
    
    /**
     * Valida si el pago ya ha sido facturado.
     * 
     * @param pagoDTO Objeto que contiene la información del pago a validar.
     * @return true si el pago ya ha sido facturado, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante la validación.
     */
    @Override
    public boolean validarPagoFactura(PagoDTO pagoDTO) throws NegocioException {
        if (pagoDTO == null) {
            throw new NegocioException("El pago no puede ser nulo.");
        }
        // logica para validar si el pago ha sido facturado

        return true;
    }

    /**
     * Registra una nueva factura en el sistema.
     * 
     * @param facturaDTO Objeto que contiene la información de la factura a registrar.
     * @return true si la factura se registró correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante el registro.
     */
    @Override
    public boolean registrarFactura(FacturaDTO facturaDTO) throws NegocioException {
        // Implementación de la lógica para registrar la factura
        return false;
    }

}
