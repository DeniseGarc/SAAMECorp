package presentacion.control;

import java.util.Calendar;
import presentacion.GUI.PantallaInicio;
import presentacion.GUI.IniciarSesion;
import presentacion.GUI.CalendarioCitas;
import presentacion.GUI.AgregarCita;
import javax.swing.JFrame;

/**
 * Clase que se encarga de manejar el flujo entre pantallas.
 *
 * @author Alici
 */
public class CoordinadorAplicacion {

    /**
     * Método para abrir la pantalla de inicio de sesión del sistema.
     */
    public void pantallaInicioSesion() {
        IniciarSesion frmInicioSesion = new IniciarSesion();
        frmInicioSesion.setVisible(true);
    }

    /**
     * Método para abrir la pantalla principal del sistema.
     *
     * @param frm Frame que mandó a llamar a la acción.
     */
    public void pantallaPrincipal(JFrame frm) {
        PantallaInicio frmInicio = new PantallaInicio();
        frmInicio.setVisible(true);
        frm.dispose();
    }

    /**
     * Método para abrir la pantalla donde aparece el calendario de citas del
     * sistema.
     *
     * @param frm Frame que mandó a llamar a la acción.
     */
    public void pantallaCalendarioCitas(JFrame frm) {
        CalendarioCitas frmCalendarioCita = new CalendarioCitas();
        frmCalendarioCita.setVisible(true);
        frm.dispose();
    }

    /**
     * Método para abrir la pantalla donde aparece el formulario para agendar
     * una nueva cita en la fecha seleccionada del calendario.
     *
     * @param frm Frame que mandó llamar a la acción.
     * @param fechaSeleccionada Fecha seleccionada de la cita.
     */
    public void pantallaAgregarCita(JFrame frm, Calendar fechaSeleccionada) {
        AgregarCita frmAgregarCita = new AgregarCita(fechaSeleccionada);
        frmAgregarCita.setVisible(true);
        frm.dispose();
    }
}
