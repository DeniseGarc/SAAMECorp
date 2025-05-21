/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 *
 * @author Alici
 */
public interface IUsuarioDAO {

    public Usuario iniciarSesion(String usuario, String contrasena) throws PersistenciaException;

}
