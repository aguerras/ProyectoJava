<%-- 
    Document   : index
    Created on : Oct 21, 2017, 1:24:38 AM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="resources/css/productos.css">
        <title>Inicio</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <div class="categorias">
                <h2>
                    Categorias
                    <c:if test="${id_tipo != ''}">
                        <a href="index">(Limpiar)</a>
                    </c:if>
                </h2>
                <div>
                    <c:forEach items="${listaTipo}" var="tipo">
                        <c:choose>
                            <c:when test="${tipo.getId_tipo() == id_tipo}">
                                <div class="box-tipo selected"><a href="index?id_tipo=${tipo.getId_tipo()}">${tipo.getNombre_tipo()}</a></div>
                            </c:when>    
                            <c:otherwise>
                                <div class="box-tipo"><a href="index?id_tipo=${tipo.getId_tipo()}">${tipo.getNombre_tipo()}</a></div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>
            <div class="productos-index">
                <c:forEach items="${listaProductos}" var="producto">
                    <div class="box-product">
                        <div class="col-left">
                            <c:choose>
                                <c:when test="${producto.getPath_img() != '' && producto.getPath_img() != null && producto.getPath_img() != 'null'}">
                                    <img src="${producto.getPath_img()}" height="150px">
                                </c:when>    
                                <c:otherwise>
                                    <img src="resources/imagen-no-disponible.gif" height="150px">
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
                            <br><br><br>
                            <c:choose>
                                <c:when test="${producto.getCantidad() == 0}">
                                    <span style="color:red;font-size:15px;float:right;">Sin stock</span>
                                </c:when>    
                                <c:otherwise>
                                    <a class="button" href="carritoDeCompras/agregar?id_producto=${producto.getId_producto()}" style="float:right;">Añadir al carrito</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
