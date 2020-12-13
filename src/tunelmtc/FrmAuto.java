/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunelmtc;

import Entidad.clsSemaforo;
import Entidad.clsSensores;
import Negocios.Semaforo;
import Negocios.Sensores;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class FrmAuto extends javax.swing.JFrame {

    public int time = 20000;
    public int sec = 20;
    public int d = 0;
    public int TiemTrans = 0;
    public static int TiemRes;
    public static int VelPro=0;

    public FrmAuto() {
        initComponents();
        setLocationRelativeTo(null);
        bloquear();
        timer = new Timer(time, repe);
        timer1 = new Timer(1000, cont);
        timer.setInitialDelay(0);
        timer.start();
        timer1.start();
    }
    void bloquear(){
        txtSensor1.setEditable(false);
        txtSensor2.setEditable(false);
        txtSensor3.setEditable(false);
        txtSensor4.setEditable(false);
        txtSensor5.setEditable(false);
        txtSensor6.setEditable(false);
        txtTiempoRest.setEditable(false);
        txtPromedio.setEditable(false);
    }
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
    private ActionListener repe = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a;
            int c;
            int b[] = new int[6];
            String color = "";
            a = (int) (Math.random() * 6);

            System.out.println(a);
            for (int i = 0; i < a; i++) {
                c = (int) (Math.random() * 60);
                b[i] = c;
            }
            if (a > 0) {
                for (int i = 0; i < a; i++) {
                    txtSensor1.setText(String.valueOf(b[0]));
                    txtSensor2.setText(String.valueOf(b[1]));
                    txtSensor3.setText(String.valueOf(b[2]));
                    txtSensor4.setText(String.valueOf(b[3]));
                    txtSensor5.setText(String.valueOf(b[4]));
                    txtSensor6.setText(String.valueOf(b[5]));
                    d = d + b[i];
                    txtPromedio.setText(String.valueOf(d / a));
                }
                clsSensores ve = new clsSensores();
                ve.setSensores_num_ve11(txtSensor1.getText());
                ve.setSensores_num_vel2(txtSensor2.getText());
                ve.setSensores_num_vel3(txtSensor3.getText());
                ve.setSensores_num_vel4(txtSensor4.getText());
                ve.setSensores_num_vel5(txtSensor5.getText());
                ve.setSensores_num_vel6(txtSensor6.getText());
                Sensores ve1 = new Sensores();
                ve1.IngresarVelocidades(ve);
                clsSemaforo se = new clsSemaforo();
                java.util.Date fecha = new Date();
                DateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(fecha1.format(fecha));
                if ((d / a) > 30) {
                    Icon icono;
                    icono = new ImageIcon(getClass().getResource("/Imagenes/Rojo.png"));
                    jlabelSemaforo.setIcon(icono);
                    color = "Rojo";
                } else {
                    Icon icono;
                    icono = new ImageIcon(getClass().getResource("/Imagenes/verde.png"));
                    jlabelSemaforo.setIcon(icono);
                    color = "Verde";
                }
                se.setSemaforos_txt_est(color);
                se.setSemaforos_txt_origen("Automatico");
                se.setSemaforos_date_feho(fecha1.format(fecha));
                se.setSemaforos_do_velpro(String.valueOf(d / a));
                Sensores sen = new Sensores();
                se.setSensores_num_cod(String.valueOf(sen.ObtenerUltimoId()));
                Semaforo sema = new Semaforo();
                sema.IngresarSemaforo(se);
            } else {
                JOptionPane.showMessageDialog(null, "No hay Coches");
            }
            if(a>0){
            VelPro = d/a;
            }else{
                VelPro=0;
            }
        }
    };
    public ActionListener cont = new ActionListener() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSensor5 = new javax.swing.JTextField();
        txtSensor6 = new javax.swing.JTextField();
        btnManual = new javax.swing.JButton();
        txtPromedio = new javax.swing.JTextField();
        btnHistorial = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlabelSemaforo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSensor1 = new javax.swing.JTextField();
        txtSensor2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSensor3 = new javax.swing.JTextField();
        txtSensor4 = new javax.swing.JTextField();
        txtTiempoRest = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(931, 580));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));

        jLabel7.setBackground(new java.awt.Color(212, 208, 200));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Tiempo restante para cambio:");

        txtSensor5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #5"));

        txtSensor6.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #6"));

        btnManual.setBackground(new java.awt.Color(0, 51, 102));
        btnManual.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnManual.setForeground(new java.awt.Color(255, 255, 255));
        btnManual.setText("Modo Manual");
        btnManual.setBorder(null);
        btnManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManualMouseClicked(evt);
            }
        });
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });

        txtPromedio.setBorder(javax.swing.BorderFactory.createTitledBorder("Velocidad Prom."));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel1.setText("Parámetro 20 km/h");

        jLabel8.setBackground(new java.awt.Color(212, 208, 200));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Historial de cambios");

        txtSensor1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #1"));

        txtSensor2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #2"));

        jLabel5.setBackground(new java.awt.Color(212, 208, 200));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Modo Automático");

        txtSensor3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #3"));

        txtSensor4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor #4"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 384, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtTiempoRest, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSensor1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(txtSensor2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSensor3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(txtSensor4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSensor5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(txtSensor6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jlabelSemaforo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTiempoRest, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSensor1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSensor2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSensor3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSensor4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSensor5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSensor6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addComponent(txtPromedio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabelSemaforo)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public Timer timer;
    public Timer timer1;
    private void btnManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManualMouseClicked
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManualMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked

    }//GEN-LAST:event_btnHistorialMouseClicked

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        FrmHistorial historial = new FrmHistorial();
        historial.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        // TODO add your handling code here: 
        timer.stop();
        timer1.stop();
        TiemTrans = 20 - sec;
        TiemRes = 20 - TiemTrans;
    }//GEN-LAST:event_btnManualActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAuto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnManual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel jlabelSemaforo;
    private javax.swing.JTextField txtPromedio;
    private javax.swing.JTextField txtSensor1;
    private javax.swing.JTextField txtSensor2;
    private javax.swing.JTextField txtSensor3;
    private javax.swing.JTextField txtSensor4;
    private javax.swing.JTextField txtSensor5;
    private javax.swing.JTextField txtSensor6;
    private javax.swing.JTextField txtTiempoRest;
    // End of variables declaration//GEN-END:variables
}
