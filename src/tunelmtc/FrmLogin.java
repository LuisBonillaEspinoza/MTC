
package tunelmtc;

import Conexion.DBManager;
import Entidad.clsOperario;
import Entidad.clsSemaforo;
import Negocios.Operario;
import Negocios.Semaforo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {
FrmAuto au = new FrmAuto();
    public FrmLogin() {
        au.timer.stop();
        au.timer1.stop();
        initComponents();
        setLocationRelativeTo(null);
        MostrarOperario();
    }
    public static String cod = "";
    public static String dni = "";
    void MostrarOperario(){
        Operario op = new Operario();
        ArrayList<clsOperario> ope = op.ObtenerIdentificador();
        Iterator ite = ope.listIterator();
        String datos[] = new String[1000];
        while(ite.hasNext()){
            int i = 0;
            clsOperario oper = new clsOperario();
            oper = (clsOperario) ite.next();
            datos[i] = oper.getOperario_txt_iden();
            cboID.addItem(datos[i]);
        }
    }
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        btnModoAuto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(212, 208, 200));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tunel - Pucallpa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        jLabel4.setBackground(new java.awt.Color(212, 208, 200));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Ingrese su identificador");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jLabel5.setBackground(new java.awt.Color(212, 208, 200));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Identificador");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        cboID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(cboID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 330, 40));

        jLabel2.setBackground(new java.awt.Color(212, 208, 200));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        txtpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 330, 40));

        btnModoAuto.setBackground(new java.awt.Color(0, 51, 102));
        btnModoAuto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnModoAuto.setForeground(new java.awt.Color(255, 255, 255));
        btnModoAuto.setText("Modo Automático");
        btnModoAuto.setBorder(null);
        btnModoAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoAutoMouseClicked(evt);
            }
        });
        btnModoAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoAutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 170, 40));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(0, 51, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(440, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MTC.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        btnEntrar.setBackground(new java.awt.Color(0, 51, 102));
        btnEntrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Iniciar Sesión");
        btnEntrar.setBorder(null);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModoAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoAutoMouseClicked

        FrmAuto tunel = new FrmAuto();
        tunel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModoAutoMouseClicked

    private void btnModoAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModoAutoActionPerformed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        // TODO add your handling code here:
//       
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        String id = String.valueOf(cboID.getSelectedItem());
        String pass = txtpass.getText();
        
        if(txtpass.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese una Contraseña Correcta");
        }
        else{
            try {
                PreparedStatement pst = con.prepareStatement("select * from operario where operario_txt_iden='" + id + "' and operario_txt_pass='" + pass + "'");
                rs = pst.executeQuery();
                if(rs.next()){
                    dni = rs.getString("operario_txt_iden");
                    cod = rs.getString("operario_txt_nom");
                    FrmManual tunel = new FrmManual();
                    String[] args = null;
                    tunel.main(args);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos Incorrectos o Usuario no Existente");
                    txtpass.setText("");
                }
            } catch (Exception e) {
                System.out.println("Error en el Login : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnModoAuto;
    private javax.swing.JComboBox<String> cboID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
