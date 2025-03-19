/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package agendarCita;

import dto.CitaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IAgendarCita {
    List<PsicologoDTO> mandarPsicologos();
    boolean validarAdeudoPsicologo(PsicologoDTO psicologo);
    List<CubiculoDTO> mandarCubiculos(LocalDateTime fecha);
    String resumenCita(CitaDTO cita);
    boolean agendarCita(CitaDTO cita);

} 
