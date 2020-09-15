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
import modelo.MtoBitacoras;




public class FrmMenu extends javax.swing.JFrame implements Runnable {

    
    CtrlLoginUsuario mod;
    String hora,minutos,ampm;;
    Calendar calendario;
    Thread hl;
    MtoLogin log=new MtoLogin();
    
    
    
    
    public FrmMenu() {
        initComponents();
       
        
        
    }
    
    public FrmMenu(CtrlLoginUsuario mod){
        initComponents();
        this.mod = mod;
        
        this.setLocationRelativeTo(null);
        
        //Seteando usuario logueado
        lblUsuario.setText(mod.getUsuario());
        //Seteando id de usuario para bitacora
        lblId.setText(Integer.toString(mod.getId_usuario()));
        lblId.setVisible(false);
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
            lblTipo.setText("Docente");
        }
        else if(mod.getId_tipo_usuario() == 3)
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
        btnSalir = new javax.swing.JButton();
        lblTipo1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        lblTipo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipo.setText("Administrador");
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, 220, 100));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 236, 236));
        jLabel2.setText("Hola,");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarDefault.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrarRollover.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 30, 30));

        lblTipo1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblTipo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo1.setIcon(new javax.swing.ImageIcon("C:\\Users\\EDUARDO\\Desktop\\check.PNG")); // NOI18N
        jPanel1.add(lblTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 660, 40, 40));

        lblHora.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("00:00:00");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 180, 100));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 236, 236));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/QueHaremos.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 310, 60));

        jLabel5.setFont(new java.awt.Font("Quicksand", 0, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 236, 236));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndMarcoFoto.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 200, 340, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroMenu.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 730));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizarDefault.png"))); // NOI18N
        btnMinimizar.setBorder(null);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizarRollover.png"))); // NOI18N
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 30, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 236, 236));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndInfoMenu.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 550, 170));

        lblId.setText("jLabel3");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 236, 236));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RecuadroHoraFecha.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 728));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar sesión?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                CtrlLoginUsuario log=new CtrlLoginUsuario();
                MtoBitacoras modBD = new MtoBitacoras();
                MtoLogin data=new MtoLogin();
                int id=modBD.capturarIdBitacora()+1;
                data.obtenerDatosUsuario(log);
                log.setId_usuario(Integer.parseInt(lblId.getText()));
                log.setId_bitacora(id);
                modBD.agregarBitacoraSalida(log);
                
                FrmIniciarSesion formulario = null;
                try {
                    formulario = new FrmIniciarSesion();
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                formulario.setVisible(true);
            }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        this.setVisible(false);
        FrmMatriculaCont formulario = new FrmMatriculaCont(mod);
        formulario.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnControlAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlAcademicoActionPerformed
        //Abrir contenedor de Control Academico
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        this.setVisible(false);
        FrmAcademicoContenedor academico = new FrmAcademicoContenedor(mod);
        academico.setVisible(true);
        
    }//GEN-LAST:event_btnControlAcademicoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Abrir contenedor de Cuentas Usuario
        MtoLogin log=new MtoLogin();
        log.obtenerDatosUsuario(mod);
        this.setVisible(false);
        FrmHerramientasCont usuario = new FrmHerramientasCont(mod);
        usuario.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnMiCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiCuentaActionPerformed
        this.setVisible(false);
        MtoLogin log1=new MtoLogin();
        log1.obtenerDatosUsuario(mod);
        FrmMiCuenta frm = new FrmMiCuenta(mod);
        frm.setVisible(true);
    }//GEN-LAST:event_btnMiCuentaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int mensaje;
        mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar el sistema?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnControlAcademico;
    private javax.swing.JButton btnMiCuenta;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipo1;
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
