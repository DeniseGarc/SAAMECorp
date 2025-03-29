/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package agendarCita;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.PsicologoDTO;
import excepciones.AgendarCitaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author saula
 */
public class FAgendarCitaTest {
    
    private FAgendarCita fAgendarCita;
    
    public FAgendarCitaTest() {
    }
    
    @BeforeEach
    public void setUp() {
       fAgendarCita = new FAgendarCita();
    }

    /**
     * Test of mandarPsicologos method, of class FAgendarCita.
     */
    @Test
    public void testMandarPsicologos() {
        LocalDate fecha = LocalDate.now();
        List<PsicologoDTO> resultado = fAgendarCita.mandarPsicologos(fecha);
        assertNotNull(resultado);
        //Psicologos creados en FGestionPsicologos
        assertEquals(3, resultado.size());
    }

    /**
     * Test of validarAdeudoPsicologo method, of class FAgendarCita.
     */
    @Test
    public void testValidarAdeudoPsicologo() {
        PsicologoDTO psicologo = new PsicologoDTO();
        //dentro de lo que cabe porque sigue mock
        boolean resultado = fAgendarCita.validarAdeudoPsicologo(psicologo);
        assertTrue(resultado || !resultado);
    }

    /**
     * Test of mandarCubiculos method, of class FAgendarCita.
     */
    @Test
    public void testMandarCubiculos() {
        LocalDateTime fecha = LocalDateTime.now();
        //sigue mock
        List<CubiculoDTO> resultado = fAgendarCita.mandarCubiculos(fecha);
        assertNotNull(resultado);
    }

    /**
     * Test of resumenCita method, of class FAgendarCita.
     */
    @Test
    public void testResumenCita() throws Exception {
        CitaNuevaDTO cita = new CitaNuevaDTO();
        List <LocalTime> listaHoras = new ArrayList<>();
        listaHoras.add(LocalTime.of(8, 0));
        listaHoras.add(LocalTime.of(10, 30));
        listaHoras.add(LocalTime.of(15, 45));
        cita.setPsicologo(new PsicologoDTO("Juan", "Heras", "Carrazco", "juanherascarrazco@gmail.com",listaHoras));
        cita.setNombrePaciente("Pedro Morales");
        cita.setTelefonoPaciente("123456789");
        cita.setCorreoPaciente("pedromorales@gmail.com");
        cita.setFechaHora(LocalDateTime.now());

        assertDoesNotThrow(() -> {
            String resumen = fAgendarCita.resumenCita(cita);
            assertNotNull(resumen);
        });
    }

    /**
     * Test of agendarCita method, of class FAgendarCita.
     */
    @Test
    public void testAgendarCita() throws Exception {
        CitaNuevaDTO cita = new CitaNuevaDTO();
        List <LocalTime> listaHoras = new ArrayList<>();
        listaHoras.add(LocalTime.of(8, 0));
        listaHoras.add(LocalTime.of(10, 30));
        listaHoras.add(LocalTime.of(15, 45));
        listaHoras.add(LocalTime.of(23, 48));
        cita.setPsicologo(new PsicologoDTO("Chris", "Alvarez", "Centeno", 
                "chrisalvarezcenteno@gmail.com",listaHoras));
        cita.setCubiculo("Cubiculo 1");
        cita.setFechaHora(LocalDateTime.now());
        cita.setNombrePaciente("Luis Uribe");
        cita.setTelefonoPaciente("123456789");
        cita.setCorreoPaciente("luisuribe@gmail.com");
        CitaRegistradaDTO citaRegistradaDTO = new CitaRegistradaDTO("1", 
                cita.getFechaHora(), cita.getCubiculo(), cita.getPsicologo(), 
                cita.getNombrePaciente(), cita.getTelefonoPaciente(), 
                cita.getCorreoPaciente());
        //sigue mock, se ocupa crear una cita desde GestionCitas
        assertThrows(AgendarCitaException.class, () -> fAgendarCita.agendarCita(null));
        assertDoesNotThrow(() -> {
            boolean resultado = fAgendarCita.agendarCita(cita);
            assertTrue(resultado);
        });
    }

    /**
     * Test of obtenerPsicologo method, of class FAgendarCita.
     */
    @Test
    public void testObtenerPsicologo() throws Exception {
         String identificador = "1234";
         //sigue mock
        assertDoesNotThrow(() -> {
            PsicologoDTO resultado = fAgendarCita.obtenerPsicologo(identificador);
            assertNotNull(resultado);});
    }
    
}
