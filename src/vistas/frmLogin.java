package vistas;

import com.bulenkov.darcula.DarculaLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import modelo.MtoLogin;
import controlador.CtrlLoginUsuario;
import java.awt.Component;
import modelo.Conexion;
import modelo.ClsCorreo;
import modelo.Validaciones;
import org.apache.commons.codec.digest.DigestUtils;
import modelo.MtoBitacoras;

/**
 *
 * @author eduardxlr
 */
public class frmLogin extends javax.swing.JFrame {

    Validaciones val = new Validaciones();
    public frmLogin() throws UnsupportedLookAndFeelException {
        initComponents();
        this.setLocationRelativeTo(null);    
        //Cargando estilos
        BasicLookAndFeel darcula = new DarculaLaf();
        UIManager.setLookAndFeel(darcula);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        //Validando primer uso
        MtoLogin mto = new MtoLogin();
        btnContinuar.setVisible(false);
        if (mto.verificarPrimerUso()) {
            btnPrimerUso.setVisible(false);
            icnPrimerUso.setVisible(false);
            if (mto.continuarPrimerUso()) {
                btnPrimerUso.setVisible(false);
                icnPrimerUso.setVisible(true);
                btnContinuar.setVisible(true);
                pnlControlesLogin.setVisible(false);
                for (Component component : pnlControlesLogin.getComponents()) {
                    component.setVisible(false);  
                }
            }
        }
        else
        {
            btnPrimerUso.setVisible(true);
            icnPrimerUso.setVisible(true);
            pnlControlesLogin.setVisible(false);
            for (Component component : pnlControlesLogin.getComponents()) {
                component.setVisible(false);  
                }
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        pnlControlesLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtContra = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnPrimerUso = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        icnPrimerUso = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Todos los Derechos Reservados - KidsAtTop! © 2020");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 700, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarDefault.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarRollover.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 30, 30));

        pnlControlesLogin.setBackground(new java.awt.Color(42, 46, 50));
        pnlControlesLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(33, 37, 41));
        txtUsuario.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(254, 254, 254));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(null);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 30));

        jSeparator2.setBackground(new java.awt.Color(1, 1, 1));
        jSeparator2.setForeground(new java.awt.Color(141, 141, 141));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 10));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Usuario:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pnlControlesLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 340, 90));

        jPanel3.setBackground(new java.awt.Color(33, 37, 41));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Contraseña:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(1, 1, 1));
        jSeparator1.setForeground(new java.awt.Color(141, 141, 141));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 10));

        txtContra.setBackground(new java.awt.Color(33, 37, 41));
        txtContra.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        txtContra.setForeground(new java.awt.Color(254, 254, 254));
        txtContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContra.setToolTipText("");
        txtContra.setBorder(null);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });
        jPanel3.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 30));

        pnlControlesLogin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 340, 90));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarSesion_default.png"))); // NOI18N
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIniciarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarSesion_rollover.png"))); // NOI18N
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlControlesLogin.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        btnRecuperar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRecuperarContraseña_default.png"))); // NOI18N
        btnRecuperar.setBorder(null);
        btnRecuperar.setBorderPainted(false);
        btnRecuperar.setContentAreaFilled(false);
        btnRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRecuperar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRecuperarContraseña_rollover.png"))); // NOI18N
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });
        pnlControlesLogin.add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        pnlControlesLogin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        getContentPane().add(pnlControlesLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 360, 640));

        btnPrimerUso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnPrimerUsoDefault.png"))); // NOI18N
        btnPrimerUso.setBorder(null);
        btnPrimerUso.setBorderPainted(false);
        btnPrimerUso.setContentAreaFilled(false);
        btnPrimerUso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPrimerUso.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnPrimerUsoRollover.png"))); // NOI18N
        btnPrimerUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimerUsoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrimerUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 300, 80));

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnContinuarDefault.png"))); // NOI18N
        btnContinuar.setBorder(null);
        btnContinuar.setBorderPainted(false);
        btnContinuar.setContentAreaFilled(false);
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContinuar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnContinuarRollover.png"))); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 300, 80));

        icnPrimerUso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icnPrimerUso.png"))); // NOI18N
        getContentPane().add(icnPrimerUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizarDefault.png"))); // NOI18N
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizarRollover.png"))); // NOI18N
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(119, 119, 119));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("¿Estás listo para educar?");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 400, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoLogin.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 728));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar el sistema?","Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
       
        
       
        
        String contra = new String(txtContra.getPassword());
        String encriptado=DigestUtils.sha1Hex(contra);
        
        if(!txtUsuario.getText().equals("") && !contra.equals(""))
        {
            MtoLogin modBD = new MtoLogin();
            CtrlLoginUsuario mod = new CtrlLoginUsuario();
            MtoBitacoras bitacora=new MtoBitacoras();
            
            mod.setUsuario(txtUsuario.getText());
            mod.setContrasenia(encriptado);
            
            int id=bitacora.capturarIdBitacora()+1;
            
            if (modBD.validarLogin(mod)) {
                if (modBD.verificarContraseña(mod)) {
                    //Abriendo formulario para cambiar contraseña generica
                    modBD.obtenerDatosUsuario(mod);
                    this.setVisible(false);
                    FrmActualizarContraseña frm = new FrmActualizarContraseña(mod);
                    frm.setVisible(true);
                }
                else
                {
                    modBD.obtenerDatosUsuario(mod);
                    
                    JOptionPane.showMessageDialog(this, "Acceso concedido, bienvenido "+mod.getUsuario());
                    this.setVisible(false);
                    frmPrincipal formulario = new frmPrincipal(mod);
                    formulario.setVisible(true);
                    
                  
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    bitacora.agregarBitacoraEntrada(mod);
                           
                    
                    
                }
                
            }
           
            
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Uno o ambos campos están vacíos, por favor ingrese sus datos.");
        }
        

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        this.setVisible(false);
        frmMenuRecuperacion formulario = new frmMenuRecuperacion();
        formulario.setVisible(true);
        /*ClsCorreo correo = new ClsCorreo();
        correo.enviarCorreo();*/
        //Conexion conectar = new Conexion();
        //conectar.conectar();
        
    }//GEN-LAST:event_btnRecuperarActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_txtContraKeyTyped

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        val.verificarPegar(evt);
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        val.verificarPegar(evt);
    }//GEN-LAST:event_txtContraKeyPressed

    private void btnPrimerUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimerUsoActionPerformed
        this.setVisible(false);
        FrmPrimerUso1 frm = new FrmPrimerUso1();
        frm.setVisible(true);
    }//GEN-LAST:event_btnPrimerUsoActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
       this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed

        JOptionPane.showMessageDialog(null, "Bienvenido, a continuación podras continuar con el registro de primer uso.","Información",JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        FrmPrimerUso3 frm = new FrmPrimerUso3();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnContinuarActionPerformed
    //</editor-fold>
    
    public static void main(String args[]) {
 

   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmLogin().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnPrimerUso;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel icnPrimerUso;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlControlesLogin;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
