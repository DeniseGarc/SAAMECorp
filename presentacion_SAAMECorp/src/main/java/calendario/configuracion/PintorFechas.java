package calendario.configuracion;

import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase que implementa la interfaz IDateEvaluator, esta clase se encarga de
 * definir el comportamiento del calendario, indicando que fechas del calendario
 * se deben de pintar y de que color, asimimo si estas fechas son apareceran
 * como seleccionables o no.
 *
 * @author Alici
 */
public class PintorFechas implements IDateEvaluator {

    /**
     * Set de fechas a pintar
     */
    private final Set<Calendar> fechas;
    /**
     * Color de texto de las fechas dadas
     */
    private final Color colorTexto;
    /**
     * Color de fondo de las fechas dadas
     */
    private final Color colorFondo;
    /**
     * Marcar las fechas como inválidas
     */
    private final boolean marcarComoInvalido;
    /**
     * Texto que aparecerá en el tooltip
     */
    private final String textoInfo;

    /**
     * Constructor con todos los atributos de la clase
     *
     * @param fechas Fechas que deben ser pintadas
     * @param colorTexto Color de texto que deben tener las fechas
     * @param colorFondo Color de fondo que deben tener las fechas
     * @param marcarComoInvalido Si deben ser marcadas como inválidas, o no
     * @param textoInfo Texto que aparecerá en el tooltip al dejar el mouse
     * sobre la fecha
     */
    public PintorFechas(List<Calendar> fechas, Color colorTexto, Color colorFondo, boolean marcarComoInvalido, String textoInfo) {
        this.fechas = new HashSet<>(fechas);
        this.colorTexto = colorTexto;
        this.colorFondo = colorFondo;
        this.marcarComoInvalido = marcarComoInvalido;
        this.textoInfo = textoInfo;
    }

    /**
     * Evalua si la fecha es considerada especial, si resulta verdadero entonces
     * la pinta
     *
     * @param date fecha a comparar con las fechas dadas
     * @return true si coincide con alguna de las fechas dentro del set, false
     * en caso contrario
     */
    @Override
    public boolean isSpecial(Date date) {
        Calendar fechaEntrante = Calendar.getInstance();
        //se convierte la fecha del dia a Calendar
        fechaEntrante.setTime(date);
        // Se recorre la lista de fechas
        for (Calendar fecha : fechas) {
            // Se compara si el dia del parametro coincide con el dia de la lista
            if (fechaEntrante.get(Calendar.YEAR) == fecha.get(Calendar.YEAR)
                    && fechaEntrante.get(Calendar.MONTH) == fecha.get(Calendar.MONTH)
                    && fechaEntrante.get(Calendar.DAY_OF_MONTH) == fecha.get(Calendar.DAY_OF_MONTH)) {
                // verdadero si coinciden
                return true;
            }
        }
        //falso en caso contrario
        return false;
    }

    /**
     * Obtiene el color de texto que tiene la fecha especial.
     *
     * @return color de texto de la fecha especial
     */
    @Override
    public Color getSpecialForegroundColor() {
        return colorTexto;
    }

    /**
     * Obtiene el color de fondo que tiene la fecha especial.
     *
     * @return color de fondo de la fecha especial
     */
    @Override
    public Color getSpecialBackroundColor() {
        return colorFondo;
    }

    /**
     * Obtiene el texto que se muestra al pasar el ratón sobre la fecha
     * especial.
     *
     * @return texto que se muestra al pasar el ratón
     */
    @Override
    public String getSpecialTooltip() {
        return textoInfo;
    }

    /**
     * Determina si la fecha debe marcarse como inválida.
     *
     * @param date Fecha a comparar si debe marcarse como inválida
     * @return true si se indicó que las fechas deben marcarse como inválida y
     * es una fecha especial
     */
    @Override
    public boolean isInvalid(Date date) {
        return marcarComoInvalido && isSpecial(date);
    }

    /**
     * Obtiene el color de texto de la fecha inválida.
     *
     * @return Color del texto de la fecha inválida
     */
    @Override
    public Color getInvalidForegroundColor() {
        return colorTexto;
    }

    /**
     * Obtiene el color de fondo de la fecha inválida.
     *
     * @return Color de fondo de la fecha inválida
     */
    @Override
    public Color getInvalidBackroundColor() {
        return colorFondo;
    }

    /**
     * Obtiene el texto que se muestra al pasar el ratón sobre la fecha
     * inválida.
     *
     * @return texto que se muestra al pasar el ratón
     */
    @Override
    public String getInvalidTooltip() {
        return textoInfo;
    }
}
