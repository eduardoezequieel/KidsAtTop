/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlResponsable;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.Conexion;
import javax.swing.table.DefaultTableModel;
import modelo.MtoResponsable;

/**
 *
 * @author katy0
 */
public class frmGestionarResponsable extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    CtrlResponsable ctrl = new CtrlResponsable();
    /**
     * Creates new form GestionarResponsableForm
     */
    public frmGestionarResponsable() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
         tResponsables.getTableHeader().setFont(new Font("Roboto Light", Font.BOLD, 12));
        tResponsables.getTableHeader().setOpaque(false);
        tResponsables.getTableHeader().setBackground(new Color(33, 37, 41));
        tResponsables.getTableHeader().setForeground(new Color(254,254,254));
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnCorreo.setEnabled(false);
        
        //Llenando jTable
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DUI");
        modelo.addColumn("Teléfono");
        modelo.addColumn("E-mail");
        modelo.addColumn("Parentesco");
        tResponsables.setModel(modelo);
        tResponsables.removeColumn(tResponsables.getColumnModel().getColumn(0));
        this.mostrarResponsables();
        
        this.llenarParentesco();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDui = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnCorreo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tResponsables = new javax.swing.JTable();
        btnSuspender = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        cbParentesco = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Gestionar Responsables ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Apellido:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("DUI:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Parentesco:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        txtNombre.setBackground(new java.awt.Color(33, 37, 41));
        txtNombre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(254, 254, 254));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, 30));

        txtEmail.setBackground(new java.awt.Color(33, 37, 41));
        txtEmail.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(254, 254, 254));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 300, 30));

        txtDui.setBackground(new java.awt.Color(33, 37, 41));
        txtDui.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtDui.setForeground(new java.awt.Color(254, 254, 254));
        txtDui.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDui.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 250, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Teléfono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        txtApellido.setBackground(new java.awt.Color(33, 37, 41));
        txtApellido.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(254, 254, 254));
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(33, 37, 41));
        txtTelefono.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(254, 254, 254));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 190, 30));

        btnCorreo.setBackground(new java.awt.Color(33, 37, 41));
        btnCorreo.setForeground(new java.awt.Color(254, 254, 254));
        btnCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEnviarCorreo_default.png"))); // NOI18N
        btnCorreo.setBorder(null);
        btnCorreo.setContentAreaFilled(false);
        btnCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCorreo.setFocusPainted(false);
        btnCorreo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEnviarCorreo_rollover.png"))); // NOI18N
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, 140, 70));

        btnActualizar.setBackground(new java.awt.Color(33, 37, 41));
        btnActualizar.setForeground(new java.awt.Color(254, 254, 254));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 140, 70));

        tResponsables.setBackground(new java.awt.Color(33, 37, 41));
        tResponsables.setFont(new java.awt.Font("Roboto Light", 1, 17)); // NOI18N
        tResponsables.setModel(new javax.swing.table.DefaultTableModel(
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
        tResponsables.setFocusable(false);
        tResponsables.setGridColor(new java.awt.Color(64, 65, 65));
        tResponsables.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tResponsables.setRowHeight(30);
        tResponsables.setSelectionBackground(new java.awt.Color(58, 58, 58));
        tResponsables.setShowVerticalLines(false);
        tResponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tResponsablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tResponsables);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 960, 320));

        btnSuspender.setBackground(new java.awt.Color(33, 37, 41));
        btnSuspender.setForeground(new java.awt.Color(254, 254, 254));
        btnSuspender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_default.png"))); // NOI18N
        btnSuspender.setBorder(null);
        btnSuspender.setContentAreaFilled(false);
        btnSuspender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSuspender.setFocusPainted(false);
        btnSuspender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_rollover.png"))); // NOI18N
        btnSuspender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuspender, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 140, 70));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Digite lo que desea buscar:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        jTextField11.setBackground(new java.awt.Color(33, 37, 41));
        jTextField11.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(254, 254, 254));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 620, 30));

        cbParentesco.setBackground(new java.awt.Color(33, 37, 41));
        cbParentesco.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbParentesco.setForeground(new java.awt.Color(255, 255, 255));
        cbParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbParentesco.setBorder(null);
        jPanel1.add(cbParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarParentesco(){
        MtoResponsable a = new MtoResponsable();
        cbParentesco.setModel(a.llenarParentesco());
    }
    
    public void mostrarResponsables(){
        Conexion con = new Conexion();
        Connection datos;
        try
        {
            datos = con.conectar();
            String sql = "SELECT r.id_responsable, r.nombre, r.apellido, r.dui, r.telefono, r.email, p.parentesco FROM responsable r, parentesco p "
                    + "WHERE r.id_parentesco = p.id_parentesco";
            PreparedStatement dato = datos.prepareStatement(sql);
            ResultSet rs = dato.executeQuery();
            while(rs.next()){
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
                modelo.addRow(fila);
            }
            tResponsables.setModel(modelo);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
        frmCorreo formulario = new frmCorreo();
        formulario.setVisible(true);
    }//GEN-LAST:event_btnCorreoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(txtNombre.getText().trim().equals("") || txtApellido.getText().trim().equals("") || txtDui.getText().trim().equals("") || txtTelefono.getText().trim().equals("") || txtEmail.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campos vacios.","Rellene los campos faltantes.",JOptionPane.WARNING_MESSAGE);
        }else{
            MtoResponsable mto = new MtoResponsable();
            ctrl.setNombre(txtNombre.getText());
            ctrl.setApellido(txtApellido.getText());
            ctrl.setDui(txtDui.getText());
            ctrl.setEmail(txtEmail.getText());
            ctrl.setTelefono(txtTelefono.getText());
            if (mto.actualizarResponsable(String.valueOf(cbParentesco.getSelectedItem()))) {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
            mostrarResponsables();
            //System.out.println(txtNombre.getText() + " " + txtApellido.getText() + " " + txtDui.getText() + " " + txtTelefono.getText() + " " + txtEmail.getText());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSuspenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuspenderActionPerformed

    private void tResponsablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tResponsablesMouseClicked
        //Activar botones
        btnActualizar.setEnabled(true);
        btnSuspender.setEnabled(true);
        btnCorreo.setEnabled(true);

        //Obtener fila seleccionada
        int fila = tResponsables.getSelectedRow();
        
        //Creando objeto de controlador
        CtrlResponsable ctr = new CtrlResponsable();
        
        //Obteniendo valores de la tabla
        txtNombre.setText(String.valueOf(tResponsables.getValueAt(fila, 0)));
        txtApellido.setText(String.valueOf(tResponsables.getValueAt(fila, 1)));
        txtDui.setText(String.valueOf(tResponsables.getValueAt(fila, 2)));
        txtTelefono.setText(String.valueOf(tResponsables.getValueAt(fila, 3)));
        txtEmail.setText(String.valueOf(tResponsables.getValueAt(fila, 4)));
        cbParentesco.setSelectedItem(String.valueOf(tResponsables.getValueAt(fila, 5)));
        ctr.setIdResponsable(Integer.parseInt((String)tResponsables.getModel().getValueAt(fila, 0)));
    }//GEN-LAST:event_tResponsablesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCorreo;
    private javax.swing.JButton btnSuspender;
    private javax.swing.JComboBox<String> cbParentesco;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTable tResponsables;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
