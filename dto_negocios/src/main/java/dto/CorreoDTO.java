/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Maryr
 */
public class CorreoDTO {

    private String correoDestino;
    private String mensaje;

    public CorreoDTO() {
    }

    public CorreoDTO(String correoDestino, String mensaje) {
        this.correoDestino = correoDestino;
        this.mensaje = mensaje;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
