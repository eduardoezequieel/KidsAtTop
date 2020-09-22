/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlRecuContra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author katy0
 */
public class MtoRecuperaciones {
    
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
    
    public MtoRecuperaciones(){
        ClsConexion conectar = new ClsConexion();
        cn = conectar.conectar();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Recuperacion por correo">
    
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
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recuperacion por administrador">
    
     public boolean validarAdmin(){
         
        //Declarando variable de retorno
        boolean retorno=false;
        try{
            //verificar existencia
            String sql="select usuario from usuario where usuario = ? AND NOT id_tipo_usuario = 1";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getUsuario());
            
            ResultSet rs1= cmd.executeQuery();
            
            if (rs1.next()) {
                    //verificar credenciales y estado del usuario
                    String sql2 ="select usuario from usuario where usuario=? and contraseña= ? ";
                    PreparedStatement cmd2 = cn.prepareStatement(sql2);
                    cmd2.setString(1, recuCtrl.getAdmin());
                    cmd2.setString(2, recuCtrl.getContraseña());
                    
                    ResultSet rs= cmd2.executeQuery();

                    if (rs.next()) {
                            retorno = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Las credenciales del admin no son correctas");
                    }
            }
            else
            {
                   JOptionPane.showMessageDialog(null,"El usuario a recuperar no puede ser admin");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return retorno;
    }
     
    public boolean verificarUser(){
        
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            //verificando existencia
            String sql="select usuario from usuario where usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getUsuario());
            
            ResultSet rs1= cmd.executeQuery();
            
            if (rs1.next()) {
                resp = true;
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario a recuperar");
            }
            
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        //Retornando valor
        return resp;
    }
    
    public boolean verificarAdminRepetido(){
        
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            //verificando existencia
            String sql="SELECT usuario FROM usuario WHERE usuario = ? AND usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getUsuario());
            cmd.setString(2, recuCtrl.getAdmin());
            
            ResultSet rs1= cmd.executeQuery();
            
            if (rs1.next()) {
                resp = true;
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no puede ser el mismo");
            }
            
            
            
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return resp;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recuperacion por preguntas de seguridad">
    public boolean obtenerIdUsuario(){
        boolean resp = false;
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_usuario FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, recuCtrl.getUsuario());
            
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
               recuCtrl.setIdUsuario(rs.getInt(1));
               resp = true;
            } else {
                JOptionPane.showMessageDialog(null,"Usuario no encontrado");
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return resp;
    }
    
    public DefaultComboBoxModel llenarPreguntas(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbPreguntas(?)}");
            
            cmd.setInt(1, recuCtrl.getIdUsuario());
            
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
   
    public DefaultComboBoxModel llenarRespuestas(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbRespuestas(?)}");
            
            cmd.setInt(1, recuCtrl.getIdUsuario());
            
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
     //</editor-fold>
    
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
