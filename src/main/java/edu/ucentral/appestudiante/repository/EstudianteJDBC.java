/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.appestudiante.repository;

import edu.ucentral.appestudiante.model.Estudiante;
import edu.ucentral.appestudiante.service.Conexion;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class EstudianteJDBC {

    private static EstudianteJDBC estudianteJDBC = null;

    private EstudianteJDBC() {

    }

    public static EstudianteJDBC instancia() {
        if (estudianteJDBC == null) {
            estudianteJDBC = new EstudianteJDBC();
        }
        return estudianteJDBC;
    }

    private final String SQL_SELECT = "SELECT * FROM estudiantes order by codigo ";

    public List<Estudiante> listarEstudiante() throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Estudiante> lista = new ArrayList();
        Estudiante estudiante = null;

        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        while (rs.next()) {
            estudiante = new Estudiante();
            estudiante.setId(rs.getInt(1));
            estudiante.setCodigo(rs.getString(2));
            estudiante.setCorreo(rs.getString(3));
            estudiante.setNombre(rs.getString(4));
            estudiante.setDireccion(rs.getString(5));
            estudiante.setMovil(rs.getString(6));

            lista.add(estudiante);
        }
        Conexion.closed(conn);
        Conexion.closed(stm);
        Conexion.closed(rs);
        return lista;
    }
    private final String SQL_SELECT_EST = "select * from ESTUDIANTES where id=?";

    public Estudiante consultarEstudiante(int id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Estudiante estudiante = null;
        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_SELECT_EST);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        
        System.out.print("-----ID------->"+id);  
       

        while(rs.next()){
            estudiante = new Estudiante();
            estudiante.setId(rs.getInt(1));
            estudiante.setCodigo(rs.getString(2));
            estudiante.setCorreo(rs.getString(3));
            estudiante.setNombre(rs.getString(4));
            estudiante.setDireccion(rs.getString(5));
            estudiante.setMovil(rs.getString(6));  
        }
       
        return estudiante;
    }

    private final String SQL_UPDATE = "UPDATE ESTUDIANTES SET  codigo=?, correo=?, nombre=?, direccion=?, movil=? WHERE id=?";

    public String modificarEstudiante(Estudiante estudiante) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        int row = 0;
        
        System.out.println(" Estudiante a modificar"+estudiante);
        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_UPDATE);
        int index = 1;
        stm.setString(index++, estudiante.getCodigo());
        stm.setString(index++, estudiante.getCorreo());
        stm.setString(index++, estudiante.getNombre());
        stm.setString(index++, estudiante.getDireccion());
        stm.setString(index++, estudiante.getMovil());
        stm.setInt(index++, estudiante.getId());
        mensaje = "Se actualizo" + row + "registro(s) satisfactoriamente";
        row = stm.executeUpdate();
        
        System.out.println("mensaje-------->"+mensaje);
        return mensaje;
    }
    
    private final String SQL_INSERT = "INSERT INTO ESTUDIANTES (codigo, correo, nombre, direccion, movil) values (?,?,?,?,?)";
    public String insertarEstudiante(Estudiante estudiante) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        int row = 0;
        
        System.out.println(" Estudiante a insertar"+estudiante);
        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_INSERT);
        int index = 1;
        
        stm.setString(index++, estudiante.getCodigo());
        stm.setString(index++, estudiante.getCorreo());
        stm.setString(index++, estudiante.getNombre());
        stm.setString(index++, estudiante.getDireccion());
        stm.setString(index++, estudiante.getMovil());

        mensaje = "Se insertó" + row + "registro(s) satisfactoriamente";
        row = stm.executeUpdate();
        
        System.out.println("mensaje-------->"+mensaje);
        return mensaje;
    }
    private final String SQL_DELETE = "DELETE from ESTUDIANTES where id=?";
    public String EliminarEstudiante(Estudiante estudiante) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        int row = 0;
        System.out.println(" Estudiante a modificar"+estudiante);
        System.out.println(" Estudiante a Eliminar"+estudiante.getId());
        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_DELETE);
        int index = 1;

        stm.setInt(index++, estudiante.getId());
        mensaje = "Se Elimino" + row + "registro(s) satisfactoriamente";
        row = stm.executeUpdate();
        
        System.out.println("mensaje-------->"+mensaje);
        return mensaje;
    }
}
