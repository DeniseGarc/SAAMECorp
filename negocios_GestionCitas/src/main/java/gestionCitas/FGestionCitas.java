/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionCitas;

import com.objetos_negocio.Cita;
import com.objetos_negocio.Cubiculo;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestionCitas implements IGestionCitas {

    Cita c = new Cita();
    Cubiculo cubiculo = new Cubiculo();

    /**
     * Metodo para agenda una cita, verifica que la cita tenga toda la
     * informacion necesaria.
     *
     * @param cita la cita que se quiere agendar
     * @return true si la cita se agendo correctamente, false si hubo algun
     * error
     */
    @Override
    // tiene que devolver una cita registrada
    public boolean agendarCita(CitaNuevaDTO cita) {
        if (cita == null || cita.getFechaHora() == null || cita.getPsicologo() == null || cita.getCubiculo() == null) {
            return false;
        }
        boolean cubiculoDisponible = c.cubiculoTieneHorasDisponiblesDia(cita.getCubiculo(), Date.from(cita.getFechaHora().atZone(ZoneId.systemDefault()).toInstant()));
        if (!cubiculoDisponible) {
            return false;
        }
        c.guardarCita(cita);
        return true;
    }

    /**
     * Obtiene una lista de los dias que tinen citas agendadas
     *
     * @return la listas de dias con al menos una cita
     */
    @Override
    public List<Date> obtenerDiasConCita() {
        return c.obtenerFechasConCitaAgendada();
    }

    /**
     * Obtiene los dias donde no hay ni un cupo disponible
     *
     * @return la lista de los dias con agenda llena
     */
    @Override
    public List<Date> obtenerDiasConAgendaLlena() {
        // Por el momento se va a dejar mock luego, vemos bien el funcionamiento
        List<Date> diasConAgendaLlena = new ArrayList<>();
//        List<Date> fechasConCita = c.obtenerFechasConCitaAgendada();
//        for (Date fecha : fechasConCita) {
//            List<CubiculoDTO> cubiculosDisponibles = cubiculo.obtenerCubiculosEstadoDisponible();
//            boolean lleno = true;
//            for (CubiculoDTO cubiculo : cubiculosDisponibles) {
//                if (c.cubiculoTieneHorasDisponiblesDia(cubiculo.getNombre(), fecha)) {
//                    lleno = false;
//                    break;
//                }
//            }
//            if (lleno) {
//                diasConAgendaLlena.add(fecha);
//            }
//        }
        diasConAgendaLlena.add(new Date(125, 3, 10));

        diasConAgendaLlena.add(new Date(125, 3, 15));
        return diasConAgendaLlena;
    }

    @Override
    public boolean validarFechaCitaRepetida(CitaNuevaDTO citaNueva) {
        return false;
    }

}
