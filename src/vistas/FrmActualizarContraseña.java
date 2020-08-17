package vistas;

import controlador.CtrlLoginUsuario;
import controlador.CtrlUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.MtoLogin;
import modelo.MtoUsuario;
import modelo.Validaciones;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author EDUARDO
 */
public class FrmActualizarContraseña extends javax.swing.JFrame {
    
    CtrlLoginUsuario mod;
    Validaciones val = new Validaciones();
    
    public FrmActualizarContraseña() {
        initComponents();
        
    }
    
    public FrmActualizarContraseña(CtrlLoginUsuario mod){
        initComponents();
        this.mod = mod;
        this.setLocationRelativeTo(null);
        jUsuario.setText(String.valueOf(mod.getId_usuario()));
        jUsuario.setVisible(false);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jUsuario = new javax.swing.JTextField();
        jNuevaContraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jConfirmarContraseña = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(42, 46, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><p style=overflow:auto;><center>Una contraseña segura debe ser fácil de recordar para ti, pero prácticamente imposible de adivinar para otra persona.</center></p>");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 630, 70));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html><p style=overflow:auto;>Se ha detectado que esta es la primera vez que inicias sesión. Debes actualizar tu contraseña, toma en cuenta los siguientes aspectos:</p>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 800, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("- No pongas tu usuario como contraseña.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("- No pongas la contraseña generica. (123)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, -1));

        jUsuario.setEditable(false);
        jUsuario.setBackground(new java.awt.Color(42, 46, 50));
        jUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        jNuevaContraseña.setBackground(new java.awt.Color(42, 46, 50));
        jNuevaContraseña.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNuevaContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jNuevaContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNuevaContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevaContraseñaActionPerformed(evt);
            }
        });
        jNuevaContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNuevaContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNuevaContraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(jNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 260, 40));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndContraseña.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 520, 540));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nueva Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, 30));

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSiguienteDefault.png"))); // NOI18N
        btnSiguiente.setBorder(null);
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSiguienteRollover.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 150, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndActualizarContraseña.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1370, 180));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("- Tu contraseña debe de tener como minimo 8 caracteres.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Confirmar Contraseña:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, -1, 30));

        jConfirmarContraseña.setBackground(new java.awt.Color(42, 46, 50));
        jConfirmarContraseña.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jConfirmarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jConfirmarContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jConfirmarContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jConfirmarContraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(jConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (jNuevaContraseña.getText().trim().equals(mod.getUsuario()) && jConfirmarContraseña.getText().trim().equals(mod.getUsuario())) 
        {
                JOptionPane.showMessageDialog(null, "Tu contraseña no puede ser igual a tu usuario.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(jNuevaContraseña.getText().trim().isEmpty() || jConfirmarContraseña.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Campos vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(jNuevaContraseña.getText().trim().length() < 8 && jConfirmarContraseña.getText().length() < 8)
        {
            JOptionPane.showMessageDialog(null, "Tu contraseña no puede tener menos de 8 caracteres.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(jNuevaContraseña.getText().trim().equals(jConfirmarContraseña.getText().trim()))
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas esta contraseña?","Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                CtrlUsuario ctrl = new CtrlUsuario();
                MtoUsuario mto = new MtoUsuario();
                String contraseña = jNuevaContraseña.getText();
                String contraseñaEncriptada = DigestUtils.sha1Hex(contraseña);
                ctrl.setContraseña(contraseñaEncriptada);
                ctrl.setId_usuario(Integer.parseInt(jUsuario.getText()));
        
                if (mto.actualizarContraseña()) {
                    JOptionPane.showMessageDialog(null, "Exito");
                    MtoLogin modBD = new MtoLogin();
                    if (modBD.detectarRespuestas(mod) == false) {
                        this.setVisible(false);
                        FrmInsertarRespuestas frm = new FrmInsertarRespuestas(mod);
                        frm.setVisible(true);
                    }
                    else
                    {
                        this.setVisible(false);
                        FrmLogin frm = null;
                        try {
                            frm = new FrmLogin();
                        } catch (UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(FrmActualizarContraseña.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frm.setVisible(true);
                    }
                    
                }
                else
                {
                        JOptionPane.showMessageDialog(null, "Error");
                }	
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jNuevaContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNuevaContraseñaKeyPressed
        // TODO add your handling code here:
        String Caracteres = jNuevaContraseña.getText();
        if(Caracteres.length()>=16){
            jNuevaContraseña.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNuevaContraseñaKeyPressed

    private void jNuevaContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevaContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNuevaContraseñaActionPerformed

    private void jConfirmarContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jConfirmarContraseñaKeyPressed
        // TODO add your handling code here:
        String Caracteres = jConfirmarContraseña.getText();
        if(Caracteres.length()>=16){
            jConfirmarContraseña.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jConfirmarContraseñaKeyPressed

    private void jNuevaContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNuevaContraseñaKeyTyped

        val.verificarEspeciales(evt);
        
        String Caracteres = jNuevaContraseña.getText();
        if(Caracteres.length()>=16){
            evt.consume();
        }
    }//GEN-LAST:event_jNuevaContraseñaKeyTyped

    private void jConfirmarContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jConfirmarContraseñaKeyTyped
        // TODO add your handling code here:
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_jConfirmarContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmActualizarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmActualizarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JTextField jConfirmarContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNuevaContraseña;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables
}
