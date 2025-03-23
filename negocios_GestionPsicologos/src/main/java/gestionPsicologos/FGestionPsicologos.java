/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPsicologos;

import dto.PsicologoDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FGestionPsicologos implements IGestionPsicologos {

    // por el momento no se utiliza, en un futuro el subsistema agendarCita va a llamar a este metodo
    @Override
    public List<PsicologoDTO> obtenerPsicologosDisponibles() {
        return null;
    }

    // mock del metodo
    @Override
    public boolean diaDisponiblePsicologo(String identificadorPsicologo, Date fecha) {
        return true;
    }

}
