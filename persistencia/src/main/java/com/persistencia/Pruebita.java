/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.persistencia;

import DAOs.CitaDAO;
import DAOs.PsicologoDAO;
import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author erika
 */
public class Pruebita {

    public static void main(String[] args) {
        try {
            // Instancia del DAO
            CitaDAO citaDAO = CitaDAO.getInstancia();
            PsicologoDAO psicologoDAO = PsicologoDAO.getInstanciaDAO();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            LocalDate fecha = LocalDate.of(2025, 5, 21);
           List<Cita> citasC = citaDAO.obtenerCitasPorDiaYCubiculo(new ObjectId("60f5a3f5e4b0c45a7c3e9002"), fecha);
           for (Cita cita : citasC) {
               System.out.println(sdf.format(cita.getFechaHora().getTime()));
           }
            System.out.println("---------------");
            List<Cita> citasP = citaDAO.obtenerCitasPorDiaYPsicologo(new ObjectId("60f5a3f5e4b0c45a7c3e8005"), fecha);
            for(Cita cita : citasP) {
                System.out.println(sdf.format(cita.getFechaHora().getTime()));
            }
            System.out.println("------------------");
            Psicologo psicologo = psicologoDAO.obtenerPsicologoPorIdentificador("60f5a3f5e4b0c45a7c3e8005");
            List<LocalTime> horas = citaDAO.obtenerHorasDisponibles(psicologo, new ObjectId("60f5a3f5e4b0c45a7c3e9002"), fecha);
            for(LocalTime hora : horas) {
                System.out.println(hora);
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
