package agendarCita;

import agendarCita.control.ControlAgendarCita;
import excepciones.AgendarCitaException;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.util.List;
import java.util.Calendar;

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
     */
    @Override
    public List<PsicologoDTO> mandarPsicologos(Calendar fecha) {
        return control.obtenerPsicologos(fecha);
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
    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo) {
        return control.obtenerCantidadAdeudoPsicologo(psicologo) < 500.00;

    }

    /**
     * Llama al metodo del control para obtener los cubiculos disponibles del
     * dia y hora de la cita.
     *
     * @param fechaHora fecha y hora seleccionados para la cita
     * @return Los cubiculos disponibles del dia a la hora seleccionada.
     */
    @Override
    public List<CubiculoDTO> mandarCubiculos(Calendar fechaHora) {
        return control.obtenerCubiculosDisponiblesHorario(fechaHora);
    }

    /**
     * Método que devuelve el resumen de la cita nueva.
     *
     * @param citaNueva Cita nueva a agendar en el sistema.
     * @return Texto con el resumen de la cita generado.
     * @throws AgendarCitaException Si la cita llega nula.
     */
    @Override
    public String resumenCita(CitaNuevaDTO citaNueva) throws AgendarCitaException {
        if (citaNueva == null) {
            throw new AgendarCitaException("La cita no puede ser nula");
        }
        return "¿Desea agendar la cita?\n"
                + citaNueva.getCubiculo() + "\n"
                + "Fecha" + citaNueva.getFechaHora() + " " + citaNueva.getFechaHora() + "\n"
                + "Psicólogo: " + citaNueva.getPsicologo().getNombre() + " " + citaNueva.getPsicologo().getApellidoPaterno() + " " + citaNueva.getPsicologo().getApellidoMaterno() + "\n"
                + "Cliente: " + citaNueva.getNombrePaciente() + ", Teléfono: " + citaNueva.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + citaNueva.getCorreoPaciente();
    }

    /**
     * Método que se encarga de agendar la cita en el sistema.
     *
     * Agendar una cita requiere: 
     * - Validar que no haya una cita "repetida" en el sistema. 
     * - Registrar la cita en el sistema.
     * - Registrar adeudo de la cita en el sistema.
     * - Mandar un correo de confirmación al psicólogo que agendó la cita.
     *
     * @param cita
     * @return
     * @throws AgendarCitaException
     */
    @Override
    public boolean agendarCita(CitaNuevaDTO cita) throws AgendarCitaException {
//        if (cita == null) {
//            throw new AgendarCitaException("La cita no puede ser nula");
//        }
//        if (sistemaGestorCitas.validarFechaCitaRepetida(cita)) {
//            throw new AgendarCitaException("No fue posible agendar la cita debido a que ya existe otra cita agendada el mismo día a la misma hora y en el mismo cubiculo");
//        }
//        boolean citaRegistrada = sistemaGestorCitas.agendarCita(cita);
//        if (!citaRegistrada) {
//            throw new AgendarCitaException("No fue posible agendar la cita");
//        }
//        // Va a cambiar cuando se implemente correctamente el subsistema de correo electronico
//        if (!sistemaCorreoElectronico.mandarCorreo(cita.getPsicologo().getCorreo(), "Texto temporal")) {
//            throw new AgendarCitaException("No fue posible enviar el correo de confirmación");
//        }
//        return true;
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
        PsicologoDTO psicologo = control.obtenerPsicologo(identificador);
        if (psicologo.getHorarioDia().isEmpty()) {
            throw new AgendarCitaException("El psicologo obtenido no tiene horario disponible por el momento");
        }
        return psicologo;
    }

}
