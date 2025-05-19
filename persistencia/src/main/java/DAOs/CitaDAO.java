/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
     *
     */
    private final MongoCollection<Cita> coleccionCitas;

    /**
     * Constructor vacio
     */
    private CitaDAO() {
        MongoDatabase bd = ConexionBD.getDatabase();
        coleccionCitas = bd.getCollection("Citas", Cita.class);
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
            List<LocalTime> horasTotales = psicologo.getHorarioDia(); 
            Date fechaConsulta = fecha.getTime();
            List<Cita> citas = coleccionCitas.find(and(eq("psicologo.correo", psicologo.getCorreo()), eq("fechaHora", fechaConsulta))).into(new ArrayList<>());
            Set<LocalTime> ocupadas = new HashSet<>();
            for (Cita cita : citas) {
                ocupadas.add(cita.getFechaHora().toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
            }
            List<LocalTime> disponibles = new ArrayList<>();
            for (LocalTime hora : horasTotales) {
                if (!ocupadas.contains(hora)) {
                    disponibles.add(hora);
                }
            }
            return disponibles;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener horas disponibles: " + e.getMessage(), e);
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
            Date fechaConsulta = fecha.getTime();
            List<Cita> citas = coleccionCitas.find(eq("fechaHora", fechaConsulta)).into(new ArrayList<>());
            Set<String> nombresCubiculos = new HashSet<>();
            for (Cita cita : citas) {
                nombresCubiculos.add(cita.getCubiculo());
            }
            List<Cubiculo> ocupados = new ArrayList<>();
            for (String nombre : nombresCubiculos) {
                ocupados.add(new Cubiculo(nombre, true));
            }
            return ocupados;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener cubículos ocupados: " + e.getMessage(), e);
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
            coleccionCitas.insertOne(cita);
            return cita;
        } catch (Exception e) {
            throw new PersistenciaException("Error al guardar la cita: " + e.getMessage(), e);
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
            List<Calendar> fechas = new ArrayList<>();

            for (Cita cita : coleccionCitas.find()) {
                fechas.add(cita.getFechaHora());
            }

            return fechas;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener fechas: " + e.getMessage(), e);
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
            Date fechaConsulta = fecha.getTime();
            List<Cita> citas = coleccionCitas.find(and(eq("cubiculo", cubiculo.getNombre()), eq("fechaHora", fechaConsulta))).into(new ArrayList<>());
            return citas.size() < 12;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar disponibilidad del cubículo: " + e.getMessage(), e);
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

            return coleccionCitas.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las citas: " + e.getMessage(), e);
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
            Date fechaConsulta = citaARegistrar.getFechaHora().getTime();
            Cita existente = coleccionCitas.find(and(eq("fechaHora", fechaConsulta), eq("cubiculo", citaARegistrar.getCubiculo()))).first();
            return existente == null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar cita duplicada: " + e.getMessage(), e);
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
