package controlador;
public class CtrlBitacora {

    /**
     * @return the id_bitacora
     */
    public int getId_bitacora() {
        return id_bitacora;
    }

    /**
     * @param id_bitacora the id_bitacora to set
     */
    public void setId_bitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //Variables
    private int id_bitacora;
    private int id_usuario;
    private String fecha;
    private String tipo;
}
