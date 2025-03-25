/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendarCita;

import dto.CitaNuevaDTO;
import dto.PsicologoDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alici
 */
public class FAgendarCita implements IAgendarCita {

    List<PsicologoDTO> listaPsicologos = new ArrayList<>();
    /**
     * Esto se elimina ya que solo es para el mock
     */
    public FAgendarCita() {
        List<LocalTime> listaHoras1 = new ArrayList<>();
        List<LocalTime> listaHoras2 = new ArrayList<>();
        List<LocalTime> listaHoras3 = new ArrayList<>();

        listaHoras1.add(LocalTime.of(8, 0));
        listaHoras1.add(LocalTime.of(10, 30));
        listaHoras1.add(LocalTime.of(15, 45));

        listaHoras2.add(LocalTime.of(9, 0));
        listaHoras2.add(LocalTime.of(11, 30));
        listaHoras2.add(LocalTime.of(16, 0));

        listaHoras3.add(LocalTime.of(7, 30));
        listaHoras3.add(LocalTime.of(12, 15));
        listaHoras3.add(LocalTime.of(14, 45));

        listaPsicologos.add(new PsicologoDTO("Jorge", "Ramirez", "Verdugo", "jorgeramirez@gmail.com", listaHoras1));
        listaPsicologos.add(new PsicologoDTO("María", "López", "Hernández", "marialopez@gmail.com", listaHoras2));
        listaPsicologos.add(new PsicologoDTO("Carlos", "Gómez", "Santos", "carlosgomez@gmail.com", listaHoras3));
    }
    /**
     * Llama al metodo del gestor de psicologos que devuelve los psicologos disponibles en ese dia
     * @param LocalDate dia de la cita
     * @return Regresa los PsicologoDTO
     */
    @Override
    public List<PsicologoDTO> mandarPsicologos(LocalDate fecha) {
        return listaPsicologos;
    }
    /**
     * Manda a llamar al metodo de gestor de adeudos y aqui se pone la condición de maximo de adeudo de 500
     * @param psicologo el psicologo del que se quiere validar adeudo
     * @return true si el adeudo es menor a 500 y false si es mayor
     */
    @Override
    public boolean validarAdeudoPsicologo(PsicologoDTO psicologo) {
        return true;
       
    }
    /**
     * Llama al metodo del gestor de cubiculos para obtener los cubiculos disponibles del dia de la cita
     * @param fecha la fecha de la que se necesitan los cubiculos
     * @return los cubiculos disponibles del dia 
     */
    @Override
    public List<String> mandarCubiculos(LocalDateTime fecha) {
        List<String> cubiculos = new ArrayList<>();
        cubiculos.add("Cubiculo 1");
        cubiculos.add("Cubiculo 2");
        cubiculos.add("Cubiculo 3");
        return cubiculos;
    }
    /**
     * terminao
     * @param cita
     * @return 
     */
    @Override
    public String resumenCita(CitaNuevaDTO cita) {
        if (cita == null) {
            //Esto pasara a ser una excepcion
            System.out.println("La cita es nula");
        }
        return "¿Desea agendar la cita?\n"
                + cita.getCubiculo() + "\n"
                + "Fecha" + cita.getFechaHora().toLocalDate() + " " + cita.getFechaHora().toLocalTime() + "\n"
                + "Psicólogo: " + cita.getPsicologo().getNombre() + " " + cita.getPsicologo().getApellidoPaterno() + " " + cita.getPsicologo().getApellidoMaterno() + "\n"
                + "Cliente: " + cita.getNombrePaciente() + ", Teléfono: " + cita.getTelefonoPaciente() + "\n"
                + "Correo del paciente: " + cita.getCorreoPaciente();
    }
    /**
     * 
     * @param cita
     * @return 
     */
    @Override
    public boolean agendarCita(CitaNuevaDTO cita) {
        return true;
    }
    /**
     * Llama a un metodo del gestor de psicologos el cual recupera al psicologo con su identificador
     * @param identificador el usuario con el que inician sesion
     * @return el psicologo que tiene ese identificador
     */
    @Override
    public PsicologoDTO obtenerPsicologo(String identificador) {
        return listaPsicologos.getLast();
    }

}
