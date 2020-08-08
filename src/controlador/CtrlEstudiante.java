/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author katy0
 */
public class CtrlEstudiante {
    
    //Declarando atributos
    private static int idEstudiante;
    private static String nombre;
    private static String apellido;
    private static String anioIngreso;
    private static String fechaNacimiento;
    private static String direccion;
    private static String genero;
    private static int idEstado;
    private static int idResponsable;
    private static String Responsable;
    private static int idGradoSeccion;
    private static byte[] foto;

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
     * @return the anioIngreso
     */
    public String getAnioIngreso() {
        return anioIngreso;
    }

    /**
     * @param anioIngreso the anioIngreso to set
     */
    public void setAnioIngreso(String anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the idResponsable
     */
    public int getIdResponsable() {
        return idResponsable;
    }

    /**
     * @param idResponsable the idResponsable to set
     */
    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    /**
     * @return the idGradoSeccion
     */
    public int getIdGradoSeccion() {
        return idGradoSeccion;
    }

    /**
     * @param idGradoSeccion the idGradoSeccion to set
     */
    public void setIdGradoSeccion(int idGradoSeccion) {
        this.idGradoSeccion = idGradoSeccion;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * @return the Responsable
     */
    public String getResponsable() {
        return Responsable;
    }

    /**
     * @param aResponsable the Responsable to set
     */
    public void setResponsable(String aResponsable) {
        Responsable = aResponsable;
    }
    
}
