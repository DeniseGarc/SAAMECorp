/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciarSesion;

import BO.UsuarioBO;
import dto.UsuarioDTO;
import enumeradores.TipoBO;
import excepciones.IniciarSesionException;
import excepciones.NegocioException;
import interfaces.IUsuarioBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorBO.ManejadorBO;

/**
 *
 * @author Alici
 */
public class ControlIniciarSesion {
    /**
     * Instancia de la clase de usuario BO por medio del manejador de BO
     */
    private IUsuarioBO usuarioBO = (UsuarioBO) ManejadorBO.crearBO(TipoBO.USUARIO);
    /**
     * Metodo para iniciar sesion al sistema
     * @param usuario Usuario que inicia sesion
     * @return UsuarioDTO con los datos del usuario
     * @throws IniciarSesionException 
     */
    protected UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException {
        try {
            return usuarioBO.iniciarSesion(usuario);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            throw new IniciarSesionException("Error al iniciar sesión", ex);
        }
    }
}
