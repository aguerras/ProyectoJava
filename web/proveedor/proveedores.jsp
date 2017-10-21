<%-- 
    Document   : proveedores
    Created on : Oct 20, 2017, 5:57:38 PM
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
            <h1>Proveedores</h1>
            <a href="admin/agregar-proveedor">Agregar proveedor</a>
            <br><br><br>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Fax</th>
                        <th>Fecha Creación</th>
                        <th>Nombre comercial</th>
                        <th>NIT</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaProveedor}" var="proveedor">
                        <tr>
                            <td>${proveedor.getNombre()}</td>
                            <td>${proveedor.getDireccion()}</td>
                            <td>${proveedor.getTelefono()}</td>
                            <td>${proveedor.getFax()}</td>
                            <td>${proveedor.getFecha_creacion()}</td>
                            <td>${proveedor.getNombre_comercial()}</td>
                            <td>${proveedor.getNit()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
