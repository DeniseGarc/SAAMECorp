/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class PsicologoMapper {
    
    public PsicologoCitaDTO toDTO(Psicologo psicologo) {
        return new PsicologoCitaDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getHorarioDia());
    }
    
    public Psicologo toEntity(PsicologoCitaDTO psicologo) {
        return new Psicologo(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getHorarioDia());
    }
    public Psicologo toEntity2 (PsicologoDTO psicologo){
        return new Psicologo(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo());
    }
    
    public List<PsicologoCitaDTO> toDTOList(List<Psicologo> psicologos) {
        List<PsicologoCitaDTO> psicologosDTO = new ArrayList<>();
        for (Psicologo psicologo : psicologos) {
            psicologosDTO.add(new PsicologoCitaDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getHorarioDia()));
        }
        return psicologosDTO;
    }
}
