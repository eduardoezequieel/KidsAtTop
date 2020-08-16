/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import controlador.CtrlLoginUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author polon
 */
public class MtoBitacoras {

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
    
    private Connection conexion;
    
    public MtoBitacoras(){
    
        Conexion con=new Conexion();
        conexion=con.conectar();
    }
    
     public Integer capturarIdBitacora()
    {
        int id = 0;
        try
        {
            String sql = "SELECT max(id_bitacora) FROM bitacora";
            PreparedStatement cmd = conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public boolean agregarBitacoraEntrada(CtrlLoginUsuario usr){
    
       boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Acceso')";
           PreparedStatement cmd=conexion.prepareStatement(query);
           
           
           if (!cmd.execute()) {
               
                retorno=true;
           }
         
       }
       catch(Exception e){
       
           System.out.println(e.toString());
       }
       return retorno;
    }
    
    public boolean agregarBitacoraSalida(CtrlLoginUsuario usr){
    
       boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Salida')";
           PreparedStatement cmd=conexion.prepareStatement(query);
           
           
           if (!cmd.execute()) {
               
                retorno=true;
           }
         
       }
       catch(Exception e){
       
           System.out.println(e.toString());
       }
       return retorno;
    }
    
    
    
    
    
}
