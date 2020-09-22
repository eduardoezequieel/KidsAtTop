/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlLoginUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author polon
 */
public class MtoBitacoras {

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    private Connection conexion;

    public MtoBitacoras() {

        ClsConexion con = new ClsConexion();
        conexion = con.conectar();
    }
    //<editor-fold defaultstate="collapsed" desc="Capturador de id_bitacora">     

    public Integer capturarIdBitacora() {
        int id = 0;
        try {
            String sql = "SELECT max(id_bitacora) FROM bitacora";
            PreparedStatement cmd = conexion.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para Log In">     
    public boolean agregarBitacoraEntrada(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Acceso')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;
    }

    public boolean agregarBitacoraSalida(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Salida')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos estudiante">   
    public boolean agregarBitacoraActualizarEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza registro de estudiante')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraEliminar(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Eliminar registro')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraRetirarEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Retiro de estudiante')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraSuspenderEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Suspensión')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActivarEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Activación')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraAgregarEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Registro')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos de usuarios">
    //bitacora agregar usuario
    public boolean agregarBitacoraAgregarUsuario(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Agrega usuario')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //bitacora actualizar usuario
    public boolean agregarBitacoraActualizarUsuario(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza registro usuario')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //bitacora suspender usuario
    public boolean agregarBitacoraSuspenderUsuario(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Suspende usuario')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //bitacora activar usuario
    public boolean agregarBitacoraActivarUsuario(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Activa usuario')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //bitacora agregar usuario
    public boolean agregarBitacoraReiniciaCuenta(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Reinicia usuario')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos responsable">   
    public boolean agregarBitacoraActualizarResponsable(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Agrega responsable')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraSuspenderResponsable(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Suspende responsable')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActivarResponsable(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Activa responsable')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos secciones">   
    public boolean agregarBitacoraAgregarSeccion(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Agrega seccion')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActualizarSeccion(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza seccion')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraSuspenderSeccion(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Suspende seccion')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActivarSeccion(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Activa seccion')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos conducta">   
    public boolean agregarBitacoraAgregarConducta(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Agrega reporte de conducta')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActualizaConducta(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza reporte de conducta')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraEliminarConducta(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Elimina reporte de conducta')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacoras para los mantenimientos asistencia">   
    public boolean agregarBitacoraAgregarAsistencia(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Agrega reporte de asistencia')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraActualizaAsistencia(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza reporte de asistencia')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    public boolean agregarBitacoraEliminarAsistencia(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Suspende reporte de asistencia')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bitacora para indicadores de logro">   
    public boolean agregarBitacoraIndicadores(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Actualiza indicador de logro')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Bitacora para traslado de alumnos">   
    public boolean agregarBitacoraTrasladoAlumnos(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Traslado de alumnos al siguiente grado')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
     public boolean agregarBitacoraGraduacionAlumnos(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Ha graduado una sección')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }

    //</editor-fold>
     
    //<editor-fold defaultstate="collapsed" desc="Bitacora para reportes">   
     
       public boolean agregarBitacoraReporteBitacora(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte de bitácoras')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
       
    public boolean agregarBitacoraReporteUsuarios(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte de lista de usuarios')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteNotasEstudiante(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte de notas del estudiante')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteEstudiantes(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte lista de estudiantes')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteGradoSeccion(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte grado/sección')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteNotasIndicador(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte lista de notas por indicador de logro')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteInasistencia(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte lista de Inasistencias')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteConducta(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte de conducta')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    public boolean agregarBitacoraReporteAsistencia(CtrlLoginUsuario usr) {

        boolean retorno = false;
        try {

            String query = "declare @fecha datetime\n"
                    + "set @fecha=(select GETDATE());\n"
                    + "\n"
                    + "Insert into bitacora (id_bitacora,id_usuario,fecha,tipo) values ('" + usr.getId_bitacora() + "','" + usr.getId_usuario() + "',@fecha,'Genera reporte lista de asistencias')";
            PreparedStatement cmd = conexion.prepareStatement(query);

            if (!cmd.execute()) {

                retorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return retorno;

    }
    
    
            //</editor-fold>

 
}
