package vistas;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import controlador.CtrlLoginUsuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.MtoLogin;



public class frmPrincipal extends javax.swing.JFrame implements Runnable {

    
    CtrlLoginUsuario mod;
    String hora,minutos,ampm;;
    Calendar calendario;
    Thread hl;
    MtoLogin log=new MtoLogin();
    
    
    
    
    public frmPrincipal() {
        initComponents();
       
        
        
    }
    
    public frmPrincipal(CtrlLoginUsuario mod){
        initComponents();
        this.mod = mod;
        lblTipoUsuario.setVisible(false);
        lblTipoUsuario.setText(String.valueOf(mod.getId_tipo_usuario()));
        this.setLocationRelativeTo(null);
        
        //Seteando usuario logueado
        lblUsuario.setText(mod.getUsuario());
        
        //Seteando foto del usuario
        byte[] foto = mod.getFoto();
        ImageIcon imagen = new ImageIcon(new ImageIcon(foto).getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(imagen);
        
        //Mostrar tipo de usuario
        if (mod.getId_tipo_usuario() == 1) {
            lblTipo.setText("Administrador");
        }
        else if(mod.getId_tipo_usuario() == 2)
        {
            lblTipo.setText("Director");
        }
        else if(mod.getId_tipo_usuario() == 3)
        {
            lblTipo.setText("Docente");
        }
        else if(mod.getId_tipo_usuario() == 4)
        {
            lblTipo.setText("Secretaria/o");
        }
        
        //Label de hora
        hl=new Thread(this);
        hl.start();
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnControlAcademico = new javax.swing.JButton();
        btnMiCuenta = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMatricula_default.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMatricula_rollover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 180, 230));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnHerramientasSistemaDefault.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnHerramientasSistemaRollover.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 180, 230));

        btnControlAcademico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnControlAcademico_default.png"))); // NOI18N
        btnControlAcademico.setBorder(null);
        btnControlAcademico.setContentAreaFilled(false);
        btnControlAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnControlAcademico.setFocusPainted(false);
        btnControlAcademico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnControlAcademico_rollover.png"))); // NOI18N
        btnControlAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlAcademicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnControlAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 180, 230));

        btnMiCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMiCuenta_default.png"))); // NOI18N
        btnMiCuenta.setBorder(null);
        btnMiCuenta.setContentAreaFilled(false);
        btnMiCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMiCuenta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMiCuenta_rollover.png"))); // NOI18N
        btnMiCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnMiCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 580, 160, -1));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarSesion_default.png"))); // NOI18N
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarSesion_rollover.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 640, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Roboto", 0, 32)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(45, 252, 119));
        lblUsuario.setText("usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, -1, -1));

        lblFoto.setFont(new java.awt.Font("Quicksand", 0, 32)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(236, 236, 236));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 280, 280));

        lblTipo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(236, 236, 236));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("TipoUsuario");
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 640, 260, 100));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 236, 236));
        jLabel2.setText("Hola,");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        lblHora.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(254, 254, 254));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("00:00:00");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 260, 100));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 236, 236));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/QueHaremos.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 310, 60));

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 236, 236));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndMarcoFoto.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 200, 340, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroMenu.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 740));

        lblTipoUsuario.setText("jLabel6");
        jPanel1.add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 236, 236));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 236, 236));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(33, 37, 41));
        jSeparator2.setForeground(new java.awt.Color(45, 255, 120));
        jSeparator2.setToolTipText("");
        jSeparator2.setEnabled(false);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 560, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
      
        this.setVisible(false);
        frmLogin formulario = null;
        try {
            formulario = new frmLogin();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        formulario.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        this.setVisible(false);
        frmGestionarMatriculaContenedor formulario = new frmGestionarMatriculaContenedor(mod);
        formulario.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnControlAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlAcademicoActionPerformed
        //Abrir contenedor de Control Academico
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        this.setVisible(false);
        frmControlAcademicoContenedor academico = new frmControlAcademicoContenedor(mod);
        academico.setVisible(true);
        
    }//GEN-LAST:event_btnControlAcademicoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Abrir contenedor de Cuentas Usuario
        MtoLogin log=new MtoLogin();
        log.obtenerDatosUsuario(mod);
        this.setVisible(false);
        frmHerramientasContenedor usuario = new frmHerramientasContenedor(mod);
        usuario.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnMiCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiCuentaActionPerformed
        this.setVisible(false);
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        FrmMiCuenta frm = new FrmMiCuenta(mod);
        frm.setVisible(true);
    }//GEN-LAST:event_btnMiCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnControlAcademico;
    private javax.swing.JButton btnMiCuenta;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        //se crea el contador de hora
        Thread ct=Thread.currentThread();
        
        while(ct==hl)      
        {
             calcula();
             lblHora.setText(hora+":"+minutos+" "+ampm);
             try
             {
                 Thread.sleep(1000);
             
             }
             
             catch(InterruptedException e)
                     
             {
               
               
             }
             
        }
    }

    //se crea el metodo para calcular hora dependiendo de AM o PM
    private void calcula() {
        
        Calendar calendario= new GregorianCalendar();
        Date fechahoraactual=new Date();
        calendario.setTime(fechahoraactual);
        ampm=calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        if (ampm.equals("PM")) {
            
            int h=calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora=h>9?""+h:"0"+h;
            
        }
        else{
            
            hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        
        }
        minutos=calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
    }
}
