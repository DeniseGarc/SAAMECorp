/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

/**
 *
 * @author erika
 */
import dto.AdeudoCitaDTO;
import dto.CitaDTO;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.PsicologoCitaDTO;
import entidades.Adeudo;
import entidades.Cita;
import entidades.Psicologo;
import java.util.ArrayList;
import java.util.List;

public class CitaMapper {

    public CitaNuevaDTO toDTO(Cita cita) {
        return new CitaNuevaDTO(cita.getFechaHora(), cita.getCubiculo(), new PsicologoCitaDTO(cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), null),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new AdeudoCitaDTO(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado()));
    }

    public Cita toEntity(CitaNuevaDTO cita) {
        return new Cita(cita.getFechaHora(), cita.getCubiculo(), new Psicologo(null, cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), null),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new Adeudo(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado()));
    }

    public List<CitaNuevaDTO> toDTOList(List<Cita> citas) {
        List<CitaNuevaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(new CitaNuevaDTO(cita.getFechaHora(), cita.getCubiculo(), new PsicologoCitaDTO(cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), null),
                    cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new AdeudoCitaDTO(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado())));
        }
        return citasDTO;
    }

    public List<CitaDTO> toDTOList2(List<Cita> citas) {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(new CitaDTO(cita.getFechaHora(), cita.getCubiculo()));
        }
        return citasDTO;
    }
    
    public List<CitaRegistradaDTO> toDTOList3 (List<Cita> citas) {
        List<CitaRegistradaDTO> citasDTO = new ArrayList<>();
        PsicologoMapper mapper = new PsicologoMapper();
        for (Cita cita : citas) {
//            citasDTO.add(new CitaRegistradaDTO(cita.getId(), cita.getFechaHora(), cita.getCubiculo(), mapper.toDTO2(cita.getPsicologo()), cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente()));
        }
        return citasDTO;
    }
}
