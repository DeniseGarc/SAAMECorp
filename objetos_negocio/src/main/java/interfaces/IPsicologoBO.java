/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.PsicologoDTO;
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
     */
    public List<PsicologoDTO> obtenerPsicologos();

    /**
     * Método para obtener el psicólogo por su identificador dado.
     *
     * @param identificador Identificador único del psicólogo.
     * @return Datos del psicologo.
     */
    public PsicologoDTO obtenerPsicologoPorIdentificador(String identificador);

}
