package dto;

import java.util.Calendar;

/**
 * Clase que representa una cita únicamente por su fecha, hora y cubículo.
 *
 * <p>
 * Este DTO (Data Transfer Object) encapsula la información necesaria para
 * identificar una cita con base en la fecha, hora y el cubículo en el que
 * se llevará a cabo.</p>
 *
 * <p>
 * Es utilizado comúnmente en procesos de validación o para verificar
 * disponibilidad de horarios.</p>
 * 
 * <p>Puede formar parte de operaciones internas donde no se requiere toda
 * la información del paciente o del psicólogo.</p>
 * 
 * @author Alici
 */
public class CitaDTO {

    /** Fecha y hora de la cita. */
    private Calendar fechaHora;

    /** Nombre del cubículo donde se realizará la cita. */
    private String cubiculo;

    /**
     * Constructor que inicializa la cita con fecha, hora y cubículo.
     *
     * @param fechaHora Fecha y hora de la cita.
     * @param cubiculo Nombre del cubículo asignado.
     */
    public CitaDTO(Calendar fechaHora, String cubiculo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     *
     * @return Fecha y hora en formato {@link Calendar}.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     *
     * @param fechaHora Fecha y hora a establecer.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el nombre del cubículo donde se realizará la cita.
     *
     * @return Nombre del cubículo.
     */
    public String getCubiculo() {
        return cubiculo;
    }

    /**
     * Establece el nombre del cubículo donde se realizará la cita.
     *
     * @param cubiculo Nombre del cubículo a establecer.
     */
    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }
}
