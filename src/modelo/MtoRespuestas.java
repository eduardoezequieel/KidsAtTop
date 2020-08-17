package modelo;
import controlador.CtrlRespuestas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author EDUARDO
 */
public class MtoRespuestas {

    /**
     * @return the Conexion
     */
    public Connection getConexion() {
        return Conexion;
    }

    /**
     * @param Conexion the Conexion to set
     */
    public void setConexion(Connection Conexion) {
        this.Conexion = Conexion;
    }
    private Connection Conexion;
    
    public MtoRespuestas(){
        
        Conexion con=new Conexion();
        Conexion=con.conectar();
    
    }
    CtrlRespuestas ctrl = new CtrlRespuestas();
    public DefaultComboBoxModel llenarPreguntas(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try
        {
            String sql = "SELECT pregunta FROM preguntas";
            PreparedStatement cmd = Conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addElement(rs.getString(1));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }
    
    public int obtenerIDPregunta(String pregunta){
        int id = 0;
        try
        {
            String sql = "SELECT id_pregunta FROM preguntas WHERE pregunta = ?";
            PreparedStatement cmd =Conexion.prepareCall(sql);
            cmd.setString(1, pregunta);
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
    
    public boolean insertarRespuestas()
    {
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO respuestas(id_respuesta, respuesta, id_pregunta, id_usuario) VALUES (?,?,?,?)";
            PreparedStatement cmd = Conexion.prepareCall(sql);
            cmd.setInt(1, ctrl.getIdRespuesta());
            cmd.setString(2, ctrl.getRespuesta());
            cmd.setInt(3, ctrl.getIdPregunta());
            cmd.setInt(4, ctrl.getIdUsuario());
           
            if (!cmd.execute()) {
                resp = true;
            }
          
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return resp;
    }
}
