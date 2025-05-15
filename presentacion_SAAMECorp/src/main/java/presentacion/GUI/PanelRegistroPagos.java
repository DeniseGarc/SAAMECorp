package presentacion.GUI;

import presentacion.control.CoordinadorAplicacion;

/**
 * Clase que representa el panel donde se registran los pagos realizados en el
 * mostrador del consultorio.
 *
 * @author Alici
 */
public class PanelRegistroPagos extends javax.swing.JPanel {

    /**
     * Coordinador del flujo de las pantallas
     */
    private final CoordinadorAplicacion flujoPantallas = CoordinadorAplicacion.getInstance();

    /**
     * Contructor que inicializa los componentes del panel
     */
    public PanelRegistroPagos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoBlanco = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cBoxPsicologo = new javax.swing.JComboBox<>();
        btnPagosAnteriores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCantidadAdeudo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cBoxFormaPago = new javax.swing.JComboBox<>();
        cBoxMetodoPago = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        btnConfirmarPago = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnFacturar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(221, 212, 240));

        pnlFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBlanco.setToolTipText("");
        pnlFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Selección de psicólogo");
        pnlFondoBlanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        cBoxPsicologo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxPsicologo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondoBlanco.add(cBoxPsicologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 300, 30));

        btnPagosAnteriores.setBackground(new java.awt.Color(86, 33, 89));
        btnPagosAnteriores.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnPagosAnteriores.setForeground(new java.awt.Color(255, 255, 255));
        btnPagosAnteriores.setText("Pagos anteriores");
        btnPagosAnteriores.setBorder(new com.formdev.flatlaf.ui.FlatButtonBorder());
        btnPagosAnteriores.setBorderPainted(false);
        btnPagosAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosAnterioresActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnPagosAnteriores, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 200, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad de adeudo:");
        pnlFondoBlanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lblCantidadAdeudo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCantidadAdeudo.setText("$ <cantidad> MXN");
        pnlFondoBlanco.add(lblCantidadAdeudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 230, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Método de pago");
        pnlFondoBlanco.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 200, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Forma de pago");
        pnlFondoBlanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 200, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Monto a pagar");
        pnlFondoBlanco.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 230, 20));

        cBoxFormaPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondoBlanco.add(cBoxFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 450, 30));

        cBoxMetodoPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondoBlanco.add(cBoxMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 450, 30));

        txtMonto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pnlFondoBlanco.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 240, 30));

        btnConfirmarPago.setBackground(new java.awt.Color(86, 33, 89));
        btnConfirmarPago.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnConfirmarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarPago.setText("Confirmar pago");
        btnConfirmarPago.setBorderPainted(false);
        btnConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagoActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnConfirmarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 450, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        pnlFondoBlanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 700, 220));

        btnFacturar.setBackground(new java.awt.Color(86, 33, 89));
        btnFacturar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("Generar factura");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 573, 700, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Resumen del pago");
        pnlFondoBlanco.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagosAnterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosAnterioresActionPerformed
        flujoPantallas.pantallaPagosAnteriores(null, null);
    }//GEN-LAST:event_btnPagosAnterioresActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        flujoPantallas.pantallaGenerarFactura(null);
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarPago;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnPagosAnteriores;
    private javax.swing.JComboBox<String> cBoxFormaPago;
    private javax.swing.JComboBox<String> cBoxMetodoPago;
    private javax.swing.JComboBox<String> cBoxPsicologo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCantidadAdeudo;
    private javax.swing.JPanel pnlFondoBlanco;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
