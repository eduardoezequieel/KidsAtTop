/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlLoginUsuario;
import controlador.CtrlNotas;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.MtoNotas;
import modelo.Validaciones;

/**
 *
 * @author katy0
 */
public class FrmIndicadores extends javax.swing.JInternalFrame {

    
    public FrmIndicadores() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        tNotas.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        tNotas.getTableHeader().setOpaque(false);
        tNotas.getTableHeader().setBackground(new Color(33, 37, 41));
        tNotas.getTableHeader().setForeground(new Color(254,254,254));
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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNotas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cbNivelAcademico = new javax.swing.JComboBox<>();
        jBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jIndicador = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gestionar Indicadores de Logro");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, -1));

        tNotas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tNotas.setBackground(new java.awt.Color(33, 37, 41));
        tNotas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tNotas.setForeground(new java.awt.Color(254, 254, 254));
        tNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Indicador de Logro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tNotas.setFocusable(false);
        tNotas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tNotas.setRowHeight(30);
        tNotas.setSelectionBackground(new java.awt.Color(45, 252, 119));
        tNotas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tNotas.setShowVerticalLines(false);
        tNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1000, 410));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Buscar...");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 960, 30));

        cbNivelAcademico.setBackground(new java.awt.Color(33, 37, 41));
        cbNivelAcademico.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbNivelAcademico.setForeground(new java.awt.Color(254, 254, 254));
        cbNivelAcademico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNivelAcademicoItemStateChanged(evt);
            }
        });
        cbNivelAcademico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNivelAcademicoKeyPressed(evt);
            }
        });
        jPanel1.add(cbNivelAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 180, -1));

        jBuscar.setBackground(new java.awt.Color(33, 37, 41));
        jBuscar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jBuscar.setForeground(new java.awt.Color(254, 254, 254));
        jBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 960, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Nivel Academico:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 180, -1));

        btnActualizar.setBackground(new java.awt.Color(33, 37, 41));
        btnActualizar.setForeground(new java.awt.Color(254, 254, 254));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusable(false);
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 130, 60));

        jIndicador.setBackground(new java.awt.Color(33, 37, 41));
        jIndicador.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jIndicador.setForeground(new java.awt.Color(254, 254, 254));
        jIndicador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jIndicador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jIndicador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIndicadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jIndicadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jIndicadorKeyTyped(evt);
            }
        });
        jPanel1.add(jIndicador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 960, 30));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Indicador de Logro");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 950, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNivelAcademicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNivelAcademicoKeyPressed
     
    }//GEN-LAST:event_cbNivelAcademicoKeyPressed

    private void jBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyPressed
 
    }//GEN-LAST:event_jBuscarKeyPressed

    private void jBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyTyped
     
    }//GEN-LAST:event_jBuscarKeyTyped

    private void cbNivelAcademicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNivelAcademicoItemStateChanged

    }//GEN-LAST:event_cbNivelAcademicoItemStateChanged
    
    
    
    
    private void tNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNotasMouseClicked
    
    }//GEN-LAST:event_tNotasMouseClicked

    private void jBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyReleased
  
    }//GEN-LAST:event_jBuscarKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jIndicadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIndicadorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIndicadorKeyPressed

    private void jIndicadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIndicadorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jIndicadorKeyReleased

    private void jIndicadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIndicadorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jIndicadorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cbNivelAcademico;
    private javax.swing.JTextField jBuscar;
    private javax.swing.JTextField jIndicador;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tNotas;
    // End of variables declaration//GEN-END:variables
}
