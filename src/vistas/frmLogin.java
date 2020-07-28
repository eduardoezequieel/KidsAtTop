package vistas;

import javax.swing.JOptionPane;
import modelo.BDUser;
import modelo.BDusuarios;
import modelo.Conexion;
import modelo.Validaciones;
import modelo.hash;

/**
 *
 * @author eduardxlr
 */
public class frmLogin extends javax.swing.JFrame {

    Validaciones val = new Validaciones();
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtContra = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Todos los Derechos Reservados - KidsAtTop! © 2020");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 680, -1, -1));

        jPanel3.setBackground(new java.awt.Color(33, 37, 41));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Contraseña");
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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 340, 90));

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(33, 37, 41));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 340, 90));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirForm.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 50, 50));

        jLabel2.setFont(new java.awt.Font("Quicksand", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(134, 134, 134));
        jLabel2.setText("¿Estás listo para educar?");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, -1));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarSesion_default.png"))); // NOI18N
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIniciarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarSesion_click.png"))); // NOI18N
        btnIniciarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarSesion_rollover.png"))); // NOI18N
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 300, 80));

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
        getContentPane().add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 300, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 200));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoLogin.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        this.setVisible(false);
        frmPrincipal formulario = new frmPrincipal();
        formulario.setVisible(true);
        
        BDUser modBD = new BDUser();
        BDusuarios mod = new BDusuarios();
        
        String contra = new String(txtContra.getPassword());
        
        if(!txtUsuario.getText().equals("") && !contra.equals(""))
        {
            String nuevaContra = hash.sha1(contra);
            
            mod.setUsuario(txtUsuario.getText());
            mod.setContrasenia(nuevaContra);
            
            if(modBD.login(mod)){
                
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña son erróneos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un campo está vacío, por favor ingrese sus datos.");
        }
        

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        this.setVisible(false);
        frmMenuRecuperacion formulario = new frmMenuRecuperacion();
        formulario.setVisible(true);
        
        
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
    //</editor-fold>
    
    public static void main(String args[]) {
 

   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
