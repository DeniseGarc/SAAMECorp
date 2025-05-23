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
 * Clase que define los metodos mapper para pasar de entidad a DTO de Psicologo
 *
 * @author erika
 */
public class PsicologoMapper {

    public PsicologoCitaDTO toDTO(Psicologo psicologo) {
        return new PsicologoCitaDTO(psicologo.getObjectString(), psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc(), psicologo.getHorasAtencion());
    }

    public Psicologo toEntity(PsicologoCitaDTO psicologo) {
        return new Psicologo(null, psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc(), psicologo.getHorarioDia());
    }

    public Psicologo toEntity2(PsicologoDTO psicologo) {
        Psicologo p = new Psicologo(null, psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc());
        if (psicologo.getId() != null && !psicologo.getId().isEmpty()) {
            p.setObjectString(psicologo.getId());
        }
        return p;
    }

    public List<PsicologoCitaDTO> toDTOList(List<Psicologo> psicologos) {
        List<PsicologoCitaDTO> psicologosDTO = new ArrayList<>();
        for (Psicologo psicologo : psicologos) {
            psicologosDTO.add(new PsicologoCitaDTO(psicologo.getObjectString(), psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc(), psicologo.getHorasAtencion()));
        }
        return psicologosDTO;
    }

    public List<PsicologoDTO> toDTOList2(List<Psicologo> psicologos) {
        List<PsicologoDTO> psicologosDTO = new ArrayList<>();
        for (Psicologo psicologo : psicologos) {
            PsicologoDTO p = new PsicologoDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc());
            p.setId(psicologo.getObjectString());
            psicologosDTO.add(p);
        }
        return psicologosDTO;
    }

    public PsicologoDTO toDTO2(Psicologo psicologo) {
        return new PsicologoDTO(psicologo.getNombre(), psicologo.getApellidoPaterno(), psicologo.getApellidoMaterno(), psicologo.getCorreo(), psicologo.getRfc());
    }
}
