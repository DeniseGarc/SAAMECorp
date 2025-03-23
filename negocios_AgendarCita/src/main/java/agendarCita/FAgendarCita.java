/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendarCita;

import dto.CitaNuevaDTO;
import dto.PsicologoDTO;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FAgendarCita implements IAgendarCita {

    @Override
    public List<PsicologoDTO> mandarPsicologos() {
        List<PsicologoDTO> listaPsicologos = new ArrayList<>();
        List<LocalTime> listaHoras1 = new ArrayList<>();
        List<LocalTime> listaHoras2 = new ArrayList<>();
        List<LocalTime> listaHoras3 = new ArrayList<>();

        listaHoras1.add(LocalTime.of(8, 0));
        listaHoras1.add(LocalTime.of(10, 30));
        listaHoras1.add(LocalTime.of(15, 45));

        listaHoras2.add(LocalTime.of(9, 0));
        listaHoras2.add(LocalTime.of(11, 30));
        listaHoras2.add(LocalTime.of(16, 0));

        listaHoras3.add(LocalTime.of(7, 30));
        listaHoras3.add(LocalTime.of(12, 15));
        listaHoras3.add(LocalTime.of(14, 45));

        listaPsicologos.add(new PsicologoDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras1));
        listaPsicologos.add(new PsicologoDTO("María", "López", "Hernández", "marialopez@gmail.com", listaHoras2));
        listaPsicologos.add(new PsicologoDTO("Carlos", "Gómez", "Santos", "carlosgomez@gmail.com", listaHoras3));

        return listaPsicologos;
    }

    @Override
    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo) {
        return true;
    }

    @Override
    public List<String> mandarCubiculos(LocalDateTime fecha) {
        List<String> cubiculos = new ArrayList<>();
        cubiculos.add("Cubiculo 1");
        cubiculos.add("Cubiculo 2");
        cubiculos.add("Cubiculo 3");
        return cubiculos;
    }

    @Override
    public String resumenCita(CitaNuevaDTO cita) {
        if (cita == null) {
            //Esto pasara a ser una excepcion
            System.out.println("La cita es nula");
        }
        return "¿Desea agendar la cita?\n"
                + cita.getCubiculo() + "\n"
                + "Fecha" + cita.getFechaHora().toLocalDate() + " " + cita.getFechaHora().toLocalTime() + "\n"
                + "Psicólogo: " + cita.getPsicologo().getNombre() + "\n"
                + "Cliente: " + cita.getNombrePaciente() + ", Teléfono: " + cita.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + cita.getCorreoPaciente();
    }

    @Override
    public boolean agendarCita(CitaNuevaDTO cita) {
        return true;
    }

    @Override
    public PsicologoDTO obtenerPsicologo(String identificador) {
        List<LocalTime> listaHoras = new ArrayList<>();

        listaHoras.add(LocalTime.of(8, 0));
        listaHoras.add(LocalTime.of(10, 30));
        listaHoras.add(LocalTime.of(15, 45));

        return new PsicologoDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras);
    }

}
