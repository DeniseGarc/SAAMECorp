/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.Cubiculo;
import excepciones.PersistenciaException;
import interfaces.ICubiculoDAO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que define los metodos en Persistencia para Cubiculos
 * @author erika
 */
public class CubiculoDAO implements ICubiculoDAO{
    
    private static CubiculoDAO instanciaCubiculoDAO;

    public CubiculoDAO() {
    }
    
    public static CubiculoDAO getInstanciaDAO(){
        if (instanciaCubiculoDAO == null){
            instanciaCubiculoDAO = new CubiculoDAO();
        }
        return instanciaCubiculoDAO;
    }
    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     * @return Lista de cubiculosDTO disponibles
     */
    @Override
    public List<Cubiculo> obtenerCubiculosEstadoDisponible() {
        List<Cubiculo> cubiculos = new LinkedList<>();
        cubiculos.add(new Cubiculo("Cubiculo 1", true));
        cubiculos.add(new Cubiculo("Cubiculo 2", true));
        cubiculos.add(new Cubiculo("Cubiculo 3", true));
        return cubiculos;
    }
    
}
