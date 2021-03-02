<%-- 
    Document   : listaEstudiantes
    Created on : 13/02/2021, 2:03:55 p. m.
    Author     : CORE I9 RX 5700XT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listado Estudiantes</title>
    </head>
    <body>
        <h1>listado Estudiantes</h1>
        <br/>
        <form action="EstudianteController" method="get">
            <input type="submit" name="accion" value="Estudiante nuevo">
        </form>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>DIRECCION</th>
                    <th>CORREO</th>
                    <th>CELULAR</th>
                    <th>Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${estudiantes}" var="estudiante">
                    <tr>
                        <td><c:out value="${estudiante.id}"></c:out></td>
                        <td><c:out value="${estudiante.codigo}"></c:out></td>
                        <td><c:out value="${estudiante.nombre}"></c:out></td>
                        <td><c:out value="${estudiante.direccion}"></c:out></td>
                        <td><c:out value="${estudiante.correo}"></c:out></td>
                        <td><c:out value="${estudiante.movil}"></c:out></td>
                            <td>
                                <form action="EstudianteController" method="get">
                                    <input type="hidden" name="idEst" value="${estudiante.id}">
                                    <input type="submit" name="accion" value="editar">
                                </form>
                            </td>
                            <td>
                                <form action="EstudianteController" method="post">
                                    <input type="hidden" name="idEst" value="${estudiante.id}">
                                    <input type="submit" name="accion" value="eliminar">
                                </form>
                                
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
