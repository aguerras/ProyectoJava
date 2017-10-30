<%-- 
    Document   : tipos-producto
    Created on : Oct 29, 2017, 6:40:09 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos de producto</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Tipos de producto</h1>
            <a class="button" href="admin/agregar-editar-tipo">Agregar tipo de producto</a>
            <br><br>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaTiposProducto}" var="tipo">
                        <tr>
                            <td>${tipo.getNombre_tipo()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
