/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.Cita;
import entidades.Cubiculo;
import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.ICitaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erika
 */
public class CitaDAO implements ICitaDAO {

    /**
     * Instancia unica de la clase
     */
    private static CitaDAO instancia;

    /**
     * Constructor vacio
     */
    private CitaDAO() {
    }

    /**
     * Metodo para obtener la instancia unica de CitaDAO Si no existe una la
     * crea
     *
     * @return instancia unida de CitaDAO
     */
    public static CitaDAO getInstancia() {
        if (instancia == null) {
            instancia = new CitaDAO();
        }
        return instancia;
    }

    /**
     * Metodo que obtiene la disponibilidad de un psicólogo en un dia dado
     *
     * @param fecha fecha a consultar
     * @param psicologo psicologo a consultar
     * @return Lista de horas disponibles del psicologo
     */
    @Override
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(Calendar fecha, Psicologo psicologo) throws PersistenciaException {
        try {
            List<LocalTime> horasDisponibles = new LinkedList<>();
            horasDisponibles.add(LocalTime.of(9, 0));
            horasDisponibles.add(LocalTime.of(11, 0));
            horasDisponibles.add(LocalTime.of(14, 0));
            horasDisponibles.add(LocalTime.of(17, 30));
            return horasDisponibles;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las horas disponibles: " + e.getMessage());
        }
    }

    /**
     * Obtiene los cubiculos que tienen citas registradas en la fecha y hora
     * dada
     *
     * @param fecha fecha y hora a consultar
     * @return Lista de cubiculos ya ocupados
     */
    @Override
    public List<Cubiculo> obtenerCubiculosNoDisponibles(Calendar fecha) throws PersistenciaException {
        try {
            List<Cubiculo> listaCubiculos = new LinkedList<>();
            listaCubiculos.add(new Cubiculo("Cubiculo 1", true));
            listaCubiculos.add(new Cubiculo("Cubiculo 2", true));
            listaCubiculos.add(new Cubiculo("Cubiculo 3", true));
            listaCubiculos.add(new Cubiculo("Cubiculo 4", true));
            return listaCubiculos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los cubiculos llenos: " + e.getMessage());
        }
    }

    /**
     * Metodo para guardar una cita
     *
     * @param cita Cita a guardar
     * @return Cita registrada
     */
    @Override
    public Cita guardarCita(Cita cita) throws PersistenciaException {
        try {
            return cita;
        } catch (Exception e) {
            throw new PersistenciaException("Error al guardar la cita: " + e.getMessage());
        }
    }

    /**
     * Obtiene las fechas que ya tienen citas agendadas
     *
     * @return
     */
    @Override
    public List<Calendar> obtenerFechasConCitaAgendada() throws PersistenciaException {
        try {
            List<Calendar> fechasAgendadas = new LinkedList<>();
            fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 1)));
            fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 5)));
            fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 10)));
            fechasAgendadas.add(toCalendar(LocalDate.of(2025, 4, 15)));
            return fechasAgendadas;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las fechas con citas agendadas: " + e.getMessage());
        }
    }

    /**
     * Metodo para consultar si un cubiculo ya tiene citas registradas en un dia
     * dao
     *
     * @param cubiculo Cubiculo a consultar
     * @param fecha Fecha a consult
     * @return True hay horas disponibles
     */
    @Override
    public boolean cubiculoTieneHorasDisponiblesDia(Cubiculo cubiculo, Calendar fecha) throws PersistenciaException {
        try {
            // Simulación de disponibilidad
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener disponibilidad del cubiculo: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener todas la citas agendadas
     *
     * @return Lista de citas registradas
     */
    @Override
    public List<Cita> obtenerCitas() throws PersistenciaException {
        try {
            List<Cita> citas = new LinkedList<>();
            // Citas simuladas
            citas.add(new Cita(toCalendar(LocalDateTime.of(2025, 5, 17, 15, 37)), "Cubiculo 1", new Psicologo("Ana", "Perez", "Garcia", "ana.perez@gmail.com"), "Juan Perez", "1234567890", "juan.perez@gmail.com", null));
            citas.add(new Cita(toCalendar(LocalDateTime.of(2025, 5, 18, 10, 0)), "Cubiculo 2", new Psicologo("Luis", "Ramirez", "Lopez", "luis.ramirez@gmail.com"), "Maria Lopez", "0987654321", "maria.lopez@gmail.com", null));
            citas.add(new Cita(toCalendar(LocalDateTime.of(2025, 5, 19, 9, 30)), "Cubiculo 3", new Psicologo("Marta", "Sanchez", "Diaz", "marta.sanchez@gmail.com"), "Carlos Gomez", "1122334455", "carlos.gomez@gmail.com", null));
            citas.add(new Cita(toCalendar(LocalDateTime.of(2025, 5, 20, 14, 15)), "Cubiculo 4", new Psicologo("Carlos", "Vega", "Mendoza", "carlos.vega@gmail.com"), "Laura Ruiz", "6677889900", "laura.ruiz@gmail.com", null));
            citas.add(new Cita(toCalendar(LocalDateTime.of(2025, 5, 21, 16, 45)), "Cubiculo 2", new Psicologo("Sofia", "Martinez", "Lopez", "sofia.martinez@gmail.com"), "Pedro Sanchez", "5544332211", "pedro.sanchez@gmail.com", null));

            return citas;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las citas: " + e.getMessage());
        }
    }

    /**
     * Metodo para validar que no exista otra cita que tenga la misma fechaHora
     * y cubiculo igual
     *
     * @param citaARegistrar
     * @return true si no existe otra cita igual, false si existe otra
     */
    @Override
    public boolean validarExistenciaCitaRepetida(Cita citaARegistrar) throws PersistenciaException {
        try {
            //esto debería acceder a una dao, hacer una consulta y regresar un boolean 
            //si es que se encuentran resultados con la misma informacion
            List<Cita> citasRegistradas = obtenerCitas();
            for (Cita cita : citasRegistradas) {
                if (cita.getFechaHora().equals(citaARegistrar.getFechaHora())
                        && cita.getCubiculo().equals(citaARegistrar.getCubiculo())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar citas repetidas: " + e.getMessage());
        }
    }

    // Métodos auxiliares
    private Calendar toCalendar(LocalDateTime dateTime) {
        return GregorianCalendar.from(dateTime.atZone(ZoneId.systemDefault()));
    }

    private Calendar toCalendar(LocalDate date) {
        return GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
    }

}
