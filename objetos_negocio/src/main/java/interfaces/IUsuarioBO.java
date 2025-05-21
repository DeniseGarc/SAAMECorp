/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.UsuarioDTO;
import excepciones.NegocioException;

/**
 *
 * @author Alici
 */
public interface IUsuarioBO {

    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) throws NegocioException;
}
