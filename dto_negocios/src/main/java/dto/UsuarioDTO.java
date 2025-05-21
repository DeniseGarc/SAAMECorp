/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Alici
 */
public class UsuarioDTO {
    /**
     * Identificador del usuario
     */
    private String identificador;
    /**
     * Nombre de usuario
     */
    private String usuario;
    /**
     * Contraseña del usuario
     */
    private String contrasena;
    /**
     * Tipo de Usuario (Administrador o Psicologo)
     */
    private String tipoUsuario;
    
    /**
     * Constructor vacio
     */
    public UsuarioDTO() {
    }
    
    /**
     * Constructor que inicializa todos sus atributos
     * @param identificador identificador del usuario
     * @param usuario nombre de usuario
     * @param contrasena password para iniciar sesion
     * @param tipoUsuario Tipo de Usuario (Administrador o Psicologo)
     */
    public UsuarioDTO(String identificador, String usuario, String contrasena, String tipoUsuario) {
        this.identificador = identificador;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * Obtiene el nombre de usuario
     * @return nombre de usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Establece el nombre de usuario
     * @param usuario nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtiene el password para iniciar sesion
     * @return password para iniciar sesion
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Establece el password para iniciar sesion
     * @param contrasena password para iniciar sesion
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * Obtiene el identificador del usuario
     * @return identificador del usuario
     */
    public String getIdentificador() {
        return identificador;
    }
    /**
     * Establece el identificador del usuario
     * @param identificador identificador del usuario
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /**
     * Obtiene Tipo de Usuario (Administrador o Psicologo)
     * @return Tipo de Usuario (Administrador o Psicologo)
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    /**
     * Establece Tipo de Usuario (Administrador o Psicologo)
     * @param tipoUsuario Tipo de Usuario (Administrador o Psicologo)
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
