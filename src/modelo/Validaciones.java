/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author polon
 */
public class Validaciones {
    
      public boolean email(String correo){
    
        Pattern pat=null;
        Matcher mat=null;
        pat=Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat=pat.matcher(correo);
        if (mat.find()) {
            
            return true;
        }
        else{
        
        
            return false;
        }
        
    }
      
      
      public void verificarPegar(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_V && evt.isControlDown()) {
            evt.consume();
        }
    }
    
    public void verificarLetras(java.awt.event.KeyEvent evt){
        
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isWhitespace(c) && c != ',' && c != '.') {
            evt.consume();
        }
        
        
    }
    
    public void verificarEnteros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
    
    public void verificarDecimales(java.awt.event.KeyEvent evt, String txt){
        char c = evt.getKeyChar();
        if ((txt.contains(".") && c == '.') || (txt.trim().equals("") && c == '.')) {
            evt.consume();
        }else{
            if ((!Character.isDigit(c)) && c != '.') {
                evt.consume();
            }
        }
    }
    
    public void verificarAlfanumerico(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c)&& !Character.isWhitespace(c) && c != ',' && c != '.') {
            evt.consume();
        }
    }
    
    public void verificarEspeciales(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '@' && c != '.' && c != '_') {
            evt.consume();
        }
    }
    
    public void verificarFechas(java.awt.event.KeyEvent evt, String txt){
        char c = evt.getKeyChar();
        if ((txt.trim().equals("") && c == '/') || (txt.endsWith("/") && c == '/') ) {
            evt.consume();
        }else{
            if (!Character.isDigit(c) && c != '/') {
                evt.consume();
            }
        }
    }
      
      
}
