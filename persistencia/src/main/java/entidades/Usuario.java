package entidades;

import org.bson.types.ObjectId;

/**
 * Clase que representa a un usuario del sistema.
 * Contiene la información básica de autenticación y tipo de usuario.
 * 
 * @author Alici
 */
public class Usuario {

    private ObjectId id;
    private String usuario;
    private String contrasena;
    private String tipoUsuario;
    private ObjectId idPsicologo;

    /**
     * Constructor vacío para crear un usuario sin inicializar.
     */
    public Usuario() {
    }

    /**
     * Constructor completo para crear un usuario con todos sus atributos.
     * 
     * @param id Identificador único del usuario (ObjectId de MongoDB).
     * @param usuario Nombre de usuario para login.
     * @param contrasena Contraseña del usuario.
     * @param tipoUsuario Tipo o rol del usuario (por ejemplo, admin, psicólogo, etc.).
     * @param idPsicologo Identificador del psicólogo asociado (si aplica).
     */
    public Usuario(ObjectId id, String usuario, String contrasena, String tipoUsuario, ObjectId idPsicologo) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.idPsicologo = idPsicologo;
    }

    /**
     * Obtiene el identificador único del usuario.
     * 
     * @return ObjectId del usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     * 
     * @param id ObjectId a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario para login.
     * 
     * @return Nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     * 
     * @param usuario Nombre de usuario a asignar.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña en texto plano (se recomienda encriptar en uso real).
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasena Contraseña a asignar.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el tipo o rol del usuario.
     * 
     * @return Tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo o rol del usuario.
     * 
     * @param tipoUsuario Tipo de usuario a asignar.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene el identificador del psicólogo asociado al usuario.
     * 
     * @return ObjectId del psicólogo, o null si no aplica.
     */
    public ObjectId getIdPsicologo() {
        return idPsicologo;
    }

    /**
     * Establece el identificador del psicólogo asociado al usuario.
     * 
     * @param idPsicologo ObjectId del psicólogo a asignar.
     */
    public void setIdPsicologo(ObjectId idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    /**
     * Obtiene el String hexadecimal del ObjectId del usuario.
     * 
     * @return Hexadecimal del ObjectId, o null si es nulo.
     */
    public String getObjectString() {
        return id != null ? id.toHexString() : null;
    }

    /**
     * Asigna el ObjectId del usuario a partir de un String hexadecimal.
     * 
     * @param idStr Cadena hexadecimal para convertir a ObjectId.
     */
    public void setObjectString(String idStr) {
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }

    /**
     * Obtiene el String hexadecimal del ObjectId del psicólogo asociado.
     * 
     * @return Hexadecimal del ObjectId del psicólogo, o null si es nulo.
     */
    public String getObjectPsicologoString() {
        return idPsicologo != null ? idPsicologo.toHexString() : null;
    }

    /**
     * Asigna el ObjectId del psicólogo a partir de un String hexadecimal.
     * 
     * @param idStr Cadena hexadecimal para convertir a ObjectId.
     */
    public void setObjectPsicologoString(String idStr) {
        this.idPsicologo = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }

}
