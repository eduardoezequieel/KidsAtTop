/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class BDUser extends Conexion {
    
    public boolean login(BDusuarios usr){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conex = conectar();
        
        String sql = "SELECT id_usuario, nombre, contraseña, apellido, id_tipo_usuario FROM usuarios WHERE usuario = ?";
        
        try {
            ps = conex.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                
                if(usr.getContrasenia().equals(rs.getString(3))) {
              
                    usr.setId_usuario(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setApellido(rs.getString(4));
                    usr.setId_tipo_usuario(rs.getInt(5));
                    return true;
                    
                } else {
                    return false;
                }
                
            }
            
            return false;
        }
        
        catch (SQLException ex){
            Logger.getLogger(BDUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
}
