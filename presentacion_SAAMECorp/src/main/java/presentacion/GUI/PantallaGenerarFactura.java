package presentacion.GUI;

import dto.FacturaDTO;
import dto.PagoDTO;
import excepciones.CoordinadorException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.control.CoordinadorAplicacion;
import presentacion.control.CoordinadorNegocio;
import presentacion.utilerias.ClaveCFDI;
import presentacion.utilerias.RegimenFiscal;

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
    CoordinadorNegocio controlNegocio = CoordinadorNegocio.getInstance();
    private JFrame frmPadre;
    private FacturaDTO factura = new FacturaDTO();

    /**
     * Constructor que inicializa los componentes de la clase.
     */
    public PantallaGenerarFactura(JFrame frmPadre, PagoDTO pago) {
        this.frmPadre = frmPadre;
        initComponents();
        cargarComboBoxes();
        cargarDatosFactura(pago);
    }

    /**
     * Metodo que carga los datos de los comboBox de regimen fiscal y uso del
     * CFDI.
     */
    private void cargarComboBoxes() {
        for (ClaveCFDI value : ClaveCFDI.values()) {
            cBoxUsoCfdi.addItem(value);
        }
        for (RegimenFiscal value : RegimenFiscal.values()) {
            cboxRegimenFiscal.addItem(value);
        }
    }

    /**
     * Método que carga los datos predeterminados de la factura en los labels
     * correspondientes.
     */
    private void cargarDatosFactura(PagoDTO pago) {
        FacturaDTO factura = armarFactura(pago);

        // emisor
        lblLugarExpedicion.setText(factura.getExpeditionPlace());
        lblTipoCFDI.setText(factura.getCfdiType());
        // pago
        lblFormaPago.setText(factura.getPaymentForm());
        lblMetodoPago.setText(factura.getPaymentMethod());
        lblCondicionesPago.setText(factura.getPaymentConditions());
        lblMontoTotal.setText(String.valueOf(factura.getTotal()));
        lblMoneda.setText(factura.getCurrency());
        // receptor
        lblRfcReceptor.setText(factura.getRfcReceiver());
        lblNombreReceptor.setText(factura.getNameReceiver());
        lblEmailReceptor.setText(factura.getEmailReceiver());
        // producto
        lblClaveProducto.setText(factura.getProductCode());
        lblDescripcionProducto.setText(factura.getDescription());
        lblUnidadProducto.setText(factura.getUnitCode() + " - " + factura.getUnit());
        lblPrecioUnitario.setText(String.valueOf(factura.getUnitPrice()));
        lblCantidadProducto.setText(String.valueOf(factura.getQuantity()));
        lblSubtotal.setText(String.valueOf(factura.getSubtotal()));
        lblTotal.setText(String.valueOf(factura.getTotal()));
    }

    /**
     * Método que arma la factura a partir de un pago y los datos del psicólogo.
     */
    private FacturaDTO armarFactura(PagoDTO pago) {
        factura.setPaymentConditions(pago.getCondicionesPago());
        factura.setPaymentForm(pago.getFormaPago());
        factura.setPaymentMethod(pago.getMetodoPago());
        factura.setQuantity(Double.valueOf(pago.getCantidad()));
        factura.setUnitPrice(pago.getPrecioUnitario());
//        factura.setRfcReceiver(pago.getPsicologo().getRfc());
//        factura.setNameReceiver(pago.getPsicologo().getNombre() + " " + pago.getPsicologo().getApellidoPaterno() + "" + " " + pago.getPsicologo().getApellidoMaterno());
//        factura.setEmailReceiver(pago.getPsicologo().getCorreo());

        return factura;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBanner = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlFondoBlanco = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnGenerarFactura = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCPReceptor = new javax.swing.JTextField();
        tabbedPane = new javax.swing.JTabbedPane();
        pnlDatosEmisor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLugarExpedicion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTipoCFDI = new javax.swing.JLabel();
        pnlDatosPago = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblFormaPago = new javax.swing.JLabel();
        lblMetodoPago = new javax.swing.JLabel();
        lblCondicionesPago = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblMoneda = new javax.swing.JLabel();
        pnlDatosReceptor = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblRfcReceptor = new javax.swing.JLabel();
        lblNombreReceptor = new javax.swing.JLabel();
        lblEmailReceptor = new javax.swing.JLabel();
        pnlDatosProducto = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblClaveProducto = new javax.swing.JLabel();
        lblDescripcionProducto = new javax.swing.JLabel();
        lblUnidadProducto = new javax.swing.JLabel();
        lblPrecioUnitario = new javax.swing.JLabel();
        lblCantidadProducto = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        cboxRegimenFiscal = new javax.swing.JComboBox<>(RegimenFiscal.values());
        cBoxUsoCfdi = new javax.swing.JComboBox<>(ClaveCFDI.values());
        jLabel6 = new javax.swing.JLabel();

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Régimen fiscal");
        pnlFondoBlanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 300, 20));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Complemento de los datos del receptor");
        pnlFondoBlanco.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 300, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Código postal del receptor");
        pnlFondoBlanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 300, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Uso del CFDI");
        pnlFondoBlanco.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 300, 20));

        txtCPReceptor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pnlFondoBlanco.add(txtCPReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 380, 30));

        tabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        pnlDatosEmisor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDatosEmisor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Lugar de expedición:");
        pnlDatosEmisor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, -1));

        lblLugarExpedicion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblLugarExpedicion.setText("jLabel7");
        pnlDatosEmisor.add(lblLugarExpedicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Tipo CFDI:");
        pnlDatosEmisor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblTipoCFDI.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTipoCFDI.setText("jLabel9");
        pnlDatosEmisor.add(lblTipoCFDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        tabbedPane.addTab("Emisor", pnlDatosEmisor);

        pnlDatosPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Forma de pago:");
        pnlDatosPago.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Método de pago:");
        pnlDatosPago.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Condiciones del pago:");
        pnlDatosPago.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Monto total:");
        pnlDatosPago.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lblFormaPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblFormaPago.setText("jLabel12");
        pnlDatosPago.add(lblFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblMetodoPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblMetodoPago.setText("jLabel12");
        pnlDatosPago.add(lblMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblCondicionesPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCondicionesPago.setText("jLabel12");
        pnlDatosPago.add(lblCondicionesPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lblMontoTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblMontoTotal.setText("jLabel12");
        pnlDatosPago.add(lblMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("Moneda");
        pnlDatosPago.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        lblMoneda.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblMoneda.setText("jLabel19");
        pnlDatosPago.add(lblMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        tabbedPane.addTab("Pago", pnlDatosPago);

        pnlDatosReceptor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("RFC receptor:");
        pnlDatosReceptor.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 19, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Nombre del receptor:");
        pnlDatosReceptor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Email del receptor:");
        pnlDatosReceptor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lblRfcReceptor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblRfcReceptor.setText("jLabel15");
        pnlDatosReceptor.add(lblRfcReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblNombreReceptor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombreReceptor.setText("jLabel15");
        pnlDatosReceptor.add(lblNombreReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lblEmailReceptor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblEmailReceptor.setText("jLabel15");
        pnlDatosReceptor.add(lblEmailReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        tabbedPane.addTab("Receptor", pnlDatosReceptor);

        pnlDatosProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Clave de producto o servicio:");
        pnlDatosProducto.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 19, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("Descripción del producto:");
        pnlDatosProducto.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Unidad del producto:");
        pnlDatosProducto.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Precio unitario:");
        pnlDatosProducto.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("Cantidad:");
        pnlDatosProducto.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        lblClaveProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblClaveProducto.setText("jLabel21");
        pnlDatosProducto.add(lblClaveProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, -1));

        lblDescripcionProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblDescripcionProducto.setText("jLabel22");
        pnlDatosProducto.add(lblDescripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, -1));

        lblUnidadProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUnidadProducto.setText("jLabel23");
        pnlDatosProducto.add(lblUnidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 360, -1));

        lblPrecioUnitario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPrecioUnitario.setText("jLabel24");
        pnlDatosProducto.add(lblPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, -1));

        lblCantidadProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCantidadProducto.setText("jLabel25");
        pnlDatosProducto.add(lblCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 70, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setText("Total:");
        pnlDatosProducto.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 80, -1));

        lblTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTotal.setText("jLabel19");
        pnlDatosProducto.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 80, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setText("Subtotal:");
        pnlDatosProducto.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 80, -1));

        lblSubtotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblSubtotal.setText("jLabel19");
        pnlDatosProducto.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 80, -1));

        tabbedPane.addTab("Producto", pnlDatosProducto);

        pnlFondoBlanco.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 500, 390));

        cboxRegimenFiscal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboxRegimenFiscal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione el regimen fiscal--" }));
        pnlFondoBlanco.add(cboxRegimenFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 380, 30));

        cBoxUsoCfdi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cBoxUsoCfdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione el uso del CFDI--" }));
        cBoxUsoCfdi.setBorder(new com.formdev.flatlaf.ui.FlatBorder());
        pnlFondoBlanco.add(cBoxUsoCfdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 380, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Información predeterminada de la factura");
        pnlFondoBlanco.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 300, 20));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegresarActionPerformed
        if (frmPadre == null) {
            flujoPantallas.regresarAlMenuPrincipal(this);
        } else {
            flujoPantallas.pantallaPagosAnteriores(null, this);
        }
    }// GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Método que genera la factura a partir de los datos ingresados por el
     * usuario y manda a realizar la factura.
     */
    private void generarFactura() {
        String cpReceptor = txtCPReceptor.getText();
        if (cpReceptor.isBlank()) {
            JOptionPane.showMessageDialog(this, "El campo de código postal no puede estar vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String usoCFDI = ((ClaveCFDI) cBoxUsoCfdi.getSelectedItem()).getClave();
        String regimenFiscal = ((RegimenFiscal) cboxRegimenFiscal.getSelectedItem()).getClave();
        if (usoCFDI.isBlank()) {
            JOptionPane.showMessageDialog(this, "El campo de uso del CFDI no puede estar vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (regimenFiscal.isBlank()) {
            JOptionPane.showMessageDialog(this, "El campo de régimen fiscal no puede estar vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        factura.setTaxZipCode(cpReceptor);
        factura.setCfdiUse(usoCFDI);
        factura.setFiscalRegime(regimenFiscal);

        try {
            FacturaDTO facturaRegistrada = controlNegocio.generarFactura(factura);
            if (facturaRegistrada != null) {
                JOptionPane.showMessageDialog(this, "Factura generada con éxito", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                Object[] options = {"Aceptar", "Descargar PDF", "Descargar XML"};
                int result = JOptionPane.showOptionDialog(
                        this,
                        "Factura generada con éxito",
                        "Éxito",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (result == 0) {
                    flujoPantallas.regresarAlMenuPrincipal(this);
                } else if (result == 1) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Guardar PDF");
                    fileChooser.setSelectedFile(new java.io.File("Factura_" + facturaRegistrada.getFolio()));
                    int userSelection = fileChooser.showSaveDialog(this);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                        controlNegocio.descargarPDF(facturaRegistrada, filePath);
                    } else {
                        JOptionPane.showMessageDialog(this, "Descarga cancelada", "Información",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (result == 2) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Guardar XML");
                    fileChooser.setSelectedFile(new java.io.File("Factura_" + facturaRegistrada.getFolio()));
                    int userSelection = fileChooser.showSaveDialog(this);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                        controlNegocio.descargarXML(facturaRegistrada, filePath);
                    } else {
                        JOptionPane.showMessageDialog(this, "Descarga cancelada", "Información",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al generar la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (CoordinadorException e) {
            JOptionPane.showMessageDialog(this, "Error al generar la factura: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Generar Factura".
     *
     * @param evt Evento de acción.
     */
    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGenerarFacturaActionPerformed
        generarFactura();
    }// GEN-LAST:event_btnGenerarFacturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Object> cBoxUsoCfdi;
    private javax.swing.JComboBox<Object> cboxRegimenFiscal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblClaveProducto;
    private javax.swing.JLabel lblCondicionesPago;
    private javax.swing.JLabel lblDescripcionProducto;
    private javax.swing.JLabel lblEmailReceptor;
    private javax.swing.JLabel lblFormaPago;
    private javax.swing.JLabel lblLugarExpedicion;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombreReceptor;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JLabel lblRfcReceptor;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTipoCFDI;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnidadProducto;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlDatosEmisor;
    private javax.swing.JPanel pnlDatosPago;
    private javax.swing.JPanel pnlDatosProducto;
    private javax.swing.JPanel pnlDatosReceptor;
    private javax.swing.JPanel pnlFondoBlanco;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField txtCPReceptor;
    // End of variables declaration//GEN-END:variables
}
