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

    private final Calendar fechaInicio;
    private final Calendar fechaFin;

    public ControlDiasCalendario(Calendar fechaInicio, Calendar fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean isInvalid(Date date) {
        // Evitar que el día actual sea invalidado
        Calendar fechaParametro = Calendar.getInstance();
        fechaParametro.setTime(date);
        Calendar fechaHoy = Calendar.getInstance();

        // Verificar si la fecha es diferente al día de hoy y está fuera del rango
        return !(fechaParametro.after(fechaInicio) && fechaParametro.before(fechaFin)) && fechaParametro.get(Calendar.DAY_OF_YEAR) != fechaHoy.get(Calendar.DAY_OF_YEAR);
    }

    @Override
    public String getInvalidTooltip() {
        return "No puede agendar cita en esta fecha";
    }

    @Override
    public boolean isSpecial(Date date) {
        return false;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }

    @Override
    public java.awt.Color getSpecialForegroundColor() {
        return null;
    }

    @Override
    public java.awt.Color getSpecialBackroundColor() {
        return null;
    }

    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }
}
