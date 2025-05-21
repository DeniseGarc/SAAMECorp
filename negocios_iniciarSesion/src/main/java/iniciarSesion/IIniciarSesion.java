/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iniciarSesion;

import dto.UsuarioDTO;
import excepciones.IniciarSesionException;

/**
 *
 * @author Alici
 */
public interface IIniciarSesion {

    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException;
}
