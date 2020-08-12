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
    
    public boolean actualizarContraseña(){
        CtrlLoginUsuario usr = new CtrlLoginUsuario();
        FrmActualizarContraseña a = new FrmActualizarContraseña();
        boolean resp = false;
        try
        {
            String sql = "UPDATE usuario SET contraseña = ? WHERE usuario = ?";
            PreparedStatement cmd = conexion.prepareCall(sql);
            cmd.setString(1, usr.getContrasenia());
            cmd.setString(2, usr.getUsuario());
            if (!cmd.execute()) {
                resp = true;
            }
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resp;
    }
    
}
