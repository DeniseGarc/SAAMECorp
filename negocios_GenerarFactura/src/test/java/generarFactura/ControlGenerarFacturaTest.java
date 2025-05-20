// package generarFactura;

// import dto.FacturaDTO;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// /**
//  * Clase de prueba para la clase ControlGenerarFactura.
//  * Esta clase contiene los métodos de prueba para los métodos de la clase
//  * ControlGenerarFactura.
//  * 
//  * @author Alici
//  */
// public class ControlGenerarFacturaTest {

//     /**
//      * Instancia de la clase ControlGenerarFactura que se va a probar.
//      */
//     private FacturaDTO factura = new FacturaDTO();

//     /**
//      * Constructor de la clase ControlGenerarFacturaTest.
//      * Este constructor inicializa una factura de prueba con datos de ejemplo.
//      */
//     public ControlGenerarFacturaTest() {
//         factura.setEmailReceiver("consultorio.alleri@gmail.com");
//         factura.setPaymentConditions("CREDITO A SIETE DIAS");
//         factura.setPaymentForm("03");
//         factura.setPaymentMethod("PUE");
//         factura.setRfcReceiver("URE180429TM6");
//         factura.setNameReceiver("UNIVERSIDAD ROBOTICA ESPAÑOLA");
//         factura.setCfdiUse("G03");
//         factura.setFiscalRegime("601");
//         factura.setTaxZipCode("86991");
//         factura.setUnitPrice(50.00);
//         factura.setQuantity(2.00);
//         factura.setSubtotal(100.00);
//         factura.setTotal(100.00);
//     }

//     /**
//      * Prueba del metodo timbrarFactura.
//      * Esta prueba verifica que el método timbrarFactura() de la clase
//      * ControlGenerarFactura
//      * funcione correctamente al timbrar una factura.
//      * TENER CUIDADO CON ESTA PRUEBA, YA QUE TIMBRA UNA FACTURA EN EL
//      * ENTORNO DE PRUEBAS DE FACTURAMA Y HAY UN LIMITE DE FACTURAS QUE PUEDEN
//      * GENERARSE
//      */
//     // @Test
//     // public void testTimbrarFacturaOK() throws Exception {
//     // System.out.println("prueba timbrarFactura()");
//     // ControlGenerarFactura instance = new ControlGenerarFactura();
//     // FacturaDTO result = instance.timbrarFactura(this.factura);
//     // assertNotNull(result);
//     // assertNotNull(result.getId());
//     // factura.setId(result.getId());
//     // }

//     /**
//      * Prueba del método timbrarFactura.
//      * Esta prueba verifica que el método timbrarFactura() de la clase
//      * ControlGenerarFactura funcione correctamente al mandar la factura por correo.
//      */
//     @Test
//     public void testMandarFacturaCorreoOK() throws Exception {
//         System.out.println("prueba mandarFacturaCorreo()");
//         ControlGenerarFactura instance = new ControlGenerarFactura();
//         boolean expResult = true;
//         boolean result = instance.mandarFacturaCorreo(factura);
//         assertEquals(expResult, result);
//     }

//     /**
//      * Prueba del método timbrarFactura.
//      * Esta prueba verifica que el método timbrarFactura() de la clase
//      * ControlGenerarFactura lance error al no ingresar un correo electronico.
//      */
//     @Test
//     public void testMandarFacturaCorreoException() throws Exception {
//         System.out.println("prueba mandarFacturaCorreo() con exception al no ingresar el correo");
//         ControlGenerarFactura instance = new ControlGenerarFactura();
//         factura.setEmailReceiver(null);
//         assertThrows(Exception.class, () -> {
//             instance.mandarFacturaCorreo(factura);
//         });
//     }

//     /**
//      * Prueba del métodor registrarFactura.
//      * Esta prueba verifica que el método registrarFactura() de la clase
//      * ControlGenerarFactura
//      * funcione correctamente al registrar una factura en la base de datos.
//      */
//     @Test
//     public void testRegistrarFactura() throws Exception {
//         System.out.println("Prueba registrarFactura()");
//         ControlGenerarFactura instance = new ControlGenerarFactura();
//         boolean expResult = true;
//         boolean result = instance.registrarFactura(factura);
//         assertEquals(expResult, result);
//     }

// }
