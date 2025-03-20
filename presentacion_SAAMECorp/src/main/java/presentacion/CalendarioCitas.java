/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.util.Date;

/**
 *
 * @author Alici
 */
public class CalendarioCitas extends javax.swing.JFrame {

    /**
     * Creates new form CalendarioCitas
     */
    //crear instancia del control de la aplicacion para poder usar los metodos
    ControladorAplicacion control = new ControladorAplicacion();
    public CalendarioCitas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CalendarioCitas = new com.toedter.calendar.JCalendar();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 800));

        CalendarioCitas.setBackground(new java.awt.Color(204, 204, 255));
        CalendarioCitas.setDecorationBackgroundColor(new java.awt.Color(221, 212, 240));
        CalendarioCitas.setPreferredSize(new java.awt.Dimension(850, 550));
        CalendarioCitas.setRequestFocusEnabled(false);
        CalendarioCitas.setSundayForeground(new java.awt.Color(102, 0, 102));
        CalendarioCitas.setWeekdayForeground(new java.awt.Color(188, 163, 226));
        CalendarioCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarioCitasMouseClicked(evt);
            }
        });
        CalendarioCitas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioCitasPropertyChange(evt);
            }
        });

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

        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/icons8-lista-50.png"))); // NOI18N
        btnCitas.setBorderPainted(false);
        btnCitas.setContentAreaFilled(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/team.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/icons8-carpeta-50.png"))); // NOI18N
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);

        btnCubiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/icons8-estrella-50.png"))); // NOI18N
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
                                .addComponent(btnCitas)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPsicologos)
                                    .addComponent(jButton4))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCubiculos)
                                    .addComponent(btnCubiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReportes)
                            .addComponent(lblReportes))
                        .addGap(12, 12, 12))))
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
                .addContainerGap(246, Short.MAX_VALUE))
        );

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(CalendarioCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalendarioCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalendarioCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarioCitasMouseClicked
        
    }//GEN-LAST:event_CalendarioCitasMouseClicked

    private void CalendarioCitasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioCitasPropertyChange
        Date fechaSeleccionada = CalendarioCitas.getDate();
        System.out.println("Día seleccionado: " + fechaSeleccionada);

        // Llama al método para pasar a la siguente pantalla 
        control.pantallaCalendarioCitas(this);
    }//GEN-LAST:event_CalendarioCitasPropertyChange

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar CalendarioCitas;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnCubiculos;
    private javax.swing.JButton btnReportes;
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
