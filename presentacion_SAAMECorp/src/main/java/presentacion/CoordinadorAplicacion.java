/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;

/**
 * Clase que se va a encargar de generar los JFrame y el cambio de pantallas
 * UNICAMENTE SU FUNCION ES CERRAR Y ABRIR PANTALLAS
 * @author Alici
 */
public class CoordinadorAplicacion {

    public void pantallaInicioSesion() {
        IniciarSesion frmInicioSesion = new IniciarSesion();
        frmInicioSesion.setVisible(true);

    }

    public void pantallaPrincipal(JFrame frm) {
        PantallaInicio frmInicio = new PantallaInicio();
        frmInicio.setVisible(true);
        frm.dispose();
    }

    public void pantallaCalendarioCitas(JFrame frm) {
        CalendarioCitas frmCalendarioCita = new CalendarioCitas();
        frmCalendarioCita.setVisible(true);
        frm.dispose();
    }

    public void pantallaAgregarCita(JFrame frm) {
        AgregarCita frmAgregarCita = new AgregarCita();
        frmAgregarCita.setVisible(true);
        frm.dispose();
    }
}
