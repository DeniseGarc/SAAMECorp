/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iniciarSesion;

import dto.UsuarioDTO;
import excepciones.IniciarSesionException;

/**
 * Interfaz para los metos del subsistema de inicio de sesion
 * @author Alici
 */
public interface IIniciarSesion {
    /**
     * Metodo para iniciar sesion en el sistema
     * @param usuario usuario que inicia sesion
     * @return UsuarioDTO con los datos del usuario que entro al sistema
     * @throws IniciarSesionException si el usuario no se ingreso correctamente
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException;
}
