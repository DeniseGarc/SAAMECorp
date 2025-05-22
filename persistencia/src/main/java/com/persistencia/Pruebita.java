/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.persistencia;

import DAOs.AdeudoDAO;
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
            AdeudoDAO adeudoDAO = AdeudoDAO.getInstancia();
            Psicologo p = new Psicologo();
            p.setId(new ObjectId("60f5a3f5e4b0c45a7c3e8005"));
            System.out.println(adeudoDAO.consultarAdeudoTotalPsicologo(p));
        } catch (PersistenciaException e) {
            System.err.println("Error de persistencia: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
