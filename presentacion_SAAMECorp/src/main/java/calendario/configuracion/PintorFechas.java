/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    private final Set<Calendar> fechas;
    private final Color colorTexto;
    private final Color colorFondo;
    private final boolean marcarComoInvalido;
    private final String textoInfo;
    
    public PintorFechas(List<Calendar> fechas, Color colorTexto, Color colorFondo, boolean marcarComoInvalido, String textoInfo) {
        this.fechas = new HashSet<>(fechas);
        this.colorTexto = colorTexto;
        this.colorFondo = colorFondo;
        this.marcarComoInvalido = marcarComoInvalido;
        this.textoInfo = textoInfo;
    }

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

    @Override
    public Color getSpecialForegroundColor() {
        return colorTexto;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return colorFondo;
    }

    @Override
    public String getSpecialTooltip() {
        return textoInfo;
    }

    @Override
    public boolean isInvalid(Date date) {
        return marcarComoInvalido && isSpecial(date);
    }

    @Override
    public Color getInvalidForegroundColor() {
        return colorTexto;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return colorFondo;
    }

    @Override
    public String getInvalidTooltip() {
        return textoInfo;
    }
}
