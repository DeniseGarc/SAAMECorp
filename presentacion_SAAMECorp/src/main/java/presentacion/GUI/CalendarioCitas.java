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
public class CalendarioCitas extends javax.swing.JFrame {

    private final CoordinadorAplicacion control = new CoordinadorAplicacion();
    private final CoordinadorNegocio controlNegocio = new CoordinadorNegocio();

    /**
     * Constructor que inicializa los componentes del frame
     */
    public CalendarioCitas() {
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
        jPanel2 = new javax.swing.JPanel();
        btnCitas = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCubiculos = new javax.swing.JButton();
        lblCitas = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();
        lblPsicologos = new javax.swing.JLabel();
        lblCubiculos = new javax.swing.JLabel();
        btnSeleccionarDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 680));

        calendarioCitas.setBackground(new java.awt.Color(204, 204, 255));
        calendarioCitas.setDecorationBackgroundColor(new java.awt.Color(221, 212, 240));
        calendarioCitas.setPreferredSize(new java.awt.Dimension(850, 550));
        calendarioCitas.setRequestFocusEnabled(false);
        calendarioCitas.setSundayForeground(new java.awt.Color(102, 0, 102));
        calendarioCitas.setWeekdayForeground(new java.awt.Color(188, 163, 226));

        jPanel3.setBackground(new java.awt.Color(188, 163, 226));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitulo.setText("Cita");

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-lista-50.png"))); // NOI18N
        btnCitas.setBorder(null);
        btnCitas.setBorderPainted(false);
        btnCitas.setContentAreaFilled(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/team.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-carpeta-50.png"))); // NOI18N
        btnReportes.setBorder(null);
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);

        btnCubiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-estrella-50.png"))); // NOI18N
        btnCubiculos.setBorder(null);
        btnCubiculos.setBorderPainted(false);
        btnCubiculos.setContentAreaFilled(false);
        btnCubiculos.setFocusPainted(false);
        btnCubiculos.setPreferredSize(new java.awt.Dimension(60, 60));

        lblCitas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Citas");

        lblReportes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportes.setText("Reportes");

        lblPsicologos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPsicologos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPsicologos.setText("Psicologos");

        lblCubiculos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCubiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculos.setText("Cubiculos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPsicologos)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCubiculos)
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblReportes)
                        .addGap(12, 12, 12))))
            .addComponent(btnCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCubiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCitas)
                .addGap(36, 36, 36)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPsicologos)
                .addGap(30, 30, 30)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReportes)
                .addGap(28, 28, 28)
                .addComponent(btnCubiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCubiculos)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        btnSeleccionarDia.setBackground(new java.awt.Color(86, 33, 89));
        btnSeleccionarDia.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarDia.setText("Seleccionar Dia");
        btnSeleccionarDia.setBorder(null);
        btnSeleccionarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSeleccionarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(calendarioCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarioCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarDiaActionPerformed
        Calendar diaSeleccionado = calendarioCitas.getCalendar();
        if (!controlNegocio.validarDiaSeleccionado(diaSeleccionado)) {
            JOptionPane.showMessageDialog(null, "Usted ya tiene agenda llena para este día", "Seleccione otra fecha", JOptionPane.OK_OPTION);
            return;
        }
        // Llama al método para pasar a la siguente pantalla 
        control.pantallaAgregarCita(this, diaSeleccionado);
    }//GEN-LAST:event_btnSeleccionarDiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnCubiculos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSeleccionarDia;
    private com.toedter.calendar.JCalendar calendarioCitas;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblCubiculos;
    private javax.swing.JLabel lblPsicologos;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
