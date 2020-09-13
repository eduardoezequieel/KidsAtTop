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
   //<editor-fold defaultstate="collapsed" desc="Capturador de id_bitacora">     
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
     
     //</editor-fold>
     
   //<editor-fold defaultstate="collapsed" desc="Bitacoras para Log In">     
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
    
     //</editor-fold>
   
   //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos estudiante">   
    public boolean agregarBitacoraActualizar(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Actualiza')";
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
    public boolean agregarBitacoraEliminar(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Eliminar')";
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
    public boolean agregarBitacoraRetirarEstudiante(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Retiro')";
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
    public boolean agregarBitacoraSuspender(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Suspensión')";
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
    public boolean agregarBitacoraActivar(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Activación')";
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
    public boolean agregarBitacoraAgregar(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Registro')";
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
    
    //</editor-fold>
    
   
   //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos de usuarios">
    
    //bitacora agregar usuario
    
     public boolean agregarBitacoraAgregarUsuario(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Agrega usuario')";
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
     
    //bitacora actualizar usuario
    
     public boolean agregarBitacoraActualizarUsuario(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Actualiza registro usuario')";
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
     
     
    //bitacora suspender usuario
    
     public boolean agregarBitacoraSuspenderUsuario(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Suspende usuario')";
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
     
    //bitacora activar usuario
    
     public boolean agregarBitacoraActivarUsuario(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Activa usuario')";
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
     
    //bitacora agregar usuario
    
     public boolean agregarBitacoraReiniciaCuenta(CtrlLoginUsuario usr){
    
     boolean retorno=false;
       try{
           
           String query = "declare @fecha datetime\n"
                   + "set @fecha=(select GETDATE());\n"
                   + "\n"
                   + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('"+usr.getId_bitacora()+"','"+usr.getId_usuario()+"',@fecha,'Reinicia usuario')";
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
    
    
    //</editor-fold>
}
