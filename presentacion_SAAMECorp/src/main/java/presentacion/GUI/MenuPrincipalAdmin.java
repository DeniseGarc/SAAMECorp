/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GUI;

import java.awt.CardLayout;
import javax.swing.JPanel;
import presentacion.control.CoordinadorAplicacion;

/**
 * Clase que representa el Frame de la pantalla de inicio del usuario
 * administrador en el sistema.
 *
 * @author Alici
 */
public class MenuPrincipalAdmin extends javax.swing.JFrame {

    /**
     * CardLayaout del panel en donde se van mostrando las pantallas según el
     * boton seleccionado.
     */
    private final CardLayout cardLayout;
    /**
     * Coordinador de las pantallas.
     */
    private final CoordinadorAplicacion flujoPantallas = CoordinadorAplicacion.getInstance();

    /**
     * Constructor que inicializa los componentes del frame y agrega los paneles
     * al CardLayout del panel lateral.
     */
    public MenuPrincipalAdmin() {
        initComponents();
        cardLayout = (CardLayout) panelLateral.getLayout();
        agregarPanelesLateral();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateral = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCitas1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnReportes1 = new javax.swing.JButton();
        btnCubiculos1 = new javax.swing.JButton();
        lblCitas1 = new javax.swing.JLabel();
        lblReportes1 = new javax.swing.JLabel();
        lblPsicologos1 = new javax.swing.JLabel();
        lblCubiculos2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPagos1 = new javax.swing.JButton();
        lblCubiculos3 = new javax.swing.JLabel();
        btnAjustes1 = new javax.swing.JButton();
        lblCubiculos4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLateral.setBackground(new java.awt.Color(221, 212, 240));
        panelLateral.setForeground(new java.awt.Color(221, 212, 240));
        panelLateral.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1010, 680));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setVerifyInputWhenFocusTarget(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCitas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-lista-50.png"))); // NOI18N
        btnCitas1.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnCitas1.setBorderPainted(false);
        btnCitas1.setContentAreaFilled(false);
        btnCitas1.setFocusPainted(false);
        btnCitas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitas1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 51));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/team.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 80, -1));

        btnReportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-carpeta-50.png"))); // NOI18N
        btnReportes1.setBorderPainted(false);
        btnReportes1.setContentAreaFilled(false);
        btnReportes1.setFocusable(false);
        jPanel3.add(btnReportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 297, 80, -1));

        btnCubiculos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-estrella-50.png"))); // NOI18N
        btnCubiculos1.setBorderPainted(false);
        btnCubiculos1.setContentAreaFilled(false);
        btnCubiculos1.setFocusPainted(false);
        btnCubiculos1.setFocusable(false);
        btnCubiculos1.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanel3.add(btnCubiculos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 70, 46));

        lblCitas1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCitas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas1.setText("Citas");
        jPanel3.add(lblCitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        lblReportes1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblReportes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportes1.setText("Reportes");
        jPanel3.add(lblReportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        lblPsicologos1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPsicologos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPsicologos1.setText("Psicologos");
        jPanel3.add(lblPsicologos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, -1));

        lblCubiculos2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCubiculos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculos2.setText("Usuario");
        jPanel3.add(lblCubiculos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 70, 70, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-user-50.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, -1, -1));

        btnPagos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/payment-icon-flatelements 1.png"))); // NOI18N
        btnPagos1.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnPagos1.setBorderPainted(false);
        btnPagos1.setContentAreaFilled(false);
        btnPagos1.setFocusable(false);
        btnPagos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagos1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPagos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 70, -1));

        lblCubiculos3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCubiculos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculos3.setText("Pagos");
        jPanel3.add(lblCubiculos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 70, -1));

        btnAjustes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container(1).png"))); // NOI18N
        btnAjustes1.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnAjustes1.setBorderPainted(false);
        btnAjustes1.setContentAreaFilled(false);
        btnAjustes1.setFocusable(false);
        jPanel3.add(btnAjustes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 70, 60));

        lblCubiculos4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCubiculos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculos4.setText("Cubiculos");
        jPanel3.add(lblCubiculos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 70, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitas1ActionPerformed
        flujoPantallas.pantallaCalendarioCitas(null);
    }//GEN-LAST:event_btnCitas1ActionPerformed

    private void btnPagos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagos1ActionPerformed
    }//GEN-LAST:event_btnPagos1ActionPerformed

    public void agregarPanelesLateral() {
        panelLateral.add(new PanelBienvenida(), "pantallaBienvenida");
        panelLateral.add(new CalendarioCitas(), "pantallaCalendarioCitas");
    }

    public JPanel getPanelLateral() {
        return panelLateral;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes1;
    private javax.swing.JButton btnCitas1;
    private javax.swing.JButton btnCubiculos1;
    private javax.swing.JButton btnPagos1;
    private javax.swing.JButton btnReportes1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCitas1;
    private javax.swing.JLabel lblCubiculos2;
    private javax.swing.JLabel lblCubiculos3;
    private javax.swing.JLabel lblCubiculos4;
    private javax.swing.JLabel lblPsicologos1;
    private javax.swing.JLabel lblReportes1;
    private javax.swing.JPanel panelLateral;
    // End of variables declaration//GEN-END:variables
}
