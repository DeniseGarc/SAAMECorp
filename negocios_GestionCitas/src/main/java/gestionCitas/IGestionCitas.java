/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionCitas;

import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IGestionCitas {

    public boolean agendarCita(CitaNuevaDTO cita);

    public List<LocalDate> obtenerDiasConCita();

    public List<LocalDate> obtenerDiasConAgendaLlena();

    public boolean validarFechaCitaRepetida(CitaNuevaDTO citaNueva);
}
