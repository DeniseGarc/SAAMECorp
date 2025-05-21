/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAOs.UsuarioDAO;
import dto.UsuarioDTO;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IUsuarioBO;
import interfaces.IUsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.UsuarioMapper;

/**
 *
 * @author Alici
 */
public class UsuarioBO implements IUsuarioBO {
    /**
     * instancia de usuario dao para acceder a la base de datos
     */
    private IUsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    /**
     * Instancia de mapper para usuario
     */
    private UsuarioMapper mapper = new UsuarioMapper();
    /**
     * Instancia privada de la pagina
     */
    private static UsuarioBO instancia;
    /**
     * Constructor privado
     */
    private UsuarioBO() {
    }
    /**
     * Metodo para obtener la instancia unica de la clase
     * @return 
     */
    public static UsuarioBO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioBO();
        }
        return instancia;
    }
    /**
     * Metodo para iniciar sesion en el sistema, devuelve el usuario encontrado
     * o lanza una excepcion si el usuario no existe o la contraseña es
     * incorrecta 
     * @param usuarioDTO Usuario de la cuenta
     * @return usuarioDTO con los datos del usuario que inicia sesion
     * @throws NegocioException 
     */
    @Override
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) throws NegocioException {
        if (usuarioDTO.getUsuario() == null || usuarioDTO.getContrasena() == null) {
            throw new NegocioException("El usuario o la contraseña no pueden ser nulos");
        }
        Usuario usuario;
        try {
            usuario = usuarioDAO.iniciarSesion(usuarioDTO.getUsuario(), usuarioDTO.getContrasena());
            if (usuarioDTO.getTipoUsuario().equals(usuario.getTipoUsuario())) {
                return mapper.toDTO(usuario);
            }
            throw new NegocioException("El tipo de usuario no coincide");
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al iniciar sesion :" + ex.getMessage());
        }
    }
}
