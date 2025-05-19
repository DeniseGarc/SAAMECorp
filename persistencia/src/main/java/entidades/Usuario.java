package entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author Alici
 */
public class Usuario {

    private ObjectId id;
    private String usuario;
    private String contrasena;
    private String tipoUsuario;
    private ObjectId idPsicologo;

    public Usuario() {
    }

    public Usuario(ObjectId id, String usuario, String contrasena, String tipoUsuario, ObjectId idPsicologo) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.idPsicologo = idPsicologo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ObjectId getIdPsicologo() {
        return idPsicologo;
    }

    public void setIdPsicologo(ObjectId idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    public String getObjectString() {
        return id != null ? id.toHexString() : null;
    }

    public void setObjectString(String idStr) {
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }

    public String getObjectPsicologoString() {
        return idPsicologo != null ? idPsicologo.toHexString() : null;
    }

    public void setObjectPsicologoString(String idStr) {
        this.idPsicologo = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }

}
