/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.Psicologo;
import excepciones.PersistenciaException;
import interfaces.IAdeudoDAO;

/**
 *
 * @author erika
 */
public class AdeudoDAO implements IAdeudoDAO{
     
    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     * @throws excepciones.PersistenciaException
     */
    @Override
    public double consultarAdeudoTotalPsicologo(Psicologo psicologo) throws PersistenciaException{
         return 100.0;
    }
    
}
