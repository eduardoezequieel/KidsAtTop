package vistas;

import controlador.CtrlLoginUsuario;
import controlador.CtrlUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.MtoLogin;
import modelo.MtoUsuario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author EDUARDO
 */
public class FrmActualizarContraseña extends javax.swing.JFrame {
    
    CtrlLoginUsuario mod;
    
    public FrmActualizarContraseña() {
        initComponents();
        
    }
    
    public FrmActualizarContraseña(CtrlLoginUsuario mod){
        initComponents();
        this.mod = mod;
        this.setLocationRelativeTo(null);
        jUsuario.setText(mod.getUsuario());
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
        jConfirmarContraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(42, 46, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Una contraseña segura debe ser fácil de recordar para ti, pero prácticamente imposible de adivinar para otra persona.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Se ha detectado que esta es la primera vez que inicias sesión. Debes actualizar tu contraseña, toma en cuenta los siguientes aspectos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("- No pongas tu usuario como contraseña.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("- No pongas la contraseña generica. (123)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jUsuario.setEditable(false);
        jUsuario.setBackground(new java.awt.Color(42, 46, 50));
        jUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 200, 30));

        jConfirmarContraseña.setBackground(new java.awt.Color(42, 46, 50));
        jConfirmarContraseña.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jConfirmarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jConfirmarContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 200, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("- Tu contraseña debe de tener como minimo 8 caracteres.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nueva Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, 30));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 150, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndActualizarContraseña.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1370, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (jConfirmarContraseña.getText().isEmpty()) 
        {
                JOptionPane.showMessageDialog(null, "Campos vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(jConfirmarContraseña.getText().length()<8)
        {
            JOptionPane.showMessageDialog(null, "Esta contraseña tiene menos de 8 caracteres o es generica.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(jConfirmarContraseña.getText().equals(jUsuario.getText()))
        {
            JOptionPane.showMessageDialog(null, "Tu contraseña no puede ser igual a tu usuario.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas esta contraseña?","Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                CtrlUsuario ctrl = new CtrlUsuario();
                MtoUsuario mto = new MtoUsuario();
                String contraseña = jConfirmarContraseña.getText();
                String contraseñaEncriptada = DigestUtils.sha1Hex(contraseña);
                ctrl.setContraseña(contraseñaEncriptada);
                ctrl.setUsuario(jUsuario.getText());
        
                if (mto.actualizarContraseña()) {
                    JOptionPane.showMessageDialog(null, "Exito");
                    this.setVisible(false);
                    frmLogin frm;
                    try 
                    {
                        frm = new frmLogin();
                        frm.setVisible(true);
                    } 
                    catch (UnsupportedLookAndFeelException ex) 
                    {
                        Logger.getLogger(FrmActualizarContraseña.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                        JOptionPane.showMessageDialog(null, "Error");
                }	
            } 
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField jConfirmarContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables
}
