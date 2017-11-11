<%-- 
    Document   : carrito
    Created on : Nov 1, 2017, 11:26:28 AM
    Author     : Alexis
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
        <div id="pedidoCupones" class="modal-body ng-scope">
            <div class="row">
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th width="40%"><label>Articulo</label></th>
                            <th><label>Cantidad</label></th>
                            <th><label>Precio U.</label></th>
                            <th><label>Precio T.</label></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaDetallePedidos}" var="pedido">
                            <tr>
                                <td>
                                    <c:choose>
                                        <c:when test="${pedido.getId_producto().getPath_img() != '' && pedido.getId_producto().getPath_img() != null && pedido.getId_producto().getPath_img() != 'null'}">
                                            <img src="${pedido.getId_producto().getPath_img()}" height="50px">
                                        </c:when>    
                                        <c:otherwise>
                                            <img src="../resources/imagen-no-disponible.gif" height="50px">
                                        </c:otherwise>
                                    </c:choose>
                                    ${pedido.getId_producto().getDescripcion()}
                                </td>
                                <td>${pedido.getCantidad()}</td>
                                <td>${pedido.getId_producto().getPrecio()}</td>
                                <td>${pedido.getId_producto().getPrecio() * pedido.getCantidad()}</td>
                                <td><a href="/ProyectoJava/carritoDeCompras/eliminar?id_producto=${pedido.getId_producto().getId_producto()}" id="delete_item"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><span><label class="ng-binding">${articulos}</label></span><span> artículo(s)</span></div>
                <div class="col-md-6">
                    <table class="pull-right">
                        <tbody>
                            <tr>
                                <td>
                                    <label>Total</label>
                                </td>
                                <td class="text-right">
                                    <span class="precioOferta ng-binding">Q</span><span class="precioOferta ng-binding">${total}</span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
            <a style="height: 35px;width:35px;background-image: url(/ProyectoJava/resources/shopping-car-white.png);background-size: 60%;background-repeat: no-repeat;background-position: center;" class="button" href="/ProyectoJava/producto/comprar" ></a>
        </div>
        </div>
    </body>
</html>
