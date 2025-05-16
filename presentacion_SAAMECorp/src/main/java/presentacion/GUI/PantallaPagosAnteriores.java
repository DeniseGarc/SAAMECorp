/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GUI;

import dto.PsicologoDTO;
import presentacion.control.CoordinadorAplicacion;

/**
 *
 * @author Alici
 */
public class PantallaPagosAnteriores extends javax.swing.JFrame {

    /**
     * Psicologo del cual se van a mostrar sus pagos anteriores.
     */
    private final PsicologoDTO psicologo;
    /**
     * Coordinador del flujo de las pantallas
     */
    private final CoordinadorAplicacion flujoPantallas = CoordinadorAplicacion.getInstance();

    /**
     * Método que inicializa los componentes del frame y define el psicologo del
     * cual se deben mostrar sus pagos anteriores.
     *
     * @param psicologo Psicologo del cual se van a mostrar sus pagos
     * anteriores.
     */
    public PantallaPagosAnteriores(PsicologoDTO psicologo) {
        this.psicologo = psicologo;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlFondoBlanco = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBlanco.setToolTipText("");
        pnlFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTitulo.setText("Registro de pagos del mes de <mes> de <Psicologo seleccionado>");
        pnlFondoBlanco.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 700, -1));

        btnFacturar.setBackground(new java.awt.Color(86, 33, 89));
        btnFacturar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("Facturar Pago");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 280, 30));

        tblPagos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Fecha y hora del pago", "Método de pago", "Forma de pago", "Monto total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        pnlFondoBlanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 890, 500));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-30.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        jPanel1.add(pnlFondoBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 20, 990, 637));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        flujoPantallas.regresarAlMenuPrincipal(this);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        flujoPantallas.pantallaGenerarFactura(this);
    }//GEN-LAST:event_btnFacturarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFondoBlanco;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
