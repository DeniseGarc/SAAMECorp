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
     * Instancia unica de la clase 
     */
    private static AdeudoDAO instancia; 
    
    /**
     * Constructor privado
     */
    private AdeudoDAO(){}
    
    /**
     * Metodo para obtener la instancia unica de AdeudoDAO
     * Si no existe una la crea
     * @return instancia unida de AdeudoDAO
     */
    public static AdeudoDAO getInstancia(){
        if (instancia == null){
            instancia= new AdeudoDAO();
        }
        return instancia; 
    }
    /**
     * Metodo que regresa el adeudo total de un psicologo dado
     * @param psicologo Psicologo a consultar
     * @return Total del adeudo del psicologo
     * @throws excepciones.PersistenciaException
     */
    @Override
    public double consultarAdeudoTotalPsicologo(Psicologo psicologo) throws PersistenciaException{
        try {
            return 100.0;
        } catch ( Exception e) {
            throw new PersistenciaException("Error al consultar el adeudo total: " + e.getMessage());
        }
    }
    
}
