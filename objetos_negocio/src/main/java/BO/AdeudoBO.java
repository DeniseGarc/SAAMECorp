/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.AdeudoDTO;
import dto.PsicologoDTO;
import interfaces.IAdeudoBO;

/**
 * Clase que implementa la logica de negocio para adeudo 
 * @author erika
 */
public class AdeudoBO implements IAdeudoBO{
    
    /**
     * Metodo que consulta el adeudo del psicologo para compronbar si este es menor o mayor a 500
     * @param psicologo psicologo a consultar
     * @return True si el adeudo es menor a 500, false si no
     */
    @Override
    public boolean consultarAdeudoPsicologo(PsicologoDTO psicologo){
        
        return false;
    }
    /**
     * Metodo para generar el adeudo al agendar una cita
     * @param adeudo Adeudo a generar
     * @return True si el adeudo se genero correctamente
     */
    @Override
    public boolean generarAdeudo(AdeudoDTO adeudo){
        //Logica
        return true;
    }
}
