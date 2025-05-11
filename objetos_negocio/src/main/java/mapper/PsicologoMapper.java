/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import entidades.Psicologo;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que define los metodos mapper para pasar de entidad a DTO de Psicologo
 * @author erika
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
    
    public List<PsicologoDTO> toDTOList2(List<Psicologo> psicologos) {
        List<PsicologoDTO> psicologosDTO = new ArrayList<>();
        for (Psicologo psicologo : psicologos) {
            psicologosDTO.add(new PsicologoDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo()));
        }
        return psicologosDTO;
    }
    
    public PsicologoDTO toDTO2(Psicologo psicologo) {
        return new PsicologoDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo());
    }
}
