<%-- 
    Document   : agregar-producto
    Created on : Oct 21, 2017, 12:30:26 AM
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
            <h1>Agregar producto</h1>
            <form method="post" action="agregar-producto">
                <input type="hidden" name="editar" id="editar" value="${editar}">
                <input type="hidden" name="id_producto" id="id_producto" value="${producto.getId_producto()}">
                <div class="container-form">
                    <div class="form-element">
                        <div class="form-label">Nombre:</div>
                        <div class="form-widget"><input type="text" name="nombre_producto" id="nombre_producto" value="${producto.getNombre_producto()}"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Descripcion:</div>
                        <div class="form-widget"><input type="text" name="descripcion" id="descripcion" value="${producto.getDescripcion()}"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Proveedor:</div>
                        <div class="form-widget">
                            <select name="id_proveedor" id="id_proveedor">
                                <c:forEach items="${listaProveedor}" var="proveedor">
                                    <c:choose>
                                        <c:when test="${proveedor.getId_proveedor() == producto.getId_proveedor().getId_proveedor()}">
                                            <option selected value="${proveedor.getId_proveedor()}">${proveedor.getNombre()}</option>
                                        </c:when>    
                                        <c:otherwise>
                                            <option value="${proveedor.getId_proveedor()}">${proveedor.getNombre()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Cantidad:</div>
                        <div class="form-widget"><input type="number" name="cantidad" id="cantidad" value="${producto.getCantidad()}"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Precio:</div>
                        <div class="form-widget"><input type="text" name="precio" id="precio" value="${producto.getPrecio()}"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Descuento:</div>
                        <div class="form-widget"><input type="text" name="descuento" id="descuento" value="${producto.getDescuento()}"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Tipo de producto:</div>
                        <div class="form-widget">
                            <select name="id_tipo" id="id_tipo">
                                <c:forEach items="${listaTiposProducto}" var="tipo">
                                    <c:choose>
                                        <c:when test="${tipo.getId_tipo() == producto.getId_tipo().getId_tipo()}">
                                            <option selected value="${tipo.getId_tipo()}">${tipo.getNombre_tipo()}</option>
                                        </c:when>    
                                        <c:otherwise>
                                            <option value="${tipo.getId_tipo()}">${tipo.getNombre_tipo()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Imágen del producto:</div>
                        <div class="form-widget"><input type="url" name="path_img" id="path_img"></div>
                    </div>
                    <br><input class="button" type="submit" value="Enviar">
                </div>
            </form>
        </div>
    </body>
</html>
