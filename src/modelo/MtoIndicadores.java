/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlIndicadores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class MtoIndicadores {
    
    private Connection cn;
    
    CtrlIndicadores indicadores = new CtrlIndicadores();
    
    DefaultTableModel modeloTabla;
    
    public Connection getCn(){
        return cn;
    }
    
    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public MtoIndicadores(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    public DefaultComboBoxModel llenarNivelAcad(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        try
        {
          CallableStatement cmd = cn.prepareCall("{CALL cbNivelAcademico}");
          
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              modelo.addElement(rs.getString(1));
          }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
    
    public void obtenerIdIndicador(String indicador){
        
        try
        {
            String sql = "SELECT id_indicador FROM indicador_logro WHERE indicador = ? AND nivel_academico = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, indicador);
            
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
            indicadores.setId_indicador(rs.getInt(1));
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    
    public boolean actualizarIndicador(){
        boolean indic = false;
        
        try{
            String sql = "UPDATE indicador_logro SET indicador = ? WHERE id_indicador = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, indicadores.getIndicador());
            cmd.setInt(2, indicadores.getId_indicador());
            
            if (!cmd.execute()) {
                indic = true;
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return indic;
    }
    
}
