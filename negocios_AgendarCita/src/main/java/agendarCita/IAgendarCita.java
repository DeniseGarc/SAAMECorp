package agendarCita;

import excepciones.AgendarCitaException;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.ResultadoAgendarCita;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que representa el proceso de agendar cita el cual se encarga de
 * acciones necesarias para agendar una cita en el sistema.
 *
 * @author Alici
 */
public interface IAgendarCita {

    /**
     * Llama al método del control para obtener los psicologos y sus horarios.
     *
     * @param fecha Fecha seleccionada para la cita.
     * @return Regresa los datos de los psicólogos y sus horarios para la fecha
     * seleccionada.
     */
    public List<PsicologoCitaDTO> mandarPsicologos(Calendar fecha) throws AgendarCitaException;

    /**
     * Manda a llamar al metodo de control, aquí se define la regla de negocio
     * de cuanto es el total de adeudo que con el cual no se permite agendar más
     * citas. Si el psicólogo tiene un adeudo mayor o igual a 500.00 pesos, ya
     * no se le permite agendar más citas hasta cubrir su adeudo.
     *
     * @param psicologo El psicologo del cual que se quiere validar el adeudo.
     * @return true si el adeudo es menor a 500, false si es mayor o igual.
     */
    public boolean validarAdeudoPsicologo(PsicologoCitaDTO psicologo) throws AgendarCitaException;

    /**
     * Llama al metodo del control para obtener los cubiculos disponibles del
     * dia y hora de la cita.
     *
     * @param fecha fecha y hora seleccionados para la cita
     * @return Los cubiculos disponibles del dia a la hora seleccionada.
     */
    public List<CubiculoDTO> mandarCubiculos(Calendar fecha) throws AgendarCitaException;

    /**
     * Método que devuelve el resumen de la cita nueva.
     *
     * @param cita Cita nueva a agendar en el sistema.
     * @param cubiculo nombre del cubiculo
     * @param psicologo nombre del psicologo
     * @return Texto con el resumen de la cita generado.
     * @throws AgendarCitaException Si la cita llega nula.
     */
    public String resumenCita(CitaNuevaDTO cita, String cubiculo, String psicologo) throws AgendarCitaException;

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
    public ResultadoAgendarCita agendarCita(CitaNuevaDTO cita) throws AgendarCitaException;

    /**
     * Llama a un metodo del gestor de psicologos el cual recupera al psicologo
     * y sus horarios con su identificador.
     *
     * @param identificador el usuario con el que inician sesion
     * @param fechaCita fecha seleccionada para la cita.
     * @return el psicologo que tiene ese identificador
     * @throws excepciones.AgendarCitaException
     */
    public PsicologoCitaDTO obtenerPsicologo(String identificador, Calendar fechaCita) throws AgendarCitaException;

}
