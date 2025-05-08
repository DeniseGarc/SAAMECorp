/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IPsicologoDAO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa los metodos para Psicologos en la capa de persistencia
 *
 * @author erika
 */
public class PsicologoDAO implements IPsicologoDAO {

    private static PsicologoDAO instanciaPsicologoDAO;
    /**
     * Constructor privado
     */
    private PsicologoDAO() {
    }
    /**
     * Metodo para obtener la instancia unica de PsicologoDAO
     * @return instancia unica de la clase PsicologoDAO
     */
    public static PsicologoDAO getInstanciaDAO() {
        if (instanciaPsicologoDAO == null) {
            instanciaPsicologoDAO = new PsicologoDAO();
        }
        return instanciaPsicologoDAO;

    }

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<Psicologo> obtenerPsicologos() throws PersistenciaException {
        try {
            List<Psicologo> lista = new LinkedList<>();
            lista.add(new Psicologo("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com"));
            lista.add(new Psicologo("Jorge", "Blanco", "Verdugo", "jorge@gmail.com"));
            lista.add(new Psicologo("Maria", "Felix", "Perez", "erikalucia005@gmail.com"));
            return lista;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los psicologos: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener un Psicologo especificp por su identificador
     *
     * @param identificador Identificador unico del Psicologo a buscar
     * @return Psicologo encontrado
     */
    @Override
    public Psicologo obtenerPsicologoPorIdentificador(String identificador) throws PersistenciaException {
        try {
            return new Psicologo("Abraham", "Sainz", "Felix", "jsusAbhram@potros.itson.com");
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener psicologo por su identificador: " + e.getMessage());
        }
    }

}
