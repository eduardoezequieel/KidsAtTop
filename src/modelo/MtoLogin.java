/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlLoginUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vistas.FrmActualizarContraseña;
import vistas.frmLogin;

/**
 *
 * @author pablo
 */
public class MtoLogin {
    
    private Connection conexion;

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public MtoLogin(){
        
        Conexion con=new Conexion();
        conexion=con.conectar();
    
    }
   //<editor-fold defaultstate="collapsed" desc="Login">   
     public boolean validarLogin(CtrlLoginUsuario usr){
        boolean retorno=false;
        try{
            //verificar existencia
            String query1="select usuario from usuario where usuario='"+usr.getUsuario()+"'";
            Statement st1=conexion.createStatement();
            ResultSet rs1=st1.executeQuery(query1);
            
            if (rs1.next()) {
                    //verificar credenciales y estado del usuario
                    int estado=1;
                    String query="select usuario,id_usuario from usuario where usuario='"+usr.getUsuario()+"' and contraseña='"+usr.getContrasenia()+"'and id_estado_usuario='"+estado+"'";
                    Statement st=conexion.createStatement();
                    ResultSet rs=st.executeQuery(query);

                    if (rs.next()) {
                            retorno=true;
                            usr.setUsuario(rs.getString(1));
                            usr.setId_usuario(rs.getInt(2));
                            
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"El perfil esta suspendido o las credenciales son erroneas.");
                    }
                
            }
            else
            {
                   JOptionPane.showMessageDialog(null,"Usuario no encontrado");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return retorno;
    }
     
    public boolean verificarContraseña(CtrlLoginUsuario usr){
        boolean resp = false;
        try
        {
             String query2 = "SELECT contraseña FROM usuario WHERE usuario = '"+usr.getUsuario()+"' AND contraseña = '40bd001563085fc35165329ea1ff5c5ecbdbbeef'";
             Statement st2 = conexion.createStatement();
             ResultSet rs2 = st2.executeQuery(query2);
             if (rs2.next()) {
                JOptionPane.showMessageDialog(null, "Debe actualizar su contraseña.","Aviso", JOptionPane.INFORMATION_MESSAGE);
                resp = true;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
    CtrlLoginUsuario usr;
    
    
    public boolean obtenerDatosUsuario(CtrlLoginUsuario usr){
        boolean resp = false;
        try
        {
            String sql = "SELECT * FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = conexion.prepareCall(sql);
            cmd.setString(1, usr.getUsuario());
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = true;
                usr.setId_usuario(rs.getInt(1));
                usr.setNombre(rs.getString(2));
                usr.setApellido(rs.getString(3));
                usr.setId_tipo_usuario(rs.getInt(4));
                usr.setId_estado_usuario(rs.getInt(5));
                usr.setEmail(rs.getString(6));
                usr.setTelefono(rs.getString(7));
                usr.setDui(rs.getString(8));
                usr.setNit(rs.getString(9));
                usr.setUsuario(rs.getString(10));
                usr.setNip(rs.getString(11));
                usr.setFecha_nacimiento(rs.getString(12));
                usr.setGenero(rs.getString(13));
                usr.setDireccion(rs.getString(14));
                usr.setContrasenia(rs.getString(15));
                usr.setFoto(rs.getBytes(16));
            }
            
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
        return resp;
    }
    
    public boolean verificarPrimerUso(){
        boolean resp = false;
        try
        {
            String sql = "SELECT*FROM usuario WHERE id_usuario = 1";
            PreparedStatement cmd = conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println("Error");
        }
        return resp;
    }
    
    public boolean continuarPrimerUso1()
    {
        boolean resp = false;
        try
        {
            String sql = "SELECT contraseña FROM usuario WHERE id_usuario = 1 AND contraseña = '3a9f3478bc9a9ec348ea30534618d4592ad5a519'";
            PreparedStatement cmd = conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    }
    
    public boolean continuarPrimerUso2()
    {
        boolean resp = false;
        try
        {
            String sql = "SELECT*FROM respuestas WHERE id_usuario = 1";
            PreparedStatement cmd = conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    }
    
    public boolean detectarRespuestas(CtrlLoginUsuario usr)
    {
        boolean resp = false;
        try
        {
            String sql = "SELECT*FROM respuestas WHERE id_usuario = ?";
            PreparedStatement cmd = conexion.prepareCall(sql);
            cmd.setInt(1, usr.getId_usuario());
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
    
    //</editor-fold>
   
    
    
}
