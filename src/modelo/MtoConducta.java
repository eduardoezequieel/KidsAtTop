/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlConducta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author katy0
 */
public class MtoConducta {
    
    //Conexion
    private Connection cn;  
    
    //Llamando al constructor
    CtrlConducta conducta = new CtrlConducta();
    
    //Modelo de la tabla 
    DefaultTableModel modeloTabla;
    
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
    
    //Llamando a la conexión
    public MtoConducta(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="LlenandoComboBox">
    //Llenado combobox de año lectivo
    public DefaultComboBoxModel llenarAnio(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbAnio}");
            
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
    
    //Llenando combobox de grado_Seccion
    public DefaultComboBoxModel llenarGradoSeccion(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbGradoSeccion(?)}");
            
            cmd.setString(1,conducta.getAnio());
            
            cmd.execute();
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
    
    
    //Llenando combobox de estudiante
    public DefaultComboBoxModel llenarEstudiante(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbEstudiante(?)}");
            
            cmd.setInt(1, conducta.getIdGradoSeccion());
            
            cmd.execute();
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
    
    //Llenando combobox de grado_Seccion
    public DefaultComboBoxModel llenarTipoFalta(){
        
        //Creando instancia del modelo
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            
            String sql = "select tipo_falta from tipo_falta";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }       
      return modelo;
    }
    
     public DefaultComboBoxModel getAsistencia(){
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String sql = "SELECT tipo_asistencia FROM tipo_asistencia";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
            
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return modelo;
    }
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ObteniendoIds">
    //Obteniendo id del grado_Seccion
    public int obtenerIdGS(String grado, String seccion){
        int id = 0;
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT gs.id_grado_seccion FROM grado_seccion gs, seccion s, grado g where g.grado = ? AND s.seccion = ? AND g.id_grado = gs.id_grado AND s.id_seccion = gs.id_seccion AND gs.anio_seccion = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, grado);
            cmd.setString(2, seccion);
            cmd.setString(3, conducta.getAnio());
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    //Obteniendo id del estudiante
    public int obtenerIdEstudiante(String apellido, String nombre){
        int id = 0;
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_estudiante FROM estudiante WHERE apellido = ? AND nombre = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, apellido);
            cmd.setString(2, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    public void obtenerIdTipoFalta(String nombre){

        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_tipo_falta FROM tipo_falta WHERE tipo_falta = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            
            cmd.setString(1, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               conducta.setIdTipoFalta(rs.getInt(1));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public int obtenerIdTipoAsistencia(String nombre){
        int id = 0;
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT id_tipo_asistencia FROM tipo_asistencia WHERE tipo_asistencia = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            
            cmd.setString(1, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    //Obteniendo id del estudiante
    public int obtenerUltimoId(){
        int id = 0;
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT max(id_conducta) FROM conducta";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    public int obtenerUltimoIdAs(){
        int id = 0;
        
        try{
            
            //Preparando sentencia sql
            String sql = "SELECT max(id_asistencia) FROM control_asistencia";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    public void obtenerCamposConducta(String fecha, String apellido, String nombre, String falta){
        try{
            
            String sql = "SELECT c.id_conducta, c.observacion FROM conducta c, estudiante e, tipo_falta t WHERE fecha = ? AND e.apellido = ? AND e.nombre = ? AND t.tipo_falta = ? AND c.id_estudiante = e.id_estudiante AND t.id_tipo_falta = c.id_tipo_falta";
            //Llamando procedimiento almacenado
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, fecha);
            cmd.setString(2, apellido);
            cmd.setString(3, nombre);
            cmd.setString(4, falta);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               conducta.setIdConducta(rs.getInt(1));
               conducta.setObservacion(rs.getString(2));
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    
    
    public int obtenerIdAsistencia(String obser, String fecha, String apellido, String nombre){
        int id = 20;
        
        try{
            
            String sql = "SELECT c.id_asistencia FROM control_asistencia c, estudiante e WHERE c.observacion = ? AND c.fecha = ? AND e.apellido = ? AND e.nombre = ? AND c.id_estudiante = e.id_estudiante";
            //Llamando procedimiento almacenado
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, obser);
            cmd.setString(2, fecha);
            cmd.setString(3, apellido);
            cmd.setString(4, nombre);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               id = rs.getInt(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        return id;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ObteniendoItems">
    public String getItemConducta(String apellido, String nombre){
        String item = "";
        try{
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbGradoSeccionInverso(?, ?)}");
            
            cmd.setString(1, apellido);
            cmd.setString(2, nombre);
            
            //Ejecutando sentencia
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               item = rs.getString(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return item;
    }
    
    public String getItemAnio(String apellido, String nombre){
        String item = "";
        try{
            
            //Llamando procedimiento almacenado
            CallableStatement cmd = cn.prepareCall("{CALL cbAnioInverso(?, ?)}");
            
            cmd.setString(1, apellido);
            cmd.setString(2, nombre);
            
            //Ejecutando sentencia
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
               item = rs.getString(1);
            }
            
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return item;
    }
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD">
    //Ingresando datos 
    public boolean insertarConducta(){
        
        //Declarando valor de retorno
        boolean resp = false;
        
        try{
            
            //Preparando sentencia sql
            String sql = "INSERT INTO conducta(id_conducta, observacion, id_estudiante, id_tipo_falta, fecha) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setInt(1, conducta.getIdConducta());
            cmd.setString(2, conducta.getObservacion());
            cmd.setInt(3, conducta.getIdEstudiante());
            cmd.setInt(4, conducta.getIdTipoFalta());
            cmd.setString(5, conducta.getFecha());
            
            //Ejecuntando sentencia sql
            if (!cmd.execute()) {
                resp = true;
            }
            
            
        
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        //Retornando valor
        return resp;
    }
    
    public boolean actualizarConducta(){
        
        //Declarando valor de retorno
        boolean resp = false;
        
        try{
            //Preparando sentencia sql
            String sql = "UPDATE conducta SET observacion = ?, id_estudiante = ?, id_tipo_falta = ?, fecha = ? WHERE id_conducta = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, conducta.getObservacion());
            cmd.setInt(2, conducta.getIdEstudiante());
            cmd.setInt(3, conducta.getIdTipoFalta());
            cmd.setString(4, conducta.getFecha());
            cmd.setInt(5, conducta.getIdConducta());
            
            //Ejecuntando sentencia sql
            if (!cmd.execute()) {
                resp = true;
            }
            
            
            
        } catch(Exception ex){
            System.out.println(ex);
        }
        return resp;
    } 
    
    public boolean eliminarConducta(){
        
        //Declarando valor de retorno
        boolean resp = false;
        
        try{
            String sql = "DELETE FROM conducta WHERE id_conducta = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, conducta.getIdConducta());
            
            ///Ejecuntando sentencia sql
            if (!cmd.execute()) {
                resp = true;
            }
            
            
            
        } catch(Exception ex){
            System.out.println(ex);
        }
        return resp;
    } 
    
    public void buscarConducta(String valor, String filtro, JTable tabla){
        
        int conta = 0;
        String apellido = "";
        String nombre = "";
        String [] columna = {"Observacion","Estudiante","Fecha"};
        String [] registro = new String[3];
        
        modeloTabla = new DefaultTableModel(null, columna);
        
        String sql = "";
        
        if (filtro.equals("Observacion")) {
            
            //creando consulta
            sql = "SELECT c.observacion, CONCAT(e.apellido,'-',e.nombre) as Estudiante, c.fecha FROM conducta c, estudiante e WHERE c.id_estudiante = e.id_estudiante AND observacion = ?";
        } else if (filtro.equals("Estudiante")){
            //Dividiendo el apellido y el nombre
            String estudiante = valor;
            String[] parte = estudiante.split("-");
            apellido = parte[0];
            nombre = parte[1];
            //creando consulta
            sql = "SELECT c.observacion, CONCAT(e.apellido,'-',e.nombre) as Estudiante, c.fecha FROM conducta c, estudiante e WHERE c.id_estudiante = e.id_estudiante AND e.apellido = ? OR e.nombre = ?";
            conta = 1;
            
        } else if(filtro.equals("Fecha")){
            
            //creando consulta
            sql = "SELECT c.observacion, CONCAT(e.apellido,'-',e.nombre) as Estudiante, c.fecha FROM conducta c, estudiante e WHERE c.id_estudiante = e.id_estudiante AND c.fecha = ?";
        }
        try{
            
            //Preparando sentencia 
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            if (conta == 1) {
                cmd.setString(1, apellido);
                cmd.setString(2, nombre);
            } else {
                cmd.setString(1, valor);
            }

            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                registro[0] = rs.getString("observacion");
                registro[1] = rs.getString("Estudiante");
                registro[2] = rs.getString("fecha");
                
                modeloTabla.addRow(registro);
            }
            
            tabla.setModel(modeloTabla);
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    } 
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD Asistencia">
    
        public boolean IngresarAsistencia(){
        
        boolean retorno=false;
        
        try{
        
            String query="Insert into control_asistencia(id_asistencia,id_estudiante,observacion,fecha,id_tipo_asistencia) values(?,?,?,?,?)";
            
            PreparedStatement cmd = cn.prepareStatement(query);
            cmd.setInt(1, conducta.getIdConducta());
            cmd.setInt(2, conducta.getIdEstudiante());
            cmd.setString(3,conducta.getObservacion());
            cmd.setString(4, conducta.getFecha());
            cmd.setInt(5, conducta.getIdTipoAsistencia());
            if (!cmd.execute()) {
                
                retorno=true;
            }
        
        }
        
        catch(Exception e){
        
            System.out.println(e.toString());
        }
        
            return retorno;
        }
        
        
        public boolean actualizarAsistencia(){
        
            boolean retorno=false;
            try{
                
                String query="update control_asistencia set id_estudiante=?,observacion=?,fecha=?,id_tipo_asistencia=? where id_asistencia=?";
                PreparedStatement cmd = cn.prepareStatement(query);
                cmd.setInt(1, conducta.getIdEstudiante());
                cmd.setString(2, conducta.getObservacion());
                cmd.setString(3, conducta.getFecha());
                cmd.setInt(4, conducta.getIdTipoAsistencia());
                cmd.setInt(5, conducta.getIdConducta());
                
                if (!cmd.execute()) {
                    
                    retorno=true;
                }
            
            }
            catch(Exception e){
            
                System.out.println(e.toString());
            
            }
        
            return retorno;
        }
        
        public boolean eliminarAsistencia(){
        
            boolean retorno = false;
        try {

            String query = "delete from control_asistencia where id_asistencia=?";

            PreparedStatement cmd = cn.prepareStatement(query);
            
            cmd.setInt(1, conducta.getIdConducta());

            if (!cmd.execute()) {
                retorno = true;
            }

            cmd.close();
            
        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return retorno;
        
        }
        
        
        public boolean comprobarAsistencia()
        {
            boolean retorno=false;
            try{
                String query="SELECT*FROM control_asistencia c, estudiante e, grado_seccion gs, grado g, seccion s WHERE c.id_estudiante = e.id_estudiante AND e.id_grado_seccion = gs.id_grado_seccion AND gs.id_grado = g.id_grado AND gs.id_seccion = s.id_seccion AND e.apellido = ?  AND e.nombre = ? AND g.grado = ? AND s.seccion = ? AND c.fecha = ?";
                PreparedStatement cmd = cn.prepareStatement(query);
                cmd.setString(1, conducta.getApellido());
                cmd.setString(2, conducta.getNombre());
                cmd.setString(3, conducta.getGrado());
                cmd.setString(4, conducta.getSeccion());
                cmd.setString(5, conducta.getFecha());
                ResultSet rs = cmd.executeQuery();
                while(rs.next()){
                    retorno = true;
                }   
            }
            catch(Exception e){
            
                System.out.println(e.toString());
            }

            return retorno;

        }
    
        //</editor-fold>


}
