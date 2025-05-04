/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.Psicologo;
import interfaces.IPsicologoDAO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa los metodos para Psicologos en la capa de persistencia
 * @author erika
 */
public class PsicologoDAO implements IPsicologoDAO{

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<Psicologo> obtenerPsicologos() {
        List<Psicologo> lista = new LinkedList<>();

        lista.add(new Psicologo("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com"));
        lista.add(new Psicologo("Jorge", "Blanco", "Verdugo", "jorge@gmail.com"));
        lista.add(new Psicologo("Maria", "Felix", "Perez", "maria@gmail.com"));

        return lista;
    }

   /**
    * Metodo para obtener un Psicologo especificp por su identificador
    * @param identificador Identificador unico del Psicologo a buscar
    * @return Psicologo encontrado
    */
    @Override
    public Psicologo obtenerPsicologoPorIdentificador(String identificador) {
        return new Psicologo("Abraham", "Sainz", "Felix", "jsusAbhram@potros.itson.com");
    }
    
}
