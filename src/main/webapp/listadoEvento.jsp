<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <table border="1" >
            <th>
                <h2>SEGUNDO PARCIAL TEM-742</h2>
                <h3><b>Nombre:</b>Javier Huanca Quispe</h3>
                <h3><b>Carnet:</b>13150670</h3>
            </th>
        </table>
        <br>
        <h1>Registro de seminarios</h1>
         </center>
        <p><a href="MainController?action=add">Nuevo</a></p>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>EXPOSITOR</th>
                <th>FECHA</th>
                <th>HORA</th>
                <th>CUPOS</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${eventos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.expositor}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td><a href="MainController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="MainController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>

        </table>
       
    </body>
</html>
