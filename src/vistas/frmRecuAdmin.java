package vistas;

import controlador.CtrlRecuContra;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.RecuContra;
import modelo.Validaciones;
import org.apache.commons.codec.digest.DigestUtils;

public class frmRecuAdmin extends javax.swing.JFrame {

    Validaciones val = new Validaciones();
    //Llamando clases
    CtrlRecuContra recuCtrl = new CtrlRecuContra();
    RecuContra recu = new RecuContra();
    
    public frmRecuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        btnAceptar.setEnabled(false);
        jNueva.setEnabled(false);
        jConfirmar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        jAdmin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jConfirmar = new javax.swing.JPasswordField();
        jContra = new javax.swing.JPasswordField();
        jNueva = new javax.swing.JPasswordField();
        jUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Recuperación de Contraseña mediante Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(33, 37, 41));
        jSeparator1.setForeground(new java.awt.Color(45, 255, 120));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1290, 10));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backpng.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back_rollover.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 260, 170));

        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVerificar_rollover-1.png"))); // NOI18N
        btnVerificar.setBorder(null);
        btnVerificar.setContentAreaFilled(false);
        btnVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVerificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVerificar_default.png"))); // NOI18N
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, -1, -1));

        jAdmin.setBackground(new java.awt.Color(33, 37, 41));
        jAdmin.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jAdmin.setForeground(new java.awt.Color(254, 254, 254));
        jAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jAdmin.setDisabledTextColor(new java.awt.Color(254, 254, 254));
        jAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAdminKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jAdminKeyTyped(evt);
            }
        });
        jPanel1.add(jAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 250, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Usuario administrador:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 250, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña administrador:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 250, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Usuario a recuperar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 250, -1));

        jLabel2.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 40, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nueva Contraseña:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 210, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Confirmar Contraseña:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 210, -1));

        jConfirmar.setBackground(new java.awt.Color(33, 37, 41));
        jConfirmar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jPanel1.add(jConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 210, 30));

        jContra.setBackground(new java.awt.Color(33, 37, 41));
        jContra.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jPanel1.add(jContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 250, 30));

        jNueva.setBackground(new java.awt.Color(33, 37, 41));
        jNueva.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jPanel1.add(jNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 210, 30));

        jUsuario.setBackground(new java.awt.Color(33, 37, 41));
        jUsuario.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(254, 254, 254));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jUsuario.setDisabledTextColor(new java.awt.Color(254, 254, 254));
        jUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 250, 30));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAceptar_rollover.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAceptar_default.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recuadro1RecuAdmin.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Rellene los siguientes datos.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, 30));

        jLabel12.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("1");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 40, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recuadro1RecuAdmin.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        frmMenuRecuperacion formulario = new frmMenuRecuperacion();
        formulario.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    private void jUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyTyped
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_jUsuarioKeyTyped

    private void jAdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAdminKeyTyped
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_jAdminKeyTyped

    private void jUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyPressed
        val.verificarPegar(evt);
    }//GEN-LAST:event_jUsuarioKeyPressed

    private void jAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAdminKeyPressed
        val.verificarPegar(evt);
    }//GEN-LAST:event_jAdminKeyPressed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
       
        //validando campos vacios
        if ((jUsuario.getText().trim().isEmpty()) || (jAdmin.getText().trim().isEmpty())
                || (jContra.getText().trim().isEmpty())) {
             JOptionPane.showMessageDialog(null, "Rellene los campos faltantes.","Campos vacios",JOptionPane.WARNING_MESSAGE);
        } else {
            
            //Mandando datos a la controlador
            recuCtrl.setUsuario(jUsuario.getText());
            recuCtrl.setAdmin(jAdmin.getText());
            String contra = new String(jContra.getPassword());
            String encriptado = DigestUtils.sha1Hex(contra);
            recuCtrl.setContraseña(encriptado);
            
            //Verificando admin y usuario
            if (recu.validarAdmin()) {
                if (recu.verificarUser()) {
                    JOptionPane.showMessageDialog(null, "Se ha confirmado las credenciales del administrador y el usuario a recuperar");
                    btnAceptar.setEnabled(true);
                    jNueva.setEnabled(true);
                    jConfirmar.setEnabled(true);
                    btnVerificar.setEnabled(false);
                    jUsuario.setEnabled(false);
                    jAdmin.setEnabled(false);
                    jContra.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Validando campos vacios
        if (jNueva.getText().trim().isEmpty() || jConfirmar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene los campos faltantes.","Campos vacios.",JOptionPane.WARNING_MESSAGE);
        } else {
            
            String nueva = new String(jNueva.getPassword());
            String confirmar = new String(jConfirmar.getPassword());
            
            //Verificando que sean igual 
            if (nueva.equals(confirmar)) {
                
                //Reestableciendo contraseña
                String contra = new String(jConfirmar.getPassword());
                String encriptado=DigestUtils.sha1Hex(contra);
                
                recuCtrl.setNuevaContra(encriptado);
                
                if (recu.cambiarContra()) {
                    JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado correctamente","Contraseña actualizada.",JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    frmLogin formulario = null;
                    try {
                        formulario = new frmLogin();
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(frmRecuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no se ha cambiado correctamente","Contraseña no actualizada.",JOptionPane.WARNING_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.","Contraseñas incorrectas.",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
    //</editor-fold>
    
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
            java.util.logging.Logger.getLogger(frmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRecuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JTextField jAdmin;
    private javax.swing.JPasswordField jConfirmar;
    private javax.swing.JPasswordField jContra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jNueva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables
}
