/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

//import dto.CitaDTO;
//import dto.CubiculoDTO;
//import dto.PsicologoDTO;
//import java.awt.List;
//import java.time.LocalTime;
import agendarCita.FAgendarCita;
import agendarCita.IAgendarCita;
import dto.CitaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alici
 */
public class ControladorAplicacion {

    private IAgendarCita sistemaAgendaCita = new FAgendarCita();
    
    public void pantallaInicioSesion (){
        IniciarSesion frmInicioSesion = new IniciarSesion();
        frmInicioSesion.setVisible(true);
        
    }
    
    public void pantallaPrincipal (JFrame frm){
        PantallaInicio frmInicio = new PantallaInicio();
        frmInicio.setVisible(true);
        frm.dispose();
    }
    public void pantallaCalendarioCitas(JFrame frm) {
        CalendarioCitas frmCalendarioCita = new CalendarioCitas();
        frmCalendarioCita.setVisible(true);
        frm.dispose();
    }

    public void pantallaAgregarCita(JFrame frm) {
        AgregarCita frmAgregarCita = new AgregarCita();
        frmAgregarCita.setVisible(true);
        frm.dispose();
    }

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
