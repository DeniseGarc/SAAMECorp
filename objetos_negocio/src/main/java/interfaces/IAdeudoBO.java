/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.PsicologoDTO;
import excepciones.NegocioException;

/**
 * Interfaz de los medotos de Adeudo BO
 *
 * @author erika
 */
public interface IAdeudoBO {

    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     *
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     * @throws excepciones.NegocioException
     */
    public double consultarAdeudoTotalPsicologo(PsicologoDTO psicologo) throws NegocioException;

}
