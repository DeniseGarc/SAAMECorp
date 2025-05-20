package presentacion.GUI;

import dto.PagoDTO;
import dto.PsicologoDTO;
import excepciones.CoordinadorException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentacion.control.CoordinadorAplicacion;
import presentacion.control.CoordinadorNegocio;
import presentacion.utilerias.FormaPago;
import presentacion.utilerias.MetodoPago;

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
    private final CoordinadorNegocio controlNegocio = CoordinadorNegocio.getInstance();

    private PagoDTO pagoRealizado;

    /**
     * Contructor que inicializa los componentes del panel
     */
    public PanelRegistroPagos() {
        initComponents();
        cargarComboBoxes();
        btnPagosAnteriores.setEnabled(false);
        btnFacturar.setEnabled(false);
        btnConfirmarPago.setEnabled(false);
        agregarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        txtCondicionesPago = new javax.swing.JTextField();
        btnConfirmarPago = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResumen = new javax.swing.JTextArea();
        btnFacturar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(221, 212, 240));

        pnlFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBlanco.setToolTipText("");
        pnlFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Selección de psicólogo");
        pnlFondoBlanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        cBoxPsicologo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxPsicologo
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione un psicólogo --" }));
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
        pnlFondoBlanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lblCantidadAdeudo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCantidadAdeudo.setText("$ <cantidad> MXN");
        pnlFondoBlanco.add(lblCantidadAdeudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 230, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Condiciones de pago");
        pnlFondoBlanco.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 200, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Forma de pago");
        pnlFondoBlanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 200, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Monto a pagar");
        pnlFondoBlanco.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 230, 20));

        cBoxFormaPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxFormaPago
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione la forma de pago --" }));
        pnlFondoBlanco.add(cBoxFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 450, 30));

        cBoxMetodoPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cBoxMetodoPago.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione el método de pago --" }));
        pnlFondoBlanco.add(cBoxMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 450, 30));

        txtCondicionesPago.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pnlFondoBlanco.add(txtCondicionesPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 450, 30));

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
        pnlFondoBlanco.add(btnConfirmarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 240, 30));

        txtAreaResumen.setColumns(20);
        txtAreaResumen.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtAreaResumen.setRows(5);
        jScrollPane1.setViewportView(txtAreaResumen);

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

        txtMonto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pnlFondoBlanco.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 240, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Método de pago");
        pnlFondoBlanco.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 807,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(pnlFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 637,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagosAnterioresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPagosAnterioresActionPerformed
        flujoPantallas.pantallaPagosAnteriores(obtenerPsicologoSeleccionado(), null);
        limpiarFormulario();
    }// GEN-LAST:event_btnPagosAnterioresActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFacturarActionPerformed
        flujoPantallas.pantallaGenerarFactura(null, pagoRealizado);
        limpiarFormulario();
    }// GEN-LAST:event_btnFacturarActionPerformed

    /**
     * Método que limpia el formulario y los campos de texto una vez se pasa a la
     * pantalla de facturar pago.
     */
    private void limpiarFormulario() {
        pagoRealizado = null;
        txtAreaResumen.setText("");
        txtCondicionesPago.setText("");
        txtMonto.setText("");
        cBoxFormaPago.setSelectedIndex(0);
        cBoxMetodoPago.setSelectedIndex(0);
        cBoxPsicologo.setSelectedIndex(0);
        btnFacturar.setEnabled(false);
    }

    private void btnConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarPagoActionPerformed
        cargarResumenPago();
        btnFacturar.setEnabled(true);
    }// GEN-LAST:event_btnConfirmarPagoActionPerformed

    /**
     * Método que obtiene el psicólogo seleccionado en el combo box.
     * 
     * @return PsicologoDTO psicologo seleccionado en el combo box.
     */
    private PsicologoDTO obtenerPsicologoSeleccionado() {
        if (cBoxPsicologo.getSelectedIndex() != 0
                && !cBoxPsicologo.getSelectedItem().equals("No hay psicólogos registrados")) {
            PsicologoDTO psicologoSeleccionado = (PsicologoDTO) cBoxPsicologo.getSelectedItem();
            return psicologoSeleccionado;
        } else {
            return null;
        }
    }

    /**
     * Método que carga el resumen del pago en el área de texto.
     */
    private void cargarResumenPago() {
        PsicologoDTO psicologo = obtenerPsicologoSeleccionado();
        FormaPago formaPago = (FormaPago) cBoxFormaPago.getSelectedItem();
        MetodoPago metodoPago = (MetodoPago) cBoxMetodoPago.getSelectedItem();
        String montoStr = txtMonto.getText();
        String condiciones = txtCondicionesPago.getText();

        if (psicologo == null || cBoxFormaPago.getSelectedIndex() == 0 || cBoxMetodoPago.getSelectedIndex() == 0
                || montoStr.isEmpty() || condiciones.isEmpty()) {
            txtAreaResumen.setText("Por favor, complete todos los campos para registrar el pago.");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "El monto ingresado no es válido. Por favor, ingrese un número válido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        PagoDTO pago = new PagoDTO();
        pago.setPsicologo(psicologo);
        pago.setFormaPago(formaPago.getClave());
        pago.setMetodoPago(metodoPago.getClave());
        pago.setMonto(monto);
        pago.setCondicionesPago(condiciones);

        StringBuilder resumen = new StringBuilder();
        resumen.append("Resumen del Pago:\n");
        resumen.append("Psicólogo: ").append(psicologo.toString()).append("\n");
        resumen.append("Forma de Pago: ").append(formaPago).append("\n");
        resumen.append("Método de Pago: ").append(metodoPago).append("\n");
        resumen.append("Monto: $").append(String.format("%.2f", monto)).append(" MXN\n");
        resumen.append("Condiciones de Pago: ").append(condiciones).append("\n");
        double adeudoAnterior = 0.0;
        try {
            adeudoAnterior = controlNegocio.obtenerCantidadAdeudoPsicologo(psicologo);
        } catch (CoordinadorException e) {
            Logger.getLogger(PanelRegistroPagos.class.getName()).log(Level.SEVERE, null, e);
        }
        double adeudoNuevo = adeudoAnterior - monto;
        if (adeudoNuevo < 0) {
            adeudoNuevo = 0;
        }
        resumen.append("Adeudo anterior: $").append(String.format("%.2f", adeudoAnterior)).append(" MXN\n");
        resumen.append("Adeudo nuevo: $").append(String.format("%.2f", adeudoNuevo)).append(" MXN\n");
        txtAreaResumen.setText(resumen.toString());

        pagoRealizado = pago;
    }

    /**
     * Método que carga los valores de los combo boxes.
     */
    private void cargarComboBoxes() {
        for (FormaPago value : FormaPago.values()) {
            cBoxFormaPago.addItem(value);
        }

        for (MetodoPago value : MetodoPago.values()) {
            cBoxMetodoPago.addItem(value);
        }
        try {
            List<PsicologoDTO> psicologos = controlNegocio.obtenerPsicologos();
            if (psicologos.isEmpty()) {
                cBoxPsicologo.addItem("No hay psicólogos registrados");
            } else {
                for (PsicologoDTO psicologo : psicologos) {
                    cBoxPsicologo.addItem(psicologo);
                }
            }

        } catch (CoordinadorException ex) {
            Logger.getLogger(PanelRegistroPagos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que agrega los listeners para los campos de texto y combo boxes.
     */
    private void agregarListeners() {
        cBoxPsicologo.addActionListener(e -> {
            PsicologoDTO psicologoSeleccionado = obtenerPsicologoSeleccionado();
            if (psicologoSeleccionado != null) {
                try {
                    lblCantidadAdeudo.setText(
                            "$ " + controlNegocio.obtenerCantidadAdeudoPsicologo(psicologoSeleccionado) + " MXN");
                } catch (CoordinadorException e1) {
                    Logger.getLogger(PanelRegistroPagos.class.getName()).log(Level.SEVERE, null, e1);
                }
                actualizarBtnConfirmar();
                btnPagosAnteriores.setEnabled(true);
            } else {
                btnPagosAnteriores.setEnabled(false);
                lblCantidadAdeudo.setText("$ 0.00 MXN");
            }
        });

        cBoxFormaPago.addActionListener(e -> {
            if (cBoxFormaPago.getSelectedIndex() != 0) {
                cBoxMetodoPago.setEnabled(true);
            } else {
                cBoxMetodoPago.setEnabled(false);
            }
        });

        cBoxMetodoPago.addActionListener(e -> {
            actualizarBtnConfirmar();

        });

        txtCondicionesPago.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }
        });

        txtMonto.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBtnConfirmar();
            }
        });
    }

    /**
     * Metodo que actualiza el estado del botón de confirmar pago.
     */
    private void actualizarBtnConfirmar() {
        boolean habilitar = cBoxFormaPago.getSelectedIndex() != 0
                && cBoxMetodoPago.getSelectedIndex() != 0 && !txtCondicionesPago.getText().isEmpty()
                && !txtMonto.getText().isEmpty() && cBoxPsicologo.getSelectedIndex() != 0;

        btnConfirmarPago.setEnabled(habilitar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarPago;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnPagosAnteriores;
    private javax.swing.JComboBox<Object> cBoxFormaPago;
    private javax.swing.JComboBox<Object> cBoxMetodoPago;
    private javax.swing.JComboBox<Object> cBoxPsicologo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadAdeudo;
    private javax.swing.JPanel pnlFondoBlanco;
    private javax.swing.JTextArea txtAreaResumen;
    private javax.swing.JTextField txtCondicionesPago;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
