/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package agendarCita;

import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IAgendarCita {

    public List<PsicologoDTO> mandarPsicologos(LocalDate fecha);

    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo);

    public List<CubiculoDTO> mandarCubiculos(LocalDateTime fecha);

    public String resumenCita(CitaNuevaDTO cita);

    public boolean agendarCita(CitaNuevaDTO cita);
    
    public PsicologoDTO obtenerPsicologo(String identificador);

}
