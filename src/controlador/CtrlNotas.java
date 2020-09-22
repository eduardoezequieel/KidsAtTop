package controlador;
/**
 *
 * @author EDUARDO
 */
public class CtrlNotas {

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
     * @return the nivelAcademico
     */
    public int getNivelAcademico() {
        return nivelAcademico;
    }

    /**
     * @param nivelAcademico the nivelAcademico to set
     */
    public void setNivelAcademico(int nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    /**
     * @return the añoSeccion
     */
    public String getAñoSeccion() {
        return añoSeccion;
    }

    /**
     * @param añoSeccion the añoSeccion to set
     */
    public void setAñoSeccion(String añoSeccion) {
        this.añoSeccion = añoSeccion;
    }

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the idIndicador
     */
    public int getIdIndicador() {
        return idIndicador;
    }

    /**
     * @param idIndicador the idIndicador to set
     */
    public void setIdIndicador(int idIndicador) {
        this.idIndicador = idIndicador;
    }

    /**
     * @return the idNotaPredeterminada
     */
    public int getIdNotaPredeterminada() {
        return idNotaPredeterminada;
    }

    /**
     * @param idNotaPredeterminada the idNotaPredeterminada to set
     */
    public void setIdNotaPredeterminada(int idNotaPredeterminada) {
        this.idNotaPredeterminada = idNotaPredeterminada;
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
     * @return the idTrimestre
     */
    public int getIdTrimestre() {
        return idTrimestre;
    }

    /**
     * @param idTrimestre the idTrimestre to set
     */
    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }
    static private int idNota;
    static private int idIndicador;
    static private int idNotaPredeterminada;
    static private int idEstudiante;
    static private int idTrimestre;
    static private String añoSeccion;
    static private int nivelAcademico;
    static private String grado;
    static private String seccion;
    private int idUsuario;
}
