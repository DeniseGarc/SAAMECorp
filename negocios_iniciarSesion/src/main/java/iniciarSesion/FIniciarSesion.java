/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciarSesion;

import dto.UsuarioDTO;
import excepciones.IniciarSesionException;

/**
 *
 * @author Alici
 */
public class FIniciarSesion implements IIniciarSesion {

    ControlIniciarSesion controlIniciarSesion = new ControlIniciarSesion();

    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException {
        if (usuario == null) {
            throw new IniciarSesionException("El usuario no puede ser nulo");
        }
        return controlIniciarSesion.iniciarSesion(usuario);
    }
}
