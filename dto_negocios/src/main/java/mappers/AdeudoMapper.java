/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dto.AdeudoCitaDTO;
import entidades.Adeudo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class AdeudoMapper {

    public AdeudoCitaDTO toDTO(Adeudo adeudo) {
        return new AdeudoCitaDTO(adeudo.getCantidad(), adeudo.isEstado());
    }

    public Adeudo toEntity(AdeudoCitaDTO adeudo) {
        return new Adeudo(adeudo.getCantidad(), adeudo.isEstado());
    }

    public List<AdeudoCitaDTO> toDTOList(List<Adeudo> adeudos) {
        List<AdeudoCitaDTO> adeudosDTO = new ArrayList<>();
        for (Adeudo adeudo : adeudos) {
            adeudosDTO.add(new AdeudoCitaDTO(adeudo.getCantidad(), adeudo.isEstado()));
        }
        return adeudosDTO;
    }
}
