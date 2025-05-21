package agendarCita;

import agendarCita.control.ControlAgendarCita;
import dto.AdeudoCitaDTO;
import excepciones.AgendarCitaException;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.ResultadoAgendarCita;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fachada del subsistema AgendarCita, se encarga de unir todas las operaciones
 * necesarias para el proceso de agendar una cita en el sistema.
 *
 * @author Alici
 */
public class FAgendarCita implements IAgendarCita {

    private final ControlAgendarCita control = new ControlAgendarCita();

    public FAgendarCita() {

    }

    /**
     * Llama al método del control para obtener los psicologos y sus horarios.
     *
     * @param fecha Fecha seleccionada para la cita.
     * @return Regresa los datos de los psicólogos y sus horarios para la fecha
     * seleccionada.
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public List<PsicologoCitaDTO> mandarPsicologos(Calendar fecha) throws AgendarCitaException {
        if (fecha == null) {
            throw new AgendarCitaException("La fecha ingresada es invalida");
        }
        try {
            return control.obtenerPsicologos(fecha);
        } catch (Exception e) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Error al obtener los psicólogos", e);
        }
    }

    /**
     * Manda a llamar al metodo de control, aquí se define la regla de negocio
     * de cuanto es el total de adeudo que con el cual no se permite agendar más
     * citas. Si el psicólogo tiene un adeudo mayor o igual a 500.00 pesos, ya
     * no se le permite agendar más citas hasta cubrir su adeudo.
     *
     * @param psicologo El psicologo del cual que se quiere validar el adeudo.
     * @return true si el adeudo es menor a 500, false si es mayor o igual.
     */
    @Override
    public boolean validarAdeudoPsicologo(PsicologoCitaDTO psicologo) {
        if (psicologo == null) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.SEVERE, "Psicólogo nulo");
            return false;
        }
        try {
            return control.obtenerCantidadAdeudoPsicologo(psicologo) < 500.00;
        } catch (AgendarCitaException ex) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.SEVERE, "Error al obtener adeudo", ex);
            return false;
        }
    }

    /**
     * Llama al metodo del control para obtener los cubiculos disponibles del
     * dia y hora de la cita.
     *
     * @param fechaHora fecha y hora seleccionados para la cita
     * @return Los cubiculos disponibles del dia a la hora seleccionada.
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public List<CubiculoDTO> mandarCubiculos(Calendar fechaHora) throws AgendarCitaException {
        if (fechaHora == null) {
            throw new AgendarCitaException("La fecha ingresada no es valida");
        }
        try {
            return control.obtenerCubiculosDisponiblesHorario(fechaHora);
        } catch (Exception e) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.SEVERE, "Error al obtener adeudo", e);
            throw new AgendarCitaException("Error al recuperar los cubiculos disponibles", e);
        }
    }

    /**
     * Método que devuelve el resumen de la cita nueva.
     *
     * @param citaNueva Cita nueva a agendar en el sistema.
     * @param cubiculo nombre del cubiculo
     * @param psicologo nombre del psicologo
     * @return Texto con el resumen de la cita generado.
     * @throws AgendarCitaException Si la cita llega nula.
     */
    @Override
    public String resumenCita(CitaNuevaDTO citaNueva, String cubiculo, String psicologo) throws AgendarCitaException {
        if (citaNueva == null) {
            throw new AgendarCitaException("La cita no puede ser nula");
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaCita = formato.format(citaNueva.getFechaHora().getTime());

        return "¿Desea agendar la cita?\n"
                + cubiculo + "\n"
                + "Fecha: " + fechaCita + "\n"
                + "Psicólogo: " + psicologo + "\n"
                + "Cliente: " + citaNueva.getNombrePaciente() + ", Teléfono: " + citaNueva.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + citaNueva.getCorreoPaciente();
    }

    /**
     * Método que se encarga de agendar la cita en el sistema.
     *
     * Agendar una cita requiere: - Validar que no haya una cita "repetida" en
     * el sistema. - Registrar la cita en el sistema. - Registrar adeudo de la
     * cita en el sistema. - Mandar un correo de confirmación al psicólogo que
     * agendó la cita.
     *
     * @param cita
     * @return Resultado de la operación.
     * @throws AgendarCitaException Si ocurre un error al intentar agendar la
     * cita
     */
    @Override
    public ResultadoAgendarCita agendarCita(CitaNuevaDTO cita) throws AgendarCitaException {
        if (cita == null) {
            throw new AgendarCitaException("La cita no puede ser nula");
        }
        if (cita == null || cita.getPsicologo() == null || cita.getCubiculo() == null) {
            throw new AgendarCitaException("Datos incompletos de la cita");
        }
        AdeudoCitaDTO adeudo = new AdeudoCitaDTO(100.0, false, "-");
        cita.setAdeudo(adeudo);

        if (!control.validarFechaCitaRepetida(cita)) {
            throw new AgendarCitaException("No fue posible agendar la cita debido a que ya existe otra cita agendada el mismo día a la misma hora y en el mismo cubiculo");
        }
        CitaNuevaDTO citaAgendada = control.agendarCita(cita);
        boolean resultadoAgendarCita = citaAgendada != null;
        if (!resultadoAgendarCita) {
            throw new AgendarCitaException("No ha sido posible agendar la cita");
        }
        boolean resultadoMandarCorreo = control.mandarCorreo(cita);
        String mensajeAdvertencia = null;
        if (!resultadoMandarCorreo) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.WARNING, "No fue posible mandar el correo de confirmación");
            mensajeAdvertencia = "no ha sido posible mandar el correo de confirmación a " + cita.getPsicologo()/*.getCorreo()*/;
        }
        return new ResultadoAgendarCita(resultadoAgendarCita, resultadoMandarCorreo, mensajeAdvertencia);
    }

    /**
     * Llama a un metodo del gestor de psicologos el cual recupera al psicologo
     * y sus horarios con su identificador.
     *
     * @param identificador el usuario con el que inician sesion
     * @param fechaCita fecha seleccionada para la cita.
     * @return el psicologo que tiene ese identificador
     * @throws excepciones.AgendarCitaException
     */
    @Override
    public PsicologoCitaDTO obtenerPsicologo(String identificador, Calendar fechaCita) throws AgendarCitaException {
        try {
            PsicologoCitaDTO psicologo = control.obtenerPsicologo(identificador, fechaCita);
            if (psicologo.getHorarioDia().isEmpty()) {
                throw new AgendarCitaException("El psicólogo obtenido no tiene horario disponible por el momento");
            }
            return psicologo;
        } catch (Exception e) {
            Logger.getLogger(FAgendarCita.class.getName()).log(Level.SEVERE, null, e);
            throw new AgendarCitaException("Error al obtener el psicólogo", e);
        }

    }

}
