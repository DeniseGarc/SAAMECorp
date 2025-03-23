/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorCalendario;

import gestionCitas.FGestionCitas;
import gestionCitas.IGestionCitas;
import gestionPsicologos.FGestionPsicologos;
import gestionPsicologos.IGestionPsicologos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestorCalendario implements IGestorCalendario {

    private final IGestionPsicologos sistemaGestorPsicologos = new FGestionPsicologos();
    private final IGestionCitas sistemaGestorCitas = new FGestionCitas();

    // El sistema gestor de citas se encarga de obtener los dias con agenda llena
    @Override
    public List<Date> diasAgendaLlena() {
        return sistemaGestorCitas.obtenerDiasConAgendaLlena();
    }

    // El sistema gestor de citas se encarga de obtener los dias que tengan citas agendadas
    @Override
    public List<Date> diasConReservas() {
        // Se obtiene la lista de días con citas y se crea una copia mutable
        List<Date> diasConReserva = new ArrayList<>(sistemaGestorCitas.obtenerDiasConCita());
        // Se remueven los días con agenda llena
        diasConReserva.removeAll(diasAgendaLlena());
        return diasConReserva;
    }

    // El gestor de psicolos se encarga de la logica de validacion
    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha) {
        return sistemaGestorPsicologos.diaDisponiblePsicologo(identificadorPsicologo, fecha);
    }
}
