/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.PsicologoDAO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IPsicologoBO;
import interfaces.IPsicologoDAO;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.PsicologoMapper;

/**
 * Clase que define la logica de negocio para psicologos
 *
 * @author erika
 */
public class PsicologoBO implements IPsicologoBO {
    
    /**
     * Instancia unica de la clase 
     */
    private static PsicologoBO instancia; 
    
    private static final IPsicologoDAO psicologoDAO = PsicologoDAO.getInstanciaDAO();
    PsicologoMapper psicologoMapper = new PsicologoMapper();
    /**
     * Constructor privado para evitar instancias externas
     */
    private PsicologoBO(){}
    
     /**
     * Metodo para obtener la instancia unica de PsicologoBO
     * Si no existe una la crea
     * @return instancia unida de PsicologoBO
     */
    public static PsicologoBO getInstancia(){
        if (instancia == null){
            instancia= new PsicologoBO();
        }
        return instancia; 
    }
    
    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<PsicologoDTO> obtenerPsicologos() throws NegocioException {
        try {
            List<Psicologo> psicologos = psicologoDAO.obtenerPsicologos();
            return psicologoMapper.toDTOList2(psicologos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los psicologos: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener un psicolo en especifico dado su identificador unico
     *
     * @param identificador Identificador del psicologo a buscar
     * @return Psicologo Encontrado
     */
    @Override
    public PsicologoDTO obtenerPsicologoPorIdentificador(String identificador) throws NegocioException {
        try {
            Psicologo psicologoEncontrado = psicologoDAO.obtenerPsicologoPorIdentificador(identificador);
            return psicologoMapper.toDTO2(psicologoEncontrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener psicologo por su id: " + e.getMessage());
        }
    }

}
