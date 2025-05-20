/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import dto.AdeudoCitaDTO;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import excepciones.NegocioException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class pruebapt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Instancia del BO
            CitaBO citaBO = CitaBO.getInstancia();

            // Crear fecha para la cita
            Calendar fechaCita = GregorianCalendar.from(
                    LocalDateTime.of(2025, 5, 20, 9, 0)
                            .atZone(ZoneId.systemDefault())
            );

            // Crear una CitaNuevaDTO
            CitaNuevaDTO nuevaCita = new CitaNuevaDTO();
            nuevaCita.setPsicologo("60f5a3f5e4b0c45a7c3e8005");
            nuevaCita.setCubiculo("60f5a3f5e4b0c45a7c3e9001");
            nuevaCita.setAdeudo(new AdeudoCitaDTO(150.00, true));
            nuevaCita.setFechaHora(fechaCita);

            // Validar si ya existe la cita
            boolean yaExiste = !citaBO.validarExistenciaCitaRepetida(nuevaCita);
            System.out.println("¿La cita ya existe?: " + yaExiste);

            if (!yaExiste) {
                // Guardar la cita
                CitaNuevaDTO citaGuardada = citaBO.guardarCita(nuevaCita);
                System.out.println("Cita guardada exitosamente:");
                System.out.println("Psicólogo ID: " + citaGuardada.getPsicologo());
                System.out.println("Cubículo ID: " + citaGuardada.getCubiculo());
                System.out.println("Fecha: " + citaGuardada.getFechaHora().getTime());
            }

            // Obtener todas las citas registradas (versión DTO simplificada)
            List<CitaRegistradaDTO> citas = citaBO.obtenerCitasCompletas();
            System.out.println("Total de citas registradas: " + citas.size());
            for(CitaRegistradaDTO cita : citas) {
                System.out.println(cita.getId() + " " + cita.getCubiculo().getNombre());
            }

        } catch (NegocioException e) {
            System.err.println("Error de negocio: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
