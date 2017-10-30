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
            <a class="button" href="tipos-producto">Ver tipos de producto</a>
            <br><br>
            <a class="button" href="admin/agregar-producto">Agregar producto</a>
            <br><br>
            <div class="productos">
                <c:forEach items="${listaProductos}" var="producto">
                    <div class="box-product-list">
                        <div class="col-left">
                            <c:choose>
                                <c:when test="${producto.getPath_img() != '' && producto.getPath_img() != null && producto.getPath_img() != 'null'}">
                                    <img src="${producto.getPath_img()}" height="150px">
                                </c:when>
                                <c:otherwise>
                                    <img src="../resources/imagen-no-disponible.gif" height="150px">
                                </c:otherwise>
                            </c:choose>
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
                            <br>
                            <span>Cantidad: ${producto.getCantidad()}</span>
                            <br><br><br>
                            <div style="float:right;">
                                <a class="button" href="admin/agregar-producto?editar=1&id_producto=${producto.getId_producto()}">Editar</a>&nbsp;&nbsp;
                                <a class="button" href="admin/eliminar-producto?id_producto=${producto.getId_producto()}">Eliminar</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>