/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import dto.PsicologoDTO;
import interfaces.IPsicologoBO;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que define la logica de negocio para psicologos
 *
 * @author erika
 */
public class PsicologoBO implements IPsicologoBO {

    /**
     * Metodo para obtener todos los psicologos registrados
     *
     * @return Lista de psicolos registrados
     */
    @Override
    public List<PsicologoDTO> obtenerPsicologos() {
        List<PsicologoDTO> lista = new LinkedList<>();
        List<LocalTime> horario = new LinkedList<>();
        horario.add(LocalTime.of(8, 0));   // 08:00 AM
        horario.add(LocalTime.of(10, 30)); // 10:30 AM
        horario.add(LocalTime.of(13, 15)); // 01:15 PM
        horario.add(LocalTime.of(16, 45)); // 04:45 PM
        horario.add(LocalTime.of(19, 0));  // 07:00 PM

        lista.add(new PsicologoDTO("Jose", "Rodriguez", "Gaxiola", "jose@gmail.com", horario));
        lista.add(new PsicologoDTO("Jorge", "Blanco", "Verdugo", "jorge@gmail.com", horario));
        lista.add(new PsicologoDTO("Maria", "Felix", "Perez", "maria@gmail.com", horario));

        return lista;
    }

    @Override
    public PsicologoDTO obtenerPsicologoPorIdentificador(String identificador) {
        return new PsicologoDTO("Abraham", "Sainz", "Felix", "jsusAbhram@potros.itson.com");
    }

}
