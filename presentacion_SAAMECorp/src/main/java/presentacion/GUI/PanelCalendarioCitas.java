package presentacion.GUI;

import java.util.Calendar;
import javax.swing.JOptionPane;
import presentacion.control.CoordinadorAplicacion;
import presentacion.control.CoordinadorNegocio;

/**
 * Clase que representa el frame el cual muestra el calendario para seleccionar
 * la fecha de la cita a registrar.
 *
 * @author Alici
 */
public class PanelCalendarioCitas extends javax.swing.JPanel {

    private final CoordinadorAplicacion flujoPantallas = CoordinadorAplicacion.getInstance();
    private final CoordinadorNegocio controlNegocio = CoordinadorNegocio.getInstance();

    /**
     * Constructor que inicializa los componentes del frame
     */
    public PanelCalendarioCitas() {
        initComponents();
        controlNegocio.pintarDiasCalendario(calendarioCitas);
        controlNegocio.bloquearDiasNoDisponibles(calendarioCitas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        calendarioCitas = new com.toedter.calendar.JCalendar();
        jPanel3 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnSeleccionarDia = new javax.swing.JButton();
        btnModificarCita = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 680));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendarioCitas.setBackground(new java.awt.Color(204, 204, 255));
        calendarioCitas.setDecorationBackgroundColor(new java.awt.Color(221, 212, 240));
        calendarioCitas.setPreferredSize(new java.awt.Dimension(850, 550));
        calendarioCitas.setRequestFocusEnabled(false);
        calendarioCitas.setSundayForeground(new java.awt.Color(102, 0, 102));
        calendarioCitas.setWeekdayForeground(new java.awt.Color(188, 163, 226));
        jPanel1.add(calendarioCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 520));

        jPanel3.setBackground(new java.awt.Color(188, 163, 226));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitulo.setText("Citas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1121, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnSeleccionarDia.setBackground(new java.awt.Color(86, 33, 89));
        btnSeleccionarDia.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarDia.setText("Seleccionar Dia");
        btnSeleccionarDia.setBorder(null);
        btnSeleccionarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarDiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 160, 30));

        btnModificarCita.setBackground(new java.awt.Color(86, 33, 89));
        btnModificarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarCita.setText("Modificar cita");
        btnModificarCita.setBorder(null);
        btnModificarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarCitaMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarDiaActionPerformed
        Calendar diaSeleccionado = calendarioCitas.getCalendar();
        if (!controlNegocio.validarDiaSeleccionado(diaSeleccionado)) {
            JOptionPane.showMessageDialog(null, "Usted ya tiene agenda llena para este día", "Seleccione otra fecha", JOptionPane.OK_OPTION);
            return;
        }
        // Llama al método para pasar a la siguente pantalla 
        flujoPantallas.pantallaAgregarCita(diaSeleccionado);;
    }//GEN-LAST:event_btnSeleccionarDiaActionPerformed

    private void btnModificarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarCitaMouseClicked
        Calendar diaSeleccionado = calendarioCitas.getCalendar();
        flujoPantallas.pantallaSeleccionCita(diaSeleccionado);
    }//GEN-LAST:event_btnModificarCitaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarCita;
    private javax.swing.JButton btnSeleccionarDia;
    private com.toedter.calendar.JCalendar calendarioCitas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
