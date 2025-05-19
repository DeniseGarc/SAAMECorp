/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 * Mock para la entidad de Cita
 *
 * @author erika
 */
public class Cita {

    /**
     * Id del registro
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
    private Psicologo psicologo;

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

    /**
     * Información del adeudo asociado a la cita, si existe.
     */
    private Adeudo adeudo;

    /**
     * Constructor vacío. Crea un objeto {@code CitaNuevaDTO} sin valores
     * definidos.
     */
    public Cita() {
    }

    /**
     * Constructor que inicializa todos los campos de la cita.
     *
     * @param fechaHora Fecha y hora de la cita.
     * @param cubiculo Cubículo asignado.
     * @param psicologo Psicólogo que atenderá.
     * @param nombrePaciente Nombre del paciente.
     * @param telefonoPaciente Teléfono del paciente.
     * @param correoPaciente Correo del paciente.
     * @param adeudo Adeudo asociado a la cita.
     */
    public Cita(Calendar fechaHora, String cubiculo, Psicologo psicologo,
            String nombrePaciente, String telefonoPaciente, String correoPaciente,
            Adeudo adeudo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
        this.psicologo = psicologo;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.adeudo = adeudo;
    }

    public Cita(Calendar fechaHora, String cubiculo) {
        this.fechaHora = fechaHora;
        this.cubiculo = cubiculo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     *
     * @return Fecha y hora de la cita.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     *
     * @param fechaHora Nueva fecha y hora.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el cubículo asignado para la cita.
     *
     * @return Identificador del cubículo.
     */
    public String getCubiculo() {
        return cubiculo;
    }

    /**
     * Establece el cubículo asignado para la cita.
     *
     * @param cubiculo Nuevo cubículo.
     */
    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    /**
     * Obtiene el psicólogo asignado a la cita.
     *
     * @return Objeto {@code PsicologoCitaDTO} con los datos del psicólogo.
     */
    public Psicologo getPsicologo() {
        return psicologo;
    }

    /**
     * Establece el psicólogo asignado a la cita.
     *
     * @param psicologo Psicólogo a asignar.
     */
    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return Nombre del paciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param nombrePaciente Nombre del paciente.
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * Obtiene el teléfono del paciente.
     *
     * @return Teléfono del paciente.
     */
    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    /**
     * Establece el teléfono del paciente.
     *
     * @param telefonoPaciente Teléfono del paciente.
     */
    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    /**
     * Obtiene el correo del paciente.
     *
     * @return Correo del paciente.
     */
    public String getCorreoPaciente() {
        return correoPaciente;
    }

    /**
     * Establece el correo del paciente.
     *
     * @param correoPaciente Correo del paciente.
     */
    public void setCorreoPaciente(String correoPaciente) {
        this.correoPaciente = correoPaciente;
    }

    /**
     * Obtiene el adeudo asociado a la cita.
     *
     * @return Objeto {@code AdeudoCitaDTO} con los datos del adeudo.
     */
    public Adeudo getAdeudo() {
        return adeudo;
    }

    /**
     * Establece el adeudo asociado a la cita.
     *
     * @param adeudo Objeto con la información del adeudo.
     */
    public void setAdeudo(Adeudo adeudo) {
        this.adeudo = adeudo;
    }
}
