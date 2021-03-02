/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.appestudiante.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class Conexion {
    private static String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver"; //"org.postgresql.Driver";  //"com.mysql.jdbc.Driver";
    private static String DB = "estudiantes_DB";
    private static String JDBC_URL = "jdbc:derby://localhost:1527/" +DB ;//"jdbc:postgresql://localhost:5432/"+ DB;  //"jdbc:mysql://localhost:3306/+DB;
    private static String JDBC_USER = "luis";  //"root";
    private static String JDBC_PASS = "123"; 
    private static Driver driver;
    
    public static synchronized Connection getConnection() throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        if(driver ==null){
            try{
               Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
               driver = (Driver)jdbcDriverClass.getConstructor().newInstance();
               DriverManager.registerDriver(driver);
            }catch(ClassNotFoundException  |  InstantiationException | 
                    IllegalAccessException e){
                System.out.println("Fallo en cargar el Driver");
            }
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASS);
    }
    
    public static void closed(ResultSet rs){
        try{
            if(rs!=null)
                rs.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(PreparedStatement stmt){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(Connection conn){
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException e){
            
        }

    }
}
