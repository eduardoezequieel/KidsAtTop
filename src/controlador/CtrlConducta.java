/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;

/**
 *
 * @author katy0
 */
public class CtrlConducta {
    
    //Declarando los atributos de la clase
     
    static private int idConducta;
    static private String observacion;
    static private int idEstudiante;
    static private String fecha;
    static private String anio;
    static private int idGradoSeccion;

    /**
     * @return the idConducta
     */
    public int getIdConducta() {
        return idConducta;
    }

    /**
     * @param idConducta the idConducta to set
     */
    public void setIdConducta(int idConducta) {
        this.idConducta = idConducta;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     * @return the idGradoSeccion
     */
    public int getIdGradoSeccion() {
        return idGradoSeccion;
    }

    /**
     * @param aIdGradoSeccion the idGradoSeccion to set
     */
    public void setIdGradoSeccion(int aIdGradoSeccion) {
        idGradoSeccion = aIdGradoSeccion;
    }
}
