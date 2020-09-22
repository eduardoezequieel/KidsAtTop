/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CtrlLoginUsuario;
import controlador.CtrlUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.ClsConexion;
import modelo.MtoBitacoras;
import modelo.MtoUsuario;
import modelo.ClsValidaciones;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author EDUARDO
 */
public class FrmGestionarUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmAgregarUsuario
     */
    //Variables globales
        String filename = null;
        byte[] person_image = null;
        DefaultTableModel modelo = new DefaultTableModel();
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        CtrlLoginUsuario mod;
        ClsValidaciones val = new ClsValidaciones();
        
    public FrmGestionarUsuarios() {
        initComponents();
    }

    public FrmGestionarUsuarios(CtrlLoginUsuario mod) throws ParseException {
        initComponents();
        this.mod = mod;
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        txtId.setVisible(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnReiniciarCuenta.setEnabled(false);
        btnExaminar.setEnabled(false);
        
        //Personalizacion JDateChooser
        jCalendario.getJCalendar().setForeground(new Color(254,254,254));
        jCalendario.getJCalendar().setSundayForeground(Color.WHITE);
        jCalendario.getJCalendar().setWeekdayForeground(Color.WHITE);
        jCalendario.getJCalendar().setDecorationBackgroundVisible(false);
        jCalendario.getJCalendar().setWeekOfYearVisible(false);
        jCalendario.getJCalendar().setBackground(Color.WHITE);
        jCalendario.getJCalendar().setPreferredSize(new Dimension(450, 450));
        
        //Cargando jTable
        modelo.addColumn("Usuario");
        modelo.addColumn("Tipo Usuario");
        modelo.addColumn("Estado");
        tUsuarios.setModel(modelo);
        
        tUsuarios.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        tUsuarios.getTableHeader().setOpaque(false);
        tUsuarios.getTableHeader().setBackground(new Color(33, 37, 41));
        tUsuarios.getTableHeader().setForeground(new Color(254,254,254));
        
        //Metodos a cargar
        llenarTipoUsuario();
        mostrarUsuario();
        centrarColumnas();
        
        String fecha = "2002/01/1";
        java.util.Date fechaParseada= new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
        jCalendario.setDate(fechaParseada);
        
        for (Component component : jLayeredPane1.getComponents()) {
            component.setEnabled(false); 
        }
        
        for (Component component : jLayeredPane2.getComponents()) {
            component.setEnabled(false); 
        }
        
        
    }
    
    public void llenarTipoUsuario(){
        MtoUsuario a = new MtoUsuario();
        cbTipoUsuario.setModel(a.llenarTipoUsuario());
    }
    
    public void centrarColumnas(){
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 3; i++) {
            tUsuarios.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
    }
    
    public void limpiarTabla(){
        //Limpiar tabla
        int filas = tUsuarios.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
    }
    
    public void reiniciarBusqueda()
    {
        jBuscar.setText("");
        String busqueda = jBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tUsuarios.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
    }
    
    public void mostrarUsuario(){
        ClsConexion con = new ClsConexion();
        Connection datos;
        try
        {
            datos = con.conectar();
            String sql = "SELECT usuario, t.tipo_usuario, e.estado_usuario FROM usuario u, tipo_usuario t, estado_usuario e WHERE u.id_estado_usuario = e.id_estado_usuario "
                    + "AND u.id_tipo_usuario = t.id_tipo_usuario  AND NOT usuario = '"+mod.getUsuario()+"'";
            PreparedStatement dato = datos.prepareStatement(sql);
            ResultSet rs = dato.executeQuery();
            while(rs.next()){
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3)};
                modelo.addRow(fila);
            }
            tUsuarios.setModel(modelo);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void limpiarCampo(){
        jNombre.setText("");
        jApellido.setText("");
        jUsuario.setText("");
        rbFemenino.setSelected(false);
        rbMasculino.setSelected(false);
        jDUI.setText("");
        jNIP.setText("");
        jNIT.setText("");
        txtId.setText("");
        jTelefono.setText("");
        jCorreo.setText("");
        jFecha.setText("");
        jDireccion.setText("");
        lblFoto.setIcon(null);
        
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false);
        btnReiniciarCuenta.setEnabled(false);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDUI = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jNIP = new javax.swing.JFormattedTextField();
        jNIT = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jTelefono = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jCalendario = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jCorreo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDireccion = new javax.swing.JTextArea();
        jFecha = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnReiniciarCuenta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSuspender = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administración de Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        lblFoto.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 160, 160));

        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_default.png"))); // NOI18N
        btnExaminar.setBorder(null);
        btnExaminar.setContentAreaFilled(false);
        btnExaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExaminar.setFocusPainted(false);
        btnExaminar.setFocusable(false);
        btnExaminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_rollover.png"))); // NOI18N
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 180, 80));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbMasculino.setBackground(new java.awt.Color(33, 37, 41));
        bgGenero.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbMasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbMasculino.setText("Masculino");
        rbMasculino.setFocusPainted(false);
        jLayeredPane1.add(rbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        rbFemenino.setBackground(new java.awt.Color(33, 37, 41));
        bgGenero.add(rbFemenino);
        rbFemenino.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbFemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbFemenino.setText("Femenino");
        rbFemenino.setFocusPainted(false);
        jLayeredPane1.add(rbFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Género:");
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 230, -1));

        jUsuario.setBackground(new java.awt.Color(33, 37, 41));
        jUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jUsuarioKeyTyped(evt);
            }
        });
        jLayeredPane1.add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuario:");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, -1));

        cbTipoUsuario.setBackground(new java.awt.Color(33, 37, 41));
        cbTipoUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoUsuario.setBorder(null);
        jLayeredPane1.add(cbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tipo de Usuario:");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, -1));

        jApellido.setBackground(new java.awt.Color(33, 37, 41));
        jApellido.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jApellido.setForeground(new java.awt.Color(255, 255, 255));
        jApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jApellidoKeyTyped(evt);
            }
        });
        jLayeredPane1.add(jApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Apellidos:");
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, -1));

        jNombre.setBackground(new java.awt.Color(33, 37, 41));
        jNombre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNombre.setForeground(new java.awt.Color(255, 255, 255));
        jNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNombreKeyTyped(evt);
            }
        });
        jLayeredPane1.add(jNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombres:");
        jLayeredPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DUI:");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 230, -1));

        jDUI.setBackground(new java.awt.Color(33, 37, 41));
        jDUI.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jDUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jDUI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDUI.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayeredPane1.add(jDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NIP:");
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 230, -1));

        jNIP.setBackground(new java.awt.Color(33, 37, 41));
        jNIP.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jNIP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jNIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNIP.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayeredPane1.add(jNIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 230, 30));

        jNIT.setBackground(new java.awt.Color(33, 37, 41));
        jNIT.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jNIT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jNIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNIT.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayeredPane1.add(jNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 230, 30));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NIT:");
        jLayeredPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 230, -1));

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 260, 510));

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTelefono.setBackground(new java.awt.Color(33, 37, 41));
        jTelefono.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTelefono.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayeredPane2.add(jTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 30));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Teléfono:");
        jLayeredPane2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, -1));

        jCalendario.setMaxSelectableDate(new java.util.Date(1041404474000L));
        jCalendario.setMinSelectableDate(new java.util.Date(-315590326000L));
        jCalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarioPropertyChange(evt);
            }
        });
        jLayeredPane2.add(jCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 50, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Fecha de Nacimiento:");
        jLayeredPane2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, -1));

        jCorreo.setBackground(new java.awt.Color(33, 37, 41));
        jCorreo.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCorreoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCorreoKeyTyped(evt);
            }
        });
        jLayeredPane2.add(jCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 280, 30));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Correo Electrónico:");
        jLayeredPane2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 280, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Dirección:");
        jLayeredPane2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 280, -1));

        jDireccion.setBackground(new java.awt.Color(33, 37, 41));
        jDireccion.setColumns(20);
        jDireccion.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jDireccion.setLineWrap(true);
        jDireccion.setRows(5);
        jDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 119, 119), 1, true));
        jDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jDireccion);

        jLayeredPane2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, 180));

        jFecha.setEditable(false);
        jFecha.setBackground(new java.awt.Color(33, 37, 41));
        jFecha.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jFecha.setForeground(new java.awt.Color(255, 255, 255));
        jFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jLayeredPane2.add(jFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 30));

        jPanel1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 310, 410));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndMarcoFotoPequeño.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 200, 200));

        btnReiniciarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnReiniciarCuenta_default.png"))); // NOI18N
        btnReiniciarCuenta.setBorder(null);
        btnReiniciarCuenta.setContentAreaFilled(false);
        btnReiniciarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarCuenta.setFocusPainted(false);
        btnReiniciarCuenta.setFocusable(false);
        btnReiniciarCuenta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnReiniciarCuenta_rollover.png"))); // NOI18N
        btnReiniciarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, 70));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_default.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFocusable(false);
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActualizar_rollover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, -1, 70));

        btnSuspender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_default.png"))); // NOI18N
        btnSuspender.setBorder(null);
        btnSuspender.setContentAreaFilled(false);
        btnSuspender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSuspender.setFocusPainted(false);
        btnSuspender.setFocusable(false);
        btnSuspender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSuspender_rollover.png"))); // NOI18N
        btnSuspender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuspender, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, 70));

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActivarDefault.png"))); // NOI18N
        btnActivar.setBorder(null);
        btnActivar.setContentAreaFilled(false);
        btnActivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActivar.setFocusPainted(false);
        btnActivar.setFocusable(false);
        btnActivar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnActivarRollover.png"))); // NOI18N
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, -1, 70));

        tUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tUsuarios.setBackground(new java.awt.Color(33, 37, 41));
        tUsuarios.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tUsuarios.setFocusable(false);
        tUsuarios.setGridColor(new java.awt.Color(64, 65, 65));
        tUsuarios.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tUsuarios.setRowHeight(30);
        tUsuarios.setSelectionBackground(new java.awt.Color(45, 252, 119));
        tUsuarios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tUsuarios.setShowVerticalLines(false);
        tUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tUsuarios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 510, 440));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Buscar...");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 510, -1));

        jBuscar.setBackground(new java.awt.Color(33, 37, 41));
        jBuscar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 510, 30));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(33, 37, 41));
        txtId.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyPressed
       String Caracteres = jNombre.getText();
        if(Caracteres.length()>=30){
            jNombre.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNombreKeyPressed

    private void jNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyTyped
        val.verificarLetras(evt);
    }//GEN-LAST:event_jNombreKeyTyped

    private void jApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyPressed
        String Caracteres = jApellido.getText();
        if(Caracteres.length()>=30){
            jApellido.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jApellidoKeyPressed

    private void jApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyTyped
        val.verificarLetras(evt);
    }//GEN-LAST:event_jApellidoKeyTyped

    private void jUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyPressed
        String Caracteres = jUsuario.getText();
        if(Caracteres.length()>=25){
            jUsuario.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jUsuarioKeyPressed

    private void jUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyTyped
        val.verificarAlfanumerico(evt);
    }//GEN-LAST:event_jUsuarioKeyTyped

    private void jCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCorreoKeyPressed
        String Caracteres = jCorreo.getText();
        if(Caracteres.length()>=50){
            jCorreo.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jCorreoKeyPressed

    private void jCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCorreoKeyTyped
        
    }//GEN-LAST:event_jCorreoKeyTyped

    private void jDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyTyped
        val.verificarAlfanumerico(evt);
    }//GEN-LAST:event_jDireccionKeyTyped

    private void jDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyPressed
        String Caracteres = jDireccion.getText();
        if(Caracteres.length()>=200){
            jDireccion.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jDireccionKeyPressed

    private void jCalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarioPropertyChange
         try{
             String dia = Integer.toString(jCalendario.getCalendar().get(Calendar.DATE));
            String año = Integer.toString(jCalendario.getCalendar().get(Calendar.YEAR));
            int mesInt = jCalendario.getCalendar().get(Calendar.MONTH) + 1;
            String mes = Integer.toString(mesInt);
            String fecha = (mes+"-"+dia+"-"+año);
            jFecha.setText(fecha);
      
        }
         catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jCalendarioPropertyChange

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        try
        {
            JFileChooser buscar = new JFileChooser();
        buscar.showOpenDialog(null);
        File f = buscar.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imagen = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(imagen);
            try
            {
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte [1024];
                for (int readNum; (readNum=fis.read(buf))!=-1;) {
                    bos.write(buf,0,readNum);
                }   
                person_image=bos.toByteArray();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnReiniciarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarCuentaActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas reiniciar la contraseña de este usuario? Se perderan sus preguntas de seguridad.","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if (mensaje == JOptionPane.YES_OPTION) {
            CtrlUsuario ctrl = new CtrlUsuario();
            MtoUsuario mto = new MtoUsuario();
            String contraSinEncriptacion="123"; 
            String contraConEncriptacion=DigestUtils.sha1Hex(contraSinEncriptacion);
            ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
            ctrl.setContraseña(contraConEncriptacion);

            if (mto.reiniciarContraseña()) {
                if (mto.eliminarRespuestas()) {
                    JOptionPane.showMessageDialog(null, "La contraseña de este usuario ha sido reestablecida a 123.","Contraseña reestablecida exitosamente", JOptionPane.INFORMATION_MESSAGE);
                    reiniciarBusqueda();
                    limpiarTabla();
                    mostrarUsuario();
                    limpiarCampo();
                    MtoBitacoras add=new MtoBitacoras();
                    int id=add.capturarIdBitacora()+1;
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    add.agregarBitacoraReiniciaCuenta(mod);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }
        }
    }                          
    }//GEN-LAST:event_btnReiniciarCuentaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         if (jNombre.getText().isEmpty() || jApellido.getText().isEmpty() || jTelefono.getText().isEmpty() || jUsuario.getText().isEmpty() || jDUI.getText().isEmpty() ||
            jDireccion.getText().isEmpty() || jFecha.getText().isEmpty() || jCorreo.getText().isEmpty() || jNIP.getText().isEmpty() || jNIT.getText().isEmpty() || (lblFoto.getIcon() == null)) {
            JOptionPane.showMessageDialog(null, "Error", "Existen campos vacios", JOptionPane.WARNING_MESSAGE);
        }
        else if(val.email(jCorreo.getText()))
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar estos campos?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                //Asignando datos
                CtrlUsuario ctrl = new CtrlUsuario();
                MtoUsuario mto = new MtoUsuario();
                ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
                ctrl.setNombre(jNombre.getText());
                ctrl.setApellido(jApellido.getText());
                int idTipoUsuario = mto.getIdTipoUsuario(cbTipoUsuario.getItemAt(cbTipoUsuario.getSelectedIndex()));
                ctrl.setId_tipo_usuario(idTipoUsuario);
                ctrl.setEmail(jCorreo.getText());
                ctrl.setTelefono(jTelefono.getText());
                ctrl.setDui(jDUI.getText());
                ctrl.setNit(jNIT.getText());
                ctrl.setUsuario(jUsuario.getText());
                ctrl.setNip(jNIP.getText());
                ctrl.setFecha_nacimiento(jFecha.getText());
                if (rbMasculino.isSelected()) {
                    ctrl.setGenero("M");
                }
                else if(rbFemenino.isSelected())
                {
                    ctrl.setGenero("F");
                }
                ctrl.setDireccion(jDireccion.getText());
                ctrl.setFoto(person_image);
                
                if (mto.actualizarUsuario()) {
                    JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    MtoBitacoras add=new MtoBitacoras();
                    int id=add.capturarIdBitacora()+1;
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    add.agregarBitacoraActualizarUsuario(mod);
                    reiniciarBusqueda();
                    limpiarTabla();
                    mostrarUsuario();
                    limpiarCampo();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Correo invalido.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSuspenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderActionPerformed
        if (jNombre.getText().isEmpty() || jApellido.getText().isEmpty() || jTelefono.getText().isEmpty() || jUsuario.getText().isEmpty() || jDUI.getText().isEmpty() ||
            jDireccion.getText().isEmpty() || jFecha.getText().isEmpty() || jCorreo.getText().isEmpty() || jNIP.getText().isEmpty() || jNIT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error", "Existen campos vacios", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas suspender a este usuario?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                 MtoUsuario mto = new MtoUsuario();
                CtrlUsuario ctrl = new CtrlUsuario();
        
                ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
                if (mto.suspenderUsuario()) {  
                    JOptionPane.showMessageDialog(null, "El usuario ha sido suspendido de forma exitosa.","Exito",JOptionPane.INFORMATION_MESSAGE);  
                    MtoBitacoras add=new MtoBitacoras();
                    int id=add.capturarIdBitacora()+1;
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    add.agregarBitacoraSuspenderUsuario(mod);

                    reiniciarBusqueda();
                    limpiarTabla();
                    mostrarUsuario();
                    limpiarCampo();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        }
    }//GEN-LAST:event_btnSuspenderActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
         if (jNombre.getText().isEmpty() || jApellido.getText().isEmpty() || jTelefono.getText().isEmpty() || jUsuario.getText().isEmpty() || jDUI.getText().isEmpty() ||
            jDireccion.getText().isEmpty() || jFecha.getText().isEmpty() || jCorreo.getText().isEmpty() || jNIP.getText().isEmpty() || jNIT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error", "Existen campos vacios", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas activar a este usuario?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                MtoUsuario mto = new MtoUsuario();
                CtrlUsuario ctrl = new CtrlUsuario();

                ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
                if (mto.activarUsuario()) { 
                    JOptionPane.showMessageDialog(null, "El usuario ha sido activado de forma exitosa.","Exito",JOptionPane.INFORMATION_MESSAGE);
                    MtoBitacoras add=new MtoBitacoras();
                    int id=add.capturarIdBitacora()+1;
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    add.agregarBitacoraActivarUsuario(mod);

                    reiniciarBusqueda();
                    limpiarTabla();
                    mostrarUsuario();
                    limpiarCampo();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void tUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tUsuariosMouseClicked
        
        MtoUsuario mto = new MtoUsuario();
        CtrlUsuario ctrl = new CtrlUsuario();
        btnActualizar.setEnabled(true);
        btnReiniciarCuenta.setEnabled(true);
        btnExaminar.setEnabled(true);
        for (Component component : jLayeredPane1.getComponents()) {
            component.setEnabled(true); 
        }
        
        for (Component component : jLayeredPane2.getComponents()) {
            component.setEnabled(true); 
        }
        
        //Capturando datos del jTable
        int fila = tUsuarios.getSelectedRow();
        String usuario = String.valueOf(tUsuarios.getValueAt(fila, 0));
        String estado = String.valueOf(tUsuarios.getValueAt(fila, 2));
        
        //Desactivar y activar
        if ("Disponible".equals(estado)) {
            btnSuspender.setEnabled(true);
            btnActivar.setEnabled(false);
        }else if("Suspendido".equals(estado))
        {
            btnSuspender.setEnabled(false);
            btnActivar.setEnabled(true);
        }
        
        //Seteando combobox
        String itemTipoUsuario = mto.getItemsTipoUsuario(usuario);
        cbTipoUsuario.setSelectedItem(itemTipoUsuario);
        
        //Seteando id
        int idUsuario = mto.getIdUsuario(usuario);
        txtId.setText(String.valueOf(idUsuario));
        
        //Capturando demas datos.
        mto.capturarDatosUsuario(usuario);
        jNombre.setText(ctrl.getNombre());
        jApellido.setText(ctrl.getApellido());
        String genero = ctrl.getGenero();
        if (genero.equals("F")) {
            rbFemenino.setSelected(true);
            rbMasculino.setSelected(false);
        }
        else if(genero.equals("M"))
        {
            rbMasculino.setSelected(true);
            rbFemenino.setSelected(false);
        }
        jDUI.setText(ctrl.getDui());
        jNIP.setText(ctrl.getNip());
        jNIT.setText(ctrl.getNit());
        jFecha.setText(ctrl.getFecha_nacimiento());
        jTelefono.setText(ctrl.getTelefono());
        jCorreo.setText(ctrl.getEmail());
        jDireccion.setText(ctrl.getDireccion());
        jUsuario.setText(usuario);
        byte[] foto = mto.capturarFoto(usuario);
        person_image = foto;
        ImageIcon imagen = new ImageIcon(new ImageIcon(foto).getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(imagen);
        
    }//GEN-LAST:event_tUsuariosMouseClicked

    private void jBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBuscarKeyPressed

    private void jBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jBuscarKeyTyped

    private void jBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyReleased
        String busqueda = jBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tUsuarios.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
    }//GEN-LAST:event_jBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGenero;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnReiniciarCuenta;
    private javax.swing.JButton btnSuspender;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JTextField jApellido;
    private javax.swing.JTextField jBuscar;
    private com.toedter.calendar.JDateChooser jCalendario;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JFormattedTextField jDUI;
    private javax.swing.JTextArea jDireccion;
    private javax.swing.JTextField jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JFormattedTextField jNIP;
    private javax.swing.JFormattedTextField jNIT;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jTelefono;
    private javax.swing.JTextField jUsuario;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tUsuarios;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    
}
