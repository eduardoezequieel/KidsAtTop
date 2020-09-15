package modelo;

import controlador.CtrlNotas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class MtoNotas {
    //Conexión
    private Connection cn;
    public MtoNotas(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    //Llamando al constructor 
    CtrlNotas ctrl = new CtrlNotas();
    
    public DefaultComboBoxModel llenarAnio(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbAnio}");
            
            //Ejecutando sentencia
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                //Agregando elementos al combobox
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }       
      return modelo;
    }
    
    public DefaultComboBoxModel llenarGradoSeccion(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbGradoSeccion(?)}");
            
            cmd.setString(1,ctrl.getAñoSeccion());
            
            cmd.execute();
            //Ejecutando sentencia
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                //Agregando elementos al combobox
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }       
      return modelo;
    }
    
    public DefaultComboBoxModel llenarTrimestre(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            String sql = "SELECT trimestre FROM trimestre;";
            PreparedStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel llenarNotaPredeterminada() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            String sql = "SELECT n_predeterminada FROM nota_predeterminada";
            PreparedStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel llenarIndicador(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            CallableStatement cmd = cn.prepareCall("{CALL cbIndicadores(?)}");
            cmd.setInt(1,ctrl.getNivelAcademico());
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return modelo;
    }
    
    public int getIDIndicador(String indicador){
        int id = 0;
        try
        {
            String sql = "SELECT id_indicador FROM indicador_logro WHERE indicador = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, indicador);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public int getIDTrimestre(String trimestre){
        int id = 0;
        try
        {
            String sql = "SELECT id_trimestre FROM trimestre WHERE trimestre = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, trimestre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public int getIDNota(int idIndicador, String grado, String seccion, int idTrimestre, String añoSeccion, String apellido, String nombre){
        int id = 0;
        try
        {
            String sql = "SELECT id_nota FROM nota ne, indicador_logro i, nota_predeterminada n, estudiante e, trimestre t, grado_seccion gs, grado g, seccion s "
                    + "WHERE ne.id_indicador = i.id_indicador AND ne.id_n_predeterminada = n.id_n_predeterminada AND ne.id_estudiante = e.id_estudiante "
                    + "AND e.id_grado_seccion = gs.id_grado_seccion AND gs.id_grado = g.id_grado AND gs.id_seccion = s.id_seccion AND  ne.id_trimestre = t.id_trimestre "
                    + "AND i.id_indicador = ? AND g.grado = ? AND s.seccion = ? AND t.id_trimestre = ? AND gs.anio_seccion = ? AND e.apellido = ? "
                    + "AND e.nombre = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, idIndicador);
            cmd.setString(2, grado);
            cmd.setString(3, seccion);
            cmd.setInt(4, idTrimestre);
            cmd.setString(5, añoSeccion);
            cmd.setString(6, apellido);
            cmd.setString(7, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public int getIDNotaPredeterminada(String notaPredeterminada){
        int id = 0;
        try
        {
            String sql = "SELECT id_n_predeterminada FROM nota_predeterminada WHERE n_predeterminada = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, notaPredeterminada);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        } 
        return id;
    }
    
    public int getIDUltimaNota(){
        int id = 0;
        try
        {
          String sql = "SELECT max(id_nota) FROM nota";
          PreparedStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next()){
              id = rs.getInt(1);
          }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public boolean ActualizarNota(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE nota SET id_n_predeterminada = ? WHERE id_nota = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, ctrl.getIdNotaPredeterminada());
            cmd.setInt(2, ctrl.getIdNota());
            if (!cmd.execute()) {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    }
    
    /*public boolean insertarNota(){
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO nota VALUES (?,?,1,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, ctrl.getIdNota());
            cmd.setInt(2, 0);
        }
        catch (Exception ex) {
            
        }
    }*/
}
