/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetos_negocio;

import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alexnieblas
 */
public class Cita {
    public List<LocalTime> obtenerHorasDisponiblesPorFechaYPsicologo(LocalDate fecha, PsicologoDTO psicologo){
        List<LocalTime> horasDisponibles = new LinkedList<>();
        horasDisponibles.add(LocalTime.of(9, 0));   
        horasDisponibles.add(LocalTime.of(11, 0));  
        horasDisponibles.add(LocalTime.of(14, 0));  
        horasDisponibles.add(LocalTime.of(17, 30)); 
        return horasDisponibles;
        
    }
    
    public List<CubiculoDTO> obtenerCubiculosNoDisponibles(LocalDateTime fecha){
        List<CubiculoDTO> listaCubiculos = new LinkedList<>();
        listaCubiculos.add(new CubiculoDTO("Cubiculo 1", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 2", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 3", true));
        listaCubiculos.add(new CubiculoDTO("Cubiculo 4", true));
        
        return listaCubiculos;
    }
    
    public CitaRegistradaDTO guardarCita(CitaNuevaDTO cita){
        CitaRegistradaDTO citaRegistrada = new CitaRegistradaDTO("1", cita.getFechaHora(), cita.getCubiculo(), cita.getPsicologo(), cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente());
        return citaRegistrada;
    }
    
    public List<LocalDate> obtenerFechasConCitaAgendada(){
        List<LocalDate> fechasAgendadas = new LinkedList<>();
        fechasAgendadas.add(LocalDate.of(2025, 4, 1));  
        fechasAgendadas.add(LocalDate.of(2025, 4, 5)); 
        fechasAgendadas.add(LocalDate.of(2025, 4, 10)); 
        fechasAgendadas.add(LocalDate.of(2025, 4, 15));
        return fechasAgendadas;
    }
    
    public boolean cubiculoTieneHorasDisponiblesDia(CubiculoDTO cubiculo, LocalDate dia){
        return true;
    }
    
    public List<CitaRegistradaDTO> obtenerCitas() {
        List<CitaRegistradaDTO> citas = new LinkedList<>();
        
        List<LocalTime> horario = new LinkedList<>();
        horario.add(LocalTime.of(8, 0));   // 08:00 AM
        horario.add(LocalTime.of(10, 30)); // 10:30 AM
        horario.add(LocalTime.of(13, 15)); // 01:15 PM
        horario.add(LocalTime.of(16, 45)); // 04:45 PM
        horario.add(LocalTime.of(19, 0));  // 07:00 PM
        
        citas.add(new CitaRegistradaDTO("1", LocalDateTime.of(2025, 4, 1, 9, 0), "Cubiculo 1", new PsicologoDTO("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com", horario), "Paciente 1", "123456789", "paciente1@email.com"));
        citas.add(new CitaRegistradaDTO("2", LocalDateTime.of(2025, 4, 5, 11, 0), "Cubiculo 2", new PsicologoDTO("Jorge", "Blanco", "Verdugo", "jorge@gmail.com", horario), "Paciente 2", "987654321", "paciente2@email.com"));
        citas.add(new CitaRegistradaDTO("3", LocalDateTime.of(2025, 4, 10, 14, 0), "Cubiculo 3", new PsicologoDTO("Jorge", "Blanco", "Verdugo", "jorge@gmail.com", horario), "Paciente 3", "456123789", "paciente3@email.com"));
        citas.add(new CitaRegistradaDTO("4", LocalDateTime.of(2025, 4, 15, 17, 30), "cubiculo 4", new PsicologoDTO("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com", horario), "Paciente 4", "789321654", "paciente4@email.com"));
        return citas;

    }
}
