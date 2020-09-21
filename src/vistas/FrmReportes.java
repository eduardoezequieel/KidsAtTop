package vistas;
import controlador.CtrlLoginUsuario;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.Conexion;
import net.sf.jasperreports.engine.JasperReport;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author EDUARDO
 */
public class FrmReportes extends javax.swing.JInternalFrame {

    CtrlLoginUsuario mod;
    
    public FrmReportes(CtrlLoginUsuario mod) {
        initComponents();
        this.mod = mod;
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
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
        jLabel1 = new javax.swing.JLabel();
        btnGenerarBitacora = new javax.swing.JButton();
        btnGenerarGradoSeccion = new javax.swing.JButton();
        btnGenerarEstudiantesGS = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();
        btnInasistencias = new javax.swing.JButton();
        btnConducta = new javax.swing.JButton();
        btnGenerarAsistenciaDia = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 37, 41));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 37, 41));
        jPanel1.setForeground(new java.awt.Color(33, 37, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icnCuadrado.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 200, 260));

        btnGenerarBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptBitacora.png"))); // NOI18N
        btnGenerarBitacora.setBorder(null);
        btnGenerarBitacora.setContentAreaFilled(false);
        btnGenerarBitacora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarBitacora.setFocusable(false);
        btnGenerarBitacora.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptBitacoraRollover.png"))); // NOI18N
        btnGenerarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarBitacoraActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarBitacora, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 210, 180));

        btnGenerarGradoSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptDocentesDefault.png"))); // NOI18N
        btnGenerarGradoSeccion.setBorder(null);
        btnGenerarGradoSeccion.setContentAreaFilled(false);
        btnGenerarGradoSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarGradoSeccion.setFocusable(false);
        btnGenerarGradoSeccion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptDocentesRollover.png"))); // NOI18N
        btnGenerarGradoSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarGradoSeccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarGradoSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 210, 180));

        btnGenerarEstudiantesGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptListaDefault.png"))); // NOI18N
        btnGenerarEstudiantesGS.setBorder(null);
        btnGenerarEstudiantesGS.setContentAreaFilled(false);
        btnGenerarEstudiantesGS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarEstudiantesGS.setFocusable(false);
        btnGenerarEstudiantesGS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptListaRollover.png"))); // NOI18N
        btnGenerarEstudiantesGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarEstudiantesGSActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarEstudiantesGS, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 210, 180));

        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptUsuarioDefault.png"))); // NOI18N
        btnLista.setBorder(null);
        btnLista.setContentAreaFilled(false);
        btnLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLista.setFocusable(false);
        btnLista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptUsuarioRollover.png"))); // NOI18N
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 210, 180));

        btnInasistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptInasistenciasDefault.png"))); // NOI18N
        btnInasistencias.setBorder(null);
        btnInasistencias.setContentAreaFilled(false);
        btnInasistencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInasistencias.setFocusable(false);
        btnInasistencias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptInasistenciasRollover.png"))); // NOI18N
        btnInasistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInasistenciasActionPerformed(evt);
            }
        });
        jPanel1.add(btnInasistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 210, 180));

        btnConducta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptConductaDefault.png"))); // NOI18N
        btnConducta.setBorder(null);
        btnConducta.setContentAreaFilled(false);
        btnConducta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConducta.setFocusable(false);
        btnConducta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptConductaRollover.png"))); // NOI18N
        btnConducta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConductaActionPerformed(evt);
            }
        });
        jPanel1.add(btnConducta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 210, 180));

        btnGenerarAsistenciaDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptAsistenciasDefault.png"))); // NOI18N
        btnGenerarAsistenciaDia.setBorder(null);
        btnGenerarAsistenciaDia.setContentAreaFilled(false);
        btnGenerarAsistenciaDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarAsistenciaDia.setFocusable(false);
        btnGenerarAsistenciaDia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptAsistenciasRollover.png"))); // NOI18N
        btnGenerarAsistenciaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarAsistenciaDiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarAsistenciaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 210, 180));

        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptNotasEstudianteDefault.png"))); // NOI18N
        btnNotas.setBorder(null);
        btnNotas.setContentAreaFilled(false);
        btnNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotas.setFocusable(false);
        btnNotas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptNotasEstudianteRollover.png"))); // NOI18N
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        jPanel1.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 210, 180));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptIndicadores.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRptIndicadoresRollover.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 210, 180));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menú de Reportes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icnCuadrado.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, -190, 200, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1010, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarBitacoraActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Deseas generar este reporte con filtros?","Información",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
                String mensaje2 = JOptionPane.showInputDialog(null, "Escribe el usuario del cual quieres un reporte de bitacoras.","Aviso",JOptionPane.INFORMATION_MESSAGE);
                try {
                    Conexion con = new Conexion();
                   String reports = "RptBitacoraParametro";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();

                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("FILTRAR_USUARIO",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario()); 
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Bitacoras");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        else if(mensaje == JOptionPane.NO_OPTION)
        {
                try {
                    Conexion con = new Conexion();
                   String reports = "RptBitacoraSinParametro";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
                   String mensaje2 = "";
                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Bitacoras");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
    }//GEN-LAST:event_btnGenerarBitacoraActionPerformed

    private void btnGenerarGradoSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarGradoSeccionActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Deseas filtrar los grados por año?","Información",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
                String mensaje2 = JOptionPane.showInputDialog(null, "Escribe el año del cual quieres un reporte de grados.","Aviso",JOptionPane.INFORMATION_MESSAGE);
                try {
                    Conexion con = new Conexion();
                   String reports = "RptGradosMaestrosParametro";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();

                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("ANIO_SECCION",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Grados");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        else if(mensaje == JOptionPane.NO_OPTION)
        {
                try {
                    Conexion con = new Conexion();
                   String reports = "RptGradosSinParametro";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
                   String mensaje2 = "";
                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Grados");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
    }//GEN-LAST:event_btnGenerarGradoSeccionActionPerformed

    private void btnGenerarEstudiantesGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarEstudiantesGSActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Deseas generar este reporte con filtros?","Información",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION){
            String mensaje1 = JOptionPane.showInputDialog(null, "Escribe el año de la información a solicitar.","Aviso",JOptionPane.INFORMATION_MESSAGE);
             String mensaje2 = JOptionPane.showInputDialog(null, "Escribe el grado por el que quieres el reporte. Por ejemplo Kinder 5","Aviso",JOptionPane.INFORMATION_MESSAGE);
             String mensaje3 = JOptionPane.showInputDialog(null, "Escribe la sección por el que quieres el reporte. Por ejemplo A","Aviso",JOptionPane.INFORMATION_MESSAGE);
                try {
                    Conexion con = new Conexion();
                   String reports = "RptEstudiantesPorGradoParametro";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();

                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("grado",mensaje2); 
                   parametros.put("seccion",mensaje3); 
                   parametros.put("USUARIO",mod.getUsuario());
                   parametros.put("ANIO",mensaje1);
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Estudiantes por grado");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
        } else if (mensaje == JOptionPane.NO_OPTION) {
            String mensaje1 = JOptionPane.showInputDialog(null, "Escribe el año de la información a solicitar.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            try{
        
            
            //se crea la conexion
            Conexion con = new Conexion();
                String reports = "RptEstudiantesPorGradoSinParametro";
                String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
                String mensaje2 = "";
                archivo = URLDecoder.decode(archivo,"UTF-8");
                JasperReport report =
                JasperCompileManager.compileReport(archivo);
                Map<String,Object> parametros = new HashMap<String,Object>();
                parametros.put("ANIO",mensaje1); 
                parametros.put("USUARIO",mod.getUsuario());
                JasperPrint print = JasperFillManager.fillReport(report,
                parametros, con.conectar());
                JasperViewer visor = new JasperViewer(print, false);
                visor.setTitle("Reporte de Alumnos por grado");
                visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                visor.setVisible(true);
                reports="";
            
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGenerarEstudiantesGSActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        try {
                    Conexion con = new Conexion();
                   String reports = "RptListaUsuariosNoParam";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
                   String mensaje2 = "";
                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Usuarios");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnInasistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInasistenciasActionPerformed
                String mensaje2 = JOptionPane.showInputDialog(null, "Escribe el ID del estudiante cual quieres un reporte de inasistencias:.","Aviso",JOptionPane.INFORMATION_MESSAGE);
                try {
                    Conexion con = new Conexion();
                   String reports = "RptInasistenciasParam";
                   String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();

                   archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("ID_ESTUDIANTE",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Inasistencias");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
                } 
                catch (JRException e) {
                    System.out.println("AQUI1");
                    System.out.println(e.getMessage());
                }catch (UnsupportedEncodingException ex) { 
                    Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }//GEN-LAST:event_btnInasistenciasActionPerformed

    private void btnGenerarAsistenciaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarAsistenciaDiaActionPerformed
        String mensaje1 = JOptionPane.showInputDialog(null, "Escribe la fecha del cual quieres un reporte de asistencia (MM-dd-yyyy).","Aviso",JOptionPane.INFORMATION_MESSAGE);
        String mensaje2 = JOptionPane.showInputDialog(null, "Escribe el grado del cual quieres un reporte de asistencia.","Aviso",JOptionPane.INFORMATION_MESSAGE);
        String mensaje3 = JOptionPane.showInputDialog(null, "Escribe la seccion del cual quieres un reporte de asistencia.","Aviso",JOptionPane.INFORMATION_MESSAGE);
        try {
            Conexion con = new Conexion();
            String reports = "RptAsistenciaDiaParametro";
            String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();

            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report =
            JasperCompileManager.compileReport(archivo);
            Map<String,Object> parametros = new HashMap<String,Object>();
            parametros.put("FECHA",mensaje1); 
            parametros.put("GRADO",mensaje2); 
            parametros.put("SECCION",mensaje3); 
            parametros.put("USUARIO",mod.getUsuario());
            JasperPrint print = JasperFillManager.fillReport(report,
            parametros, con.conectar());
            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Reporte de Asistencia");
            visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
            visor.setVisible(true);
            reports="";
        } 
        catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
        }catch (UnsupportedEncodingException ex) { 
            Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarAsistenciaDiaActionPerformed

    private void btnConductaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConductaActionPerformed
        String mensaje1=JOptionPane.showInputDialog(null,"Escribe los apellidos del Estudiante",JOptionPane.INFORMATION_MESSAGE);
        String mensaje2=JOptionPane.showInputDialog(null,"Escribe los nombres del Estudiante",JOptionPane.INFORMATION_MESSAGE);
        
        try{
           Conexion con = new Conexion();

        
            String reports = "reporteConductaEstudiante";
            String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("Filtrar",mensaje1); 
                   parametros.put("FiltrarNombre",mensaje2); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Conducta");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
        
        }
        catch(JRException e){
        
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConductaActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        String mensaje1=JOptionPane.showInputDialog(null,"Escribe los apellidos del Estudiante",JOptionPane.INFORMATION_MESSAGE);
        String mensaje2=JOptionPane.showInputDialog(null,"Escribe los nombres del Estudiante",JOptionPane.INFORMATION_MESSAGE);
        String mensaje3=JOptionPane.showInputDialog(null,"Escribe el trimestre del reporte a generar",JOptionPane.INFORMATION_MESSAGE);
        
        try{
           Conexion con = new Conexion();

        
            String reports = "RptNotasEstudiante";
            String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("APELLIDO",mensaje1); 
                   parametros.put("NOMBRE",mensaje2); 
                   parametros.put("TRIMESTRE",mensaje3); 
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Reporte de Notas");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
        
        }
        catch(JRException e){
        
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNotasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mensaje1=JOptionPane.showInputDialog(null,"Escribe el año del curso",JOptionPane.INFORMATION_MESSAGE);
        String mensaje2=JOptionPane.showInputDialog(null,"Escribe el grado",JOptionPane.INFORMATION_MESSAGE);
        String mensaje3=JOptionPane.showInputDialog(null,"Escribe la seccion",JOptionPane.INFORMATION_MESSAGE);
        String mensaje4=JOptionPane.showInputDialog(null,"Escribe el número del indicador a revisar",JOptionPane.INFORMATION_MESSAGE);
        
        try{
           Conexion con = new Conexion();

        
            String reports = "RptNotasIndicador";
            String archivo = getClass().getResource("/reportes/"+reports+".jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
                   JasperReport report =
                   JasperCompileManager.compileReport(archivo);
                   Map<String,Object> parametros = new HashMap<String,Object>();
                   parametros.put("ANIO",mensaje1); 
                   parametros.put("GRADO",mensaje2); 
                   parametros.put("SECCION",mensaje3); 
                   parametros.put("INDICADOR",mensaje4);
                   parametros.put("USUARIO",mod.getUsuario());
                   JasperPrint print = JasperFillManager.fillReport(report,
                   parametros, con.conectar());
                   JasperViewer visor = new JasperViewer(print, false);
                   visor.setTitle("Resultados de Indicador");
                   visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
                   visor.setVisible(true);
                   reports="";
        
        }
        catch(JRException e){
        
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrmReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConducta;
    private javax.swing.JButton btnGenerarAsistenciaDia;
    private javax.swing.JButton btnGenerarBitacora;
    private javax.swing.JButton btnGenerarEstudiantesGS;
    private javax.swing.JButton btnGenerarGradoSeccion;
    private javax.swing.JButton btnInasistencias;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
