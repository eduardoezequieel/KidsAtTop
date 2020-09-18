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
public class FrmNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionarNotasForm
     */
    
    Validaciones val = new Validaciones();
    MtoNotas mto = new MtoNotas();
    CtrlNotas ctrl = new CtrlNotas();
    CtrlLoginUsuario mod;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
    
    public FrmNotas() {
        initComponents();
       
    }

    public FrmNotas(CtrlLoginUsuario mod) {
        this.mod = mod;
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        tNotas.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        tNotas.getTableHeader().setOpaque(false);
        tNotas.getTableHeader().setBackground(new Color(33, 37, 41));
        tNotas.getTableHeader().setForeground(new Color(254,254,254));
        
        
        //Metodos a ejecutar
        llenarAnio();
        llenarGradoSeccion();
        llenarTrimestre();
        llenarNotaPredeterminada();
        llenarIndicadores();
        
        //Llenando tabla
        modelo.addColumn("Estudiante");
        modelo.addColumn("Nota del Indicador");
        tNotas.setModel(modelo);
        mostrarEstudiantes();
        centrarColumnas();
     
        
    }
    
    public void llenarAnio(){
        cbAño.setModel(mto.llenarAnio());
    }
    
    public void llenarGradoSeccion(){
        String año = cbAño.getItemAt(cbAño.getSelectedIndex());
        ctrl.setAñoSeccion(año);
        
        cbGradoSeccion.setModel(mto.llenarGradoSeccion());
    }
    
    public void llenarTrimestre(){
        cbTrimestre.setModel(mto.llenarTrimestre());
    }
    
    public void llenarNotaPredeterminada(){
        cbNotaP.setModel(mto.llenarNotaPredeterminada());
    }
    
    public void llenarIndicadores(){
        String grado = cbGradoSeccion.getItemAt(cbGradoSeccion.getSelectedIndex());
        String nivelSubstring = grado.substring(7,8);
        
        int nivel = Integer.parseInt(nivelSubstring);
        ctrl.setNivelAcademico(nivel);
        cbIndicadores.setModel(mto.llenarIndicador());
    }
    
    public void mostrarEstudiantes(){
        limpiarTabla();
        int idIndicador = mto.getIDIndicador(cbIndicadores.getItemAt(cbIndicadores.getSelectedIndex()));
        String gradoSeccion = cbGradoSeccion.getItemAt(cbGradoSeccion.getSelectedIndex());
        String grado = gradoSeccion.substring(0,8);
        String seccion = gradoSeccion.substring(9);
        int idTrimestre = mto.getIDTrimestre(cbTrimestre.getItemAt(cbTrimestre.getSelectedIndex()));
        String año = cbAño.getItemAt(cbAño.getSelectedIndex());
        Conexion con = new Conexion();
        Connection datos;
        try
        {
            datos = con.conectar();
            String sql = "SELECT CONCAT(e.apellido,'  ',e.nombre)as Estudiante, n.n_predeterminada FROM nota ne, indicador_logro i, nota_predeterminada n, estudiante e, trimestre t,"
                    + " grado_seccion gs, grado g, seccion s WHERE ne.id_indicador = i.id_indicador AND ne.id_n_predeterminada = n.id_n_predeterminada "
                    + "AND ne.id_estudiante = e.id_estudiante AND e.id_grado_seccion = gs.id_grado_seccion AND gs.id_grado = g.id_grado AND gs.id_seccion = s.id_seccion "
                    + "AND  ne.id_trimestre = t.id_trimestre AND i.id_indicador = ? AND g.grado = ? AND s.seccion = ? AND t.id_trimestre = ? AND gs.anio_seccion = ? ORDER BY e.apellido ASC";
            PreparedStatement cmd = datos.prepareCall(sql);
            cmd.setInt(1, idIndicador);
            cmd.setString(2, grado);
            cmd.setString(3, seccion);
            cmd.setInt(4, idTrimestre);
            cmd.setString(5, año);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object fila[] = {rs.getString(1), rs.getString(2)};
                modelo.addRow(fila);
            }
            tNotas.setModel(modelo);
            
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void limpiarTabla() {
        //Limpiar tabla
        int filas = tNotas.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }
    
    public void centrarColumnas(){
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 1; i++) {
            tNotas.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
    }
    
     public void reiniciarBusqueda()
    {
        jBuscar.setText("");
        String busqueda = jBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tNotas.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
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
        jLabel12 = new javax.swing.JLabel();
        cbNotaP = new javax.swing.JComboBox<>();
        cbIndicadores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNotas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cbAño = new javax.swing.JComboBox<>();
        jBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbGradoSeccion = new javax.swing.JComboBox<>();
        cbTrimestre = new javax.swing.JComboBox<>();
        lblAviso = new javax.swing.JLabel();
        jID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 37, 41));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gestionar Notas ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Indicador de logro:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 930, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nota:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 130, -1));

        cbNotaP.setBackground(new java.awt.Color(33, 37, 41));
        cbNotaP.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbNotaP.setForeground(new java.awt.Color(254, 254, 254));
        cbNotaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNotaPKeyPressed(evt);
            }
        });
        jPanel1.add(cbNotaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 130, -1));

        cbIndicadores.setBackground(new java.awt.Color(33, 37, 41));
        cbIndicadores.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbIndicadores.setForeground(new java.awt.Color(254, 254, 254));
        cbIndicadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIndicadoresItemStateChanged(evt);
            }
        });
        cbIndicadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbIndicadoresKeyPressed(evt);
            }
        });
        jPanel1.add(cbIndicadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 930, -1));

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
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Estudiante", "Nota del Indicador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tNotas.setFocusable(false);
        tNotas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tNotas.setRowHeight(40);
        tNotas.setSelectionBackground(new java.awt.Color(45, 252, 119));
        tNotas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tNotas.setShowVerticalLines(false);
        tNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 810, 410));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Buscar alumno...");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 470, 20));

        cbAño.setBackground(new java.awt.Color(33, 37, 41));
        cbAño.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbAño.setForeground(new java.awt.Color(254, 254, 254));
        cbAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAñoItemStateChanged(evt);
            }
        });
        cbAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbAñoKeyPressed(evt);
            }
        });
        jPanel1.add(cbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 180, -1));

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
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 470, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Año:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 180, -1));

        btnAgregar.setBackground(new java.awt.Color(33, 37, 41));
        btnAgregar.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_default.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusable(false);
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_rollover.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 150, 70));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Grado/Sección:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 180, 20));

        cbGradoSeccion.setBackground(new java.awt.Color(33, 37, 41));
        cbGradoSeccion.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbGradoSeccion.setForeground(new java.awt.Color(254, 254, 254));
        cbGradoSeccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradoSeccionItemStateChanged(evt);
            }
        });
        cbGradoSeccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbGradoSeccionKeyPressed(evt);
            }
        });
        jPanel1.add(cbGradoSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 180, -1));

        cbTrimestre.setBackground(new java.awt.Color(33, 37, 41));
        cbTrimestre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbTrimestre.setForeground(new java.awt.Color(254, 254, 254));
        cbTrimestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTrimestreItemStateChanged(evt);
            }
        });
        cbTrimestre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTrimestreKeyPressed(evt);
            }
        });
        jPanel1.add(cbTrimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 180, -1));

        lblAviso.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(254, 254, 254));
        lblAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAviso.setText("Esperando...");
        jPanel1.add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, 170, 40));

        jID.setBackground(new java.awt.Color(33, 37, 41));
        jID.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jID.setForeground(new java.awt.Color(254, 254, 254));
        jID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 73, 73), 1, true));
        jID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jIDKeyTyped(evt);
            }
        });
        jPanel1.add(jID, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 70, 30));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(254, 254, 254));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Trimestre:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 180, -1));

        jButton1.setText("Ingresar Notas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int idNotaPredeterminada = mto.getIDNotaPredeterminada(cbNotaP.getItemAt(cbNotaP.getSelectedIndex()));
        ctrl.setIdNotaPredeterminada(idNotaPredeterminada);
        
        if (mto.ActualizarNota()) {
            reiniciarBusqueda();
            mostrarEstudiantes();
            
            lblAviso.setForeground(Color.green);
            lblAviso.setText("Exito");
        }
        else{
            lblAviso.setForeground(Color.red);
            lblAviso.setText("Error");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbAñoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbAñoKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbAñoKeyPressed

    private void cbTrimestreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTrimestreKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbTrimestreKeyPressed

    private void cbGradoSeccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbGradoSeccionKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbGradoSeccionKeyPressed

    private void cbIndicadoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbIndicadoresKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbIndicadoresKeyPressed

    private void cbNotaPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNotaPKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_cbNotaPKeyPressed

    private void jBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jBuscarKeyPressed

    private void jBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isWhitespace(c) && c != '@' && c != '.' && c != '_') {
            val.verificarAlfanumerico(evt);
        }
    }//GEN-LAST:event_jBuscarKeyTyped

    private void cbAñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAñoItemStateChanged
        
        llenarGradoSeccion();
        mostrarEstudiantes();
    }//GEN-LAST:event_cbAñoItemStateChanged

    private void cbGradoSeccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradoSeccionItemStateChanged
        llenarIndicadores();
        mostrarEstudiantes();
    }//GEN-LAST:event_cbGradoSeccionItemStateChanged

    private void cbTrimestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTrimestreItemStateChanged
        mostrarEstudiantes();
    }//GEN-LAST:event_cbTrimestreItemStateChanged

    private void cbIndicadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIndicadoresItemStateChanged
        mostrarEstudiantes();
    }//GEN-LAST:event_cbIndicadoresItemStateChanged

    private void jIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDKeyPressed

    private void jIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDKeyTyped
    
    
    
    
    private void tNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNotasMouseClicked
      
        lblAviso.setForeground(Color.white);
        lblAviso.setText("Esperando...");
        
        int fila = tNotas.getSelectedRow();
        
        String estudiante = String.valueOf(tNotas.getValueAt(fila, 0));
        String nota = String.valueOf(tNotas.getValueAt(fila, 1));
        
         //Dividiendo del estudiante
        
        String[] parte = estudiante.split("  ");
        String apellido = parte[0];
        String nombre = parte[1];
        
        //Capturando datos
        int idIndicador = mto.getIDIndicador(cbIndicadores.getItemAt(cbIndicadores.getSelectedIndex()));
        String gradoSeccion = cbGradoSeccion.getItemAt(cbGradoSeccion.getSelectedIndex());
        String grado = gradoSeccion.substring(0,8);
        String seccion = gradoSeccion.substring(9);
        int idTrimestre = mto.getIDTrimestre(cbTrimestre.getItemAt(cbTrimestre.getSelectedIndex()));
        String año = cbAño.getItemAt(cbAño.getSelectedIndex());
        
        int idNota = mto.getIDNota(idIndicador, grado, seccion, idTrimestre, año, apellido, nombre);
        jID.setText(String.valueOf(idNota));
        
        ctrl.setIdNota(idNota);
    }//GEN-LAST:event_tNotasMouseClicked

    private void jBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscarKeyReleased
        String busqueda = jBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        tNotas.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(busqueda));
    }//GEN-LAST:event_jBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String año = cbAño.getItemAt(cbAño.getSelectedIndex());
       String gradoSeccion = cbGradoSeccion.getItemAt(cbGradoSeccion.getSelectedIndex());
        String grado = gradoSeccion.substring(0,8);
        String seccion = gradoSeccion.substring(9);
       
       ctrl.setAñoSeccion(año);
       ctrl.setGrado(grado);
       ctrl.setSeccion(seccion);
       
        if (mto.insertarNotas()) {
            reiniciarBusqueda();
            mostrarEstudiantes();
            JOptionPane.showMessageDialog(null, "Todas las notas han sido ingresadas.");
            
        }
        else
        {
            System.out.println("Error");;
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbGradoSeccion;
    private javax.swing.JComboBox<String> cbIndicadores;
    private javax.swing.JComboBox<String> cbNotaP;
    private javax.swing.JComboBox<String> cbTrimestre;
    private javax.swing.JTextField jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JTable tNotas;
    // End of variables declaration//GEN-END:variables
}
