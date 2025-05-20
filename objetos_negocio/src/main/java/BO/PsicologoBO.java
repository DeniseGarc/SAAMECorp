/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.PsicologoDAO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IPsicologoBO;
import interfaces.IPsicologoDAO;
import java.util.List;
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
    private PsicologoBO() {
    }

    /**
     * Metodo para obtener la instancia unica de PsicologoBO Si no existe una la
     * crea
     *
     * @return instancia unida de PsicologoBO
     */
    public static PsicologoBO getInstancia() {
        if (instancia == null) {
            instancia = new PsicologoBO();
        }
        return instancia;
    }

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<PsicologoCitaDTO> obtenerPsicologos() throws NegocioException {
        try {
            List<Psicologo> psicologos = psicologoDAO.obtenerPsicologos();
            return psicologoMapper.toDTOList(psicologos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los psicologos: " + e.getMessage());
        }
    }

    /**
     * Método para obtener el psicólogo por su identificador dado.
     *
     * @param id
     * @return Datos del psicologo.
     * @throws excepciones.NegocioException
     */
    @Override
    public PsicologoCitaDTO obtenerPsicologoPorIdentificador(String id) throws NegocioException {
        try {
            Psicologo psicologo = psicologoDAO.obtenerPsicologoPorIdentificador(id);
            return psicologoMapper.toDTO(psicologo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los psicologos: " + e.getMessage());
        }
    }

}
