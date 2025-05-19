/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.persistencia;

import DAOs.CitaDAO;
import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author erika
 */
public class Pruebita {

    public static void main(String[] args) {
        //Jalaron psicologo y cubiculo al cien gang
        CitaDAO dao = CitaDAO.getInstancia();

        try {
            // Crear datos de prueba
            Calendar fecha = Calendar.getInstance();
            fecha.set(Calendar.HOUR_OF_DAY, 10);
            fecha.set(Calendar.MINUTE, 0);
            fecha.set(Calendar.SECOND, 0);

            Psicologo psicologo = new Psicologo();
            psicologo.setCorreo("prueba@correo.com");
            psicologo.setHorarioDia(Arrays.asList(
                    LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0)
            ));

            Cubiculo cubiculo = new Cubiculo("Cubiculo A", true);

            Cita cita = new Cita();
            cita.setFechaHora((Calendar) fecha.clone());
            cita.setPsicologo(psicologo);
            cita.setCubiculo(cubiculo.getNombre());

            // Guardar cita
            dao.guardarCita(cita);
            System.out.println("Cita guardada.");

            // Obtener todas las citas
            List<Cita> citas = dao.obtenerCitas();
            System.out.println("Citas registradas:");
            for (Cita c : citas) {
                System.out.println(c.getFechaHora() + " " + c.getPsicologo().getId());
            }

            // Validar existencia de cita repetida
            boolean esValida = dao.validarExistenciaCitaRepetida(cita);
            System.out.println("ya basta?: " + !esValida);

            // Obtener horas disponibles del psicólogo
            List<LocalTime> horasDisponibles = dao.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psicologo);
            System.out.println("Horas disponibles para el psicólogo:");
            horasDisponibles.forEach(System.out::println);

            // Obtener cubículos ocupados
            List<Cubiculo> ocupados = dao.obtenerCubiculosNoDisponibles(fecha);
            System.out.println("Cubículos no disponibles:");
            ocupados.forEach(c -> System.out.println(c.getNombre()));

            // Fechas con citas agendadas
            List<Calendar> fechasConCitas = dao.obtenerFechasConCitaAgendada();
            System.out.println("Fechas con citas:");
            for (Calendar f : fechasConCitas) {
                System.out.println(f);
            }

            // ¿Tiene disponibilidad el cubículo?
            boolean disponible = dao.cubiculoTieneHorasDisponiblesDia(cubiculo, fecha);
            System.out.println("¿We fire?: " + disponible);

        } catch (PersistenciaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
