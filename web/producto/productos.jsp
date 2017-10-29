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
            <a class="button" href="admin/agregar-producto">Agregar producto</a>
            <br><br>
            <div class="productos">
                <c:forEach items="${listaProductos}" var="producto">
                    <div class="box-product">
                        <div class="col-left">
                            <img src="../resources/imagen-no-disponible.gif" height="150px">
                        </div>
                        <div class="col-right">
                            <div class="div-precio">
                                <span class="precio">Q${producto.getPrecio()}</span>
                            </div>
                            <h2 class="nombre-producto">${producto.getNombre_producto()}</h2>
                            <div class="div-proveedor">
                                <span class="proveedor">${producto.getId_proveedor().getNombre()}</span>
                            </div>
                            <span class="tipo">${producto.getId_tipo().getNombre_tipo()}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>