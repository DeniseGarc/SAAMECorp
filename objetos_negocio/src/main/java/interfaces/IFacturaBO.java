package interfaces;

import dto.FacturaDTO;
import dto.PagoDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con las facturas.
 * 
 * @author Alici
 */ 
public interface IFacturaBO {
    /**
     * Valida si el pago ya ha sido facturado.
     * 
     * @param pagoDTO Objeto que contiene la información del pago a validar.
     * @return true si el pago ya ha sido facturado, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante la validación.
     */
    public boolean validarPagoFactura(PagoDTO pagoDTO) throws NegocioException;
    /**
     * Registra una nueva factura en el sistema.
     * 
     * @param facturaDTO Objeto que contiene la información de la factura a registrar.
     * @return true si la factura se registró correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante el registro.
     */
   public boolean registrarFactura(FacturaDTO facturaDTO) throws NegocioException;
}
