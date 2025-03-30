/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPsicologos;

import com.objetos_negocio.Cita;
import com.objetos_negocio.Psicologo;
import dto.PsicologoDTO;
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
    List<PsicologoDTO> listaPsicologos = new ArrayList<>();
    Psicologo psicologo = new Psicologo();
    Cita cita = new Cita();
   
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

        listaPsicologos.add(new PsicologoDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras1));
        listaPsicologos.add(new PsicologoDTO("María", "López", "Hernández", "marialopez@gmail.com", listaHoras2));
        listaPsicologos.add(new PsicologoDTO("Carlos", "Gómez", "Santos", "carlosgomez@gmail.com", listaHoras3));
    }
    
    /**
     * regresa la lista de psicologos disponibles en la fecha dada
     * @param fecha dia de la cita
     * @return  lista de PsicologosDTO
     */
    @Override
    public List<PsicologoDTO> obtenerPsicologosDisponibles(LocalDate fecha) {
        List<PsicologoDTO> disponibles = new ArrayList<>();
        List<PsicologoDTO> psicologos = psicologo.obtenerPsicologos();
        for (PsicologoDTO psic : psicologos) {
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
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, LocalDate fecha) {
        List<PsicologoDTO> psicologos = psicologo.obtenerPsicologos();
        for (PsicologoDTO psic : psicologos) {
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
    /**
     * Metodo para obtener un psicologo de la base de datos usando su identificasdor
     * @param identificador del psicologo
     * @return psicologoDTO 
     */
    public PsicologoDTO obtenerPsicologoPorID(String identificador){
        return listaPsicologos.getLast();
    }

}
