package presentacion.control;

import dto.PsicologoDTO;
import java.util.Calendar;
import presentacion.GUI.PantallaIniciarSesion;
import presentacion.GUI.PantallaAgregarCita;
import javax.swing.JFrame;
import presentacion.GUI.MenuPrincipalAdmin;
import presentacion.GUI.MenuPrincipalPsicologo;
import presentacion.GUI.PantallaGenerarFactura;
import presentacion.GUI.PantallaPagosAnteriores;
import presentacion.sesion.GestorSesion;
import presentacion.sesion.TipoUsuario;

/**
 * Clase que aplica Singleton y se encarga de manejar el flujo entre pantallas.
 *
 * @author Alici
 */
public class CoordinadorAplicacion {

    /**
     * Instancia única del singleton
     */
    private static CoordinadorAplicacion instancia;
    /**
     * Referencia al menu principal cuando el usuario es un administrador
     */
    private MenuPrincipalAdmin menuAdmin;
    /**
     * Referencia al menu principal cuando el usuario es un psicologo
     */
    private MenuPrincipalPsicologo menuPsicologo;

    /**
     * Constructor privado para evitar la creación de múltiples instancias.
     */
    private CoordinadorAplicacion() {
    }

    /**
     * Método para obtener la instancia única de CoordinadorAplicacion.
     *
     * @return Instancia única del coordinador.
     */
    public static CoordinadorAplicacion getInstance() {
        if (instancia == null) {
            instancia = new CoordinadorAplicacion();
        }
        return instancia;
    }

    /**
     * Método para abrir la pantalla de inicio de sesión del sistema.
     */
    public void pantallaInicioSesion() {
        PantallaIniciarSesion frmInicioSesion = new PantallaIniciarSesion();
        frmInicioSesion.setVisible(true);
    }

    /**
     * Método para abrir la pantalla principal del sistema dependiendo del tipo
     * de usuario que inicio sesión en el sistema.
     *
     * @param frm Frame que mandó a llamar a la acción.
     */
    public void pantallaPrincipal(JFrame frm) {
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            this.menuAdmin = new MenuPrincipalAdmin();
            menuAdmin.setVisible(true);
        } else {
            this.menuPsicologo = new MenuPrincipalPsicologo();
            menuPsicologo.setVisible(true);
        }
        frm.dispose();
    }

    /**
     * Método para abrir la pantalla donde aparece el calendario de citas del
     * sistema.
     *
     * @param frm Frame que mandó a llamar a la acción, null si no se desea
     * cerrar dicho frame.
     */
    public void pantallaCalendarioCitas(JFrame frm) {
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            menuAdmin.setVisible(true);
            menuAdmin.getCardLayout().show(menuAdmin.getPanelLateral(), "pantallaCalendarioCitas");
        } else {
            menuPsicologo.setVisible(true);
            menuPsicologo.getCardLayout().show(menuPsicologo.getPanelLateral(), "pantallaCalendarioCitas");
        }
        if (frm != null) {
            frm.dispose();
        }
    }

    /**
     * Método para abrir la pantalla donde aparece el formulario para agendar
     * una nueva cita en la fecha seleccionada del calendario.
     *
     * @param fechaSeleccionada Fecha seleccionada de la cita.
     */
    public void pantallaAgregarCita(Calendar fechaSeleccionada) {
        PantallaAgregarCita frmAgregarCita = new PantallaAgregarCita(fechaSeleccionada);
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            menuAdmin.setVisible(false);
        } else {
            menuPsicologo.setVisible(false);
        }
        frmAgregarCita.setVisible(true);
    }

    /**
     * Metodo para abrir la pantalla donde se pueden registrar pagos realizados
     * en el mostrador del consultorio.
     */
    public void pantallaRegistroPagos() {
        menuAdmin.getCardLayout().show(menuAdmin.getPanelLateral(), "pantallaRegistroPagos");
    }

    /**
     * Método para regresar al menu principal haciendolo visible de nuevo
     *
     * @param frm Frame que manda a llamar a la acción y va a cerrarse.
     */
    public void regresarAlMenuPrincipal(JFrame frm) {
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            menuAdmin.setVisible(true);
        } else {
            menuPsicologo.setVisible(true);
        }
        frm.dispose();
    }

    /**
     * Método para abrir la pantalla donde se muestran los pagos anteriores del
     * psicologo seleccionado
     *
     * @param psicologo Psicologo seleccionado del cual se van a mostrar sus
     * pagos anteriores.
     * @param frm Frame que manda a llamar a la acción, null en caso de que sea
     * llamado desde un panel.
     */
    public void pantallaPagosAnteriores(PsicologoDTO psicologo, JFrame frm) {
        PantallaPagosAnteriores frmPantalla = new PantallaPagosAnteriores(psicologo);
        menuAdmin.setVisible(false);
        frmPantalla.setVisible(true);
        if (frm != null) {
            frm.dispose();
        }
    }

    /**
     * Método para abrir la pantalla donde se muestra el formulario para generar
     * una factura de el pago seleccionado.
     *
     * @param frm Frame que mandó a llamar a la acción.
     * @param pagoSeleccionado Pago seleccionado a facturar.
     */
    public void pantallaGenerarFactura(JFrame frm) {
        PantallaGenerarFactura frmPantalla = new PantallaGenerarFactura(frm);
        menuAdmin.setVisible(false);
        if (frm != null) {
            frm.setVisible(false);
        }
        frmPantalla.setVisible(true);
    }
}
