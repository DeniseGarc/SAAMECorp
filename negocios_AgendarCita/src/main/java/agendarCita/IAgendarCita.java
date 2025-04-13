/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package agendarCita;

import excepciones.AgendarCitaException;
import dto.CitaNuevaDTO;
import dto.CubiculoDTO;
import dto.PsicologoCitaDTO;
import dto.ResultadoAgendarCita;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IAgendarCita {

    public List<PsicologoCitaDTO> mandarPsicologos(Calendar fecha);

    public boolean validarAdeudoPsicologo(PsicologoCitaDTO psicologo);

    public List<CubiculoDTO> mandarCubiculos(Calendar fecha);

    public String resumenCita(CitaNuevaDTO cita) throws AgendarCitaException;

    public ResultadoAgendarCita agendarCita(CitaNuevaDTO cita) throws AgendarCitaException;

    public PsicologoCitaDTO obtenerPsicologo(String identificador, Calendar fechaCita) throws AgendarCitaException;

}
