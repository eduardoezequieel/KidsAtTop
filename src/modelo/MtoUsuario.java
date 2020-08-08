package modelo;

import controlador.CtrlUsuario;
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
public class MtoUsuario {
   
    //Conexión
    private Connection cn;
    public MtoUsuario(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    //Llamando al constructor 
    CtrlUsuario ctrl = new CtrlUsuario();
    
    //<editor-fold defaultstate="collapsed" desc="Capturar IDs">
    public Integer getIdTipoUsuario (String nombre){
         Integer id = 0;
        try{
            
            String sql = "SELECT id_tipo_usuario FROM tipo_usuario WHERE tipo_usuario = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    public Integer getIdEstadoUsuario (String nombre){
        Integer id = 0;
        try
        {
            String sql = "SELECT id_estado_usuario FROM estado_usuario WHERE estado_usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, nombre);
            
            ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
             id = rs.getInt(1);
             }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return id;
    }
    
    public Integer getIdUsuario(String usuario){
        Integer id = 0;
        try{
            //Consulta
            String sql = "SELECT id_usuario FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
           //Asignando valores de la consulta 
            cmd.setString(1, usuario);
            //Ejecutando consulta
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return id;
    }
    
    public static String email, telefono, dui, direccion, nit, nip, fecha_nacimiento;
    public static Integer maxIdUsuario;
    public boolean capturarDatosUsuario(String usuario){
        boolean resp = false;
        try{
            String sql = "SELECT email, telefono, dui, direccion, nit, nip, fecha_nacimiento FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, usuario);
            
            //Ejecutando consulta
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
                email = rs.getString(1);
                telefono = rs.getString(2);
                dui = rs.getString(3);
                direccion = rs.getString(4);
                nit = rs.getString(5);
                nip = rs.getString(6);
                fecha_nacimiento = rs.getString(7);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
    
    public byte[] capturarFoto(String usuario){
        byte[] foto = null;
        try{
            String sql = "SELECT foto FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, usuario);
            
            //Ejecutando consulta
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                foto = rs.getBytes(1); 
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return foto;
    }
    
    public boolean capturarMaxIdUsuario(){
        boolean resp = false;
        try{
            String sql = "SELECT max(id_usuario) FROM usuario";
            PreparedStatement cmd = cn.prepareCall(sql);
            
            //Ejecutando consulta
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
                maxIdUsuario = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            
        }
        return resp;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ComboBox">
    //Metodo para llenar el combobox del tipo usuario
    public DefaultComboBoxModel llenarTipoUsuario(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            CallableStatement cmd = cn.prepareCall("{CALL cbTipoUsuario}");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
    
    //Metodo para llenar el combobox del estado usuario (temporal)
    public DefaultComboBoxModel llenarEstadoUsuario(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            CallableStatement cmd = cn.prepareCall("{CALL cbEstadoUsuario}");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }       
      return modelo;
    }
    
    public String getItemsTipoUsuario(String usuario){
        String item = "";
        try{
            //Llamando procedimiento
            CallableStatement cmd = cn.prepareCall("{CALL cbTipoUsuarioInverso(?)}");
            cmd.setString(1, usuario);
            
            //Ejecutando sentencia
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                item = rs.getString(1);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return item;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD">
    public boolean insertarUsuario(){
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO usuario(id_usuario, nombre, apellido, id_tipo_usuario, id_estado_usuario, email, telefono, dui, nit,  usuario, nip, fecha_nacimiento, genero,"
                    + "direccion, contraseña, foto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, ctrl.getId_usuario());
            cmd.setString(2, ctrl.getNombre());
            cmd.setString(3, ctrl.getApellido());
            cmd.setInt(4, ctrl.getId_tipo_usuario());
            cmd.setInt(5, ctrl.getId_estado_usuario());
            cmd.setString(6, ctrl.getEmail());
            cmd.setString(7, ctrl.getTelefono());
            cmd.setString(8, ctrl.getDui());
            cmd.setString(9, ctrl.getNit());
            cmd.setString(10, ctrl.getUsuario());
            cmd.setString(11, ctrl.getNip());
            cmd.setString(12, ctrl.getFecha_nacimiento());
            cmd.setString(13, ctrl.getGenero());
            cmd.setString(14, ctrl.getDireccion());
            cmd.setString(15, ctrl.getContraseña());
            cmd.setBytes(16, ctrl.getFoto());
            
            if (!cmd.execute()) {
                resp=true;
            }
            
            cmd.close();
            cn.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    
    public boolean actualizarUsuario(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET nombre = ?, apellido = ?, id_tipo_usuario = ?, id_estado_usuario = ?, email = ?, telefono = ?, dui = ?, nit = ?, usuario = ?, nip = ?, fecha_nacimiento = ?, "
                    + "genero = ?, direccion = ?, contraseña = ?, foto = ? WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, ctrl.getNombre());
            cmd.setString(2, ctrl.getApellido());
            cmd.setInt(3, ctrl.getId_tipo_usuario());
            cmd.setInt(4, ctrl.getId_estado_usuario());
            cmd.setString(5, ctrl.getEmail());
            cmd.setString(6, ctrl.getTelefono());
            cmd.setString(7, ctrl.getDui());
            cmd.setString(8, ctrl.getNit());
            cmd.setString(9, ctrl.getUsuario());
            cmd.setString(10, ctrl.getNip());
            cmd.setString(11, ctrl.getFecha_nacimiento());
            cmd.setString(12, ctrl.getGenero());
            cmd.setString(13, ctrl.getDireccion());
            cmd.setString(14, ctrl.getContraseña());
            cmd.setBytes(15, ctrl.getFoto());
            cmd.setInt(16, ctrl.getId_usuario());
            
            //Ejecutando consulta
            if (!cmd.execute()) {
                resp = true;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
     //</editor-fold>
}
