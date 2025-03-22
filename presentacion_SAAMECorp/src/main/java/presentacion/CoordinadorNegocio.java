/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import agendarCita.FAgendarCita;
import agendarCita.IAgendarCita;
import dto.CitaDTO;
import dto.PsicologoDTO;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * clase que se va a encarga de acciones/metodos que conectan con negocio sigue
 * siendo el controlador de aplicación pero con el fin de no sobre cargar el
 * controlador con metodos que permiten mover de pantallas y funcionalidades
 */
public class CoordinadorNegocio {

    private IAgendarCita sistemaAgendaCita = new FAgendarCita();

//    public List<PsicologoDTO> mostrarPsicologos() {
//            return sistemaAgendaCita.mandarPsicologos();
//    }
    public List<LocalTime> mostrarHorarios(PsicologoDTO psicologo) {
        return psicologo.getHorarioDia();
    }

//    public List<CubiculoDTO> mostrarCubiculos(LocalDateTime fechaHoraCita) {
//        return sistemaAgendaCita.mandarCubiculos(fechaHoraCita);
//    }
    public void resumenCita(CitaDTO cita) {
        String mensaje = "¿Desea agendar la cita?\n"
                + cita.getCubiculo() + " " + cita.getFechaHora() + "\n"
                + "Psicólogo: " + cita.getPsicologo().getNombre() + "\n"
                + "Cliente: " + cita.getNombrePaciente() + ", " + cita.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + cita.getCorreoPaciente();

        int opcion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Cancelar", "Aceptar"},
                "Aceptar");

        if (opcion == 1) {
            agendarCita(cita);
        }
    }

    private void agendarCita(CitaDTO cita) {

    }

    public void pintarDiasCalendario() {
    }

}
