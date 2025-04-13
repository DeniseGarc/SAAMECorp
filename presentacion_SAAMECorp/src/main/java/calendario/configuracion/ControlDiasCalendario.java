package calendario.configuracion;

import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase que implementa la interfaz IDateEvaluator, esta clase se encarga de
 * definir un periodo en el cual las fechas del calendario que reciba la
 * instancia de esta clase aparezcan como seleccionables. Se encarga de bloquear
 * todas los demás días que no entren dentro del periodo dado.
 *
 * @author Alici
 */
public class ControlDiasCalendario implements IDateEvaluator {

    /**
     * Fecha de inicio del periodo disponible para agendar cita
     */
    private final Calendar fechaInicio;
    /**
     * Fecha de fin del periodo disponible para agendar cita
     */
    private final Calendar fechaFin;

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param fechaInicio Fecha de inicio del periodo
     * @param fechaFin Fecha fin del periodo
     */
    public ControlDiasCalendario(Calendar fechaInicio, Calendar fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Determina si la fecha del calendario es inválida.
     *
     * @param date Fecha a comparar con el periodo de fechas
     * @return true si la fecha debe considerarse inválida, false en caso
     * contrario.
     */
    @Override
    public boolean isInvalid(Date date) {
        // Evitar que el día actual sea invalidado
        Calendar fechaParametro = Calendar.getInstance();
        fechaParametro.setTime(date);
        Calendar fechaHoy = Calendar.getInstance();

        // Verificar si la fecha es diferente al día de hoy y está fuera del rango
        return !(fechaParametro.after(fechaInicio) && fechaParametro.before(fechaFin)) && fechaParametro.get(Calendar.DAY_OF_YEAR) != fechaHoy.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * obtiene el texto que se muestra al pasar el ratón por la fecha.
     *
     * @return texto que se muestra al pasar el ratón
     */
    @Override
    public String getInvalidTooltip() {
        return "No puede agendar cita en esta fecha";
    }

    /**
     * Determina si la fecha debe considerarse como especial, en este caso no
     * hay fechas especiales por lo que siempre se devuelve false.
     *
     * @param date Fecha a comparar
     * @return false
     */
    @Override
    public boolean isSpecial(Date date) {
        return false;
    }

    /**
     * Obtiene el texto que aparece al pasar el ratón sobre la fecha especial.
     *
     * @return Null ya que no hay fechas especiales
     */
    @Override
    public String getSpecialTooltip() {
        return null;
    }

    /**
     * Obtiene el color del texto para las fechas especiales.
     *
     * @return null, no hay fechas especiales
     */
    @Override
    public java.awt.Color getSpecialForegroundColor() {
        return null;
    }

    /**
     * Obtiene el color de fondo para las fechas especiales.
     *
     * @return null, no hay fechas especiales
     */
    @Override
    public java.awt.Color getSpecialBackroundColor() {
        return null;
    }

    /**
     * Obtiene el color del texto para las fechas inválidas
     *
     * @return null, no tienen color personalizado
     */
    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    /**
     * Obtiene el color de fondo para las fechas inválidas.
     *
     * @return null, no tienen color personalizado
     */
    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }
}
