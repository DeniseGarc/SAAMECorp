/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos;

import java.util.List;
import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.PagosException;

/**
 * Interfaz que define los métodos para realizar operaciones de pago.
 * ESTA CLASE ES UN MOCK
 * 
 * @author Alici
 */
public class FPago implements IPago {
    private ControlPago controlPago = new ControlPago();

    /**
     * Método para obtener los psicólogos registrados en el sistema.
     * 
     * @return Lista de objetos PsicologoDTO que representan los psicólogos.
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los psicólogos.
     */
    @Override
    public List<PsicologoDTO> obtenerPsicologos() throws PagosException {
        List<PsicologoDTO> psicologos;
        try {
            psicologos = controlPago.obtenerPsicologos();
        } catch (PagosException e) {
            throw new PagosException("Error al obtener los psicólogos: " + e.getMessage(), e);
        }
        return psicologos;
    }

    /**
     * Método para obtener los pagos del mes anterior de un psicólogo específico.
     * 
     * @param psicologo Objeto PsicologoDTO que representa al psicólogo.
     * @return Lista de objetos PagoDTO que representan los pagos del mes anterior.
     * @throws PagosException Si ocurre un error de negocio durante la obtención de
     *                        los pagos.
     */
    @Override
    public List<PagoDTO> obtenerPagosMesAnterior(PsicologoDTO psicologo) throws PagosException {
        List<PagoDTO> pagos;
        try {
            pagos = controlPago.obtenerPagosMesAnterior(psicologo);
        } catch (PagosException e) {
            throw new PagosException("Error al obtener los pagos: " + e.getMessage(), e);
        }
        return pagos;
    }
}
