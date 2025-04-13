package gestorCalendario;

import excepciones.GestorCalendarioException;
import gestorCalendario.control.ControlGestorCalendario;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase fachada del subsistema GestorCalendario, se encarga de todas las
 * operaciones relacionadas al calendario de citas.
 *
 * @author Alici
 */
public class FGestorCalendario implements IGestorCalendario {

    private final ControlGestorCalendario control = new ControlGestorCalendario();

    /**
     * Método que obtiene las fechas del consultorio donde todos los horarios
     * han sido agendados y ya no quedan cubiculos con horas disponibles.
     *
     * @return Lista de fechas a partir de la fecha actual donde se ha llenado
     * la agenda del consultorio
     */
    @Override
    public List<Calendar> diasAgendaLlena() {
        return control.obtenerDiasConAgendaLlena();
    }

    /**
     * Método que obtiene las fechas las cuales tienen citas registradas y sin
     * contar aquellas donde la agenda del consultorio se encuentra llena.
     *
     * @return Lista de fechas a partir de la fecha actual donde se han
     * registrado citas en el sistema.
     */
    @Override
    public List<Calendar> diasConReservas() {
        return control.obtenerDiasConCita();
    }

    /**
     * Método que manda a validar si el día seleccionado del calendario esta
     * disponible para el psicólogo cuando es usuario.
     *
     * @param identificadorPsicologo Identificador del psicólogo registrado.
     * @param fecha Fecha seleccionada del calendario
     * @return true si el psicólogo tiene horas disponibles para el día, false
     * en caso contrario.
     */
    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Calendar fecha) throws GestorCalendarioException {
        try {
            return control.diaDisponiblePsicologo(identificadorPsicologo, fecha);
        } catch (GestorCalendarioException ex) {
            Logger.getLogger(FGestorCalendario.class.getName()).log(Level.SEVERE, null, ex);
            throw new GestorCalendarioException(ex.getMessage(), ex);
        }
    }
}
