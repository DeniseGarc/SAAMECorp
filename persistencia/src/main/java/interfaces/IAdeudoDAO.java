/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Psicologo;
import excepciones.PersistenciaException;

/**
 *Interfaz que para la clase de AdeudoDAO que implementa los metodos en persistencia.
 * @author erika
 */
public interface IAdeudoDAO {
  public double consultarAdeudoTotalPsicologo(Psicologo psicologo) throws PersistenciaException;
}
