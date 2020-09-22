package modelo;

import controlador.CtrlLoginUsuario;
import controlador.CtrlUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vistas.FrmActualizarContraseña;
/**
 *
 * @author EDUARDO
 */
public class MtoUsuario {
   
    //Conexión
    private Connection cn;
    public MtoUsuario(){
        ClsConexion con = new ClsConexion();
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
    
    
    public static Integer maxIdUsuario;
    public boolean capturarDatosUsuario(String usuario){
        boolean resp = false;
        try{
            String sql = "SELECT nombre, apellido, email, telefono, dui, nit, nip, fecha_nacimiento, genero, direccion, foto FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, usuario);
            
            //Ejecutando consulta
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
                ctrl.setNombre(rs.getString(1));
                ctrl.setApellido(rs.getString(2));
                ctrl.setEmail(rs.getString(3));
                ctrl.setTelefono(rs.getString(4));
                ctrl.setDui(rs.getString(5));
                ctrl.setNit(rs.getString(6));
                ctrl.setNip(rs.getString(7));
                ctrl.setFecha_nacimiento(rs.getString(8));
                ctrl.setGenero(rs.getString(9));
                ctrl.setDireccion(rs.getString(10));
                ctrl.setFoto(rs.getBytes(11));
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
    
    public String capturarUsuario(Integer id)
    {
        String usuario = null;
        try
        {
            String sql = "SELECT usuario FROM usuario WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                usuario = rs.getString(1);
            }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return usuario;
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
            String sql = "UPDATE usuario SET nombre = ?, apellido = ?, id_tipo_usuario = ?, email = ?, telefono = ?, dui = ?, nit = ?, usuario = ?, nip = ?, fecha_nacimiento = ?, "
                    + "genero = ?, direccion = ?, foto = ? WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, ctrl.getNombre());
            cmd.setString(2, ctrl.getApellido());
            cmd.setInt(3, ctrl.getId_tipo_usuario());
            cmd.setString(4, ctrl.getEmail());
            cmd.setString(5, ctrl.getTelefono());
            cmd.setString(6, ctrl.getDui());
            cmd.setString(7, ctrl.getNit());
            cmd.setString(8, ctrl.getUsuario());
            cmd.setString(9, ctrl.getNip());
            cmd.setString(10, ctrl.getFecha_nacimiento());
            cmd.setString(11, ctrl.getGenero());
            cmd.setString(12, ctrl.getDireccion());
            cmd.setBytes(13, ctrl.getFoto());
            cmd.setInt(14, ctrl.getId_usuario());
            
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
    
    public boolean suspenderUsuario(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET id_estado_usuario = 2 WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, ctrl.getId_usuario());
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
    
    public boolean activarUsuario(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET id_estado_usuario = 1 WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, ctrl.getId_usuario());
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
    
    public boolean reiniciarContraseña(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET contraseña = ? WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, ctrl.getContraseña());
            cmd.setInt(2, ctrl.getId_usuario());
            
            //Ejecutando sentencia
            if (!cmd.execute()) {
                resp = true;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
    
    public boolean actualizarContraseña(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET contraseña = ? WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, ctrl.getContraseña());
            cmd.setInt(2, ctrl.getId_usuario());
            if (!cmd.execute()) {
                resp = true;
            }
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
    
    public boolean actualizarMiCuenta(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET nombre = ?, apellido = ?, email = ?, telefono = ?, dui = ?, nit = ?, usuario = ?, nip = ?, fecha_nacimiento = ?, "
                    + "genero = ?, direccion = ?, foto = ? WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, ctrl.getNombre());
            cmd.setString(2, ctrl.getApellido());
            cmd.setString(3, ctrl.getEmail());
            cmd.setString(4, ctrl.getTelefono());
            cmd.setString(5, ctrl.getDui());
            cmd.setString(6, ctrl.getNit());
            cmd.setString(7, ctrl.getUsuario());
            cmd.setString(8, ctrl.getNip());
            cmd.setString(9, ctrl.getFecha_nacimiento());
            cmd.setString(10, ctrl.getGenero());
            cmd.setString(11, ctrl.getDireccion());
            cmd.setBytes(12, ctrl.getFoto());
            cmd.setInt(13, ctrl.getId_usuario());
            
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
    
    public boolean eliminarRespuestas(){
        boolean resp = false;
        try
        {
            String sql = "DELETE FROM respuestas WHERE id_usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, ctrl.getId_usuario());
            
            if (!cmd.execute()) {
                resp = true;
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    }
     //</editor-fold>
    
    //Validaciones
    
    public boolean validarDUI(String dui){
        boolean resp = false;
        try
        {
            String sql = "SELECT dui FROM usuario WHERE dui = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, dui);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean validarNIT(String nit){
        boolean resp = false;
        try
        {
            String sql = "SELECT nit FROM usuario WHERE nit = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, nit);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean validarNIP(String nip){
        boolean resp = false;
        try
        {
            String sql = "SELECT nip FROM usuario WHERE nip = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, nip);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean validarUsuario(String user){
        boolean resp = false;
        try
        {
            String sql = "SELECT usuario FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, user);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean validarCorreo(String correo){
        boolean resp = false;
        try
        {
            String sql = "SELECT email FROM usuario WHERE email = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, correo);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean validarTelefono(String telefono){
        boolean resp = false;
        try
        {
            String sql = "SELECT telefono FROM usuario WHERE telefono = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, telefono);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    } 
}
