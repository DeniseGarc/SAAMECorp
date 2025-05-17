/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sistemaFacturas;

import DTO.FacturaRegistroDTO;
import excepciones.ConexionFacturamaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase SistemaFacturas.
 * Esta clase contiene los métodos de prueba para los métodos de la clase
 * SistemaFacturas.
 * 
 * @author Alici
 */
public class SistemaFacturasTest {

    public SistemaFacturasTest() {
    }

    /**
     * Metodo de prueba para timbrarFactura.
     * NO DEJAR QUE ESTA PRUEBA SE EJECUTE CONSTANTEMENTE, YA QUE HAY UN LIMITE DE
     * FACTURAS QUE SE PUEDEN TIMBRAR EN EL ENTORNO DE PRUEBAS DE FACTURAMA.
     * 
     */
    // @Test
    // public void testTimbrarFacturaOK() throws Exception {
    // System.out.println("prueba timbrarFactura()");
    // FacturaRegistroDTO factura = new FacturaRegistroDTO();
    // factura.setPaymentConditions("CREDITO A SIETE DIAS");
    // factura.setPaymentForm("03");
    // factura.setPaymentMethod("PUE");
    // factura.setRfcReceiver("URE180429TM6");
    // factura.setNameReceiver("UNIVERSIDAD ROBOTICA ESPAÑOLA");
    // factura.setCfdiUse("G03");
    // factura.setFiscalRegime("601");
    // factura.setTaxZipCode("86991");
    // factura.setUnitPrice(50.00);
    // factura.setQuantity(2.00);
    // factura.setSubtotal(100.00);
    // factura.setTotal(100.00);
    // SistemaFacturas instance = new SistemaFacturas();
    // FacturaRegistroDTO result = instance.timbrarFactura(factura);
    // assertNotNull(result.getId());
    // }

    /**
     * Prueba de la excepción al timbrar la factura.
     * Esta prueba simula un error al timbrar la factura, como por ejemplo no
     * ingresar el codigo postal del receptor.
     * 
     */
    @Test
    public void testTimbrarFacturaException() throws Exception {
        System.out.println("prueba timbrarFactura() genera exception");
        FacturaRegistroDTO factura = new FacturaRegistroDTO();
        factura.setPaymentConditions("CREDITO A SIETE DIAS");
        factura.setPaymentForm("03");
        factura.setPaymentMethod("PUE");
        factura.setRfcReceiver("URE180429TM6");
        factura.setNameReceiver("UNIVERSIDAD ROBOTICA ESPAÑOLA");
        factura.setCfdiUse("G03");
        factura.setFiscalRegime("601");
        // simulando error donde no se establece el código postal
        // factura.setTaxZipCode("86991");
        factura.setUnitPrice(50.00);
        factura.setQuantity(2.00);
        factura.setSubtotal(100.00);
        factura.setTotal(100.00);
        SistemaFacturas instance = new SistemaFacturas();
        assertThrows(ConexionFacturamaException.class, () -> {
            instance.timbrarFactura(factura);
        });
    }

    /**
     * Prueba del metodo mandarFacturaCorreo con resultado exitoso.
     */
    @Test
    public void testMandarFacturaCorreoOK() throws Exception {
        System.out.println("prueba mandarFacturaCorreo()");
        FacturaRegistroDTO factura = new FacturaRegistroDTO();
        factura.setId("WtwrZtVQ_dZc0qWmgzmg7w2");
        factura.setEmailReceiver("consultorio.alleri@gmail.com");
        SistemaFacturas instance = new SistemaFacturas();
        boolean expResult = true;
        boolean result = instance.mandarFacturaCorreo(factura);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo mandarFacturaCorreo cuando lanza exception.
     */
    @Test
    public void testMandarFacturaCorreoIdFacturaNoExiste() throws Exception {
        System.out.println("prueba mandarFacturaCorreo() genera exception al no encontrar la factura por id");
        FacturaRegistroDTO factura = new FacturaRegistroDTO();
        // simulando error donde el id de la factura no existe
        factura.setId("WtwrZtVQ_dZc0qWmgzmg7w9");
        factura.setEmailReceiver("consultorio.alleri@gmail.com");
        SistemaFacturas instance = new SistemaFacturas();
        assertThrows(ConexionFacturamaException.class, () -> {
            instance.mandarFacturaCorreo(factura);
        });
    }
    

    /**
     * Prueba del metodo descargarPDF con resultado exitoso.
     */
    @Test
    public void testDescargarPDF() throws Exception {
        System.out.println("prueba descargarPDF()");
        FacturaRegistroDTO factura = new FacturaRegistroDTO();
        factura.setId("WtwrZtVQ_dZc0qWmgzmg7w2");
        String filePath = "factura";
        SistemaFacturas instance = new SistemaFacturas();
        boolean expResult = true;
        boolean result = instance.descargarPDF(factura, filePath);
        assertEquals(expResult, result);
    }

    
    /**
     * Prueba del metodo descargarXML con resultado exitoso.
     */
    @Test
    public void testDescargarXML() throws Exception {
        System.out.println("prueba descargarXML()");
        FacturaRegistroDTO factura = new FacturaRegistroDTO();
        factura.setId("WtwrZtVQ_dZc0qWmgzmg7w2");
        String filePath = "factura";
        SistemaFacturas instance = new SistemaFacturas();
        boolean expResult = true;
        boolean result = instance.descargarXML(factura, filePath);
        assertEquals(expResult, result);
    }

}
