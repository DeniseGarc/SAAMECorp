package gestorCalendario.control;

import dto.CubiculoDTO;
import dto.PsicologoDTO;
import enumeradores.TipoBO;
import excepciones.GestorCalendarioException;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IPsicologoBO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
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

    IPsicologoBO psicologoBO = (IPsicologoBO) ManejadorBO.crearBO(TipoBO.PSICOLOGO);
    ICitaBO citaBO = (ICitaBO) ManejadorBO.crearBO(TipoBO.CITA);
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(TipoBO.CUBICULO);

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
    public List<Calendar> obtenerDiasConCita() throws GestorCalendarioException {
        try {
            Calendar hoy = Calendar.getInstance();
            hoy = normalizarFecha(hoy);

            List<Calendar> diasConCita = citaBO.obtenerFechasConCitaAgendada();
            if (diasConCita == null) {
                throw new GestorCalendarioException("No se pudieron obtener las fechas con cita.");
            }

            // Filtrar fechas pasadas sin modificar la lista original
            List<Calendar> fechasValidas = new ArrayList<>();
            for (Calendar fechaCita : diasConCita) {
                if (!fechaCita.before(hoy)) {
                    fechasValidas.add(normalizarFecha(fechaCita));
                }
            }

            // Quitar los días que ya tienen agenda llena
            List<Calendar> diasAgendaLlena = obtenerDiasConAgendaLlena();
            fechasValidas.removeAll(diasAgendaLlena);

            return fechasValidas;

        } catch (Exception ex) {
            Logger.getLogger(ControlGestorCalendario.class.getName()).log(Level.SEVERE, null, ex);
            throw new GestorCalendarioException("Error al obtener los días con cita agendada", ex);
        }
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
    public List<Calendar> obtenerDiasConAgendaLlena() throws GestorCalendarioException {
        try {
            Calendar hoy = Calendar.getInstance();
            hoy = normalizarFecha(hoy);
            // se obtienen los cubiculos disponinles
            List<CubiculoDTO> cubiculosDisponibles = cubiculoBO.obtenerCubiculosEstadoDisponible();
            if (cubiculosDisponibles == null) {
                throw new GestorCalendarioException("No hay cubículos disponibles en el sistema.");
            }
            // se obtienen las fechas con cita
            List<Calendar> fechasConCita = citaBO.obtenerFechasConCitaAgendada();
            if (fechasConCita == null) {
                throw new GestorCalendarioException("No se pudieron obtener las fechas con cita.");
            }
            // set de fechas con agenda llena
            Set<Calendar> diasAgendaLlena = new HashSet<>();
            // se recorren las fechas con cita
            for (Calendar fechaCita : fechasConCita) {
                // si la fecha esta antes de la fecha actual, no se evalua
                if (fechaCita.before(hoy)) {
                    continue;
                }
                // se deja solamente la fecha
                Calendar fecha = normalizarFecha(fechaCita);
                boolean todosCubiculosLlenos = true;

                for (CubiculoDTO cubiculo : cubiculosDisponibles) {
                    if (cubiculo == null) {
                        continue;
                    }
                    // Si se encuentra un cubiculo el cual tiene  horas disponibles, entonces no todos los cubiculos se encuentran llenos
                    if (citaBO.cubiculoTieneHorasDisponiblesDia(cubiculo, fecha)) {
                        todosCubiculosLlenos = false;
                        break;
                    }
                }
                // Si todos los cubiculos del dia estan llenos se agrega el día al set 
                if (todosCubiculosLlenos) {
                    diasAgendaLlena.add(fecha);
                }
            }
            // regresa el set como array list
            return new ArrayList<>(diasAgendaLlena);
        } catch (Exception ex) {
            Logger.getLogger(ControlGestorCalendario.class.getName()).log(Level.SEVERE, null, ex);
            throw new GestorCalendarioException("Error al obtener los días con agenda llena", ex);
        }
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
        if (identificador == null || identificador.trim().isEmpty()) {
            throw new GestorCalendarioException("El identificador del psicólogo no puede ser nulo o vacío.");
        }
        if (fecha == null) {
            throw new GestorCalendarioException("La fecha no puede ser nula.");
        }

        try {
            PsicologoDTO psicologoEncontrado = psicologoBO.obtenerPsicologoPorIdentificador(identificador);
            if (psicologoEncontrado == null) {
                throw new GestorCalendarioException("No se encontró un psicólogo con el identificador: " + identificador);
            }

            List<LocalTime> horasDisponibles = citaBO.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psicologoEncontrado);
            return horasDisponibles != null && !horasDisponibles.isEmpty();
        } catch (GestorCalendarioException ex) {
            throw ex; // Reenvía si ya es la excepción personalizada
        } catch (Exception e) {
            Logger.getLogger(ControlGestorCalendario.class.getName()).log(Level.SEVERE, null, e);
            throw new GestorCalendarioException("Error al verificar la disponibilidad del psicólogo", e);
        }
    }

    /**
     * Método para dejar solamente la fecha del Calendar.
     *
     * @param fechaOriginal Calendar al que se le desea obtener solamente su
     * fecha.
     * @return Calendar con solamente la fecha asignada.
     */
    private Calendar normalizarFecha(Calendar fechaOriginal) {
        Calendar fecha = (Calendar) fechaOriginal.clone();
        fecha.set(Calendar.HOUR_OF_DAY, 0);
        fecha.set(Calendar.MINUTE, 0);
        fecha.set(Calendar.SECOND, 0);
        fecha.set(Calendar.MILLISECOND, 0);
        return fecha;
    }

}
