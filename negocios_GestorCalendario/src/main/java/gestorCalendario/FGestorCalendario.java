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
     * han sido agendados y ya no quedan cubículos con horas disponibles.
     *
     * @return Lista de fechas a partir de la fecha actual donde se ha llenado
     * la agenda del consultorio
     * @throws GestorCalendarioException si ocurre un error al obtener los datos
     */
    @Override
    public List<Calendar> diasAgendaLlena() throws GestorCalendarioException {
        try {
            return control.obtenerDiasConAgendaLlena();
        } catch (Exception e) {
            throw new GestorCalendarioException("Error al obtener los días con agenda llena", e);
        }
    }

    /**
     * Método que obtiene las fechas las cuales tienen citas registradas y sin
     * contar aquellas donde la agenda del consultorio se encuentra llena.
     *
     * @return Lista de fechas a partir de la fecha actual donde se han
     * registrado citas en el sistema.
     * @throws GestorCalendarioException si ocurre un error al obtener las
     * fechas
     */
    @Override
    public List<Calendar> diasConReservas() throws GestorCalendarioException {
        try {
            return control.obtenerDiasConCita();
        } catch (Exception e) {
            throw new GestorCalendarioException("Ha ocurrido un error al obtener los días con reserva", e);
        }
    }

    /**
     * Método que manda a validar si el día seleccionado del calendario esta
     * disponible para el psicólogo cuando es usuario.
     *
     * @param identificadorPsicologo Identificador del psicólogo registrado.
     * @param fecha Fecha seleccionada del calendario
     * @return true si el psicólogo tiene horas disponibles para el día, false
     * en caso contrario.
     * @throws GestorCalendarioException si ocurre un error o si los parámetros
     * son inválidos
     */
    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Calendar fecha) throws GestorCalendarioException {
        try {
            if (identificadorPsicologo == null || identificadorPsicologo.trim().isEmpty()) {
                throw new GestorCalendarioException("El identificador del psicólogo no puede ser nulo o vacío.");
            }

            if (fecha == null) {
                throw new GestorCalendarioException("La fecha no puede ser nula.");
            }

            Calendar hoy = Calendar.getInstance();
            hoy.set(Calendar.HOUR_OF_DAY, 0);
            hoy.set(Calendar.MINUTE, 0);
            hoy.set(Calendar.SECOND, 0);
            hoy.set(Calendar.MILLISECOND, 0);

            if (fecha.before(hoy)) {
                throw new GestorCalendarioException("No se puede consultar disponibilidad en fechas pasadas.");
            }

            return control.diaDisponiblePsicologo(identificadorPsicologo, fecha);
        } catch (GestorCalendarioException ex) {
            Logger.getLogger(FGestorCalendario.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(FGestorCalendario.class.getName()).log(Level.SEVERE, null, ex);
            throw new GestorCalendarioException("Error inesperado al consultar disponibilidad del psicólogo.", ex);
        }
    }
}
