/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlSecciones;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class MtoSecciones {
    
    CtrlSecciones ctrl = new CtrlSecciones();
    
    private Connection cn;
    
    public MtoSecciones(){
        Conexion conectar = new Conexion();
        cn = conectar.conectar();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Obtener ID">
    public void obtenerUltimoId(){ 
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT max(id_grado_seccion) FROM grado_seccion";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               ctrl.setIdGradoSeccion(rs.getInt(1) + 1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }

    }
    
    public void obtenerIdGrado(){
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_grado FROM grado WHERE grado = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, ctrl.getGrado());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               ctrl.setIdGrado(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void obtenerIdSeccion(){
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_seccion FROM seccion WHERE seccion = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, ctrl.getSeccion());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               ctrl.setIdSeccion(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void obtenerIdUsuario(){
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_usuario FROM usuario WHERE usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, ctrl.getUsuario());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               ctrl.setIdUsuario(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Llenar ComboBox">
    public DefaultComboBoxModel obtenerUsuarios(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("SELECT usuario from usuario where id_estado_usuario = 1;");
            
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
    public DefaultComboBoxModel obtenerGrados(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("SELECT grado from grado;");
            
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
    public DefaultComboBoxModel obtenerSecciones(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("SELECT seccion from seccion;");
            
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
    
    //<editor-fold defaultstate="collapsed" desc="CRUD">
    public boolean verificarRegistro(){
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            String verSql = "select * from grado_seccion where id_seccion = ? and id_grado = ? and anio_seccion = ?";
            PreparedStatement verCmd = cn.prepareStatement(verSql);
            verCmd.setInt(2, ctrl.getIdGrado());
            verCmd.setInt(1, ctrl.getIdSeccion());
            verCmd.setString(3, ctrl.getAnio());
            ResultSet rs = verCmd.executeQuery();
            if (rs.next()) {
                resp = true;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return resp;
    }
    public boolean insertarGradoSeccion(){
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
                       
            //Preparando sentencia
            String sql = "INSERT INTO grado_seccion(id_grado_seccion, id_grado, id_seccion, id_usuario, anio_seccion)"
                            + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setInt(1, ctrl.getIdGradoSeccion());
            cmd.setInt(2, ctrl.getIdGrado());
            cmd.setInt(3, ctrl.getIdSeccion());
            cmd.setInt(4, ctrl.getIdUsuario());
            cmd.setString(5, ctrl.getAnio());
            
            if (!cmd.execute()) {
                resp = true;
            }
            
        
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        //Retornando valor
        return resp;
    }
    
    //</editor-fold>
}
