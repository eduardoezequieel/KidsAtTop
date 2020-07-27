/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidsattop;

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
public class Login {
    
    public boolean login(usuarios usr){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conex = getConnection();
        
        String sql = "SELECT id_usuario, nombre, contrasenia, apellido, id_tipo_usuario FROM usuarios WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                
                if(usr.getPassword().equals(rs.getString(3))) {
              
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setApellido(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    return true;
                    
                } else {
                    return false;
                }
                
            }
            
            return false;
        }
        
        catch (SQLException ex){
            Logger.getLogger(BDusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
