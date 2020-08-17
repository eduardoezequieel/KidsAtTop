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
import modelo.MtoBitacoras;
import modelo.Validaciones;
/**
 *
 * @author katy0
 */
public class FrmAdministrarUsuarios extends javax.swing.JInternalFrame {

    //Variables globales
        String filename = null;
        byte[] person_image = null;
        DefaultTableModel modelo = new DefaultTableModel();
        CtrlLoginUsuario mod;
        Validaciones val = new Validaciones();
       
    public FrmAdministrarUsuarios(){
        initComponents();
    }

    public FrmAdministrarUsuarios(CtrlLoginUsuario mod) {
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
        jBuscar.setText("");
        String busqueda = jBuscar.getText();
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
        jNombre.setText("");
        jApellido.setText("");
        jUsuario.setText("");
        rbFemenino.setSelected(false);
        rbMasculino.setSelected(false);
        jDUI.setText("");
        jNIP.setText("");
        jNIT.setText("");
        jFecha.setText("");
        jTelefono.setText("");
        jCorreo.setText("");
        jDireccion.setText("");
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
        jBuscar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLayer1 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jUsuario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rbFemenino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        jLayer2 = new javax.swing.JLayeredPane();
        jFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDUI = new javax.swing.JFormattedTextField();
        jTelefono = new javax.swing.JFormattedTextField();
        jNIT = new javax.swing.JFormattedTextField();
        jNIP = new javax.swing.JFormattedTextField();
        jCalendario = new com.toedter.calendar.JDateChooser();
        jLayer3 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jCorreo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDireccion = new javax.swing.JTextArea();
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
        });
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 550, 30));

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

        jNombre.setBackground(new java.awt.Color(33, 37, 41));
        jNombre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNombre.setForeground(new java.awt.Color(254, 254, 254));
        jNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreActionPerformed(evt);
            }
        });
        jNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNombreKeyTyped(evt);
            }
        });
        jLayer1.add(jNombre);
        jNombre.setBounds(90, 10, 170, 30);

        cbTipoUsuario.setBackground(new java.awt.Color(33, 37, 41));
        cbTipoUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbTipoUsuario.setForeground(new java.awt.Color(254, 254, 254));
        cbTipoUsuario.setToolTipText("");
        cbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoUsuarioActionPerformed(evt);
            }
        });
        cbTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTipoUsuarioKeyPressed(evt);
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

        jApellido.setBackground(new java.awt.Color(33, 37, 41));
        jApellido.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jApellido.setForeground(new java.awt.Color(254, 254, 254));
        jApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jApellidoActionPerformed(evt);
            }
        });
        jApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jApellidoKeyTyped(evt);
            }
        });
        jLayer1.add(jApellido);
        jApellido.setBounds(90, 50, 170, 30);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Usuario:");
        jLayer1.add(jLabel12);
        jLabel12.setBounds(20, 150, 58, 20);

        jUsuario.setBackground(new java.awt.Color(33, 37, 41));
        jUsuario.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jUsuario.setForeground(new java.awt.Color(254, 254, 254));
        jUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsuarioActionPerformed(evt);
            }
        });
        jUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jUsuarioKeyTyped(evt);
            }
        });
        jLayer1.add(jUsuario);
        jUsuario.setBounds(20, 170, 240, 30);

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

        jFecha.setEditable(false);
        jFecha.setBackground(new java.awt.Color(33, 37, 41));
        jFecha.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jFecha.setForeground(new java.awt.Color(254, 254, 254));
        jFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFechaActionPerformed(evt);
            }
        });
        jLayer2.add(jFecha);
        jFecha.setBounds(10, 170, 170, 30);

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

        jDUI.setBackground(new java.awt.Color(33, 37, 41));
        jDUI.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jDUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jDUI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDUI.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jDUI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDUIKeyPressed(evt);
            }
        });
        jLayer2.add(jDUI);
        jDUI.setBounds(50, 10, 180, 30);

        jTelefono.setBackground(new java.awt.Color(33, 37, 41));
        jTelefono.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTelefono.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTelefonoKeyPressed(evt);
            }
        });
        jLayer2.add(jTelefono);
        jTelefono.setBounds(10, 230, 220, 30);

        jNIT.setBackground(new java.awt.Color(33, 37, 41));
        jNIT.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jNIT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jNIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNIT.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNITKeyPressed(evt);
            }
        });
        jLayer2.add(jNIT);
        jNIT.setBounds(10, 110, 220, 30);

        jNIP.setBackground(new java.awt.Color(33, 37, 41));
        jNIP.setForeground(new java.awt.Color(255, 255, 255));
        try {
            jNIP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jNIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNIP.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNIPKeyPressed(evt);
            }
        });
        jLayer2.add(jNIP);
        jNIP.setBounds(50, 50, 180, 30);

        jCalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarioPropertyChange(evt);
            }
        });
        jLayer2.add(jCalendario);
        jCalendario.setBounds(180, 170, 50, 30);

        jPanel1.add(jLayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 240, 270));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Correo Electrónico:");
        jLayer3.add(jLabel9);
        jLabel9.setBounds(0, 20, 170, 19);

        jCorreo.setBackground(new java.awt.Color(33, 37, 41));
        jCorreo.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jCorreo.setForeground(new java.awt.Color(254, 254, 254));
        jCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCorreoActionPerformed(evt);
            }
        });
        jCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCorreoKeyPressed(evt);
            }
        });
        jLayer3.add(jCorreo);
        jCorreo.setBounds(0, 40, 230, 30);

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(254, 254, 254));
        jLabel17.setText("Dirección:");
        jLayer3.add(jLabel17);
        jLabel17.setBounds(0, 80, 70, 20);

        jDireccion.setBackground(new java.awt.Color(33, 37, 41));
        jDireccion.setColumns(20);
        jDireccion.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jDireccion.setRows(5);
        jDireccion.setBorder(null);
        jDireccion.setNextFocusableComponent(jLayer1);
        jDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDireccionMouseClicked(evt);
            }
        });
        jDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDireccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jDireccion);

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
        if (jNombre.getText().isEmpty() || jApellido.getText().isEmpty() || jTelefono.getText().isEmpty() || jUsuario.getText().isEmpty() || jDUI.getText().isEmpty() ||
            jDireccion.getText().isEmpty() || jFecha.getText().isEmpty() || jCorreo.getText().isEmpty() || jNIP.getText().isEmpty() || jNIT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios.","Rellene los campos faltantes.",JOptionPane.WARNING_MESSAGE);
        }
        else if(rbMasculino.isSelected() || rbFemenino.isSelected()){
            if (val.email(jCorreo.getText())) {
                 CtrlUsuario ctrl = new CtrlUsuario();
                MtoUsuario mto = new MtoUsuario();
                mto.capturarMaxIdUsuario();
                ctrl.setId_usuario(mto.maxIdUsuario+1);
                ctrl.setNombre(jNombre.getText());
                ctrl.setApellido(jApellido.getText());
                int idTipoUsuario = mto.getIdTipoUsuario(cbTipoUsuario.getItemAt(cbTipoUsuario.getSelectedIndex()));
                ctrl.setId_tipo_usuario(idTipoUsuario);
                int idEstadoUsuario = 1;
                ctrl.setId_estado_usuario(idEstadoUsuario);
                ctrl.setEmail(jCorreo.getText());
                ctrl.setTelefono(jTelefono.getText());
                ctrl.setDui(jDUI.getText());
                ctrl.setNit(jNIT.getText());
                ctrl.setUsuario(jUsuario.getText());
                ctrl.setNip(jNIP.getText());
                ctrl.setFecha_nacimiento(jFecha.getText());
                if (rbFemenino.isSelected()) {
                    ctrl.setGenero("F");
                }
                else if(rbMasculino.isSelected())
                {
                    ctrl.setGenero("M");
                }
                ctrl.setDireccion(jDireccion.getText());
                String contraSinEncriptacion="txt"; 
                String contraConEncriptacion=DigestUtils.sha1Hex(contraSinEncriptacion);
                ctrl.setContraseña(contraConEncriptacion);
                ctrl.setFoto(person_image);

                if (mto.insertarUsuario()) {
                    JOptionPane.showMessageDialog(null, "Se ha ingresado el nuevo usuario. Su contraseña por defecto es: 123","Exito",JOptionPane.INFORMATION_MESSAGE);


                    MtoBitacoras add=new MtoBitacoras();
                    int id=add.capturarIdBitacora()+1;
                    mod.setId_usuario(mod.getId_usuario());
                    mod.setId_bitacora(id);
                    add.agregarBitacoraAgregar(mod);

                    limpiarTabla();
                    mostrarUsuario();
                    limpiarCampo();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correo Invalido","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un género.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreActionPerformed
       
    }//GEN-LAST:event_jNombreActionPerformed

    private void jApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApellidoActionPerformed
        
    }//GEN-LAST:event_jApellidoActionPerformed

    private void jUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsuarioActionPerformed
         
    }//GEN-LAST:event_jUsuarioActionPerformed

    private void jDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDireccionMouseClicked
        
    }//GEN-LAST:event_jDireccionMouseClicked

    private void jCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCorreoActionPerformed
       
    }//GEN-LAST:event_jCorreoActionPerformed

    private void cbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoUsuarioActionPerformed
      
    }//GEN-LAST:event_cbTipoUsuarioActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (jNombre.getText().isEmpty() || jApellido.getText().isEmpty() || jTelefono.getText().isEmpty() || jUsuario.getText().isEmpty() || jDUI.getText().isEmpty() ||
            jDireccion.getText().isEmpty() || jFecha.getText().isEmpty() || jCorreo.getText().isEmpty() || jNIP.getText().isEmpty() || jNIT.getText().isEmpty()) {
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
                    add.agregarBitacoraActualizar(mod);
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
                    add.agregarBitacoraSuspender(mod);

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
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }
        }
    }//GEN-LAST:event_btnReiniciarCuentaActionPerformed
    }
    private void jFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFechaActionPerformed

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
            jFecha.setText(fecha);
      
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
        jNombre.setText(nombre);
        jApellido.setText(apellido);
        jCorreo.setText(mto.email);
        jTelefono.setText(mto.telefono);
        jDUI.setText(mto.dui);
        jDireccion.setText(mto.direccion);
        jNIT.setText(mto.nit);
        jNIP.setText(mto.nip);
        jFecha.setText(mto.fecha_nacimiento);
        jUsuario.setText(usuario);
        
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
                    add.agregarBitacoraActivar(mod);

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

    private void jBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyReleased
        String busqueda = jBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tUsuarios.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
        
    }//GEN-LAST:event_jBuscarKeyReleased

    private void jNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyTyped
        // TODO add your handling code here:
        val.verificarLetras(evt);
    }//GEN-LAST:event_jNombreKeyTyped

    private void jApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyTyped
        // TODO add your handling code here:
        val.verificarLetras(evt);
    }//GEN-LAST:event_jApellidoKeyTyped

    private void jUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyTyped
        // TODO add your handling code here:
        val.verificarEspeciales(evt);
    }//GEN-LAST:event_jUsuarioKeyTyped

    private void jNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyPressed
        // TODO add your handling code here:
        String Caracteres = jNombre.getText();
        if(Caracteres.length()>=30){
            jNombre.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNombreKeyPressed

    private void jApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyPressed
        // TODO add your handling code here:
        String Caracteres = jApellido.getText();
        if(Caracteres.length()>=30){
            jApellido.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jApellidoKeyPressed

    private void cbTipoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTipoUsuarioKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbTipoUsuarioKeyPressed

    private void jUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyPressed
        // TODO add your handling code here:
        String Caracteres = jUsuario.getText();
        if(Caracteres.length()>=25){
            jUsuario.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        
        val.verificarPegar(evt);
    }//GEN-LAST:event_jUsuarioKeyPressed

    private void jDUIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDUIKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jDUIKeyPressed

    private void jNIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNIPKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNIPKeyPressed

    private void jNITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNITKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNITKeyPressed

    private void jTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTelefonoKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jTelefonoKeyPressed

    private void jCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCorreoKeyPressed
        // TODO add your handling code here:
        String Caracteres = jCorreo.getText();
        if(Caracteres.length()>=50){
            jCorreo.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jCorreoKeyPressed

    private void jDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyPressed
        // TODO add your handling code here:
        String Caracteres = jDireccion.getText();
        if(Caracteres.length()>=200){
            jDireccion.setText("");
            JOptionPane.showMessageDialog(null, "Limite de carácteres alcanzado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        val.verificarPegar(evt);
    }//GEN-LAST:event_jDireccionKeyPressed

    private void jDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyTyped
        // TODO add your handling code here:
        val.verificarAlfanumerico(evt);
    }//GEN-LAST:event_jDireccionKeyTyped

    private void jBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jBuscarKeyPressed


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
    private javax.swing.JTextField jApellido;
    private javax.swing.JTextField jBuscar;
    private com.toedter.calendar.JDateChooser jCalendario;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JFormattedTextField jDUI;
    private javax.swing.JTextArea jDireccion;
    private javax.swing.JTextField jFecha;
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
    private javax.swing.JFormattedTextField jNIP;
    private javax.swing.JFormattedTextField jNIT;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField jTelefono;
    private javax.swing.JTextField jUsuario;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMarco;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tUsuarios;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
