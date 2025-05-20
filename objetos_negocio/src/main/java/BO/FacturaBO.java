package BO;

import DAOs.FacturaDAO;
import DAOs.PsicologoDAO;
import dto.FacturaDTO;
import dto.PagoDTO;
import entidades.Factura;
import entidades.Pago;
import entidades.Psicologo;
import excepciones.NegocioException;
import interfaces.IFacturaBO;
import interfaces.IFacturaDAO;
import interfaces.IPsicologoDAO;
import mapper.FacturaMapper;
import mapper.PagoMapper;

/**
 * Clase que implementa la lógica de negocio para la gestión de facturas.
 *
 * @author Alici
 */
public class FacturaBO implements IFacturaBO {

    /**
     * Instancia única de la clase FacturaDAO.
     */
    private IFacturaDAO facturaDAO = FacturaDAO.getInstance();
    private IPsicologoDAO psicologoDAO = PsicologoDAO.getInstanciaDAO();
    /**
     * Instancia del mapper para convertir entre DTOs y entidades.
     */
    private FacturaMapper mapperFactura = new FacturaMapper();

    private PagoMapper mapperPago = new PagoMapper();

    /**
     * Valida si el pago ya ha sido facturado.
     *
     * @param pagoDTO Objeto que contiene la información del pago a validar.
     * @return true si el pago ya ha sido facturado, false en caso contrario.
     * @throws NegocioException Si ocurre un error de negocio durante la
     *                          validación.
     */
    @Override
    public boolean validarPagoFactura(PagoDTO pagoDTO) throws NegocioException {
        if (pagoDTO == null) {
            throw new NegocioException("El pago no puede ser nulo.");
        }
        try {
            Pago pago = mapperPago.toEntity(pagoDTO);
            Factura factura = facturaDAO.consultarFactura(pago);
            return factura != null;
        } catch (Exception e) {
            throw new NegocioException("Error al validar el pago: " + e.getMessage());
        }
    }

    /**
     * Registra una nueva factura en el sistema.
     *
     * @param pagoDTO
     * @param facturaDTO Objeto que contiene la información de la factura a
     *                   registrar.
     * @return true si la factura se registró correctamente, false en caso
     *         contrario.
     * @throws NegocioException Si ocurre un error de negocio durante el
     *                          registro.
     */
    @Override
    public boolean registrarFactura(PagoDTO pagoDTO, FacturaDTO facturaDTO) throws NegocioException {
        if (facturaDTO == null || facturaDTO.getId() == null) {
            throw new NegocioException(
                    "La factura no puede ser nula o no tener el id de la factura registrada en Facturama");
        }
        if (pagoDTO == null) {
            throw new NegocioException("El pago no puede ser nulo");
        }
        try {
            Pago pago = mapperPago.toEntity(pagoDTO);
            Psicologo psicologoRfc = new Psicologo();
            psicologoRfc.setRfc(facturaDTO.getRfcReceiver());
            Psicologo psicologo = psicologoDAO.obtenerPsicologoPorRfc(psicologoRfc);
            pago.setIdPsicologo(psicologo.getId());
            facturaDAO.guardarFactura(pago, mapperFactura.toEntity(facturaDTO));
        } catch (Exception e) {
            throw new NegocioException("Error al registrar la factura: " + e.getMessage());
        }
        return true;
    }

}
