/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendarCita;

import correoElectronico.FCorreoElectronico;
import correoElectronico.ICorreoElectronico;
import excepciones.AgendarCitaException;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import gestionAdeudos.FGestionAdeudos;
import gestionAdeudos.IGestionAdeudos;
import gestionCitas.FGestionCitas;
import gestionCitas.IGestionCitas;
import gestionCubiculos.FGestionCubiculos;
import gestionCubiculos.IGestionCubiculos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import gestionPsicologos.FGestionPsicologos;
import gestionPsicologos.IGestionPsicologos;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Alici
 */
public class FAgendarCita implements IAgendarCita {

    private final IGestionPsicologos sistemaGestorPsicologos = new FGestionPsicologos();
    private final IGestionAdeudos sistemaGestorAdeudos = new FGestionAdeudos();
    private final IGestionCubiculos sistemaGestionCubiculos = new FGestionCubiculos();
    private final IGestionCitas sistemaGestorCitas = new FGestionCitas();
    private final ICorreoElectronico sistemaCorreoElectronico = new FCorreoElectronico();

    public FAgendarCita() {

    }

    /**
     * Llama al metodo del gestor de psicologos que devuelve los psicologos
     * disponibles en ese dia
     *
     * @param fecha
     * @return Regresa los PsicologoDTO
     */
    @Override
    public List<PsicologoDTO> mandarPsicologos(LocalDate fecha) {
        return sistemaGestorPsicologos.obtenerPsicologosDisponibles(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * Manda a llamar al metodo de gestor de adeudos y aqui se pone la condición
     * de maximo de adeudo de 500
     *
     * @param psicologo el psicologo del que se quiere validar adeudo
     * @return true si el adeudo es menor a 500 y false si es mayor
     */
    @Override
    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo) {
        return sistemaGestorAdeudos.obtenerCantidadAdeudoPsicologo(psicologo) < 500.00;

    }

    /**
     * Llama al metodo del gestor de cubiculos para obtener los cubiculos
     * disponibles del dia de la cita
     *
     * @param fecha la fecha de la que se necesitan los cubiculos
     * @return los cubiculos disponibles del dia
     */
    @Override
    public List<CubiculoDTO> mandarCubiculos(LocalDateTime fecha) {
        return sistemaGestionCubiculos.obtenerCubiculosDisponiblesHorario(fecha);
    }

    /**
     * terminao
     *
     * @param cita
     * @return
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public String resumenCita(CitaNuevaDTO cita) throws AgendarCitaException {
        if (cita == null) {
            throw new AgendarCitaException("La cita no puede ser nula");
        }
        return "¿Desea agendar la cita?\n"
                + cita.getCubiculo() + "\n"
                + "Fecha" + cita.getFechaHora().toLocalDate() + " " + cita.getFechaHora().toLocalTime() + "\n"
                + "Psicólogo: " + cita.getPsicologo().getNombre() + " " + cita.getPsicologo().getApellidoPaterno() + " " + cita.getPsicologo().getApellidoMaterno() + "\n"
                + "Cliente: " + cita.getNombrePaciente() + ", Teléfono: " + cita.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + cita.getCorreoPaciente();
    }

    /**
     *
     * @param cita
     * @return
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public boolean agendarCita(CitaNuevaDTO cita) throws AgendarCitaException {
        if (cita == null) {
            throw new AgendarCitaException("La cita no puede ser nula");
        }
        if (sistemaGestorCitas.validarFechaCitaRepetida(cita)) {
            throw new AgendarCitaException("No fue posible agendar la cita debido a que ya existe otra cita agendada el mismo día a la misma hora y en el mismo cubiculo");
        }
        boolean citaRegistrada = sistemaGestorCitas.agendarCita(cita);
        // Ver si luego cambia a exception
        if (!citaRegistrada) {
            throw new AgendarCitaException("No fue posible agendar la cita");
        }
        // Va a cambiar cuando se implemente correctamente el subsistema de correo electronico
        if (!sistemaCorreoElectronico.mandarCorreo(cita.getPsicologo().getCorreo(), "Texto temporal")) {
            throw new AgendarCitaException("No fue posible enviar el correo de confirmación");
        }
        return true;
    }

    /**
     * Llama a un metodo del gestor de psicologos el cual recupera al psicologo
     * con su identificador
     *
     * @param identificador el usuario con el que inician sesion
     * @return el psicologo que tiene ese identificador
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public PsicologoDTO obtenerPsicologo(String identificador) throws AgendarCitaException {
        PsicologoDTO psicologo = sistemaGestorPsicologos.obtenerPsicologoPorID(identificador);
        if (psicologo.getHorarioDia().isEmpty()) {
            throw new AgendarCitaException("El psicologo obtenido no tiene horario disponible por el momento");
        }
        return psicologo;
    }

}
