package dto;

import java.time.LocalTime;
import java.util.List;

/**
 * Clase DTO que representa la información de un psicólogo junto con su horario disponible en un día específico.
 * 
 * <p>Se utiliza para mostrar y registrar citas, incluyendo los datos personales del psicólogo
 * y los horarios en los que puede atender durante un día.</p>
 * 
 * <p>Este DTO se construye directamente o a partir de un objeto {@link PsicologoDTO} y una lista de horarios disponibles.</p>
 * 
 * @author Alici
 */
public class PsicologoCitaDTO {

    /** Nombre del psicólogo. */
    private String nombre;

    /** Apellido paterno del psicólogo. */
    private String apellidoPaterno;

    /** Apellido materno del psicólogo. */
    private String apellidoMaterno;

    /** Correo electrónico del psicólogo. */
    private String correo;

    /** Lista de horarios (horas) disponibles del psicólogo durante un día. */
    private List<LocalTime> horarioDia;

    /**
     * Constructor vacío. Crea un objeto {@code PsicologoCitaDTO} sin valores definidos.
     */
    public PsicologoCitaDTO() {
    }

    /**
     * Constructor que inicializa todos los campos del psicólogo y su horario disponible.
     * 
     * @param nombre Nombre del psicólogo.
     * @param apellidoPaterno Apellido paterno del psicólogo.
     * @param apellidoMaterno Apellido materno del psicólogo.
     * @param correo Correo electrónico del psicólogo.
     * @param horarioDia Lista de horarios disponibles en el día.
     */
    public PsicologoCitaDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, List<LocalTime> horarioDia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.horarioDia = horarioDia;
    }

    /**
     * Constructor que crea un {@code PsicologoCitaDTO} a partir de un {@code PsicologoDTO} y una lista de horarios.
     * 
     * @param psicologo Objeto que contiene los datos personales del psicólogo.
     * @param horarioDia Lista de horarios disponibles en el día.
     */
    public PsicologoCitaDTO(PsicologoDTO psicologo, List<LocalTime> horarioDia) {
        this.nombre = psicologo.getNombre();
        this.apellidoPaterno = psicologo.getApellidoPaterno();
        this.apellidoMaterno = psicologo.getApellidoMaterno();
        this.correo = psicologo.getCorreo();
        this.horarioDia = horarioDia;
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
     * Obtiene la lista de horarios disponibles en el día para el psicólogo.
     * 
     * @return Lista de horarios disponibles.
     */
    public List<LocalTime> getHorarioDia() {
        return horarioDia;
    }

    /**
     * Establece la lista de horarios disponibles en el día para el psicólogo.
     * 
     * @param horarioDia Nueva lista de horarios disponibles.
     */
    public void setHorarioDia(List<LocalTime> horarioDia) {
        this.horarioDia = horarioDia;
    }

    /**
     * Devuelve el nombre completo del psicólogo en formato: "Nombre ApellidoPaterno ApellidoMaterno".
     * 
     * @return Nombre completo del psicólogo como cadena de texto.
     */
    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
