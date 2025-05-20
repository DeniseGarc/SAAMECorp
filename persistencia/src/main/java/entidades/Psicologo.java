package entidades;

import java.time.LocalTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa a un psicólogo en el sistema. Contiene información
 * básica como nombre, apellidos, correo y RFC.
 *
 * @author erika
 */
public class Psicologo {

    /**
     * Id del registro
     */
    private ObjectId id;

    /**
     * RFC del psicólogo.
     */
    private String rfc;

    /**
     * Nombre del psicólogo.
     */
    private String nombre;

    /**
     * Apellido paterno del psicólogo.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del psicólogo.
     */
    private String apellidoMaterno;

    /**
     * Correo electrónico del psicólogo.
     */
    private String correo;

   /**
     * Lista de horarios (horas) disponibles del psicólogo durante un día.
     */
    private List<LocalTime> horasAtencion;
  
    /**
     * Constructor por defecto.
     */
    public Psicologo() {
    }

    /**
     * Constructor que inicializa casi todos los campos del psicólogo.
     *
     * @param id Identificador único del psicólogo.
     * @param nombre Nombre del psicólogo.
     * @param apellidoPaterno Apellido paterno del psicólogo.
     * @param apellidoMaterno Apellido materno del psicólogo.
     * @param correo Correo electrónico del psicólogo.
     * @param rfc RFC del psicólogo.
     */
    public Psicologo(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
            String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.rfc = rfc;
    }

    /**
     * Constructor que inicializa todos los campos del psicólogo.
     *
     * @param id Identificador único del psicólogo.
     * @param nombre Nombre del psicólogo.
     * @param apellidoPaterno Apellido paterno del psicólogo.
     * @param apellidoMaterno Apellido materno del psicólogo.
     * @param correo Correo electrónico del psicólogo.
     * @param rfc RFC del psicólogo.
     * @param horarioDia
     */
    public Psicologo(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
            String rfc, List<LocalTime> horasAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.rfc = rfc;
        this.horasAtencion = horasAtencion;
    }

    /**
     * Obtiene el identificador único del psicólogo.
     *
     * @return Identificador único del psicólogo.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del psicólogo.
     *
     * @param id Nuevo identificador único del psicólogo.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del psicólogo.
     *
     * @return Nombre del psicólogo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del psicólogo.
     *
     * @param nombre Nuevo nombre del psicólogo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del psicólogo.
     *
     * @return Apellido paterno del psicólogo.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del psicólogo.
     *
     * @param apellidoPaterno Nuevo apellido paterno del psicólogo.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del psicólogo.
     *
     * @return Apellido materno del psicólogo.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del psicólogo.
     *
     * @param apellidoMaterno Nuevo apellido materno del psicólogo.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del psicólogo.
     *
     * @return Correo electrónico del psicólogo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del psicólogo.
     *
     * @param correo Nuevo correo electrónico del psicólogo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el RFC del psicólogo.
     *
     * @return RFC del psicólogo.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del psicólogo.
     *
     * @param rfc Nuevo RFC del psicólogo.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<LocalTime> getHorasAtencion() {
        return horasAtencion;
    }

    public void setHorasAtencion(List<LocalTime> horasAtencion) {
        this.horasAtencion = horasAtencion;
    }

    /**
     * Devuelve el nombre completo del psicólogo en formato: "Nombre
     * ApellidoPaterno ApellidoMaterno".
     *
     * @return Nombre completo del psicólogo como cadena de texto.
     */
    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    /**
     * Devuelve el identificador MongoDB como una cadena hexadecimal.
     *
     * @return Cadena hexadecimal del ObjectId o null si el id es null.
     */
    public String getObjectString() {
        return id != null ? id.toHexString() : null;
    }

    /**
     * Asigna el identificador MongoDB a partir de una cadena hexadecimal.
     *
     * @param idStr Cadena con el valor del ObjectId. Si es null o vacío, no se
     * asigna.
     */
    public void setObjectString(String idStr) {
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }
}
