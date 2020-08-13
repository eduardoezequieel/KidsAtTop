package vistas;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import controlador.CtrlLoginUsuario;
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
        jLabel2.setText("Hola, "+mod.getUsuario());
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
        jSeparator1 = new javax.swing.JSeparator();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMatricula_default.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnControlAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnControlAcademico.setFocusPainted(false);
        btnControlAcademico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnControlAcademico_rollover.png"))); // NOI18N
        btnControlAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlAcademicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnControlAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 180, 230));

        jSeparator1.setBackground(new java.awt.Color(33, 37, 41));
        jSeparator1.setForeground(new java.awt.Color(45, 255, 120));
        jSeparator1.setToolTipText("");
        jSeparator1.setEnabled(false);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 620, 20));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarSesion_default.png"))); // NOI18N
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarSesion_rollover.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 640, -1, -1));

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 236, 236));
        jLabel2.setText("<html><b>Hola</b>, Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        lblHora.setFont(new java.awt.Font("Quicksand Medium", 1, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(254, 254, 254));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("00:00:00");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 220, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 236, 236));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/QueHaremos.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 310, 60));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 236, 236));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, -1, -1));

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 236, 236));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perfil.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroMenu.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, -1, -1));

        lblTipoUsuario.setText("jLabel6");
        jPanel1.add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTipoUsuario;
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
