<%-- 
    Document   : comprar
    Created on : Nov 10, 2017, 10:11:49 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Gracias por su compra ${usuarioNombre}!</h1>
            <br>
            <table class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th width="40%"><label>Articulo</label></th>
                            <th><label>Cantidad</label></th>
                            <th><label>Precio U.</label></th>
                            <th><label>Precio T.</label></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaDetalleFactura}" var="detalle_factura">
                            <tr>
                                <td>${detalle_factura.getId_producto().getDescripcion()}</td>
                                <td>${detalle_factura.getCantidad()}</td>
                                <td>${detalle_factura.getId_producto().getPrecio()}</td>
                                <td>${detalle_factura.getId_producto().getPrecio() * detalle_factura.getCantidad()}</td>
                            </tr>
                        </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><label>Total</label></td>
                                <td><span class="precioOferta ng-binding">Q</span><span class="precioOferta ng-binding">${factura.getPrecio_total()}</span></td>
                            </tr>
                    </tbody>
                </table>
        </div>
    </body>
</html>
