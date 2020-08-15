package vistas;

import com.bulenkov.darcula.DarculaLaf;
import controlador.CtrlLoginUsuario;
import controlador.CtrlUsuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.MtoUsuario;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author katy0
 */
public class frmControlarUsuarios extends javax.swing.JInternalFrame {

    //Variables globales
        String filename = null;
        byte[] person_image = null;
        DefaultTableModel modelo = new DefaultTableModel();
        CtrlLoginUsuario mod;
       
    public frmControlarUsuarios(){
        initComponents();
    }

    public frmControlarUsuarios(CtrlLoginUsuario mod) {
        initComponents();
        this.mod = mod;
         txtId.setVisible(false);
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false);
        btnReiniciarCuenta.setEnabled(false);
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        tUsuarios.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        tUsuarios.getTableHeader().setOpaque(false);
        tUsuarios.getTableHeader().setBackground(new Color(33, 37, 41));
        tUsuarios.getTableHeader().setForeground(new Color(254,254,254));
 
        //Cargando jTable
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo Usuario");
        modelo.addColumn("Estado Usuario");
        modelo.addColumn("Usuario");
        modelo.addColumn("Genero");
        tUsuarios.setModel(modelo);
        
        this.mostrarUsuario();
      
      //Personalizacion JDateChooser
      jCalendario.getJCalendar().setForeground(new Color(254,254,254));
      jCalendario.getJCalendar().setSundayForeground(Color.WHITE);
      jCalendario.getJCalendar().setWeekdayForeground(Color.WHITE);
      jCalendario.getJCalendar().setDecorationBackgroundVisible(false);
      jCalendario.getJCalendar().setWeekOfYearVisible(false);
      jCalendario.getJCalendar().setBackground(Color.WHITE);
      jCalendario.getJCalendar().setPreferredSize(new Dimension(450, 450));
       
      //Metodos a ejecutar
      llenarTipoUsuario();
    }
    
    public void reiniciarBusqueda()
    {
        txtBuscar.setText("");
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tUsuarios.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
    }
    
    public void llenarTipoUsuario(){
        MtoUsuario a = new MtoUsuario();
        cbTipoUsuario.setModel(a.llenarTipoUsuario());
    }
    
    public void mostrarUsuario(){
        Conexion con = new Conexion();
        Connection datos;
        try
        {
            datos = con.conectar();
            String sql = "SELECT nombre, apellido, t.tipo_usuario, e.estado_usuario, usuario, genero FROM tipo_usuario t, estado_usuario e, usuario a "
                    + "WHERE a.id_tipo_usuario = t.id_tipo_usuario AND a.id_estado_usuario = e.id_estado_usuario AND NOT usuario = '"+mod.getUsuario()+"'";
            PreparedStatement dato = datos.prepareStatement(sql);
            ResultSet rs = dato.executeQuery();
            while(rs.next()){
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                modelo.addRow(fila);
            }
            tUsuarios.setModel(modelo);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void limpiarCampo(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        rbFemenino.setSelected(false);
        rbMasculino.setSelected(false);
        txtDUI.setText("");
        txtNIP.setText("");
        txtNit.setText("");
        txtFecha.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtId.setText("");
        lblFoto.setIcon(null);
     
        btnAgregar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnSuspender.setEnabled(false);
        btnActivar.setEnabled(false);
        btnReiniciarCuenta.setEnabled(false);
    }
    
    public void limpiarTabla(){
        //Limpiar tabla
        int filas = tUsuarios.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
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

        btgBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnReiniciarCuenta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnSuspender = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLayer1 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rbFemenino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        jLayer2 = new javax.swing.JLayeredPane();
        jCalendario = new com.toedter.calendar.JDateChooser();
        txtFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDUI = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtNit = new javax.swing.JFormattedTextField();
        txtNIP = new javax.swing.JFormattedTextField();
        jLayer3 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        btnCargarFoto = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        lblMarco = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Administrar Usuarios");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        btnReiniciarCuenta.setBackground(new java.awt.Color(33, 37, 41));
        btnReiniciarCuenta.setForeground(new java.awt.Color(254, 254, 254));
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
        jPanel1.add(btnReiniciarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, 140, 70));

        btnActualizar.setBackground(new java.awt.Color(33, 37, 41));
        btnActualizar.setForeground(new java.awt.Color(254, 254, 254));
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
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 140, 70));

        btnActivar.setBackground(new java.awt.Color(33, 37, 41));
        btnActivar.setForeground(new java.awt.Color(254, 254, 254));
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
        jPanel1.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 140, 70));

        btnSuspender.setBackground(new java.awt.Color(33, 37, 41));
        btnSuspender.setForeground(new java.awt.Color(254, 254, 254));
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
        jPanel1.add(btnSuspender, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 140, 70));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(254, 254, 254));
        jLabel18.setText("Digite lo que desea buscar:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 230, -1));

        txtBuscar.setBackground(new java.awt.Color(33, 37, 41));
        txtBuscar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(254, 254, 254));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 550, 30));

        txtId.setBackground(new java.awt.Color(33, 37, 41));
        txtId.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        txtId.setForeground(new java.awt.Color(254, 254, 254));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 40, 30));

        jLayer1.setForeground(new java.awt.Color(33, 37, 41));
        jLayer1.setNextFocusableComponent(jLayer2);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Nombre:");
        jLayer1.add(jLabel5);
        jLabel5.setBounds(20, 10, 70, 30);

        txtNombre.setBackground(new java.awt.Color(33, 37, 41));
        txtNombre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(254, 254, 254));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jLayer1.add(txtNombre);
        txtNombre.setBounds(90, 10, 170, 30);

        cbTipoUsuario.setBackground(new java.awt.Color(33, 37, 41));
        cbTipoUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbTipoUsuario.setForeground(new java.awt.Color(254, 254, 254));
        cbTipoUsuario.setToolTipText("");
        cbTipoUsuario.setBorder(null);
        cbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUsuarioActionPerformed(evt);
            }
        });
        jLayer1.add(cbTipoUsuario);
        cbTipoUsuario.setBounds(20, 110, 240, 29);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Tipo de Usuario:");
        jLayer1.add(jLabel7);
        jLabel7.setBounds(20, 90, 130, 19);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Apellido:");
        jLayer1.add(jLabel6);
        jLabel6.setBounds(20, 50, 61, 30);

        txtApellido.setBackground(new java.awt.Color(33, 37, 41));
        txtApellido.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(254, 254, 254));
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jLayer1.add(txtApellido);
        txtApellido.setBounds(90, 50, 170, 30);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Usuario:");
        jLayer1.add(jLabel12);
        jLabel12.setBounds(20, 150, 58, 20);

        txtUsuario.setBackground(new java.awt.Color(33, 37, 41));
        txtUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(254, 254, 254));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jLayer1.add(txtUsuario);
        txtUsuario.setBounds(20, 170, 240, 30);

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(254, 254, 254));
        jLabel16.setText("Género:");
        jLayer1.add(jLabel16);
        jLabel16.setBounds(20, 210, 54, 20);

        rbFemenino.setBackground(new java.awt.Color(33, 37, 41));
        btgBotones.add(rbFemenino);
        rbFemenino.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbFemenino.setForeground(new java.awt.Color(254, 254, 254));
        rbFemenino.setText("Femenino");
        rbFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemeninoActionPerformed(evt);
            }
        });
        jLayer1.add(rbFemenino);
        rbFemenino.setBounds(40, 240, 102, 28);

        rbMasculino.setBackground(new java.awt.Color(33, 37, 41));
        btgBotones.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbMasculino.setForeground(new java.awt.Color(254, 254, 254));
        rbMasculino.setText("Masculino");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });
        jLayer1.add(rbMasculino);
        rbMasculino.setBounds(150, 240, 106, 28);

        jPanel1.add(jLayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 270));

        jCalendario.setBackground(new java.awt.Color(255, 255, 255));
        jCalendario.setForeground(new java.awt.Color(255, 255, 255));
        jCalendario.setMaxSelectableDate(new java.util.Date(1072854073000L));
        jCalendario.setMinSelectableDate(new java.util.Date(-315590327000L));
        jCalendario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCalendarioFocusGained(evt);
            }
        });
        jCalendario.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jCalendarioAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendarioMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCalendarioMouseReleased(evt);
            }
        });
        jCalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarioPropertyChange(evt);
            }
        });
        jCalendario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCalendarioKeyPressed(evt);
            }
        });
        jLayer2.add(jCalendario);
        jCalendario.setBounds(180, 170, 50, 29);

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(33, 37, 41));
        txtFecha.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(254, 254, 254));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jLayer2.add(txtFecha);
        txtFecha.setBounds(10, 170, 170, 30);

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setText("Fecha de nacimiento:");
        jLayer2.add(jLabel15);
        jLabel15.setBounds(10, 150, 151, 19);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("NIT:");
        jLayer2.add(jLabel13);
        jLabel13.setBounds(10, 90, 29, 19);

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(254, 254, 254));
        jLabel20.setText("NIP:");
        jLayer2.add(jLabel20);
        jLabel20.setBounds(10, 50, 29, 30);

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("DUI:");
        jLayer2.add(jLabel11);
        jLabel11.setBounds(10, 10, 29, 30);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Teléfono:");
        jLayer2.add(jLabel10);
        jLabel10.setBounds(10, 210, 67, 20);

        txtDUI.setBackground(new java.awt.Color(33, 37, 41));
        txtDUI.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtDUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDUI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDUI.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayer2.add(txtDUI);
        txtDUI.setBounds(50, 10, 180, 30);

        txtTelefono.setBackground(new java.awt.Color(33, 37, 41));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayer2.add(txtTelefono);
        txtTelefono.setBounds(10, 230, 220, 30);

        txtNit.setBackground(new java.awt.Color(33, 37, 41));
        txtNit.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtNit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNit.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayer2.add(txtNit);
        txtNit.setBounds(10, 110, 220, 30);

        txtNIP.setBackground(new java.awt.Color(33, 37, 41));
        txtNIP.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtNIP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNIP.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLayer2.add(txtNIP);
        txtNIP.setBounds(50, 50, 180, 30);

        jPanel1.add(jLayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 240, 270));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Correo Electrónico:");
        jLayer3.add(jLabel9);
        jLabel9.setBounds(0, 20, 170, 19);

        txtEmail.setBackground(new java.awt.Color(33, 37, 41));
        txtEmail.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(254, 254, 254));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jLayer3.add(txtEmail);
        txtEmail.setBounds(0, 40, 230, 30);

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(254, 254, 254));
        jLabel17.setText("Dirección:");
        jLayer3.add(jLabel17);
        jLabel17.setBounds(0, 80, 70, 20);

        txtDireccion.setBackground(new java.awt.Color(33, 37, 41));
        txtDireccion.setColumns(20);
        txtDireccion.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setRows(5);
        txtDireccion.setBorder(null);
        txtDireccion.setNextFocusableComponent(jLayer1);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txtDireccion);

        jLayer3.add(jScrollPane2);
        jScrollPane2.setBounds(0, 110, 230, 140);

        jPanel1.add(jLayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 240, 250));

        tUsuarios.setBackground(new java.awt.Color(33, 37, 41));
        tUsuarios.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Tipo de Usuario", "Estado de Usuario", "Usuario", "Genero"
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
        jScrollPane3.setViewportView(tUsuarios);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 950, 190));

        btnCargarFoto.setBackground(new java.awt.Color(33, 37, 41));
        btnCargarFoto.setForeground(new java.awt.Color(254, 254, 254));
        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_default.png"))); // NOI18N
        btnCargarFoto.setBorder(null);
        btnCargarFoto.setContentAreaFilled(false);
        btnCargarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCargarFoto.setFocusPainted(false);
        btnCargarFoto.setFocusable(false);
        btnCargarFoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_rollover.png"))); // NOI18N
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 140, 70));

        btnLimpiar.setBackground(new java.awt.Color(33, 37, 41));
        btnLimpiar.setForeground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLimpiarDefault.png"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFocusable(false);
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLimpiarRollover.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 140, 70));

        btnAgregar.setBackground(new java.awt.Color(33, 37, 41));
        btnAgregar.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_default.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setFocusable(false);
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_rollover.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        lblFoto.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(254, 254, 254));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 160, 160));

        lblMarco.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblMarco.setForeground(new java.awt.Color(254, 254, 254));
        lblMarco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fndMarcoFotoPequeño.png"))); // NOI18N
        jPanel1.add(lblMarco, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 200, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemeninoActionPerformed
       
    }//GEN-LAST:event_rbFemeninoActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
       
    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
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
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtDUI.getText().isEmpty() ||
            txtDireccion.getText().isEmpty() || txtFecha.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNIP.getText().isEmpty() || txtNit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios.","Rellene los campos faltantes.",JOptionPane.WARNING_MESSAGE);
        }
        else if(rbMasculino.isSelected() || rbFemenino.isSelected()){
            CtrlUsuario ctrl = new CtrlUsuario();
            MtoUsuario mto = new MtoUsuario();
            mto.capturarMaxIdUsuario();
            ctrl.setId_usuario(mto.maxIdUsuario+1);
            ctrl.setNombre(txtNombre.getText());
            ctrl.setApellido(txtApellido.getText());
            int idTipoUsuario = mto.getIdTipoUsuario(cbTipoUsuario.getItemAt(cbTipoUsuario.getSelectedIndex()));
            ctrl.setId_tipo_usuario(idTipoUsuario);
            int idEstadoUsuario = 1;
            ctrl.setId_estado_usuario(idEstadoUsuario);
            ctrl.setEmail(txtEmail.getText());
            ctrl.setTelefono(txtTelefono.getText());
            ctrl.setDui(txtDUI.getText());
            ctrl.setNit(txtNit.getText());
            ctrl.setUsuario(txtUsuario.getText());
            ctrl.setNip(txtNIP.getText());
            ctrl.setFecha_nacimiento(txtFecha.getText());
            if (rbFemenino.isSelected()) {
                ctrl.setGenero("F");
            }
            else if(rbMasculino.isSelected())
            {
                ctrl.setGenero("M");
            }
            ctrl.setDireccion(txtDireccion.getText());
            String contraSinEncriptacion="txt"; 
            String contraConEncriptacion=DigestUtils.sha1Hex(contraSinEncriptacion);
            ctrl.setContraseña(contraConEncriptacion);
            ctrl.setFoto(person_image);

            if (mto.insertarUsuario()) {
                JOptionPane.showMessageDialog(null, "Se ha ingresado el nuevo usuario. Su contraseña por defecto es: 123","Exito",JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                mostrarUsuario();
                limpiarCampo();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
       
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
         
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
       
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoUsuarioActionPerformed
      
    }//GEN-LAST:event_cbTipoUsuarioActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtDUI.getText().isEmpty() ||
            txtDireccion.getText().isEmpty() || txtFecha.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNIP.getText().isEmpty() || txtNit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error", "Existen campos vacios", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar estos campos?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (mensaje == JOptionPane.YES_OPTION) {
                //Asignando datos
            CtrlUsuario ctrl = new CtrlUsuario();
            MtoUsuario mto = new MtoUsuario();
            
            ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
            ctrl.setNombre(txtNombre.getText());
            ctrl.setApellido(txtApellido.getText());
            int idTipoUsuario = mto.getIdTipoUsuario(cbTipoUsuario.getItemAt(cbTipoUsuario.getSelectedIndex()));
            ctrl.setId_tipo_usuario(idTipoUsuario);
            ctrl.setEmail(txtEmail.getText());
            ctrl.setTelefono(txtTelefono.getText());
            ctrl.setDui(txtDUI.getText());
            ctrl.setNit(txtNit.getText());
            ctrl.setUsuario(txtUsuario.getText());
            ctrl.setNip(txtNIP.getText());
            ctrl.setFecha_nacimiento(txtFecha.getText());
            if (rbMasculino.isSelected()) {
                ctrl.setGenero("M");
            }
            else if(rbFemenino.isSelected())
            {
                ctrl.setGenero("F");
            }
            ctrl.setDireccion(txtDireccion.getText());
            ctrl.setFoto(person_image);
            
            if (mto.actualizarUsuario()) {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                
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
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSuspenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderActionPerformed
         if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtDUI.getText().isEmpty() ||
            txtDireccion.getText().isEmpty() || txtFecha.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNIP.getText().isEmpty() || txtNit.getText().isEmpty()) {
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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnReiniciarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarCuentaActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas reiniciar la contraseña de este usuario?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if (mensaje == JOptionPane.YES_OPTION) {
            CtrlUsuario ctrl = new CtrlUsuario();
            MtoUsuario mto = new MtoUsuario();
            String contraSinEncriptacion="123"; 
            String contraConEncriptacion=DigestUtils.sha1Hex(contraSinEncriptacion);
            ctrl.setId_usuario(Integer.parseInt(txtId.getText()));
            ctrl.setContraseña(contraConEncriptacion);

            if (mto.reiniciarContraseña()) {
                JOptionPane.showMessageDialog(null, "La contraseña de este usuario ha sido reestablecida a 123.","Contraseña reestablecida exitosamente", JOptionPane.INFORMATION_MESSAGE);
                reiniciarBusqueda();
                limpiarTabla();
                mostrarUsuario();
                limpiarCampo();
            }else
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }//GEN-LAST:event_btnReiniciarCuentaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void jCalendarioAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jCalendarioAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendarioAncestorMoved

    private void jCalendarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCalendarioKeyPressed
         
    }//GEN-LAST:event_jCalendarioKeyPressed

    private void jCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarioMouseClicked
       
    }//GEN-LAST:event_jCalendarioMouseClicked

    private void jCalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarioPropertyChange
        try{
             String dia = Integer.toString(jCalendario.getCalendar().get(Calendar.DATE));
            String año = Integer.toString(jCalendario.getCalendar().get(Calendar.YEAR));
            int mesInt = jCalendario.getCalendar().get(Calendar.MONTH) + 1;
            String mes = Integer.toString(mesInt);
            String fecha = (mes+"-"+dia+"-"+año);
            txtFecha.setText(fecha);
      
        }catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jCalendarioPropertyChange

    private void jCalendarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCalendarioFocusGained
         
    }//GEN-LAST:event_jCalendarioFocusGained

    private void jCalendarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarioMouseReleased
       
    }//GEN-LAST:event_jCalendarioMouseReleased

    private void tUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tUsuariosMouseClicked
       //Controlando botones
       btnAgregar.setEnabled(false);
       btnActualizar.setEnabled(true);
       btnReiniciarCuenta.setEnabled(true);
        
        MtoUsuario mto = new MtoUsuario();

        //Obteniendo fila
        int fila = tUsuarios.getSelectedRow();
        
        //Obteniendo valores de la fila
        String nombre = String.valueOf(tUsuarios.getValueAt(fila, 0));
        String apellido = String.valueOf(tUsuarios.getValueAt(fila, 1));
        String usuario = String.valueOf(tUsuarios.getValueAt(fila, 4));
        String genero = String.valueOf(tUsuarios.getValueAt(fila, 5));
        String estado = String.valueOf(tUsuarios.getValueAt(fila, 3));
        
        //Desactivar y activar
        if ("Disponible".equals(estado)) {
            btnSuspender.setEnabled(true);
            btnActivar.setEnabled(false);
        }else if("Suspendido".equals(estado))
        {
            btnSuspender.setEnabled(false);
            btnActivar.setEnabled(true);
        }
        
        //Seleccionando radiobutton
        if ("M".equals(genero)) {
            rbMasculino.setSelected(true);
            rbFemenino.setSelected(false);
        }
        else if("F".equals(genero))
        {
            rbFemenino.setSelected(true);
            rbMasculino.setSelected(false);
        }
        
        //Seteando combobox
        String itemTipoUsuario = mto.getItemsTipoUsuario(usuario);
        cbTipoUsuario.setSelectedItem(itemTipoUsuario);
        
        //Seteando id
        int idUsuario = mto.getIdUsuario(usuario);
        txtId.setText(String.valueOf(idUsuario));
        
        //Seteando datos restantes
        mto.capturarDatosUsuario(usuario);
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtEmail.setText(mto.email);
        txtTelefono.setText(mto.telefono);
        txtDUI.setText(mto.dui);
        txtDireccion.setText(mto.direccion);
        txtNit.setText(mto.nit);
        txtNIP.setText(mto.nip);
        txtFecha.setText(mto.fecha_nacimiento);
        txtUsuario.setText(usuario);
        
        //Capturando datos del usuario
        byte[] foto = mto.capturarFoto(usuario);
        person_image = foto;
        ImageIcon imagen = new ImageIcon(new ImageIcon(foto).getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(imagen);
        
        
        
        
    }//GEN-LAST:event_tUsuariosMouseClicked

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
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
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampo();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtDUI.getText().isEmpty() ||
            txtDireccion.getText().isEmpty() || txtFecha.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNIP.getText().isEmpty() || txtNit.getText().isEmpty()) {
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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String busqueda = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tUsuarios.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgBotones;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReiniciarCuenta;
    private javax.swing.JButton btnSuspender;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private com.toedter.calendar.JDateChooser jCalendario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayer1;
    private javax.swing.JLayeredPane jLayer2;
    private javax.swing.JLayeredPane jLayer3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMarco;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JFormattedTextField txtDUI;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtNIP;
    private javax.swing.JFormattedTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
