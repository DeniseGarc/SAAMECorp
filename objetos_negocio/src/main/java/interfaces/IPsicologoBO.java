/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define los metodos para la logica de negocio para psicologos
 *
 * @author erika
 */
public interface IPsicologoBO {

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     * @throws excepciones.NegocioException
     */
    public List<PsicologoCitaDTO> obtenerPsicologos() throws NegocioException;

    /**
     * Método para obtener el psicólogo por su identificador dado.
     *
     * @param id
     * @return Datos del psicologo.
     * @throws excepciones.NegocioException
     */
    public PsicologoCitaDTO obtenerPsicologoPorIdentificador(String id) throws NegocioException;

}
