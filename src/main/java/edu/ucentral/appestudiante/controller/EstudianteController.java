/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.appestudiante.controller;

import edu.ucentral.appestudiante.model.Estudiante;
import edu.ucentral.appestudiante.repository.EstudianteJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CORE I9 RX 5700XT
 */
@WebServlet(name = "EstudianteController", urlPatterns = {"/EstudianteController"})
public class EstudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("editar")) {
                try {
                    consultarEstudiante(request, response);
                  
                } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (accion.equals("listar")) {
                    try {
                        listarEstudiantes(request, response);
                    } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if (accion.equals("Estudiante nuevo")) {
                crearEstudiante(request, response);
            }
           
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("Modificar")) {
                try {
                    modificarEstudiante(request, response);
                } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(accion.equals("Adicionar")){
                try {
                    insertarEstudiante(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } if(accion.equals("eliminar")){
                try {
                    eliminarEstudiante(request,response);
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Estudiante> estudiantes = EstudianteJDBC.instancia().listarEstudiante();
        request.setAttribute("estudiantes", estudiantes);
        request.getRequestDispatcher("WEB-INF/estudiantes/listaEstudiantes.jsp").forward(request, response);
    }

    private void consultarEstudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEst"));
        Estudiante estudiante = EstudianteJDBC.instancia().consultarEstudiante(id);
        request.setAttribute("estudiante", estudiante);
        request.setAttribute("accion", "Modificar");
        request.getRequestDispatcher("WEB-INF/estudiantes/formEstudiante.jsp").forward(request, response);
    }

    private void modificarEstudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String movil = request.getParameter("movil");
        Estudiante estudiante = new Estudiante(id, codigo, correo, nombre, direccion, movil);
        System.out.println("Estudiante antes del envio: " + estudiante);
        String mensaje = EstudianteJDBC.instancia().modificarEstudiante(estudiante);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EstudianteController");
    }

    private void crearEstudiante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("accion", "Adicionar");
        request.getRequestDispatcher("WEB-INF/estudiantes/formEstudiante.jsp").forward(request, response);
    }

    private void insertarEstudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String movil = request.getParameter("movil");
        Estudiante estudiante = new Estudiante( codigo, correo, nombre, direccion, movil);
        System.out.println("Estudiante antes del envio: " + estudiante);
        String mensaje = EstudianteJDBC.instancia().insertarEstudiante(estudiante);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EstudianteController");
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id = Integer.parseInt(request.getParameter("idEst"));
        Estudiante estudiante = new Estudiante(id);
        String mensaje = EstudianteJDBC.instancia().EliminarEstudiante(estudiante);
        response.sendRedirect("EstudianteController");
        
    }
}
