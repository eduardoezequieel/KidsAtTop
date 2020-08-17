package vistas;

import controlador.CtrlEstudiante;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.MtoEstudiante;
import modelo.Validaciones;

/**
 *
 * @author EDUARDO
 */
public class FrmMatricula extends javax.swing.JInternalFrame {

    //Llamando clases 
    Validaciones val = new Validaciones();
    CtrlEstudiante estudianteCtrl = new CtrlEstudiante();
    MtoEstudiante estudiante = new MtoEstudiante();
    
    //Declarando variables
    String filename = null;
    byte[] person_image = null;
    
    public FrmMatricula() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        //llenando combobox
        this.llenarGS();
        
        //Mostrando responsable
        estudiante.obteniendoResponsable();  
        jResponsable.setText(estudianteCtrl.getResponsable());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jResponsable = new javax.swing.JTextField();
        jNombre = new javax.swing.JTextField();
        jFecha = new javax.swing.JTextField();
        jApellido = new javax.swing.JTextField();
        rbF = new javax.swing.JRadioButton();
        rbM = new javax.swing.JRadioButton();
        cbGS = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDireccion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCargarFoto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jAño = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dirección:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Una vez ingresados los datos del responsable, se procedera a la matricula del nuevo estudiante.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Género:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Responsable:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grado/Sección:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jResponsable.setBackground(new java.awt.Color(33, 37, 41));
        jResponsable.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jResponsable.setForeground(new java.awt.Color(255, 255, 255));
        jResponsable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jResponsable.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jResponsable.setEnabled(false);
        jResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jResponsableKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jResponsableKeyTyped(evt);
            }
        });
        jPanel1.add(jResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 240, 30));

        jNombre.setBackground(new java.awt.Color(33, 37, 41));
        jNombre.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jNombre.setForeground(new java.awt.Color(255, 255, 255));
        jNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 240, 30));

        jFecha.setEditable(false);
        jFecha.setBackground(new java.awt.Color(33, 37, 41));
        jFecha.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jFecha.setForeground(new java.awt.Color(255, 255, 255));
        jFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jPanel1.add(jFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 190, 30));

        jApellido.setBackground(new java.awt.Color(33, 37, 41));
        jApellido.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jApellido.setForeground(new java.awt.Color(255, 255, 255));
        jApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(jApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 240, 30));

        rbF.setBackground(new java.awt.Color(33, 37, 41));
        rbGenero.add(rbF);
        rbF.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        rbF.setForeground(new java.awt.Color(255, 255, 255));
        rbF.setText("Femenino");
        jPanel1.add(rbF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        rbM.setBackground(new java.awt.Color(33, 37, 41));
        rbGenero.add(rbM);
        rbM.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        rbM.setForeground(new java.awt.Color(255, 255, 255));
        rbM.setText("Masculino");
        jPanel1.add(rbM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        cbGS.setBackground(new java.awt.Color(33, 37, 41));
        cbGS.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cbGS.setForeground(new java.awt.Color(255, 255, 255));
        cbGS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbGS, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 240, -1));

        jDireccion.setBackground(new java.awt.Color(33, 37, 41));
        jDireccion.setColumns(20);
        jDireccion.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jDireccion.setRows(5);
        jDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jDireccion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 240, 120));

        jPanel2.setBackground(new java.awt.Color(61, 66, 72));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 180, 220));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_default.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregar_rollover.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 180, 80));

        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_default.png"))); // NOI18N
        btnCargarFoto.setBorder(null);
        btnCargarFoto.setContentAreaFilled(false);
        btnCargarFoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCargarFoto_rollover.png"))); // NOI18N
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 180, 80));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Año Ingreso:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        jAño.setBackground(new java.awt.Color(33, 37, 41));
        jAño.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jAño.setForeground(new java.awt.Color(255, 255, 255));
        jAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jAño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(119, 119, 119)));
        jAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAñoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jAñoKeyTyped(evt);
            }
        });
        jPanel1.add(jAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        //Validando campos vacios 
        if ((jNombre.getText().trim().isEmpty()) || (jApellido.getText().trim().isEmpty()) || (jFecha.getText().trim().isEmpty())
                || (rbM.isSelected() == false) && (rbF.isSelected() == false) || (jResponsable.getText().trim().isEmpty()) || (jDireccion.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Campos vacios.","Rellene los campos faltantes.",JOptionPane.WARNING_MESSAGE);
        } else {
            
            //Mandando datos a la clase
            estudiante.obtenerUltimoId();
            estudianteCtrl.setNombre(jNombre.getText());
            estudianteCtrl.setApellido(jApellido.getText());
            estudianteCtrl.setFechaNacimiento(jFecha.getText());
            estudianteCtrl.setAnioIngreso(jAño.getText());
            estudianteCtrl.setDireccion(jDireccion.getText());
            if (rbF.isSelected()) {
                estudianteCtrl.setGenero("F");
            } else if (rbM.isSelected()) {
                estudianteCtrl.setGenero("M");
            }     
            estudianteCtrl.setIdEstado(1);
            //Dividiendo el grado y la seccion
            String gradoSeccion = cbGS.getItemAt(cbGS.getSelectedIndex());
            String[] parte = gradoSeccion.split("-");
            String grado = parte[0];
            String seccion = parte[1];
            
            estudiante.obtenerIdGS(grado, seccion);
            estudianteCtrl.setFoto(person_image);
        
            if (estudiante.insertarEstudiante()) {
                JOptionPane.showMessageDialog(null, "Se ha agregado el estudiante correctamente");
                this.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha agregado el estudiante correctamente");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

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
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

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

    private void jNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jNombreKeyPressed

    private void jNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNombreKeyTyped
        // TODO add your handling code here:
        val.verificarLetras(evt);
    }//GEN-LAST:event_jNombreKeyTyped

    private void jApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jApellidoKeyPressed

    private void jApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jApellidoKeyTyped
        // TODO add your handling code here:
        val.verificarLetras(evt);
    }//GEN-LAST:event_jApellidoKeyTyped

    private void jDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jDireccionKeyPressed

    private void jDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDireccionKeyTyped
        // TODO add your handling code here:
        val.verificarAlfanumerico(evt);
    }//GEN-LAST:event_jDireccionKeyTyped

    private void jResponsableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jResponsableKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jResponsableKeyPressed

    private void jResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jResponsableKeyTyped
        // TODO add your handling code here:
        val.verificarLetras(evt);
    }//GEN-LAST:event_jResponsableKeyTyped

    private void jAñoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAñoKeyPressed
        // TODO add your handling code here:
        val.verificarPegar(evt);
    }//GEN-LAST:event_jAñoKeyPressed

    private void jAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAñoKeyTyped
        // TODO add your handling code here:
        val.verificarEnteros(evt);
    }//GEN-LAST:event_jAñoKeyTyped

    public void llenarGS(){
        
        //Llenando combobox
        cbGS.setModel(estudiante.llenarGS());
    }
    
    public void limpiarCampos(){
    
        //limpiando campos
        jNombre.setText("");
        jApellido.setText("");
        jFecha.setText("");
        jAño.setText("");
        rbF.setSelected(false);
        rbM.setSelected(false);
        jDireccion.setText("");
        lblFoto.setText("");
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JComboBox<String> cbGS;
    private javax.swing.JTextField jApellido;
    private javax.swing.JTextField jAño;
    private javax.swing.JTextArea jDireccion;
    private javax.swing.JTextField jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jResponsable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JRadioButton rbF;
    private javax.swing.ButtonGroup rbGenero;
    private javax.swing.JRadioButton rbM;
    // End of variables declaration//GEN-END:variables
}
