/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciarSesion;

import dto.UsuarioDTO;
import excepciones.IniciarSesionException;

/**
 * Clase fachada 
 * @author Alici
 */
public class FIniciarSesion implements IIniciarSesion {
    /**
     * Instancia del controlador del subsistema para acceder a los metodos
     */
    ControlIniciarSesion controlIniciarSesion = new ControlIniciarSesion();
    /**
     * Metodo para iniciar sesion en el sistema
     * @param usuario usuario que inicia sesion
     * @return UsuarioDTO con los datos del usuario que entro al sistema
     * @throws IniciarSesionException si el usuario no se ingreso correctamente
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException {
        if (usuario == null) {
            throw new IniciarSesionException("El usuario no puede ser nulo");
        }
        return controlIniciarSesion.iniciarSesion(usuario);
    }
}
