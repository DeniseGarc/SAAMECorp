/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.control;

import presentacion.utilerias.Validadores;
import agendarCita.FAgendarCita;
import agendarCita.IAgendarCita;
import calendario.configuracion.ControlDiasCalendario;
import calendario.configuracion.PintorFechas;
import com.toedter.calendar.JCalendar;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import excepciones.AgendarCitaException;
import excepciones.CoordinadorException;
import gestorCalendario.FGestorCalendario;
import gestorCalendario.IGestorCalendario;
import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.sesion.GestorSesion;
import presentacion.sesion.TipoUsuario;

/**
 *
 * clase que se va a encarga de acciones/metodos que conectan con negocio sigue
 * siendo el controlador de aplicación pero con el fin de no sobre cargar el
 * controlador con metodos que permiten mover de pantallas y funcionalidades
 */
public class CoordinadorNegocio {

    private final IAgendarCita sistemaAgendarCita = new FAgendarCita();
    private final IGestorCalendario sistemaGestorCalendario = new FGestorCalendario();

    public PsicologoDTO mostrarPsicologo(String identificadorPsicologo) throws CoordinadorException {
        try {
            return sistemaAgendarCita.obtenerPsicologo(identificadorPsicologo);
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("El psicologo no se encuentra con disponiblidad de horario");
        }
    }

    public boolean validarAdeudoPsicologoSeleccionado(PsicologoDTO psicologo) {
        return sistemaAgendarCita.validarAdeudoPsicologo(psicologo);
    }

    public List<PsicologoDTO> mostrarPsicologos(Calendar fecha) {
        return sistemaAgendarCita.mandarPsicologos(fecha);
    }

    public List<LocalTime> mostrarHorarios(PsicologoDTO psicologo) {
        return psicologo.getHorarioDia();
    }

    public List<String> mostrarCubiculos(Calendar fechaHoraCita) {
        List<String> nombresCubiculos = new ArrayList<>();
        for (CubiculoDTO cubiculo : sistemaAgendarCita.mandarCubiculos(fechaHoraCita)) {
            nombresCubiculos.add(cubiculo.getNombre());
        }
        return nombresCubiculos;
    }

    public String obtenerResumenCita(CitaNuevaDTO cita) throws CoordinadorException {
        String error = Validadores.validarCita(cita);
        if (error != null) {
            return error;
        }
        try {
            return sistemaAgendarCita.resumenCita(cita);
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al generar resumen de la cita.");
        }
    }

    public boolean agendarCita(CitaNuevaDTO cita) throws CoordinadorException {
        try {
            return sistemaAgendarCita.agendarCita(cita);
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
    }

    /**
     * Método que define la cantidad de días que estan disponibles para su
     * selección en el calendario dado. Aqui se define que el limite para
     * agendar cita es de dos meses en adelato.
     *
     * @param calendario Calendario de la interfaz gráfica donde se va a aplicar
     * el bloqueo de dias
     */
    public void bloquearDiasNoDisponibles(JCalendar calendario) {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaTope = Calendar.getInstance();
        fechaTope.add(Calendar.MONTH, 2);
        ControlDiasCalendario desactivarDias = new ControlDiasCalendario(fechaActual, fechaTope);
        calendario.getDayChooser().addDateEvaluator(desactivarDias);
        calendario.getDayChooser().updateUI();
    }

    public void pintarDiasCalendario(JCalendar calendario) {
        List<Calendar> diasConReservas = sistemaGestorCalendario.diasConReservas();
        List<Calendar> diasAgendaLlena = sistemaGestorCalendario.diasAgendaLlena();
        PintorFechas diasConCita = new PintorFechas(diasConReservas, Color.white, new Color(233, 69, 191), false, "Hay citas agendadas este día");
        PintorFechas diasSinDisponibilidad = new PintorFechas(diasAgendaLlena, Color.white, new Color(138, 34, 111), true, "La agenda del consultorio esta llena para este día");

        calendario.getDayChooser().addDateEvaluator(diasConCita);
        calendario.getDayChooser().addDateEvaluator(diasSinDisponibilidad);
        calendario.getDayChooser().updateUI();
        // Cada que se seleccione una nueva fecha se vuelve a pintar el calendario
        calendario.getDayChooser().addPropertyChangeListener("day", evt -> {
            calendario.getDayChooser().updateUI();
        });
    }

    public boolean validarDiaSeleccionado(Calendar diaSeleccionado) {
        if (GestorSesion.getTipoUsuario().equals(TipoUsuario.PSICOLOGO)) {
            if (!sistemaGestorCalendario.diaDisponiblePsicologo(GestorSesion.getIdentificadorUsuario(), diaSeleccionado)) {
                return false;
            }
        }
        return true;
    }
}
