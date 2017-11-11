<%-- 
    Document   : reporteProducto
    Created on : Nov 5, 2017, 5:58:57 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de productos</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Reporte de productos vendidos</h1>
            <br><br>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Productos vendidos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaProducto}" var="producto">
                        <tr>
                            <td>${producto.getNombre_producto()}</td>
                            <td>${producto.getCantidad()}</td>
                            <td>${producto.getPrecio()}</td>
                            <td>5</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
