
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>   
            <c:if test="${aviso.id==0}">Nuevo </c:if>
            <c:if test="${aviso.id !=0}">Editar </c:if>
                Registro de Evento
            </h1>
            <form action="MainController" method="POST">
                <input type="hidden" name="id" value="${evento.id}"/>
            <label>Titulo</label>
            <input type="text" name="titulo" value="${evento.titulo}"/>
            <br>
            <label>Expositor</label>
            <input type="text" name="expositor" value="${evento.expositor}"/>
            <br>
            <label>Fecha</label>
            <input type="text" name="fecha" value="${evento.fecha}"/>
            <br>
            <label>Hora</label>
            <input type="text" name="hora" value="${evento.hora}"/>
            <br>
            <label>Cupos</label>
            <input type="text" name="cupo" value="${evento.cupo}"/>
            <br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
