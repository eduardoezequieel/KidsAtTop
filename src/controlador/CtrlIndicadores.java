/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author pablo
 */
public class CtrlIndicadores {
 
    static private int id_indicador;
    static private String indicador;
    static private int nivel_academico;
    private int id_bitacora;
    private int mensaje;

    public int getId_indicador() {
        return id_indicador;
    }

    public void setId_indicador(int id_indicador) {
        this.id_indicador = id_indicador;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public int getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(int nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public int getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public int getMensaje() {
        return mensaje;
    }

    public void setMensaje(int mensaje) {
        this.mensaje = mensaje;
    }
  
    
}
