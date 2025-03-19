/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendarCita;

import dto.CitaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FAgendarCita implements IAgendarCita {

    @Override
    public List<PsicologoDTO> mandarPsicologos() {
        List<PsicologoDTO> listaPsicologos = new ArrayList<>();
        List<LocalTime> listaHoras = new ArrayList<>();
        
        listaHoras.add(LocalTime.of(8, 0));  
        listaHoras.add(LocalTime.of(10, 30));
        listaHoras.add(LocalTime.of(15, 45));
        
        listaPsicologos.add(new PsicologoDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras));
        
        return listaPsicologos;
    }

    @Override
    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo) {
        return true;
    }

    @Override
    public List<CubiculoDTO> mandarCubiculos(LocalDateTime fecha) {
        List<CubiculoDTO> cubiculos = null;
        cubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        cubiculos.add(new CubiculoDTO("Cubiculo 3", true));
        return cubiculos;
    }

    @Override
    public String resumenCita(CitaDTO cita) {
        return ("Cita: 23/04/24"
                + "Psicologo: Jorge Ramirez"
                + "Cubiculo: 3");
    }

    @Override
    public boolean agendarCita(CitaDTO cita) {
        return true;
    }
    
}
