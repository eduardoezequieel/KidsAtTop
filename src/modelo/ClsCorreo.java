/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Panel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author katy0
 */
public class ClsCorreo {
    
    private static String destino; //Correo de destinatario
    private static String asunto;  //Asunto del correo
    private static String mensaje; //Cuerpo del correo
    

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
     public void enviarCorreo(){
        
        //Creando propiedades para poder conectar a una cuenta de gmail
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        
        //Creando instacia de la cuenta de origen
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoOrigen = "kidsattop@gmail.com";
        String contrasenia = "proyecto2020";
        
        //Creando estructura de correo(Destino, asunto, mensaje)
        String destinoCorreo = destino;
        String asuntoCorreo = asunto;
        String mensajeCorreo = mensaje;
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoOrigen));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (destinoCorreo));
            mail.setSubject(asuntoCorreo);
            mail.setText(mensajeCorreo);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoOrigen,contrasenia);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            JOptionPane.showMessageDialog(null, "Su correo ha sido enviado correctamente");
            
            
        } catch (AddressException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
