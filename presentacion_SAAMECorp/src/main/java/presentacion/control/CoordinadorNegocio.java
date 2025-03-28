/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.control;

import agendarCita.FAgendarCita;
import agendarCita.IAgendarCita;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import excepciones.AgendarCitaException;
import excepciones.CoordinadorException;
import gestorCalendario.FGestorCalendario;
import gestorCalendario.IGestorCalendario;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public List<PsicologoDTO> mostrarPsicologos(LocalDate fecha) {
        return sistemaAgendarCita.mandarPsicologos(fecha);
    }

    public List<LocalTime> mostrarHorarios(PsicologoDTO psicologo) {
        return psicologo.getHorarioDia();
    }

    public List<String> mostrarCubiculos(LocalDateTime fechaHoraCita) {
        List<String> nombresCubiculos = new ArrayList<>();
        for (CubiculoDTO cubiculo : sistemaAgendarCita.mandarCubiculos(fechaHoraCita)) {
            nombresCubiculos.add(cubiculo.getNombre());
        }
        return nombresCubiculos;
    }

    public String obtenerResumenCita(CitaNuevaDTO cita) {
        String error = Validadores.validarCita(cita);
        if (error != null) {
            return error;
        }
        return sistemaAgendarCita.resumenCita(cita);
    }

    public boolean agendarCita(CitaNuevaDTO cita) {
        return sistemaAgendarCita.agendarCita(cita);
    }

    public void bloquearDiasNoDisponibles(JCalendar calendario) {
        Calendar fechaActualCalendario = Calendar.getInstance();
        Date fechaActual = fechaActualCalendario.getTime();
        // fecha tope para agendar cita (2 meses)
        fechaActualCalendario.add(Calendar.MONTH, 2);
        Date fechaTope = fechaActualCalendario.getTime();
        ControlDiasCalendario desactivarDias = new ControlDiasCalendario(fechaActual, fechaTope);
        calendario.getDayChooser().addDateEvaluator(desactivarDias);
        calendario.getDayChooser().updateUI();
    }

    public void pintarDiasCalendario(JCalendar calendario) {
        List<Date> diasConReservas = sistemaGestorCalendario.diasConReservas();
        List<Date> diasAgendaLlena = sistemaGestorCalendario.diasAgendaLlena();
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

    public boolean validarDiaSeleccionado(Date diaSeleccionado) {
        if (GestorSesion.getTipoUsuario().equals(TipoUsuario.PSICOLOGO)) {
            if (!sistemaGestorCalendario.diaDisponiblePsicologo(GestorSesion.getIdentificadorUsuario(), diaSeleccionado)) {
                return false;
            }
        }
        return true;
    }

    // Clase interna para evaluar fechas y asignarles colores
    static class PintorFechas implements IDateEvaluator {

        private final Set<Date> fechas;
        private final Color colorTexto;
        private final Color colorFondo;
        private final boolean marcarComoInvalido;
        private final String textoInfo;

        public PintorFechas(List<Date> fechas, Color colorTexto, Color colorFondo, boolean marcarComoInvalido, String textoInfo) {
            this.fechas = new HashSet<>(fechas);
            this.colorTexto = colorTexto;
            this.colorFondo = colorFondo;
            this.marcarComoInvalido = marcarComoInvalido;
            this.textoInfo = textoInfo;
        }

        @Override
        public boolean isSpecial(Date date) {
            Calendar fechaEntrante = Calendar.getInstance();
            Calendar fechaLista = Calendar.getInstance();
            //se convierte la fecha del dia a Calendar
            fechaEntrante.setTime(date);
            // Se recorre la lista de fechas
            for (Date d : fechas) {
                // Se convierte el dia de la lista a Calendar
                fechaLista.setTime(d);
                // Se compara si el dia del parametro coincide con el dia de la lista
                if (fechaEntrante.get(Calendar.YEAR) == fechaLista.get(Calendar.YEAR)
                        && fechaEntrante.get(Calendar.MONTH) == fechaLista.get(Calendar.MONTH)
                        && fechaEntrante.get(Calendar.DAY_OF_MONTH) == fechaLista.get(Calendar.DAY_OF_MONTH)) {
                    // verdadero si coinciden
                    return true;
                }
            }
            //falso en caso contrario
            return false;
        }

        @Override
        public Color getSpecialForegroundColor() {
            return colorTexto;
        }

        @Override
        public Color getSpecialBackroundColor() {
            return colorFondo;
        }

        @Override
        public String getSpecialTooltip() {
            return textoInfo;
        }

        @Override
        public boolean isInvalid(Date date) {
            return marcarComoInvalido && isSpecial(date);
        }

        @Override
        public Color getInvalidForegroundColor() {
            return colorTexto;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return colorFondo;
        }

        @Override
        public String getInvalidTooltip() {
            return textoInfo;
        }
    }

    static class ControlDiasCalendario implements IDateEvaluator {

        private final Date fechaInicio;
        private final Date fechaFin;

        public ControlDiasCalendario(Date fechaInicio, Date fechaFin) {
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
        }

        @Override
        public boolean isInvalid(Date date) {
            // Evitar que el día actual sea invalidado
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(date);
            Calendar fechaHoy = Calendar.getInstance();

            // Verificar si la fecha es diferente al día de hoy y está fuera del rango
            return !(date.after(fechaInicio) && date.before(fechaFin)) && calendario.get(Calendar.DAY_OF_YEAR) != fechaHoy.get(Calendar.DAY_OF_YEAR);
        }

        @Override
        public String getInvalidTooltip() {
            return "No puede agendar cita en esta fecha";
        }

        @Override
        public boolean isSpecial(Date date) {
            return false;
        }

        @Override
        public String getSpecialTooltip() {
            return null;
        }

        @Override
        public java.awt.Color getSpecialForegroundColor() {
            return null;
        }

        @Override
        public java.awt.Color getSpecialBackroundColor() {
            return null;
        }

        @Override
        public Color getInvalidForegroundColor() {
            return null;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return null;
        }
    }

}
