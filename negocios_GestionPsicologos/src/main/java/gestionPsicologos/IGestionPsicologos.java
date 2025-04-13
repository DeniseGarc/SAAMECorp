/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionPsicologos;

import dto.PsicologoCitaDTO;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IGestionPsicologos {
   

    public List<PsicologoCitaDTO> obtenerPsicologosDisponibles(Date fecha);

    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha);
    
    public PsicologoCitaDTO obtenerPsicologoPorID(String identificador);
}
