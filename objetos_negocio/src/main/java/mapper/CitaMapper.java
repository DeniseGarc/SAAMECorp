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
        return new CitaNuevaDTO(cita.getFechaHora(), cita.getObjectCubiculoString(), cita.getObjectPsicologoString(),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(), new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(), cita.getDetallesAdeudo().isEstado()));
    }

    public Cita toEntity(CitaNuevaDTO cita) {
        Cita c = new Cita();
        c.setFechaHora(cita.getFechaHora());
        c.setNombrePaciente(cita.getNombrePaciente());
        c.setTelefonoPaciente(cita.getTelefonoPaciente());
        c.setCorreoPaciente(cita.getCorreoPaciente());
        c.setObjectPsicologoString(cita.getPsicologo());
        c.setObjectCubiculoString(cita.getCubiculo());
        c.setDetallesAdeudo(new Adeudo(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado()));
        return c;
    }

    public List<CitaNuevaDTO> toDTOList(List<Cita> citas) {
        List<CitaNuevaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            CitaNuevaDTO c = new CitaNuevaDTO();
            c.setFechaHora(cita.getFechaHora());
            c.setNombrePaciente(cita.getNombrePaciente());
            c.setTelefonoPaciente(cita.getTelefonoPaciente());
            c.setCorreoPaciente(cita.getCorreoPaciente());
            c.setPsicologo(cita.getObjectPsicologoString());
            c.setCubiculo(cita.getObjectCubiculoString());
            c.setAdeudo(new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(), cita.getDetallesAdeudo().isEstado()));
            citasDTO.add(c);
        }
        return citasDTO;
    }

    public List<CitaDTO> toDTOList2(List<Cita> citas) {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(new CitaDTO(cita.getFechaHora(), cita.getObjectCubiculoString()));
        }
        return citasDTO;
    }

    public List<CitaRegistradaDTO> toDTOList3(List<Cita> citas) {
        List<CitaRegistradaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            CitaRegistradaDTO c = new CitaRegistradaDTO();
            c.setId(cita.getObjectString());
            c.setFechaHora(cita.getFechaHora());
            c.setNombrePaciente(cita.getNombrePaciente());
            c.setTelefonoPaciente(cita.getTelefonoPaciente());
            c.setCorreoPaciente(cita.getCorreoPaciente());
            c.setPsicologo(cita.getObjectPsicologoString());
            c.setCubiculo(cita.getObjectCubiculoString());
            c.setAdeudo(new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(), cita.getDetallesAdeudo().isEstado()));
            citasDTO.add(c);
        }
        return citasDTO;
    }
}
