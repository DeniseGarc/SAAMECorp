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
import static enumeradores.TipoBO.CUBICULO;
import static enumeradores.TipoBO.PSICOLOGO;
import excepciones.NegocioException;
import interfaces.ICubiculoBO;
import interfaces.IPsicologoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorBO.ManejadorBO;

public class CitaMapper {

    IPsicologoBO psicologoBO = (IPsicologoBO) ManejadorBO.crearBO(PSICOLOGO);
    ICubiculoBO cubiculoBO = (ICubiculoBO) ManejadorBO.crearBO(CUBICULO);

    public CitaNuevaDTO toDTO(Cita cita) {
        return new CitaNuevaDTO(cita.getFechaHora(), cita.getObjectCubiculoString(), cita.getObjectPsicologoString(),
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), cita.getCorreoPaciente(),
                new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(), cita.getDetallesAdeudo().isEstado(),
                        cita.getDetallesAdeudo().getNotas()));
    }

    public Cita toEntity(CitaNuevaDTO cita) {
        Cita c = new Cita();
        c.setFechaHora(cita.getFechaHora());
        c.setNombrePaciente(cita.getNombrePaciente());
        c.setTelefonoPaciente(cita.getTelefonoPaciente());
        c.setCorreoPaciente(cita.getCorreoPaciente());
        c.setObjectPsicologoString(cita.getPsicologo());
        c.setObjectCubiculoString(cita.getCubiculo());
        c.setDetallesAdeudo(
                new Adeudo(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado(), cita.getAdeudo().getNotas()));
        return c;
    }

    public Cita toEntity2(CitaRegistradaDTO cita) {
        Cita c = new Cita();
        c.setObjectString(cita.getId());
        c.setFechaHora(cita.getFechaHora());
        c.setNombrePaciente(cita.getNombrePaciente());
        c.setTelefonoPaciente(cita.getTelefonoPaciente());
        c.setCorreoPaciente(cita.getCorreoPaciente());
        c.setObjectPsicologoString(cita.getPsicologo().getId());
        c.setObjectCubiculoString(cita.getCubiculo().getId());
        c.setDetallesAdeudo(
                new Adeudo(cita.getAdeudo().getCantidad(), cita.getAdeudo().isEstado(), cita.getAdeudo().getNotas()));
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
            c.setAdeudo(new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(), cita.getDetallesAdeudo().isEstado(),
                    cita.getDetallesAdeudo().getNotas()));
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
            try {
                CitaRegistradaDTO c = new CitaRegistradaDTO();
                c.setId(cita.getObjectString());
                c.setFechaHora(cita.getFechaHora());
                c.setNombrePaciente(cita.getNombrePaciente());
                c.setTelefonoPaciente(cita.getTelefonoPaciente());
                c.setCorreoPaciente(cita.getCorreoPaciente());
                c.setPsicologo(psicologoBO.obtenerPsicologoPorIdentificador(cita.getObjectPsicologoString()));
                c.setCubiculo(cubiculoBO.buscarCubiculoPorId(cita.getObjectCubiculoString()));
                c.setAdeudo(new AdeudoCitaDTO(cita.getDetallesAdeudo().getCantidad(),
                        cita.getDetallesAdeudo().isEstado(), cita.getDetallesAdeudo().getNotas()));
                citasDTO.add(c);
            } catch (NegocioException ex) {
                Logger.getLogger(CitaMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return citasDTO;
    }
}
