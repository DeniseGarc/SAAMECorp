/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author Alici
 */
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        return usuario;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        if (usuario.getTipoUsuario().equals("PSICOLOGO")) {
            usuarioDTO.setIdentificador(usuario.getObjectPsicologoString());
            usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
            usuarioDTO.setUsuario(usuario.getUsuario());
        } else {
            usuarioDTO.setIdentificador(usuario.getObjectString());
            usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
            usuarioDTO.setUsuario(usuario.getUsuario());
        }
        return usuarioDTO;
    }
}
