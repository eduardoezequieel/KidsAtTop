package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pablo
 */
public class Conexion {
    //pedira importar import java.sqlConnection();
    public Connection conectar(){
        Connection cn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Pedira importar import java.sql.DriverManager
           cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9H26RGO\\SQLEXPRESS;" + "databaseName=KidsAtTop;integratedSecurity=true;");
           
            if (cn != null) {
                    System.out.println("Si hay conexion");
                }
            }
            catch(Exception ex){
                    System.out.println(ex.getMessage());
            }
            return cn;
        }
    
    /*//Conexion Kath
    public Connection conectar(){
        Connection cn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Pedira importar import java.sql.DriverManager
           cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-17NMDSR;" + "databaseName=KidsAtTop;integratedSecurity=true;");
           
            if (cn != null) {
                    System.out.println("Si hay conexion");
                }
            }
            catch(Exception ex){
                    System.out.println(ex.getMessage());
            }
            return cn;
           
        }*/
}
