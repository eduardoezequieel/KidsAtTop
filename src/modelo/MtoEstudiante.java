/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlEstudiante;
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
public class MtoEstudiante {
    
    //Llamando clase de controlador
    CtrlEstudiante estudianteCtrl = new CtrlEstudiante();
    
    //Declarando conexion
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
    
    public MtoEstudiante(){
        
        //Llamando conexion
        Conexion conectar = new Conexion();
        cn = conectar.conectar();
    }
    
    public void obteniendoResponsable(){
        
        //Llamando clase de responsable
        CtrlResponsable responsableCtrl = new CtrlResponsable();
        try{
            
            //Preparando sentencia
            String sql = "SELECT CONCAT(nombre,' ',apellido) as responsable, id_responsable FROM responsable WHERE dui = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, responsableCtrl.getDui());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                estudianteCtrl.setResponsable(rs.getString(1));
                estudianteCtrl.setIdResponsable(rs.getInt(2));
            }
            
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Llenando Combobox">
    public DefaultComboBoxModel llenarGS(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbGS}");
            
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
    
    //<editor-fold defaultstate="collapsed" desc="Obteniendo Ids">
    //Obteniendo id del estudiante
    public void obtenerUltimoId(){

        try{
            
            //Preparando sentencia sql
            String sql = "SELECT max(id_estudiante) FROM estudiante";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               estudianteCtrl.setIdEstudiante(rs.getInt(1) + 1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public void obtenerIdGS(String grado, String seccion){
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT gs.id_grado_seccion FROM grado_seccion gs, seccion s, grado g where g.grado = ? AND s.seccion = ? AND g.id_grado = gs.id_grado AND s.id_seccion = gs.id_seccion";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, grado);
            cmd.setString(2, seccion);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               estudianteCtrl.setIdGradoSeccion(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }

    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD">
    public boolean insertarEstudiante(){
        
        //Declarando valor de retorno
        boolean resp = false;
        
        try{
            
            //Preparando sentencia
            String sql = "INSERT INTO estudiante(id_estudiante, nombre, apellido, anio_ingreso, fecha_nacimiento, direccion, genero, "
                            + "id_estado_estudiante, id_responsable, id_grado_seccion, foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setInt(1, estudianteCtrl.getIdEstudiante());
            cmd.setString(2, estudianteCtrl.getNombre());
            cmd.setString(3, estudianteCtrl.getApellido());
            cmd.setString(4, estudianteCtrl.getAnioIngreso());
            cmd.setString(5, estudianteCtrl.getFechaNacimiento());
            cmd.setString(6, estudianteCtrl.getDireccion());
            cmd.setString(7, estudianteCtrl.getGenero());
            cmd.setInt(8, estudianteCtrl.getIdEstado());
            cmd.setInt(9, estudianteCtrl.getIdResponsable());
            cmd.setInt(10, estudianteCtrl.getIdGradoSeccion());
            cmd.setBytes(11, estudianteCtrl.getFoto());
            
            if (!cmd.execute()) {
                resp = true;
            }
            
        
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        //Retornando valor
        return resp;
    }
    // </editor-fold>
}
