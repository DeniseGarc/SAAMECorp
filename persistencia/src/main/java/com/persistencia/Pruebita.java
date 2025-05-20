/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.persistencia;

import DAOs.CitaDAO;
import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author erika
 */
public class Pruebita {

    public static void main(String[] args) {
        try {
            // Instancia del DAO
            CitaDAO citaDAO = CitaDAO.getInstancia();

            // Mostrar todas las citas
            List<Cita> citas = citaDAO.obtenerCitas();
            System.out.println("Total de citas registradas: " + citas.size());
            for (Cita cita : citas ) {
                System.out.println(cita.getFechaHora() + " " + cita.getDetallesAdeudo().getCantidad());
            }

        } catch (PersistenciaException e) {
            System.err.println("Error de persistencia: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
