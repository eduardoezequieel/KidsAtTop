/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author katy0
 */
public class frmGestionarNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionarNotasForm
     */
    public frmGestionarNotas() {
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
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNotas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Gestionar Notas ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Indicador de logro:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox1.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 290, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Estudiante:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Nota:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jComboBox3.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox3.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 180, -1));

        jComboBox2.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox2.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 550, -1));

        tNotas.setBackground(new java.awt.Color(33, 37, 41));
        tNotas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tNotas.setForeground(new java.awt.Color(254, 254, 254));
        tNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tNotas.setRowHeight(30);
        tNotas.setSelectionBackground(new java.awt.Color(45, 252, 119));
        tNotas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tNotas.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 890, 340));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Digite lo que desea buscar:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jComboBox4.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox4.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 290, -1));

        jTextField1.setBackground(new java.awt.Color(33, 37, 41));
        jTextField1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(254, 254, 254));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 210, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("Año:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jButton7.setBackground(new java.awt.Color(33, 37, 41));
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_default.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_rollover.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 140, 70));

        jButton5.setBackground(new java.awt.Color(33, 37, 41));
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 140, 70));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setText("Grado/Sección:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, 20));

        jComboBox5.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox5.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 290, -1));

        jComboBox6.setBackground(new java.awt.Color(33, 37, 41));
        jComboBox6.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(254, 254, 254));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 180, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(254, 254, 254));
        jLabel16.setText("Trimestre:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tNotas;
    // End of variables declaration//GEN-END:variables
}
