/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
    
     public boolean validarLogin(BDusuarios usr){
    
         
         
        
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
                    else{

                        JOptionPane.showMessageDialog(null,"El perfil esta suspendido o las credenciales son erroneas.");

                    }
                
            }
            else{
            
                   JOptionPane.showMessageDialog(null,"Usuario no encontrado");

            }
           
            
            
        }
        
        
        catch(Exception e)
        {
            System.out.println(e.toString());
        
        }
        
        
        return retorno;
    
    }
    
    
    
    
}
