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
        pnlFondoBarra = new javax.swing.JPanel();
        btnCitas = new javax.swing.JButton();
        btnPsicologos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCubiculos = new javax.swing.JButton();
        lblCitas = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();
        lblPsicologos = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblIconoUsuario = new javax.swing.JLabel();
        btnPagos = new javax.swing.JButton();
        lblPagos = new javax.swing.JLabel();
        btnAjustes = new javax.swing.JButton();
        lblCubiculos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLateral.setBackground(new java.awt.Color(221, 212, 240));
        panelLateral.setForeground(new java.awt.Color(221, 212, 240));
        panelLateral.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1010, 680));

        pnlFondoBarra.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBarra.setVerifyInputWhenFocusTarget(false);
        pnlFondoBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-lista-50.png"))); // NOI18N
        btnCitas.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnCitas.setBorderPainted(false);
        btnCitas.setContentAreaFilled(false);
        btnCitas.setFocusPainted(false);
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });
        pnlFondoBarra.add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 51));

        btnPsicologos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/gmail_groups.png"))); // NOI18N
        btnPsicologos.setBorderPainted(false);
        btnPsicologos.setContentAreaFilled(false);
        btnPsicologos.setFocusPainted(false);
        btnPsicologos.setFocusable(false);
        btnPsicologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPsicologosActionPerformed(evt);
            }
        });
        pnlFondoBarra.add(btnPsicologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 70, 60));

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-carpeta-50.png"))); // NOI18N
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setFocusable(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        pnlFondoBarra.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 70, -1));

        btnCubiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-cubiculo.png"))); // NOI18N
        btnCubiculos.setBorderPainted(false);
        btnCubiculos.setContentAreaFilled(false);
        btnCubiculos.setFocusPainted(false);
        btnCubiculos.setFocusable(false);
        btnCubiculos.setPreferredSize(new java.awt.Dimension(60, 60));
        btnCubiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCubiculosMouseClicked(evt);
            }
        });
        pnlFondoBarra.add(btnCubiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 70, 46));

        lblCitas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Citas");
        pnlFondoBarra.add(lblCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        lblReportes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportes.setText("Reportes");
        pnlFondoBarra.add(lblReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lblPsicologos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPsicologos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPsicologos.setText("Psicologos");
        pnlFondoBarra.add(lblPsicologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, -1));

        lblUsername.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Usuario");
        pnlFondoBarra.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 70, 70, -1));

        lblIconoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-user-50.png"))); // NOI18N
        pnlFondoBarra.add(lblIconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, -1, -1));

        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-pagos.png"))); // NOI18N
        btnPagos.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnPagos.setBorderPainted(false);
        btnPagos.setContentAreaFilled(false);
        btnPagos.setFocusable(false);
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        pnlFondoBarra.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 70, -1));

        lblPagos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPagos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagos.setText("Pagos");
        pnlFondoBarra.add(lblPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 70, -1));

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-ajustes.png"))); // NOI18N
        btnAjustes.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.setFocusable(false);
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });
        pnlFondoBarra.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 70, 60));

        lblCubiculos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCubiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculos.setText("Cubiculos");
        pnlFondoBarra.add(lblCubiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 70, -1));

        getContentPane().add(pnlFondoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        flujoPantallas.pantallaCalendarioCitas(null);
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        flujoPantallas.pantallaRegistroPagos();
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnPsicologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPsicologosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPsicologosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjustesActionPerformed

    private void btnCubiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCubiculosMouseClicked
        flujoPantallas.PantallaGestionCubiculos(this);
    }//GEN-LAST:event_btnCubiculosMouseClicked

    /**
     * Método para agregar los paneles al CardLayout del panel lateral del menú.
     */
    public void agregarPanelesLateral() {
        panelLateral.add(new PanelBienvenida(), "pantallaBienvenida");
        panelLateral.add(new PanelCalendarioCitas(), "pantallaCalendarioCitas");
        panelLateral.add(new PanelRegistroPagos(), "pantallaRegistroPagos");
    }

    /**
     * Método que regresa el panel lateral el cual tiene un CardLayout donde se
     * muestran las pantallas del menú de la barra lateral izquierda.
     *
     * @return Panel lateral derecho donde aparecen las pantallas según lo
     * seleccionado en el menú.
     */
    public JPanel getPanelLateral() {
        return panelLateral;
    }

    /**
     * CardLayout del panel lateral donde aparecen las pantallas según lo
     * seleccionado en el menú lateral izquierdo.
     *
     * @return CardLayout del panel.
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnCubiculos;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnPsicologos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblCubiculos;
    private javax.swing.JLabel lblIconoUsuario;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblPsicologos;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel pnlFondoBarra;
    // End of variables declaration//GEN-END:variables
}
