/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.ConexionBD;
import entidades.Psicologo;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author erika
 */
public class Pruebita {

    public static void main(String[] args) {
        MongoDatabase db = ConexionBD.getDatabase();
        MongoCollection<Psicologo> coleccion = db.getCollection("psicologos", Psicologo.class);

        Psicologo p1 = new Psicologo(
                "Sol",
                "Ruiz",
                "Pacheco",
                "god.games@frfr.com",
                Arrays.asList(LocalTime.of(9, 0), LocalTime.of(11, 0), LocalTime.of(14, 30))
        );

        Psicologo p2 = new Psicologo(
                "Lucia",
                "Vásquez",
                "Gastelum",
                "matenme.ya@plis.com",
                Arrays.asList(LocalTime.of(10, 0), LocalTime.of(13, 0), LocalTime.of(16, 0))
        );

        Psicologo p3 = new Psicologo(
                "Denise",
                "García",
                "Acosta",
                "dios.nos@abandono.com",
                Arrays.asList(LocalTime.of(8, 30), LocalTime.of(12, 0), LocalTime.of(15, 30))
        );

        coleccion.insertOne(p1);
        coleccion.insertOne(p2);
        coleccion.insertOne(p3);

        List<Psicologo> psicologos = coleccion.find().into(new java.util.ArrayList<>());

        for (Psicologo psicologo : psicologos) {
            System.out.println("ID: " + psicologo.getId());
            System.out.println("Nombre completo: " + psicologo);
            System.out.println("Correo: " + psicologo.getCorreo());
            System.out.println("Horarios disponibles: " + psicologo.getHorarioDia());
            System.out.println("Six hundred men, six hundred deaths under my comand");
        }
    }
}

