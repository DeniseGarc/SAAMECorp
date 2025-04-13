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

    public List<Calendar> diasAgendaLlena() throws GestorCalendarioException;

    public List<Calendar> diasConReservas() throws GestorCalendarioException;

    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Calendar fecha) throws GestorCalendarioException;
}
