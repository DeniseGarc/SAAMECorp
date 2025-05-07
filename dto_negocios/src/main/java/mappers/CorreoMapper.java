/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dto.CorreoCitaDTO;
import dto.CorreoDTO;
import java.text.SimpleDateFormat;

/**
 *
 * @author Maryr
 */
public class CorreoMapper {

    public CorreoDTO toDTO(CorreoCitaDTO correo) {
        String mensaje = "<html>"
                + "<body style='font-family: Arial, sans-serif; background-color: #DDD4F0; padding: 20px;'>"
                + "<div style='max-width: 600px; margin: auto; background: #BCA3E2; padding: 15px; border-radius: 10px;'>"
                + "<h2 style='color: #562159; text-align: center;'>Detalles de la Cita</h2>"
                + "<p><b>Cubículo:</b> " + correo.getCubiculo() + "</p>"
                + "<p><b>Fecha:</b> " + correo.getFechaHora() + "</p>"
                + "<p><b>Psicólogo:</b> " + correo.getNombrePsicologo() + "</p>"
                + "<p><b>Cliente:</b> " + correo.getNombreCliente() + "</p>"
                + "<p><b>Teléfono:</b> " + correo.getTelefonoCliente() + "</p>"
                + "<p><b>Correo del paciente:</b> " + correo.getCorreoCliente() + "</p>"
                + "<hr style='border: 1px solid #562159;'>"
                + "<p style='color: #562159; text-align: center;'>Este es un correo automático. Por favor, no respondas.</p>"
                + "</div>"
                + "</body>"
                + "</html>";
        return new CorreoDTO(correo.getCorreoDestino(), mensaje);
    }
}
