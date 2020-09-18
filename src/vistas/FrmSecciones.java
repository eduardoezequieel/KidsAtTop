/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlSecciones;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.MtoSecciones;
import modelo.Validaciones;
import modelo.MtoBitacoras;
import controlador.CtrlLoginUsuario;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import kidsattop.JtPropiedades;

/**
 *
 * @author katy0
 */
public class FrmSecciones extends javax.swing.JInternalFrame {
    public TableCellRenderer centerAlight = new JtPropiedades();
    CtrlLoginUsuario mod;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
    CtrlSecciones ctrl = new CtrlSecciones();
    Validaciones val = new Validaciones();

    /**
     * Creates new form GestionarSeccionesForm
     */
    public FrmSecciones() {
        initComponents();

    }

    public FrmSecciones(CtrlLoginUsuario mod) {

        initComponents();
        System.out.println(mod.getId_usuario());
        this.mod = mod;
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        tSecciones.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        tSecciones.getTableHeader().setOpaque(false);
        tSecciones.getTableHeader().setBackground(new Color(33, 37, 41));
        tSecciones.getTableHeader().setForeground(new Color(254, 254, 254));
        modelo.addColumn("identifi");
        modelo.addColumn("Grado");
        modelo.addColumn("Sección");
        modelo.addColumn("Usuario Asignado");
        modelo.addColumn("Año");
        modelo.addColumn("Estado");
        tSecciones.setModel(modelo);
        tSecciones.getColumnModel().getColumn(0).setMinWidth(0);
        tSecciones.getColumnModel().getColumn(0).setMaxWidth(0);
        
        


        mostrarSecciones();
        llenarUsuarios();
        llenarGrados();
        llenarSecciones();
        centrarColumnas();
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false);


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
        jLabel11 = new javax.swing.JLabel();
        cbSecciones = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSecciones = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSuspender = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbGrados = new javax.swing.JComboBox<>();
        btnActivar = new javax.swing.JButton();
        cbAño = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("En este formulario puedes administrar los grados y secciones de tu organización.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 90, 1010, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Digite lo que desea buscar:");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 780, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sección:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 270, -1));

        cbSecciones.setBackground(new java.awt.Color(33, 37, 41));
        cbSecciones.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbSecciones.setForeground(new java.awt.Color(254, 254, 254));
        cbSecciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSecciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbSeccionesKeyPressed(evt);
            }
        });
        jPanel1.add(cbSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 270, -1));

        tSecciones = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tSecciones.setBackground(new java.awt.Color(33, 37, 41));
        tSecciones.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tSecciones.setForeground(new java.awt.Color(255, 255, 255));
        tSecciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tSecciones.setFocusable(false);
        tSecciones.setGridColor(new java.awt.Color(64, 65, 65));
        tSecciones.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tSecciones.setRowHeight(30);
        tSecciones.setSelectionBackground(new java.awt.Color(45, 252, 119));
        tSecciones.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tSecciones.setShowVerticalLines(false);
        tSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSeccionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tSecciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1000, 290));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Usuario del Docente:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 270, -1));

        cbUsuario.setBackground(new java.awt.Color(33, 37, 41));
        cbUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbUsuario.setForeground(new java.awt.Color(254, 254, 254));
        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(cbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 270, -1));

        btnAgregar.setBackground(new java.awt.Color(33, 37, 41));
        btnAgregar.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_default.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_rollover.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 140, 70));

        btnActualizar.setBackground(new java.awt.Color(33, 37, 41));
        btnActualizar.setForeground(new java.awt.Color(254, 254, 254));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 140, 70));

        btnSuspender.setBackground(new java.awt.Color(33, 37, 41));
        btnSuspender.setForeground(new java.awt.Color(254, 254, 254));
        btnSuspender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_default.png"))); // NOI18N
        btnSuspender.setBorder(null);
        btnSuspender.setContentAreaFilled(false);
        btnSuspender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSuspender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_rollover.png"))); // NOI18N
        btnSuspender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuspender, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 140, 70));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Año:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, -1));

        txtBuscar.setBackground(new java.awt.Color(33, 37, 41));
        txtBuscar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(254, 254, 254));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 780, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Grado:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 220, -1));

        cbGrados.setBackground(new java.awt.Color(33, 37, 41));
        cbGrados.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbGrados.setForeground(new java.awt.Color(254, 254, 254));
        cbGrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGrados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbGradosKeyPressed(evt);
            }
        });
        jPanel1.add(cbGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 220, -1));

        btnActivar.setBackground(new java.awt.Color(33, 37, 41));
        btnActivar.setForeground(new java.awt.Color(254, 254, 254));
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActivarDefault.png"))); // NOI18N
        btnActivar.setBorder(null);
        btnActivar.setContentAreaFilled(false);
        btnActivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActivar.setFocusPainted(false);
        btnActivar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActivarRollover.png"))); // NOI18N
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 140, 70));

        cbAño.setBackground(new java.awt.Color(33, 37, 41));
        cbAño.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbAño.setForeground(new java.awt.Color(254, 254, 254));
        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021" }));
        cbAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbAñoKeyPressed(evt);
            }
        });
        jPanel1.add(cbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 220, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestionar Secciones ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 1000, -1));

        btnLimpiar.setBackground(new java.awt.Color(33, 37, 41));
        btnLimpiar.setForeground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLimpiarDefault.png"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLimpiarRollover.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 140, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    public void reiniciarCampos(){
        btnAgregar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false); 
        txtBuscar.setText("");
    }
    
    public void llenarUsuarios() {
        MtoSecciones mto = new MtoSecciones();
        cbUsuario.setModel(mto.obtenerUsuarios());
    }

    public void llenarSecciones() {
        MtoSecciones mto = new MtoSecciones();
        cbSecciones.setModel(mto.obtenerSecciones());
    }

    public void llenarGrados() {
        MtoSecciones mto = new MtoSecciones();
        cbGrados.setModel(mto.obtenerGrados());
    }

    public void vaciarTabla() {
        int filas = tSecciones.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }
    
    public void centrarColumnas(){
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 6; i++) {
            tSecciones.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
    }

    public void mostrarSecciones() {

        Conexion con = new Conexion();
        Connection datos;
        try {
            datos = con.conectar();
            String sql = "Select gs.id_grado_seccion, g.grado, s.seccion, u.usuario, gs.anio_seccion, e.estado_gs "
                    + "from grado_seccion gs, grado g, seccion s, usuario u, estado_gs e "
                    + "where gs.id_usuario = u.id_usuario and gs.id_grado = g.id_grado and gs.id_seccion = s.id_seccion and gs.id_estado_gs = e.id_estado_gs";
            PreparedStatement dato = datos.prepareStatement(sql);
            ResultSet rs = dato.executeQuery();
            while (rs.next()) {
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                modelo.addRow(fila);
            }
            tSecciones.setModel(modelo);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isWhitespace(c) && c != '@' && c != '.' && c != '_') {
            val.verificarAlfanumerico(evt);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        val.verificarPegar(evt);
        String Caracteres = txtBuscar.getText();
        if(Caracteres.length()>=30){
            txtBuscar.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtBuscarKeyPressed
    //</editor-fold>
    private void calAnioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calAnioMousePressed

    }//GEN-LAST:event_calAnioMousePressed

    private void tSeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSeccionesMouseClicked
        MtoSecciones mto = new MtoSecciones();
        btnAgregar.setEnabled(false);
        //Obtener fila seleccionada
        int fila = tSecciones.getSelectedRow();

        if (String.valueOf(tSecciones.getValueAt(fila, 5)).equals("Suspendido")) {
            btnActualizar.setEnabled(true);
            btnSuspender.setEnabled(false);
            btnActivar.setEnabled(true);
        } else {
            btnActualizar.setEnabled(true);
            btnSuspender.setEnabled(true);
            btnActivar.setEnabled(false);
        }
        ctrl.setIdGradoSeccion(Integer.parseInt((String) tSecciones.getValueAt(fila, 0)));
        cbGrados.setSelectedItem((String) tSecciones.getValueAt(fila, 1));
        cbSecciones.setSelectedItem((String) tSecciones.getValueAt(fila, 2));
        cbUsuario.setSelectedItem((String) tSecciones.getValueAt(fila, 3));
        cbAño.setSelectedItem((String)tSecciones.getValueAt(fila, 4));
        mto.obtenerIdGrado();
        mto.obtenerIdUsuario();
        mto.obtenerIdSeccion();

    }//GEN-LAST:event_tSeccionesMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        MtoSecciones mto = new MtoSecciones();
        ctrl.setGrado((String) cbGrados.getSelectedItem());
        ctrl.setSeccion((String) cbSecciones.getSelectedItem());
        ctrl.setUsuario((String) cbUsuario.getSelectedItem());
        ctrl.setAnio(String.valueOf(cbAño.getSelectedItem()));
        mto.obtenerUltimoId();
        mto.obtenerIdGrado();
        mto.obtenerIdUsuario();
        mto.obtenerIdSeccion();
        if (mto.verificarRegistro()) {
            JOptionPane.showMessageDialog(null, "El grado que intenta ingresar ya ha sido registrado");
        } else {
            if (mto.insertarGradoSeccion()) {
                JOptionPane.showMessageDialog(null, "Se han ingresado los datos correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                MtoBitacoras add = new MtoBitacoras();
                int id = add.capturarIdBitacora() + 1;
                mod.setId_usuario(mod.getId_usuario());
                mod.setId_bitacora(id);
                add.agregarBitacoraAgregarSeccion(mod);
                reiniciarCampos();

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        txtBuscar.setText("");
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tSecciones.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        vaciarTabla();
        mostrarSecciones();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        MtoSecciones mto = new MtoSecciones();
        ctrl.setGrado((String) cbGrados.getSelectedItem());
        ctrl.setSeccion((String) cbSecciones.getSelectedItem());
        ctrl.setUsuario((String) cbUsuario.getSelectedItem());
        ctrl.setAnio(String.valueOf(cbAño.getSelectedItem()));
        mto.obtenerIdGrado();
        mto.obtenerIdUsuario();
        mto.obtenerIdSeccion();
        if (mto.verificarRegistro()) {
            JOptionPane.showMessageDialog(null, "El grado que intenta ingresar ya ha sido registrado");
        } else {
            if (mto.actualizarGradoSeccion()) {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                MtoBitacoras add = new MtoBitacoras();
                int id = add.capturarIdBitacora() + 1;
                mod.setId_usuario(mod.getId_usuario());
                mod.setId_bitacora(id);
                add.agregarBitacoraActualizarSeccion(mod);
                reiniciarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        txtBuscar.setText("");
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tSecciones.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        vaciarTabla();
        mostrarSecciones();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSuspenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderActionPerformed
        MtoSecciones mto = new MtoSecciones();
        if (mto.suspenderSeccion()) {
            JOptionPane.showMessageDialog(null, "La sección ha sido suspendida de forma exitosa.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            MtoBitacoras add = new MtoBitacoras();
            int id = add.capturarIdBitacora() + 1;
            mod.setId_usuario(mod.getId_usuario());
            mod.setId_bitacora(id);
            add.agregarBitacoraSuspenderSeccion(mod);
            reiniciarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        txtBuscar.setText("");
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tSecciones.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        vaciarTabla();
        mostrarSecciones();
    }//GEN-LAST:event_btnSuspenderActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tSecciones.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cbGradosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbGradosKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbGradosKeyPressed

    private void cbSeccionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbSeccionesKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbSeccionesKeyPressed

    private void cbUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbUsuarioKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbUsuarioKeyPressed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        MtoSecciones mto = new MtoSecciones();
        if (mto.activarSeccion()) {
            JOptionPane.showMessageDialog(null, "La sección ha sido activada de forma exitosa.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            MtoBitacoras add = new MtoBitacoras();
            int id = add.capturarIdBitacora() + 1;
            mod.setId_usuario(mod.getId_usuario());
            mod.setId_bitacora(id);
            add.agregarBitacoraActivarSeccion(mod);
            reiniciarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        txtBuscar.setText("");
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tSecciones.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        vaciarTabla();
        mostrarSecciones();
    }//GEN-LAST:event_btnActivarActionPerformed

    private void cbAñoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbAñoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAñoKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        reiniciarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSuspender;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbGrados;
    private javax.swing.JComboBox<String> cbSecciones;
    private javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tSecciones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
