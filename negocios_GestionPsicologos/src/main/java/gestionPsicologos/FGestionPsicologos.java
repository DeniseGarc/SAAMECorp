/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPsicologos;

import com.objetos_negocio.Cita;
import com.objetos_negocio.Psicologo;
import dto.CitaRegistradaDTO;
import dto.PsicologoCitaDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestionPsicologos implements IGestionPsicologos {
    List<PsicologoCitaDTO> listaPsicologos = new ArrayList<>();
    PsicologoCitaDTO psicologo = new PsicologoCitaDTO();
    CitaRegistradaDTO cita = new CitaRegistradaDTO();
   
    public FGestionPsicologos(){
    
    //Listas para mock    
        List<LocalTime> listaHoras1 = new ArrayList<>();
        List<LocalTime> listaHoras2 = new ArrayList<>();
        List<LocalTime> listaHoras3 = new ArrayList<>();
    
     
        listaHoras1.add(LocalTime.of(8, 0));
        listaHoras1.add(LocalTime.of(10, 30));
        listaHoras1.add(LocalTime.of(15, 45));

        listaHoras2.add(LocalTime.of(9, 0));
        listaHoras2.add(LocalTime.of(11, 30));
        listaHoras2.add(LocalTime.of(16, 0));

        listaHoras3.add(LocalTime.of(7, 30));
        listaHoras3.add(LocalTime.of(12, 15));
        listaHoras3.add(LocalTime.of(14, 45));

        listaPsicologos.add(new PsicologoCitaDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras1));
        listaPsicologos.add(new PsicologoCitaDTO("María", "López", "Hernández", "marialopez@gmail.com", listaHoras2));
        listaPsicologos.add(new PsicologoCitaDTO("Carlos", "Gómez", "Santos", "carlosgomez@gmail.com", listaHoras3));
    }
    
    /**
     * regresa la lista de psicologos disponibles en la fecha dada
     * @param fecha dia de la cita
     * @return  lista de PsicologosDTO
     */
    @Override
    public List<PsicologoCitaDTO> obtenerPsicologosDisponibles(Date fecha) {
        List<PsicologoCitaDTO> disponibles = new ArrayList<>();
        List<PsicologoCitaDTO> psicologos = psicologo.obtenerPsicologos();
        for (PsicologoCitaDTO psic : psicologos) {
            List<LocalTime> horas = cita.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psic);
            if (!horas.isEmpty()) {
                disponibles.add(psic);
            }
        }
        return disponibles;
    }

    /**
     * 
     * @param identificadorPsicologo
     * @param fecha
     * @return 
     */
    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha) {
        List<PsicologoCitaDTO> psicologos = psicologo.obtenerPsicologos();
        for (PsicologoCitaDTO psic : psicologos) {
            if (psic.getCorreo().equals(identificadorPsicologo)) {
                List<LocalTime> horas = cita.obtenerHorasDisponiblesPorFechaYPsicologo(fecha, psic);
                if (!horas.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Este iría en el objeto negocio pq el subsistema no se comunica con la base no?
    // Este metodo le debe de llamar al de objeto negocio
    /**
     *
     * @param identificador del psicologo
     * @return psicologoDTO 
     */
    @Override
    public PsicologoCitaDTO obtenerPsicologoPorID(String identificador){
        return listaPsicologos.getLast();
    }

}
