/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Psicologo;
import java.util.List;

/**
 * INterfaz que implementa los metodos para la clase de PsicologoDAO
 * @author erika
 */
public interface IPsicologoDAO {
     /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    public List<Psicologo> obtenerPsicologos();

    /**
     * Método para obtener el psicólogo por su identificador dado.
     *
     * @param identificador Identificador único del psicólogo.
     * @return Datos del psicologo.
     */
    public Psicologo obtenerPsicologoPorIdentificador(String identificador);
}
