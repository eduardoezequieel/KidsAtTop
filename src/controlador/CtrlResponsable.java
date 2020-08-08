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
public class CtrlResponsable {
    //Declarando atributos de la clase
    private static int idResponsable;
    private static String nombre;
    private static String apellido;
    private static String dui;
    private static int idEstado;
    private static String telefono;
    private static String email;
    private static int idParentesco;
    private static int form = 0;

    /**
     * @return the idResponsable
     */
    public int getIdResponsable() {
        return idResponsable;
    }

    /**
     * @param aIdResponsable the idResponsable to set
     */
    public void setIdResponsable(int aIdResponsable) {
        idResponsable = aIdResponsable;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param aNombre the nombre to set
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param aApellido the apellido to set
     */
    public void setApellido(String aApellido) {
        apellido = aApellido;
    }

    /**
     * @return the dui
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param aDui the dui to set
     */
    public void setDui(String aDui) {
        dui = aDui;
    }

    /**
     * @return the idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * @param aIdEstado the idEstado to set
     */
    public void setIdEstado(int aIdEstado) {
        idEstado = aIdEstado;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param aTelefono the telefono to set
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param aEmail the email to set
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * @return the idParentesco
     */
    public int getIdParentesco() {
        return idParentesco;
    }

    /**
     * @param aIdParentesco the idParentesco to set
     */
    public void setIdParentesco(int aIdParentesco) {
        idParentesco = aIdParentesco;
    }

    /**
     * @return the form
     */
    public int getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(int form) {
        this.form = form;
    }
    
}
