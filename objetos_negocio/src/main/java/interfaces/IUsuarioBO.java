/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.UsuarioDTO;
import excepciones.NegocioException;

/**
 * interfaz para la clase de usuario BO que define los metodos y da acceso a estos
 * @author Alici
 */
public interface IUsuarioBO {
    /**
     * Metodo para iniciar sesion
     * @param usuarioDTO usuario que inicia sesion
     * @return UsuarioDTO con los datos del usuario que entra al sistema
     * @throws NegocioException 
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) throws NegocioException;
}
