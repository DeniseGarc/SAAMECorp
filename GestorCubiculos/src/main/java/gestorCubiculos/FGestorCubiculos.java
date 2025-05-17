/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorCubiculos;

import dto.CubiculoDTO;
import excepciones.GestorCubiculosException;
import java.util.List;

/**
 *
 * @author erika
 */
public class FGestorCubiculos implements IGestorCubiculos{
    
    private final GestorCubiculosControl control = new GestorCubiculosControl();

    public FGestorCubiculos() {
    }
    
    
    @Override
    public List<CubiculoDTO> obtenerCubiculosPorEstado(boolean estado) throws GestorCubiculosException {
       return control.ObtenerCubiculosPorEstado(estado);
    }

    @Override
    public List<CubiculoDTO> obtenerCubiculos() throws GestorCubiculosException {
        return control.obtenerCubiculos();
    }

    @Override
    public boolean agregarCubiculo(CubiculoDTO cubiculo) throws GestorCubiculosException {
       return control.AgregaeCubiculo(cubiculo);
    }

    @Override
    public boolean actualizarEstadoCubiculo(CubiculoDTO cubiculoAgregar) throws GestorCubiculosException {
        return control.ModificarEstado(cubiculoAgregar);
    }

    @Override
    public boolean modificarCubiculo(CubiculoDTO cubiculoModificar) throws GestorCubiculosException {
        return control.ModificarCubiculo(cubiculoModificar);
    }
    
}
