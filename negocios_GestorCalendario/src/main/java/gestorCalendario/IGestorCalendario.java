package gestorCalendario;

import excepciones.GestorCalendarioException;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que representa un gestor de calendario el cual se encarga de
 * acciones para administrar las fechas y eventos relacionados a fechas.
 *
 * @author Alici
 */
public interface IGestorCalendario {

    /**
     * Método que obtiene las fechas del consultorio donde todos los horarios
     * han sido agendados y ya no quedan cubiculos con horas disponibles.
     *
     * @return Lista de fechas a partir de la fecha actual donde se ha llenado
     * la agenda del consultorio
     * @throws excepciones.GestorCalendarioException Si ocurre un error al
     * obtener los datos.
     */
    public List<Calendar> diasAgendaLlena() throws GestorCalendarioException;

    /**
     * Método que obtiene las fechas las cuales tienen citas registradas y sin
     * contar aquellas donde la agenda del consultorio se encuentra llena.
     *
     * @return Lista de fechas a partir de la fecha actual donde se han
     * registrado citas en el sistema.
     * @throws excepciones.GestorCalendarioException Si ocurre un error al
     * obtener los datos.
     */
    public List<Calendar> diasConReservas() throws GestorCalendarioException;

    /**
     * Método que manda a validar si el día seleccionado del calendario esta
     * disponible para el psicólogo cuando es usuario.
     *
     * @param identificadorPsicologo Identificador del psicólogo registrado.
     * @param fecha Fecha seleccionada del calendario
     * @return true si el psicólogo tiene horas disponibles para el día, false
     * en caso contrario.
     * @throws excepciones.GestorCalendarioException Si ocurre un error al
     * obtener los datos.
     */
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Calendar fecha) throws GestorCalendarioException;
}
