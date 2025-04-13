/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;


import dto.AdeudoCitaDTO;
import dto.PsicologoDTO;
import interfaces.IAdeudoBO;

/**
 * Clase que implementa la logica de negocio para adeudo 
 * @author erika
 */
public class AdeudoBO implements IAdeudoBO{
    
    
    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     */
    @Override
    public double consultarAdeudoTotalPsicologo(PsicologoDTO psicologo) {
       return 100.0;
    }
}
