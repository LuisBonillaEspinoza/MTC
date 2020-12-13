package tunelmtc;

import Entidad.clsSemaforo;
import Entidad.clsSensores;
import Negocios.Semaforo;
import Negocios.Sensores;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import static tunelmtc.FrmAuto.VelPro;
import static tunelmtc.FrmAuto.jlabelSemaforo;

public final class FrmManual extends javax.swing.JFrame {
    
    FrmAuto auto1 = new FrmAuto();
    private int sec = auto1.TiemRes;
    private int VelPro1 = 0;
    
    public FrmManual() {
        initComponents();
        bloqueo();
        auto1.timer.stop();
        setLocationRelativeTo(null);
        if (auto1.VelPro < 30) {
            semaforoVerde();
        } else {
            semaforoRojo();
        }
        int sec1 = (sec - 1) * 1000;
        FrmLogin lo = new FrmLogin();
        txtope.setText(lo.cod);
        VelProm.setText(String.valueOf(auto1.VelPro));
        timer2 = new Timer(1000, accion1);
        CambioImagen = new Timer(20000, cambio);
        random = new Timer(20000, accion2);
        timer2.setInitialDelay(0);
        CambioImagen.setInitialDelay(sec1);
        random.setInitialDelay(sec1);
        timer2.start();
        CambioImagen.start();
        random.start();
    }
    void bloqueo(){
        txtTiempoRest.setEditable(false);
        txtope.setEditable(false);
        VelProm.setEditable(false);
    }
    public ActionListener accion2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a;
            int c;
            int b[] = new int[6];
            a = (int) (Math.random() * 6);
            for (int i = 0; i < a; i++) {
                c = (int) (Math.random() * 60);
                b[i] = c;
            }
            if (a > 0) {
                int suma = 0;
                for (int i = 0; i < a; i++) {
                    suma = suma + b[i];
                    
                }
                VelPro1 = suma / a;
            } else {
                VelPro1 = 0;
            }
            System.out.println(VelPro1);
            VelProm.setText(String.valueOf(VelPro1));
        }
    };
    public ActionListener accion1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean a;
            int hour = 0;
            int min = 0;
            a = true;
            if (sec > 0) {
                sec--;
            }
            if (a) {
                String b = "";
                b += (hour > 9) ? ":" + hour : "0" + hour;
                b += (min > 9) ? ":" + min : ":0" + min;
                b += (sec > 9) ? ":" + sec : ":0" + sec;
                txtTiempoRest.setText(b);
                
            }
            while (sec == 0) {
                sec = 20;
                a = true;
                if (sec > 0) {
                    sec--;
                }
                if (a) {
                    String b = "";
                    b += (hour > 9) ? ":" + hour : "0" + hour;
                    b += (min > 9) ? ":" + min : ":0" + min;
                    b += (sec > 9) ? ":" + sec : ":0" + sec;
                    
                    txtTiempoRest.setText(b);
                    
                }
            }
        }
    };
    public ActionListener cambio = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int contadorCamara1 = (int) (Math.random() * 4);
            int contadorCamara2 = (int) (Math.random() * 4);
            Icon iconoCamara1;
            switch (contadorCamara1) {
                case 0:
                    contadorCamara1 = 1;
                    iconoCamara1 = new ImageIcon(getClass().getResource("/Cámara/Camara1 - 2.png"));
                    jCamara1.setIcon(iconoCamara1);
                    break;
                
                case 1:
                    contadorCamara1 = 2;
                    iconoCamara1 = new ImageIcon(getClass().getResource("/Cámara/Camara1 - 3.png"));
                    jCamara1.setIcon(iconoCamara1);
                    break;
                
                case 2:
                    contadorCamara1 = 3;
                    iconoCamara1 = new ImageIcon(getClass().getResource("/Cámara/Camara1 - 4.png"));
                    jCamara1.setIcon(iconoCamara1);
                    break;
                
                case 3:
                    contadorCamara1 = 0;
                    iconoCamara1 = new ImageIcon(getClass().getResource("/Cámara/Camara1 - 1.png"));
                    jCamara1.setIcon(iconoCamara1);
                    break;
            }
            Icon iconoCamara2;
            switch (contadorCamara2) {
                case 0:
                    contadorCamara2 = 1;
                    iconoCamara2 = new ImageIcon(getClass().getResource("/Cámara/Camara2 - 2.png"));
                    jCamara2.setIcon(iconoCamara2);
                    break;
                
                case 1:
                    contadorCamara2 = 2;
                    iconoCamara2 = new ImageIcon(getClass().getResource("/Cámara/Camara2 - 3.png"));
                    jCamara2.setIcon(iconoCamara2);
                    break;
                
                case 2:
                    contadorCamara2 = 3;
                    iconoCamara2 = new ImageIcon(getClass().getResource("/Cámara/Camara2 - 4.png"));
                    jCamara2.setIcon(iconoCamara2);
                    break;
                
                case 3:
                    contadorCamara2 = 0;
                    iconoCamara2 = new ImageIcon(getClass().getResource("/Cámara/Camara2 - 1.png"));
                    jCamara2.setIcon(iconoCamara2);
                    break;
            }
        }
    };
    
    public void semaforoVerde() {
        Icon icono;
        icono = new ImageIcon(getClass().getResource("/Imagenes/verde.png"));
        jlabelSemaforo.setIcon(icono);
    }
    
    public void semaforoRojo() {
        Icon icono;
        icono = new ImageIcon(getClass().getResource("/Imagenes/Rojo.png"));
        jlabelSemaforo.setIcon(icono);
    }
    Timer timer2;
    Timer CambioImagen;
    Timer random;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGestion = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jlabelSemaforo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCamara1 = new javax.swing.JLabel();
        jCamara2 = new javax.swing.JLabel();
        VelProm = new javax.swing.JTextField();
        txtTiempoRest = new javax.swing.JTextField();
        btnRojo = new javax.swing.JButton();
        btnVerde = new javax.swing.JButton();
        txtope = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));

        jLabel5.setBackground(new java.awt.Color(212, 208, 200));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Modo Manual");

        jLabel4.setBackground(new java.awt.Color(212, 208, 200));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Bienvenido ");

        jLabel6.setBackground(new java.awt.Color(212, 208, 200));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Velocidad promedio:");

        jLabel7.setBackground(new java.awt.Color(212, 208, 200));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Tiempo restante para cambio:");

        btnGestion.setBackground(new java.awt.Color(0, 51, 102));
        btnGestion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnGestion.setForeground(new java.awt.Color(255, 255, 255));
        btnGestion.setText("Gestion operario");
        btnGestion.setBorder(null);
        btnGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionMouseClicked(evt);
            }
        });
        btnGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(0, 51, 102));
        btnCerrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar Sesión");
        btnCerrar.setBorder(null);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(0, 51, 102));
        btnHistorial.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Ver");
        btnHistorial.setBorder(null);
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        jlabelSemaforo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Rojo.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(212, 208, 200));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Historial de cambios");

        jCamara1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cámara/Camara1 - 1.png"))); // NOI18N
        jCamara1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagen exterior", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jCamara2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cámara/Camara2 - 1.png"))); // NOI18N
        jCamara2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagen interior", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        btnRojo.setBackground(new java.awt.Color(0, 51, 102));
        btnRojo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnRojo.setForeground(new java.awt.Color(255, 255, 255));
        btnRojo.setText("Rojo");
        btnRojo.setBorder(null);
        btnRojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRojoMouseClicked(evt);
            }
        });
        btnRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRojoActionPerformed(evt);
            }
        });

        btnVerde.setBackground(new java.awt.Color(0, 51, 102));
        btnVerde.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnVerde.setForeground(new java.awt.Color(255, 255, 255));
        btnVerde.setText("Verde");
        btnVerde.setBorder(null);
        btnVerde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerdeMouseClicked(evt);
            }
        });
        btnVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtope, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(VelProm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCamara1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCamara2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTiempoRest, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jlabelSemaforo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtope, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCamara1)
                            .addComponent(jCamara2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(VelProm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelSemaforo)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTiempoRest, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked

    }//GEN-LAST:event_btnHistorialMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        FrmAuto tunel = new FrmAuto();
        tunel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseClicked

    }//GEN-LAST:event_btnGestionMouseClicked

    private void btnRojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRojoMouseClicked
        // TODO add your handling code here:     
    }//GEN-LAST:event_btnRojoMouseClicked

    private void btnRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRojoActionPerformed
        // TODO add your handling code here:  
        FrmLogin log = new FrmLogin();
        java.util.Date fecha = new Date();
        DateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        clsSemaforo se = new clsSemaforo();
        se.setSemaforos_txt_est("Rojo");
        se.setSemaforos_txt_origen("Manual");
        se.setSemaforos_date_feho(fecha1.format(fecha));
        se.setSemaforos_do_velpro(VelProm.getText());
        se.setOperario_num_id(log.dni);
        Sensores sen = new Sensores();
        se.setSensores_num_cod(String.valueOf(sen.ObtenerUltimoId()));
        Semaforo sema = new Semaforo();
        sema.IngresarSemaforo1(se);
        semaforoRojo();
        btnRojo.setEnabled(false);
        btnVerde.setEnabled(true);
    }//GEN-LAST:event_btnRojoActionPerformed

    private void btnVerdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerdeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnVerdeMouseClicked

    private void btnVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdeActionPerformed
        // TODO add your handling code here:
                FrmLogin log = new FrmLogin();
        java.util.Date fecha = new Date();
        DateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        clsSemaforo se = new clsSemaforo();
        se.setSemaforos_txt_est("Verde");
        se.setSemaforos_txt_origen("Manual");
        se.setSemaforos_date_feho(fecha1.format(fecha));
        se.setSemaforos_do_velpro(VelProm.getText());
        se.setOperario_num_id(log.dni);
        Sensores sen = new Sensores();
        se.setSensores_num_cod(String.valueOf(sen.ObtenerUltimoId()));
        Semaforo sema = new Semaforo();
        sema.IngresarSemaforo1(se);
        semaforoVerde();
        btnVerde.setEnabled(false);
        btnRojo.setEnabled(true);
    }//GEN-LAST:event_btnVerdeActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        FrmHistorial historial = new FrmHistorial();
        historial.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionActionPerformed
        // TODO add your handling code here:
        FrmMenuUsuario gestion = new FrmMenuUsuario();
        gestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmManual().setVisible(true);
            }
        });
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VelProm;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnHistorial;
    static javax.swing.JButton btnRojo;
    static javax.swing.JButton btnVerde;
    public static javax.swing.JLabel jCamara1;
    private static javax.swing.JLabel jCamara2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlabelSemaforo;
    private javax.swing.JTextField txtTiempoRest;
    private javax.swing.JTextField txtope;
    // End of variables declaration//GEN-END:variables
}
