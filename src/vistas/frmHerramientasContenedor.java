/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlLoginUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.MtoLogin;


/**
 *
 * @author katy0
 */
public class frmHerramientasContenedor extends javax.swing.JFrame {
     
    CtrlLoginUsuario mod;
  
   
    public frmHerramientasContenedor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
     public frmHerramientasContenedor(CtrlLoginUsuario mod){
        initComponents();
        this.mod = mod;
        System.out.println(mod.getId_tipo_usuario());
        
        int user=mod.getId_tipo_usuario();
         if (user==2||user==3||user==4) {
             
             jControlarUsuarios.setEnabled(false);
         }
         
        
        
        
        
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
        jEscritorio = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jControlarUsuarios1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jControlarUsuarios = new javax.swing.JButton();
        jReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(33, 37, 41));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEscritorio.setBackground(new java.awt.Color(33, 37, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoKidsAtTop.png"))); // NOI18N

        jEscritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jEscritorioLayout = new javax.swing.GroupLayout(jEscritorio);
        jEscritorio.setLayout(jEscritorioLayout);
        jEscritorioLayout.setHorizontalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEscritorioLayout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(253, 253, 253))
        );
        jEscritorioLayout.setVerticalGroup(
            jEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEscritorioLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jEscritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 1000, 740));

        jControlarUsuarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backpng.png"))); // NOI18N
        jControlarUsuarios1.setBorder(null);
        jControlarUsuarios1.setContentAreaFilled(false);
        jControlarUsuarios1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jControlarUsuarios1.setFocusPainted(false);
        jControlarUsuarios1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back_rollover.png"))); // NOI18N
        jControlarUsuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jControlarUsuarios1ActionPerformed(evt);
            }
        });
        jPanel1.add(jControlarUsuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 240, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndHerramientasSistema.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 280, 280));

        jControlarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdministrarUsuarios_default.png"))); // NOI18N
        jControlarUsuarios.setBorder(null);
        jControlarUsuarios.setContentAreaFilled(false);
        jControlarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jControlarUsuarios.setFocusPainted(false);
        jControlarUsuarios.setFocusable(false);
        jControlarUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdministrarUsuarios_rollover.png"))); // NOI18N
        jControlarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jControlarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(jControlarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 360, 70));

        jReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnReportesDefault.png"))); // NOI18N
        jReportes.setBorder(null);
        jReportes.setContentAreaFilled(false);
        jReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jReportes.setFocusPainted(false);
        jReportes.setFocusable(false);
        jReportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnReportesRollover.png"))); // NOI18N
        jReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReportesActionPerformed(evt);
            }
        });
        jPanel1.add(jReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 360, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dashboard.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, -1, 740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jControlarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jControlarUsuariosActionPerformed
        //Abriendo formulario de Controlar Usuarios
        frmControlarUsuarios usuarios = null;
        try {
            usuarios = new frmControlarUsuarios();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmHerramientasContenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        jEscritorio.add(usuarios);
        usuarios.setVisible(true);
    }//GEN-LAST:event_jControlarUsuariosActionPerformed

    private void jControlarUsuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jControlarUsuarios1ActionPerformed
        this.setVisible(false);
         MtoLogin log=new MtoLogin();
         log.obtenerDatosUsuario(mod);
        frmPrincipal formulario = new frmPrincipal(mod);
        formulario.setVisible(true);
    }//GEN-LAST:event_jControlarUsuarios1ActionPerformed

    private void jReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jReportesActionPerformed

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
            java.util.logging.Logger.getLogger(frmHerramientasContenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHerramientasContenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHerramientasContenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHerramientasContenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHerramientasContenedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jControlarUsuarios;
    private javax.swing.JButton jControlarUsuarios1;
    private javax.swing.JDesktopPane jEscritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jReportes;
    // End of variables declaration//GEN-END:variables
}
