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
 *
 * @author erika
 */
public class CubiculoDAO implements ICubiculoDAO {
    /**
     * Instancia unica de la clase
     */
    private static CubiculoDAO instanciaCubiculoDAO;
    /**
     * Constructor privado
     */
    private CubiculoDAO() {
    }
    /**
     * Metodo para obtener la instancia unica de la clase CubiculoDAO
     * @return Instancia Unica de la clase CubiculoDAO
     */
    public static CubiculoDAO getInstanciaDAO() {
        if (instanciaCubiculoDAO == null) {
            instanciaCubiculoDAO = new CubiculoDAO();
        }
        return instanciaCubiculoDAO;
    }

    /**
     * Metodo que obtiene todos los cubiculos cuyo estado sea disponible
     *
     * @return Lista de cubiculosDTO disponibles
     */
    @Override
    public List<Cubiculo> obtenerCubiculosEstadoDisponible() throws PersistenciaException {
        try {
            List<Cubiculo> cubiculos = new LinkedList<>();
            cubiculos.add(new Cubiculo("Cubiculo 1", true));
            cubiculos.add(new Cubiculo("Cubiculo 2", true));
            cubiculos.add(new Cubiculo("Cubiculo 3", true));
            return cubiculos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los cubiculos disponibles: " + e.getMessage());
        }
    }

    @Override
    public List<Cubiculo> obtenerCubiculoPorEstado(boolean estado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ModificarCubiculo(Cubiculo cubiculoModificar) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ModificarEstadoCubiculo(Cubiculo CubiculoModificar) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean AgregarCubiculo(Cubiculo cubiculoAgregar) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cubiculo buscarCubiculoPorID(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cubiculo> buscarCubiculos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   

}
