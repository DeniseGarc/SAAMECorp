/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Psicologo;
import excepciones.PersistenciaException;
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
     * @throws excepciones.PersistenciaException
     */
    public List<Psicologo> obtenerPsicologos() throws PersistenciaException;

    /**
     * Método para obtener el psicólogo por su identificador dado.
     *
     * @param identificador Identificador único del psicólogo.
     * @return Datos del psicologo.
     * @throws excepciones.PersistenciaException
     */
    public Psicologo obtenerPsicologoPorIdentificador(String identificador) throws PersistenciaException;
}
