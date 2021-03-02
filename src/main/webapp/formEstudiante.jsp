<%-- 
    Document   : formEstudiante
    Created on : 13/02/2021, 2:24:59 p. m.
    Author     : CORE I9 RX 5700XT
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Estudiante</title>
        
    </head>
    <body>
        <h1>Datos Estudiante</h1>
        <h1>
            resultado:${mensaje}
        </h1>
        <form action="EstudianteController" method="post">
            <table>
                <input type="hidden" name="id" value="${estudiante.id}"/>
                <tr>
                    <td>CODIGO</td>
                    <td><input type="text" id="codigo" name="codigo" value="${estudiante.codigo}"></td>
                </tr>
                <tr>
                    <td>NOMBRE</td>
                    <td><input type="text" id="nombre" name="nombre" value="${estudiante.nombre}"></td>
                </tr>
                <tr>
                    <td>DIRECCION</td>
                    <td><input type="text" id="direccion" name="direccion" value="${estudiante.direccion}"></td>
                </tr>
                <tr>
                    <td>CORREO</td>
                    <td><input type="text" id="correo" name="correo" value="${estudiante.correo}"></td>
                </tr>
                <tr>
                    <td>MOVIL</td>
                    <td><input type="text" id="movil" name="movil" value="${estudiante.movil}"></td>
                </tr>
            </table>
                    <button type="submit" value="${accion}" name="accion">${accion}</button>
        </form>
        
    </body>
</html>
