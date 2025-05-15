package presentacion.control;

import java.util.Calendar;
import presentacion.GUI.IniciarSesion;
import presentacion.GUI.CalendarioCitas;
import presentacion.GUI.AgregarCita;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentacion.GUI.MenuPrincipalAdmin;
import presentacion.GUI.MenuPrincipalPsicologo;
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
        IniciarSesion frmInicioSesion = new IniciarSesion();
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
     * @param frm Frame que mandó a llamar a la acción.
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
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            menuAdmin.setVisible(false);
        } else {
            menuPsicologo.setVisible(false);
        }
        AgregarCita frmAgregarCita = new AgregarCita(fechaSeleccionada);
        frmAgregarCita.setVisible(true);
    }
}
