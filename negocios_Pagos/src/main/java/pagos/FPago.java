/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos;

import java.util.List;

import dto.PsicologoDTO;
import excepciones.PagosException;

/**
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

}
