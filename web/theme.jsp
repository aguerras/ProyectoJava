<%-- 
    Document   : theme
    Created on : Oct 21, 2017, 12:44:42 AM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <style type="text/css">
            <%@ include file="resources/css/theme.css" %>
        </style>
        <ul class="nav">
            <li id="inicio">
                <a href="/ProyectoJava/">Inicio</a>
            </li>
            <% if (session.getAttribute("user") == null) { %>
                <li>
                    <a href="/ProyectoJava/Login">Login</a>
                </li>
            <% } else { %>
                <li>
                    <a href="/ProyectoJava/producto/productos">Productos</a>
                </li>
                <li>
                    <a href="/ProyectoJava/proveedor/proveedores">Proveedores</a>
                </li>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn">Reportes</a>
                    <div class="dropdown-content">
                        <a href="/ProyectoJava/reportes/reporteBasico">Reporte de Facturas</a>
                        <a href="/ProyectoJava/reportes/reporteProducto">Reporte de productos vendidos</a>
                    </div>
                </li>
                <li style="float: right;">
                    <a href="/ProyectoJava/Logout">Cerrar Sesion</a>
                </li>
                <li style="float: right;"> 
                    <a href="/ProyectoJava/carritoDeCompras/carrito" id="carrito_boton"></a>
                </li>
                <li style="float: right;">
                    <a>
                        ${user.getNombres()}
                    </a>
                </li>
            <% } %>
        </ul>
    </body>
</html>
