package dto;

/**
 * Clase DTO que encapsula los datos personales básicos de un psicólogo.
 *
 * <p>
 * Este DTO se utiliza principalmente para representar al psicólogo sin
 * información adicional, como horarios o citas, permitiendo transportar los
 * datos de manera simple entre capas del sistema.
 * </p>
 *
 * <p>
 * Incluye nombre, apellidos y correo electrónico del psicólogo.
 * </p>
 *
 * @author Alici
 */
public class PsicologoDTO {

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
     * RFC del psicólogo.
     */
    private String rfc;

    /**
     * Constructor por defecto.
     */
    public PsicologoDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa todos los atributos del psicólogo.
     *
     * @param nombre Nombre del psicólogo.
     * @param apellidoPaterno Apellido paterno del psicólogo.
     * @param apellidoMaterno Apellido materno del psicólogo.
     * @param correo Correo electrónico del psicólogo.
     * @param rfc RFC del psicólogo.
     */
    public PsicologoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String rfc) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.rfc = rfc;
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

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
