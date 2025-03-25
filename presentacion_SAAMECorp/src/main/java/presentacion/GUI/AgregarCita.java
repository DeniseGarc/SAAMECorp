/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GUI;

import dto.CitaNuevaDTO;
import dto.PsicologoDTO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import presentacion.control.CoordinadorAplicacion;
import presentacion.control.CoordinadorNegocio;
import presentacion.sesion.GestorSesion;
import presentacion.sesion.TipoUsuario;

/**
 *
 * @author Alici
 */
public class AgregarCita extends javax.swing.JFrame {

    private final Date fechaCita;
    //crear instancia del control de la aplicacion para poder usar los metodos
    private final CoordinadorAplicacion control = new CoordinadorAplicacion();
    CoordinadorNegocio controlNegocio = new CoordinadorNegocio();
    private final List<PsicologoDTO> psicologos;

    public AgregarCita(Date fechaSeleccionada) {
        this.fechaCita = fechaSeleccionada;
        this.psicologos = controlNegocio.mostrarPsicologos(fechaCita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        initComponents();
        agregarListeners();
        btnConfirmar.setEnabled(false);
        SimpleDateFormat formato = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
        lblFechaCita.setText(formato.format(fechaCita));
        if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
            llenarComboPsicologos();
        } else {
            seleccionarPsicologoUsuario();

        }
        if (cmbPsicologos.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay psicologos disponibles en el momento", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
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
        jPanel4 = new javax.swing.JPanel();
        lblPsicologo = new javax.swing.JLabel();
        cmbPsicologos = new javax.swing.JComboBox<>();
        lblHorario = new javax.swing.JLabel();
        cmbHorarios = new javax.swing.JComboBox<>();
        cmbCubiculo = new javax.swing.JComboBox<>();
        lblCubiculo = new javax.swing.JLabel();
        lblNombrePaciente = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        lblTelefonoPaciente = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        lblTelefonoPaciente1 = new javax.swing.JLabel();
        txtCorreoPaciente = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblFechaCita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(221, 212, 240));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(221, 212, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 680));

        jPanel3.setBackground(new java.awt.Color(188, 163, 226));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitulo.setText("Agendar Cita");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(959, Short.MAX_VALUE))
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
            .addComponent(btnCubiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(850, 550));

        lblPsicologo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPsicologo.setForeground(new java.awt.Color(0, 0, 0));
        lblPsicologo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPsicologo.setText("Psicologo");

        cmbPsicologos.setBackground(new java.awt.Color(255, 255, 255));
        cmbPsicologos.setForeground(new java.awt.Color(0, 0, 0));

        lblHorario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblHorario.setForeground(new java.awt.Color(0, 0, 0));
        lblHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorario.setText("Horario");

        cmbHorarios.setBackground(new java.awt.Color(255, 255, 255));
        cmbHorarios.setForeground(new java.awt.Color(0, 0, 0));

        cmbCubiculo.setBackground(new java.awt.Color(255, 255, 255));
        cmbCubiculo.setForeground(new java.awt.Color(0, 0, 0));

        lblCubiculo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCubiculo.setForeground(new java.awt.Color(0, 0, 0));
        lblCubiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCubiculo.setText("Cubiculo");

        lblNombrePaciente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombrePaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrePaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombrePaciente.setText("Nombre del Paciente");

        txtNombrePaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePaciente.setForeground(new java.awt.Color(0, 0, 0));

        lblTelefonoPaciente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTelefonoPaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefonoPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefonoPaciente.setText("Telefono del Paciente");

        txtTelefonoPaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoPaciente.setForeground(new java.awt.Color(0, 0, 0));

        lblTelefonoPaciente1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTelefonoPaciente1.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefonoPaciente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefonoPaciente1.setText("Correo del Paciente");

        txtCorreoPaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoPaciente.setForeground(new java.awt.Color(0, 0, 0));

        btnConfirmar.setBackground(new java.awt.Color(86, 33, 89));
        btnConfirmar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorder(null);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-30.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblFechaCita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaCita.setForeground(new java.awt.Color(0, 0, 0));
        lblFechaCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaCita.setText("FECHA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreoPaciente)
                                .addComponent(txtTelefonoPaciente)
                                .addComponent(lblTelefonoPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCubiculo, 0, 602, Short.MAX_VALUE)
                                .addComponent(lblCubiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbHorarios, 0, 602, Short.MAX_VALUE)
                                .addComponent(lblHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbPsicologos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPsicologo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombrePaciente)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblFechaCita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPsicologo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPsicologos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCubiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCubiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombrePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelefonoPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonoPaciente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        mostrarResumenCita();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        control.pantallaCalendarioCitas(this);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private CitaNuevaDTO obtenerDatosCita() {
        return new CitaNuevaDTO(
                obtenerFechaHoraCita(),
                cmbCubiculo.getSelectedItem().toString(),
                (PsicologoDTO) cmbPsicologos.getSelectedItem(),
                txtNombrePaciente.getText(),
                txtTelefonoPaciente.getText(),
                txtCorreoPaciente.getText()
        );
    }

    private void seleccionarPsicologoUsuario() {
        cmbPsicologos.addItem(controlNegocio.mostrarPsicologo(GestorSesion.getIdentificadorUsuario()));
        cmbPsicologos.setEnabled(false);
    }

    private void mostrarResumenCita() {
        CitaNuevaDTO cita = obtenerDatosCita(); // Método que obtiene los datos de la UI
        String mensaje = controlNegocio.obtenerResumenCita(cita);

        if (!mensaje.startsWith("¿Desea agendar la cita?")) {
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showOptionDialog(
                this,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Cancelar", "Aceptar"},
                "Aceptar"
        );

        if (opcion == 1) {
            if (controlNegocio.agendarCita(cita)) {
                JOptionPane.showMessageDialog(null, "La cita ha sido agendada, se ha mandado un correo al psicológo para su confirmación", "Cita agendada exitosamente", JOptionPane.INFORMATION_MESSAGE);
                control.pantallaCalendarioCitas(this);
            } else {
                JOptionPane.showMessageDialog(null, "Error al agendar cita", "No se ha podido agendar la cita", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void llenarComboPsicologos() {
        cmbPsicologos.removeAllItems();
        for (PsicologoDTO psicologo : psicologos) {
            cmbPsicologos.addItem(psicologo);
        }
    }

    private void llenarComboHorariosPsicologo(PsicologoDTO psicologoSeleccionado) {
        cmbHorarios.removeAllItems();
        cmbHorarios.setEnabled(true);
        for (LocalTime hora : psicologoSeleccionado.getHorarioDia()) {
            cmbHorarios.addItem(hora);
        }
    }

    private LocalDateTime obtenerFechaHoraCita() {
        LocalTime horaSeleccionada = (LocalTime) cmbHorarios.getSelectedItem();
        LocalDate fechaCitaLocal = fechaCita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return LocalDateTime.of(fechaCitaLocal, horaSeleccionada);
    }

    private void llenarComboCubiculos() {
        cmbCubiculo.removeAllItems();
        cmbCubiculo.setEnabled(true);
        List<String> cubiculos = controlNegocio.mostrarCubiculos(obtenerFechaHoraCita());
        for (String cubiculo : cubiculos) {
            cmbCubiculo.addItem(cubiculo);
        }
    }

    private void actualizarEstadoBoton() {
        boolean camposLlenos = !txtNombrePaciente.getText().trim().isEmpty()
                && !txtCorreoPaciente.getText().trim().isEmpty()
                && !txtTelefonoPaciente.getText().trim().isEmpty()
                && cmbCubiculo.getSelectedIndex() != -1
                && cmbPsicologos.getSelectedIndex() != -1
                && cmbHorarios.getSelectedIndex() != -1;

        btnConfirmar.setEnabled(camposLlenos);

    }

    private void agregarListeners() {
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }
        };
        txtNombrePaciente.getDocument().addDocumentListener(listener);
        txtCorreoPaciente.getDocument().addDocumentListener(listener);
        txtTelefonoPaciente.getDocument().addDocumentListener(listener);

        // Listener para cBoxEspecialidad
        cmbPsicologos.addItemListener(e -> {
            if (cmbPsicologos.getSelectedIndex() != -1) {
                PsicologoDTO psicologoSeleccionado = (PsicologoDTO) cmbPsicologos.getSelectedItem();
                if (controlNegocio.validarAdeudoPsicologoSeleccionado(psicologoSeleccionado)) {
                    llenarComboHorariosPsicologo(psicologoSeleccionado);
                } else {
                    if (GestorSesion.getTipoUsuario() == TipoUsuario.ADMIN) {
                        cmbPsicologos.removeItem(psicologoSeleccionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usted presenta un adeudo de 500 o mayor, por lo que no es posible agendar una cita", "No le es posible agendar cita en este momento", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                cmbHorarios.setEnabled(false);
                cmbCubiculo.setEnabled(false);
            }
        });

        // Listener para cBoxMedico
        cmbHorarios.addItemListener(e -> {
            if (cmbHorarios.getSelectedIndex() != -1) {
                llenarComboCubiculos();
            } else {
                cmbCubiculo.setEnabled(false);
            }
        });
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnCubiculos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cmbCubiculo;
    private javax.swing.JComboBox<LocalTime> cmbHorarios;
    private javax.swing.JComboBox<PsicologoDTO> cmbPsicologos;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblCubiculo;
    private javax.swing.JLabel lblCubiculos;
    private javax.swing.JLabel lblFechaCita;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNombrePaciente;
    private javax.swing.JLabel lblPsicologo;
    private javax.swing.JLabel lblPsicologos;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTelefonoPaciente;
    private javax.swing.JLabel lblTelefonoPaciente1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCorreoPaciente;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
