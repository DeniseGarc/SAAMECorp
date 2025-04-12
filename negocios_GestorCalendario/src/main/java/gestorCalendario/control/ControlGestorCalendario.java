package gestorCalendario.control;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Alici
 */
public class ControlGestorCalendario {

    /**
     * Método que regresa los días que se encuentran con citas agendadas.
     *
     * Cómo se determina que un día tiene cita agendada: 
     * - Obteniendo la fecha de las citas registradas dentro del sistema. 
     * - Se deben de obtener solo aquellos días a partir de la fecha actual, 
     * no días anteriores.
     * - Los días que tienen agendar llena no cuentan como días con cita, ya
     * que se manejan por separado.
     *
     * @return Lista de días los cuales tienen cita agendada.
     */
    public List<Calendar> obtenerDiasConCita() {
        /*Ejemplo de lo que deberia de realizar el método*/
    //           // Se obtiene la lista de días con citas y se crea una copia mutable
    //              List<Calendar> diasConReserva = new ArrayList<>(control.obtenerDiasConCita());
    //          // Se remueven los días con agenda llena
    //              diasConReserva.removeAll(diasAgendaLlena());
    //              return diasConReserva;
        return null;
    }

    /**
     * Método que obtiene los días donde el consultorio tiene no disponibles,
     * es decir, hay agenda llena para ese día.
     * 
     * Cómo se determina si un día tiene agenda llena:
     * - No quedan cubiculos disponibles a ninguna hora del día. 
     *
     * @return Lista de días los cuales el consultorio ya no tiene más cubiculos
     * ni horarios disponibles.
     */
    public List<Calendar> obtenerDiasConAgendaLlena() {
        return null;
    }

    /**
     * Método que valida si el psicologo con el identificador dado tiene horas
     * disponibles para el día seleccionado.
     *
     * @param identificador Identificador del psicologo a validar sus horarios.
     * @param fecha Fecha seleccionada del calendario.
     * @return true si el psicologo tiene horas disponibles en la fecha
     * seleccionada, false en caso contrario.
     */
    public boolean diaDisponiblePsicologo(String identificador, Calendar fecha) {
        return false;
    }
}
