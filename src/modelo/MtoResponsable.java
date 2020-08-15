/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlResponsable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author katy0
 */
public class MtoResponsable {
    
    //Declarando variable de la conexion 
    private Connection cn;
    
    //Llamando clase controlador
    CtrlResponsable responsableCtrl = new CtrlResponsable();

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
    
    public MtoResponsable(){
        Conexion conectar = new Conexion();
        cn = conectar.conectar();
    }
    
    public boolean verificarDui(){
        
        //Declarando valor de retorno 
        boolean resp = false;
        
        try{
            
            //Preparando sentencia
            String sql = "SELECT dui FROM responsable WHERE dui = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, responsableCtrl.getDui());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                responsableCtrl.setDui(rs.getString(1));
                resp = true;
            }
            
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
                
        //Retornando valor
        return resp;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Llenando Combobox">
    public DefaultComboBoxModel llenarParentesco(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbParentesco}");
            
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
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ObteniendoIds">
    //Obteniendo id del parentesco
    public void obtenerIdParentesco(String parentesco){
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_parentesco FROM parentesco WHERE parentesco = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, parentesco);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               responsableCtrl.setIdParentesco(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public void obtenerIdEstado(){
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_estado_responsable FROM responsable WHERE id_responsable = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, responsableCtrl.getIdResponsable());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               responsableCtrl.setIdEstado(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    //Obteniendo id del responsable
    public void obtenerUltimoId(){ 
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT max(id_responsable) FROM responsable";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               responsableCtrl.setIdResponsable(rs.getInt(1) + 1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }

    }
   // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD">
    
    public boolean insertarResponsable(){
        
        //Declarando variable de retorno
        boolean resp = false;
        
        try{
            
            //Preparando sentencia
            String sql = "INSERT INTO responsable(id_responsable, nombre, apellido, dui, id_estado_responsable, telefono, email, id_parentesco)"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setInt(1, responsableCtrl.getIdResponsable());
            cmd.setString(2, responsableCtrl.getNombre());
            cmd.setString(3, responsableCtrl.getApellido());
            cmd.setString(4, responsableCtrl.getDui());
            cmd.setInt(5, responsableCtrl.getIdEstado());
            cmd.setString(6, responsableCtrl.getTelefono());
            cmd.setString(7, responsableCtrl.getEmail());
            cmd.setInt(8, responsableCtrl.getIdParentesco());
            
            if (!cmd.execute()) {
                resp = true;
            }
            
        
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        //Retornando valor
        return resp;
    }
    
    public boolean actualizarResponsable(String parentesco){
        boolean resp = false;
        try{
            //Se obtiene el Id del parentesco seleccionado
            String parent = "SELECT id_parentesco FROM parentesco WHERE parentesco = ?";
            PreparedStatement cmdPar = cn.prepareStatement(parent);
            cmdPar.setString(1, parentesco);
            ResultSet rs = cmdPar.executeQuery();
            while(rs.next()){
                responsableCtrl.setIdParentesco(rs.getInt(1));
            }
            
            //Se actualiza el responsable seleccionado
            String sql = "UPDATE responsable set nombre = ?, apellido = ?, dui = ?, telefono = ?, email = ?, id_parentesco = ? WHERE id_responsable = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, responsableCtrl.getNombre());
            cmd.setString(2, responsableCtrl.getApellido());
            cmd.setString(3, responsableCtrl.getDui());
            cmd.setString(4, responsableCtrl.getTelefono());
            cmd.setString(5, responsableCtrl.getEmail());
            cmd.setInt(6, responsableCtrl.getIdParentesco());
            cmd.setInt(7, responsableCtrl.getIdResponsable());
            
            if (!cmd.execute()) {
                resp = true;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return resp;
    }
    public boolean suspenderResponsable(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE responsable SET id_estado_responsable = 3 WHERE id_responsable = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, responsableCtrl.getIdResponsable());
            //Ejecutando consulta
            if (!cmd.execute()) {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return resp;
    }
    
    public boolean activarResponsable(){
        boolean resp = false;
        try
        {
            String sql = "UPDATE responsable SET id_estado_responsable = 1 WHERE id_responsable = ?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setInt(1, responsableCtrl.getIdResponsable());
            //Ejecutando consulta
            if (!cmd.execute()) {
                resp = true;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return resp;
    }
    // </editor-fold>
    
}
