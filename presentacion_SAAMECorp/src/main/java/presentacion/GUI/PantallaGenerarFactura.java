package presentacion.GUI;

import javax.swing.JFrame;
import presentacion.control.CoordinadorAplicacion;

/**
 * Frame que representa la pantalla de la aplicación donde se registran los
 * datos para generar la factura del pago.
 *
 * @author Alici
 */
public class PantallaGenerarFactura extends javax.swing.JFrame {

    /**
     * Coordinador del flujo de pantallas de la aplicación.
     */
    private final CoordinadorAplicacion flujoPantallas = CoordinadorAplicacion.getInstance();
    private JFrame frmPadre;

    /**
     * Constructor que inicializa los componentes de la clase.
     */
    public PantallaGenerarFactura(JFrame frmPadre) {
        this.frmPadre = frmPadre;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBanner = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlFondoBlanco = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnGenerarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1101, 752));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));

        pnlBanner.setBackground(new java.awt.Color(188, 163, 226));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitulo.setText("Generar factura");

        javax.swing.GroupLayout pnlBannerLayout = new javax.swing.GroupLayout(pnlBanner);
        pnlBanner.setLayout(pnlBannerLayout);
        pnlBannerLayout.setHorizontalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBannerLayout.setVerticalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pnlFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-30.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setFocusable(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 30));

        btnGenerarFactura.setBackground(new java.awt.Color(86, 33, 89));
        btnGenerarFactura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnGenerarFactura.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.setBorder(null);
        btnGenerarFactura.setPreferredSize(new java.awt.Dimension(64, 19));
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        pnlFondoBlanco.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 820, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (frmPadre == null) {
            flujoPantallas.regresarAlMenuPrincipal(this);
        } else {
            flujoPantallas.pantallaPagosAnteriores(null, this);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlFondoBlanco;
    // End of variables declaration//GEN-END:variables
}
