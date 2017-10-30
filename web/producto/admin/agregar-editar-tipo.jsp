<%-- 
    Document   : agregar-editar-tipo
    Created on : Oct 29, 2017, 6:45:45 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Agregar tipo de producto</h1>
            <form method="post" action="agregar-editar-tipo">
                <input type="hidden" name="editar" id="editar" value="${editar}">
                <input type="hidden" name="id_tipo" id="id_tipo" value="${tipo.getId_tipo()}">
                <div class="container-form">
                    <div class="form-element">
                        <div class="form-label">Nombre:</div>
                        <div class="form-widget"><input type="text" name="nombre_tipo" id="nombre_tipo" value="${tipo.getNombre_tipo()}"></div>
                    </div>
                    <br><input class="button" type="submit" value="Enviar">
                </div>
            </form>
        </div>
    </body>
</html>
