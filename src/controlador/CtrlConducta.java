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
    static private int idTipoAsistencia;
    static private int idTipoFalta;
    static private String nombre;
    static private String apellido;
    static private String grado;
    static private String seccion;
    static private int LongitudArray;
    static private String anioSeccion;

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

    /**
     * @return the idTipoAsistencia
     */
    public int getIdTipoAsistencia() {
        return idTipoAsistencia;
    }

    /**
     * @param idTipoAsistencia the idTipoAsistencia to set
     */
    public void setIdTipoAsistencia(int idTipoAsistencia) {
        this.idTipoAsistencia = idTipoAsistencia;
    }

    /**
     * @return the idTipoFalta
     */
    public int getIdTipoFalta() {
        return idTipoFalta;
    }

    /**
     * @param aIdTipoFalta the idTipoFalta to set
     */
    public void setIdTipoFalta(int aIdTipoFalta) {
        idTipoFalta = aIdTipoFalta;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the LongitudArray
     */
    public int getLongitudArray() {
        return LongitudArray;
    }

    /**
     * @param LongitudArray the LongitudArray to set
     */
    public void setLongitudArray(int LongitudArray) {
        this.LongitudArray = LongitudArray;
    }

    /**
     * @return the anioSeccion
     */
    public String getAnioSeccion() {
        return anioSeccion;
    }

    /**
     * @param anioSeccion the anioSeccion to set
     */
    public void setAnioSeccion(String anioSeccion) {
        this.anioSeccion = anioSeccion;
    }
}
