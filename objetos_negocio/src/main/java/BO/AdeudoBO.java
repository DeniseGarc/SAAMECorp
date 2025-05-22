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
import mapper.AdeudoMapper;
import mapper.PsicologoMapper;

/**
 * Clase que implementa la logica de negocio para adeudo
 *
 * @author erika
 */
public class AdeudoBO implements IAdeudoBO {

    IAdeudoDAO adeudoDAO = AdeudoDAO.getInstancia();
    PsicologoMapper psicologoMapper = new PsicologoMapper();
    /**
     * Instancia unica de la clase 
     */
    private static AdeudoBO instancia; 
    
    /**
     * Constructor privado 
     */
    private AdeudoBO(){
    }
    /**
     * Metodo para obtener la instancia unica de AdeudoBO
     * Si no existe una la crea
     * @return instancia unida de AdeudoBO
     */
    public static AdeudoBO getInstancia(){
        if (instancia == null){
            instancia= new AdeudoBO();
        }
        return instancia; 
    }
    
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
            double ad = adeudoDAO.consultarAdeudoTotalPsicologo(entidad);
            return ad;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el adeudo total del psicologo: " + e.getMessage());
        }
    }
}
