package gestorCalendario.control;

import dto.CitaNuevaDTO;
import dto.PsicologoDTO;
import excepciones.GestorCalendarioException;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IPsicologoBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorBO.ManejadorBO;

/**
 * Clase control que se encarga de la comunicación entre la fachada del
 * subsistema GestorCalendario y los objetos negocio.
 *
 * @author Alici
 */
public class ControlGestorCalendario {

    IPsicologoBO psicologoBO = ManejadorBO.crearPsicologoBO();
    ICitaBO citaBO = ManejadorBO.crearCitaBO();
    ICubiculoBO cubiculoBO = ManejadorBO.crearCubiculoBO();

    /**
     * Método que regresa los días que se encuentran con citas agendadas.
     *
     * Cómo se determina que un día tiene cita agendada: - Obteniendo la fecha
     * de las citas registradas dentro del sistema. - Se deben de obtener solo
     * aquellos días a partir de la fecha actual, no días anteriores. - Los días
     * que tienen agendar llena no cuentan como días con cita, ya que se manejan
     * por separado.
     *
     * @return Lista de días los cuales tienen cita agendada.
     */
    public List<Calendar> obtenerDiasConCita() {
        List<CitaNuevaDTO> citas = citaBO.obtenerCitas();
        Calendar hoy = Calendar.getInstance();

        hoy.set(Calendar.HOUR_OF_DAY, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);

        Set<Calendar> diasConCita = new HashSet<>();

        for (CitaNuevaDTO cita : citas) {
            Calendar fecha = (Calendar) cita.getFechaHora().clone();
            fecha.set(Calendar.HOUR_OF_DAY, 0);
            fecha.set(Calendar.MINUTE, 0);
            fecha.set(Calendar.SECOND, 0);
            fecha.set(Calendar.MILLISECOND, 0);

            if (!fecha.before(hoy)) {
                diasConCita.add(fecha);
            }
        }

        List<Calendar> diasAgendaLlena = obtenerDiasConAgendaLlena();
        diasConCita.removeAll(diasAgendaLlena);

        return new ArrayList<>(diasConCita);
    }

    /**
     * Método que obtiene los días donde el consultorio tiene no disponibles, es
     * decir, hay agenda llena para ese día.
     *
     * Cómo se determina si un día tiene agenda llena: - No quedan cubiculos
     * disponibles a ninguna hora del día.
     *
     * @return Lista de días los cuales el consultorio ya no tiene más cubiculos
     * ni horarios disponibles.
     */
    public List<Calendar> obtenerDiasConAgendaLlena() {
        List<CitaNuevaDTO> citas = citaBO.obtenerCitas();
        int totalCubiculos = cubiculoBO.obtenerCubiculosEstadoDisponible().size();

        Map<String, Set<String>> cubiculosUsadosPorDia = new HashMap<>();

        Map<String, Calendar> fechaReferencia = new HashMap<>();
        for (CitaNuevaDTO cita : citas) {
            Calendar fecha = (Calendar) cita.getFechaHora().clone();
            fecha.set(Calendar.HOUR_OF_DAY, 0);
            fecha.set(Calendar.MINUTE, 0);
            fecha.set(Calendar.SECOND, 0);
            fecha.set(Calendar.MILLISECOND, 0);
            String clave = fecha.get(Calendar.YEAR) + "-" + fecha.get(Calendar.MONTH) + "-" + fecha.get(Calendar.DAY_OF_MONTH);
            cubiculosUsadosPorDia
                    .computeIfAbsent(clave, k -> new HashSet<>())
                    .add(cita.getCubiculo());
            fechaReferencia.putIfAbsent(clave, fecha); // Para recuperar el Calendar
        }
        List<Calendar> diasAgendaLlena = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : cubiculosUsadosPorDia.entrySet()) {
            if (entry.getValue().size() >= totalCubiculos) {
                diasAgendaLlena.add(fechaReferencia.get(entry.getKey()));
            }
        }
        return diasAgendaLlena;
    }

    /**
     * Método que valida si el psicologo con el identificador dado tiene horas
     * disponibles para el día seleccionado.
     *
     * @param identificador Identificador del psicologo a validar sus horarios.
     * @param fecha Fecha seleccionada del calendario.
     * @return true si el psicologo tiene horas disponibles en la fecha
     * seleccionada, false en caso contrario.
     * @throws GestorCalendarioException Si ocurre un error al consultar los
     * datos.
     */
    public boolean diaDisponiblePsicologo(String identificador, Calendar fecha) throws GestorCalendarioException {
        try {
            PsicologoDTO psicologoEncontrado = psicologoBO.obtenerPsicologoPorIdentificador(identificador);
            return !citaBO.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psicologoEncontrado).isEmpty();
        } catch (Exception e) {
            Logger.getLogger(ControlGestorCalendario.class.getName()).log(Level.SEVERE, null, e);
            throw new GestorCalendarioException("Ha ocurrido un error al intentar consultar si el psicólogo tiene el día disponible", e);
        }
    }
}
