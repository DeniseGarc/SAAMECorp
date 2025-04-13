/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.AdeudoDTO;
import dto.PsicologoDTO;

/**
 * Interfaz de los medotos de Adeudo BO 
 * @author erika
 */
public interface IAdeudoBO {
    public boolean consultarAdeudoPsicologo(PsicologoDTO psicologo);
    public boolean generarAdeudo(AdeudoDTO adeudo);
}
