package controlador;

import java.sql.Connection;

/**
 *
 * @author EDUARDO
 */
public class CtrlUsuario {

    /**
     * @return the foto
     */
    public static byte[] getFoto() {
        return foto;
    }

    /**
     * @param aFoto the foto to set
     */
    public static void setFoto(byte[] aFoto) {
        foto = aFoto;
    }

    /**
     * @return the foto
     */


    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(Integer id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public Integer getId_estado_usuario() {
        return id_estado_usuario;
    }

    public void setId_estado_usuario(Integer id_estado_usuario) {
        this.id_estado_usuario = id_estado_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    //Campos
    static private Integer id_usuario;
    static private String nombre;
    static private String apellido;
    static private Integer id_tipo_usuario;
    static private Integer id_estado_usuario;
    static private String email;
    static private String telefono;
    static private String dui;
    static private String nit;
    static private String usuario;
    static private String nip;
    static private String fecha_nacimiento;
    static private String genero;
    static private String direccion;
    static private String contraseña;
    static private byte[] foto;
}
