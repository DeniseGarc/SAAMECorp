package dto;

import java.time.LocalTime;
import java.util.List;

/**
 * DTO para obtener los datos del psicólogo junto a su horario.
 *
 * @author Alici
 */
public class PsicologoCitaDTO {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private List<LocalTime> horarioDia;

    public PsicologoCitaDTO() {
    }

    public PsicologoCitaDTO(PsicologoDTO psicologo, List<LocalTime> horarioDia) {
        this.nombre = psicologo.getNombre();
        this.apellidoPaterno = psicologo.getApellidoPaterno();
        this.apellidoMaterno = psicologo.getApellidoMaterno();
        this.correo = psicologo.getCorreo();
        this.horarioDia = horarioDia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<LocalTime> getHorarioDia() {
        return horarioDia;
    }

    public void setHorarioDia(List<LocalTime> horarioDia) {
        this.horarioDia = horarioDia;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
