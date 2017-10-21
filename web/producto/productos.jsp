<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/productos.css">
        <title>Productos</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <a href="admin/agregar-producto">Agregar producto</a>
            <c:forEach items="${listaProductos}" var="producto">
                <div class="box-product">
                    <div class="col-left">
                        <img src="../resources/imagen-no-disponible.gif" height="150px">
                    </div>
                    <div class="col-right">
                        <h2>${producto.getNombre_producto()}</h2>
                        <span>${producto.getId_proveedor()}</span><br>
                        <span>${producto.getTipo()}</span><br>
                        <span>${producto.getPrecio()}</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>