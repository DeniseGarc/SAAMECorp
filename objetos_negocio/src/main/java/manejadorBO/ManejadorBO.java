/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorBO;

import BO.AdeudoBO;
import BO.CitaBO;
import BO.CubiculoBO;
import BO.PsicologoBO;
import interfaces.IAdeudoBO;
import interfaces.ICitaBO;
import interfaces.ICubiculoBO;
import interfaces.IPsicologoBO;

/**
 * Clase que funciona como fábrica de objetos negocio.
 * @author erika
 */
public class ManejadorBO {
    
    /**
     * Método que crea y regresa la instancia de AdeudoBO.
     *
     * @return clase AdeudoBO que implementa la interfaz IAdeudoBO.
     */
    public static IAdeudoBO crearAdeudoBO(){
        IAdeudoBO audeudoBO = new AdeudoBO();
        return audeudoBO;
    }
    
    /**
     * Método que crea y regresa la instancia de CitaBO.
     * @return clase CitaBO que implementa la interfaz ICitaBO.
     */
    public static ICitaBO crearCitaBO(){
        ICitaBO citaBO = new CitaBO();
        return citaBO;
    }
    
    /**
     * Método que crea y regresa la instancia de CubiculoBO.
     * @return clase CubiculoBO que implementa la interfaz ICubiculoBO.
     */
    public static ICubiculoBO crearCubiculoBO(){
        ICubiculoBO cubiculoBO = new CubiculoBO();
        return cubiculoBO;
    }
    
    /**
     *  Método que crea y regresa la instancia de PsicologoBO.
     * @return clase PsicologoBO que implementa la interfaz IPsicologoBO.
     */
    public static IPsicologoBO crearPsicologoBO(){
        IPsicologoBO psicologoBO = new PsicologoBO();
        return psicologoBO;
    }
}
