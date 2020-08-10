/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlRecuContra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author katy0
 */
public class RecuContra {
    
    //Llamando clase constructor
    CtrlRecuContra recuCtrl = new CtrlRecuContra();
    
    
    //Declarando variable de conexion
    private Connection cn;

    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }

    /**
     * @param cn the cn to set
     */
    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public RecuContra(){
        Conexion conectar = new Conexion();
        cn = conectar.conectar();
    }
    
    //Recuperación por correo
    
    public boolean verificarUsuario(){
        
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            //Preparando sentencia
            String sql = "SELECT email FROM usuario where usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getUsuario());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                recuCtrl.setCorreo(rs.getString(1));
                resp = true;
            }
            
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        //Retornando valor
        return resp;
    }
    
    public void generarCodigo(){
        int n = 1000;
        int m = 9999;
        int valorEntero = (int)Math.floor(Math.random()*(n-m+1)+m);
        recuCtrl.setCodigoVerificacion(valorEntero);
    }
    
    public boolean cambiarContra(){
        
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            //Preparando sentencia
            String sql = "UPDATE usuario SET contraseña = ? WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getNuevaContra());
            cmd.setString(2, recuCtrl.getUsuario());
            
            if (!cmd.execute()) {
                resp = true;
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        //Retornando variable
        return resp;
    }
    
  
}
