/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 * entidad de Cita
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

    private ObjectId idPsicologo;
    private ObjectId idCubiculo;
    private Adeudo detallesAdeudo;

    /**
     * Constructor vacío. Crea un objeto {@code CitaNuevaDTO} sin valores
     * definidos.
     */
    public Cita() {
    }

    public Cita(ObjectId id, Calendar fechaHora, String nombrePaciente, String telefonoPaciente, String correoPaciente, ObjectId idPsicologo, ObjectId idCubiculo, Adeudo detallesAdeudo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.correoPaciente = correoPaciente;
        this.idPsicologo = idPsicologo;
        this.idCubiculo = idCubiculo;
        this.detallesAdeudo = detallesAdeudo;
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

    public ObjectId getIdPsicologo() {
        return idPsicologo;
    }

    public void setIdPsicologo(ObjectId idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    public ObjectId getIdCubiculo() {
        return idCubiculo;
    }

    public void setIdCubiculo(ObjectId idCubiculo) {
        this.idCubiculo = idCubiculo;
    }

    public Adeudo getDetallesAdeudo() {
        return detallesAdeudo;
    }

    public void setDetallesAdeudo(Adeudo detallesAdeudo) {
        this.detallesAdeudo = detallesAdeudo;
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

    public String getObjectCubiculoString() {
        return idCubiculo != null ? idCubiculo.toHexString() : null;
    }

    public void setObjectCubiculoString(String idStr) {
        this.idCubiculo = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }
}
