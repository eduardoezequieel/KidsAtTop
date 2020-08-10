/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlRecuContra;
import javax.swing.JOptionPane;
import modelo.ClsCorreo;
import modelo.RecuContra;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author eduardxlr
 */
public class frmRecuCorreo extends javax.swing.JFrame {

    //Llamando clases
    CtrlRecuContra recuCtrl = new CtrlRecuContra();
    RecuContra recu = new RecuContra();
    ClsCorreo clsCorreo = new ClsCorreo();
    
    /**
     * Creates new form RecuCorreoForm
     */
    public frmRecuCorreo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Deshabilitando botones y txt
        jCodigo.setEnabled(false);
        btnVerificar.setEnabled(false);
        jNueva.setEnabled(false);
        jConfirmar.setEnabled(false);
        btnAceptar.setEnabled(false);
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
        jSeparator1 = new javax.swing.JSeparator();
        jUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        jConfirmar = new javax.swing.JPasswordField();
        jNueva = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(33, 37, 41));
        jSeparator1.setForeground(new java.awt.Color(45, 255, 120));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1290, 10));

        jUsuario.setBackground(new java.awt.Color(33, 37, 41));
        jUsuario.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(254, 254, 254));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 210, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Usuario a recuperar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jCodigo.setBackground(new java.awt.Color(33, 37, 41));
        jCodigo.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jCodigo.setForeground(new java.awt.Color(254, 254, 254));
        jCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(jCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 160, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Nueva contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Confirmar contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, -1, -1));

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEnviar_default.png"))); // NOI18N
        btnEnviar.setBorder(null);
        btnEnviar.setBorderPainted(false);
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setFocusPainted(false);
        btnEnviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEnviar_rollover.png"))); // NOI18N
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 180, 70));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAceptar_rollover.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAceptar_default.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 440, 180, 70));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backpng.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back_rollover.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 180, 70));

        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVerificar_rollover-1.png"))); // NOI18N
        btnVerificar.setBorder(null);
        btnVerificar.setBorderPainted(false);
        btnVerificar.setContentAreaFilled(false);
        btnVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerificar.setFocusPainted(false);
        btnVerificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVerificar_default.png"))); // NOI18N
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 180, 70));
        jPanel1.add(jConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 210, 30));
        jPanel1.add(jNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 312, 210, 30));

        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Codigo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("3");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, 20, -1));

        jLabel9.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("1");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 20, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroRecuCorreo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 370, 340));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroRecuCorreo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 380, 340));

        jLabel11.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("2");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 20, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroRecuCorreo.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 370, 340));

        jLabel12.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Recuperación de Contraseña mediante Correo Electrónico");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Rellene los siguientes campos.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       this.setVisible(false);
       frmMenuRecuperacion formulario = new frmMenuRecuperacion();
       formulario.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        
        //Validando campos vacios
        if (jCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene los campos faltantes.","Campos vacios",JOptionPane.WARNING_MESSAGE);
        } else {
            
            //Verificando codigos
            int codigo = Integer.parseInt(jCodigo.getText());
            
            if (codigo == recuCtrl.getCodigoVerificacion()) {
                JOptionPane.showMessageDialog(null, "El código se ha verificado correctamente. Puedes cambiar la contraseña.","Verificación correcta",JOptionPane.INFORMATION_MESSAGE);
                jCodigo.setEnabled(false);
                btnVerificar.setEnabled(false);
                jNueva.setEnabled(true);
                jConfirmar.setEnabled(true);
                btnAceptar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "El código no coincide con el enviado al correo.","Código incorrecto.",JOptionPane.WARNING_MESSAGE);
            }
                    
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        //Validando campos vacios
        if (jUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene los campos faltantes.","Campos vacios.",JOptionPane.WARNING_MESSAGE);
        } else {
            
            recuCtrl.setUsuario(jUsuario.getText());
            
            //Verificando usuario
            if (recu.verificarUsuario()) {
                
                //Generando codigo de verificacion
                recu.generarCodigo();
                
                //Mandando codigo al correo
                String destinatario = recuCtrl.getCorreo();
                String asunto = "Código de verificación";
                String mensaje = "Te saludamos del equipo de KidsAtTop! System, has seleccionado recuperar la contraseña por este medio, "
                                    + "tu código de verificación es: " + String.valueOf(recuCtrl.getCodigoVerificacion());
                
                clsCorreo.setDestino(destinatario);
                clsCorreo.setAsunto(asunto);
                clsCorreo.setMensaje(mensaje);         
                clsCorreo.enviarCorreo();
                
                jUsuario.setEnabled(false);
                btnEnviar.setEnabled(false);
                jCodigo.setEnabled(true);
                btnVerificar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un usuario con este nombre","Usuario no encontrado",JOptionPane.WARNING_MESSAGE);
            }
        }
     
    }//GEN-LAST:event_btnEnviarActionPerformed

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
                    frmMenuRecuperacion formulario = new frmMenuRecuperacion();
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no se ha cambiado correctamente","Contraseña no actualizada.",JOptionPane.WARNING_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.","Contraseñas incorrectas.",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(frmRecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRecuCorreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JPasswordField jConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
