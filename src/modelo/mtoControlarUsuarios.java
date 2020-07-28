package modelo;

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
public class mtoControlarUsuarios {
    //Metodos Get y Set
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(Integer id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public Integer getId_estado_usuario() {
        return id_estado_usuario;
    }

    public void setId_estado_usuario(Integer id_estado_usuario) {
        this.id_estado_usuario = id_estado_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
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

    //Campos
    private Connection cn;
    private Integer id_usuario;
    private String nombre;
    private String apellido;
    private Integer id_tipo_usuario;
    private Integer id_estado_usuario;
    private String email;
    private String telefono;
    private String dui;
    private String nit;
    private String usuario;
    private String nip;
    private String fecha_nacimiento;
    private String genero;
    private String direccion;
    private String contraseña;
    private byte[] foto;
    
    public mtoControlarUsuarios(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
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
    
    public boolean insertarUsuario(){
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO usuario(id_usuario, nombre, apellido, id_tipo_usuario, id_estado_usuario, email, telefono, dui, nit,  usuario, nip, fecha_nacimiento, genero,"
                    + "direccion, contraseña, foto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, id_usuario);
            cmd.setString(2, nombre);
            cmd.setString(3, apellido);
            cmd.setInt(4, id_tipo_usuario);
            cmd.setInt(5, id_estado_usuario);
            cmd.setString(6, email);
            cmd.setString(7, telefono);
            cmd.setString(8, dui);
            cmd.setString(9, nit);
            cmd.setString(10, usuario);
            cmd.setString(11, nip);
            cmd.setString(12, fecha_nacimiento);
            cmd.setString(13, genero);
            cmd.setString(14, direccion);
            cmd.setString(15, contraseña);
            cmd.setBytes(16, foto);
            
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
}
