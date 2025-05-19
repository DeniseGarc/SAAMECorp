/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 *
 * @author Maryr
 */
public class CitaRegistradaDTO {

    /**
     * id del registro de la cita
     */
    private ObjectId id;

    /**
     * Fecha y hora en que se llevará a cabo la cita.
     */
    private Calendar fechaHora;

    /**
     * Identificador del cubículo donde se llevará a cabo la cita.
     */
    private String cubiculo;

    /**
     * Psicólogo asignado a la cita.
     */
    private PsicologoDTO psicologo;

    /**
     * Nombre completo del paciente.
     */
    private String nombrePaciente;

    /**
     * Teléfono de contacto del paciente.
     */
    private String telefonoPaciente;

    /**
     * Correo electrónico del paciente.
     */
    private String correoPaciente;

    public CitaRegistradaDTO() {
    }

    public CitaRegistradaDTO(ObjectId id, Calendar fechaHora, String cubiculo, PsicologoDTO psicologo, String nombrePaciente, String telefonoPaciente, String correoPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public PsicologoDTO getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(PsicologoDTO psicologo) {
        this.psicologo = psicologo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getCorreoPaciente() {
        return correoPaciente;
    }

    public void setCorreoPaciente(String correoPaciente) {
        this.correoPaciente = correoPaciente;
    }

}
