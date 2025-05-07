/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.AdeudoDAO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAdeudoBO;
import interfaces.IAdeudoDAO;
import mappers.AdeudoMapper;
import mappers.PsicologoMapper;

/**
 * Clase que implementa la logica de negocio para adeudo
 *
 * @author erika
 */
public class AdeudoBO implements IAdeudoBO {

    IAdeudoDAO adeudoDAO = new AdeudoDAO();
    PsicologoMapper psicologoMapper = new PsicologoMapper();

    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     *
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     */
    @Override
    public double consultarAdeudoTotalPsicologo(PsicologoDTO psicologo) throws NegocioException {
        try {
            Psicologo entidad = psicologoMapper.toEntity2(psicologo);
            return adeudoDAO.consultarAdeudoTotalPsicologo(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el adeudo total del psicologo: " + e.getMessage());
        }
    }
}
