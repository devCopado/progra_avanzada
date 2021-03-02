<%-- 
    Document   : index
    Created on : 9/02/2021, 9:18:20 p. m.
    Author     : CORE I9 RX 5700XT
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina principale</title>
    </head>
    <body>
        <h1>Hello World! Carlos</h1>
        <form action="EstudianteController" method="GET">
            
            <input type="submit" name="accion" value="editar">
            <br>
            <input type="submit" name="accion" value="listar">
            
        </form>
    </body>
</html>
