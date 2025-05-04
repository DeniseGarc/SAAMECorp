/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dto.AdeudoCitaDTO;
import dto.CitaNuevaDTO;
import dto.PsicologoCitaDTO;
import entidades.Adeudo;
import entidades.Cita;
import entidades.Psicologo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class CItaMapper {

    public CitaNuevaDTO toDTO(Cita cita) {
        return new CitaNuevaDTO(cita.getFechaHora(), cita.getCubiculo(), new PsicologoCitaDTO(cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), cita.getPsicologo().getHorarioDia()),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new AdeudoCitaDTO(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado()));
    }

    public Cita toEntity(CitaNuevaDTO cita) {
        return new Cita(cita.getFechaHora(), cita.getCubiculo(), new Psicologo(cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), cita.getPsicologo().getHorarioDia()),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new Adeudo(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado()));
    }

    public List<CitaNuevaDTO> toDTOList(List<Cita> citas) {
        List<CitaNuevaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(new CitaNuevaDTO(cita.getFechaHora(), cita.getCubiculo(), new PsicologoCitaDTO(cita.getPsicologo().getNombre(), cita.getPsicologo().getApellidoPaterno(), cita.getPsicologo().getApellidoMaterno(), cita.getPsicologo().getCorreo(), cita.getPsicologo().getHorarioDia()),
                    cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new AdeudoCitaDTO(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado())));
        }
        return citasDTO;
    }
}
