<%-- 
    Document   : theme
    Created on : Oct 21, 2017, 12:44:42 AM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <li>
                <a href="#">Tipos de producto</a>
            </li>
            <li>
                <a href="/ProyectoJava/proveedor/proveedores">Proveedores</a>
            </li>
            <% java.util.ArrayList<String> listaPaginas = new java.util.ArrayList<String>(){{add("proveedores.jsp");add("producto.jsp");add("index.jsp");}}; %>
            <% if (listaPaginas.contains(request.getServletPath().substring(request.getServletPath().lastIndexOf("/")+1))) { %>
                <li id="search">
                    <form action="" method="get">
                        <input type="text" id="search_text" placeholder="Search"/>
                        <input type="button" id="search_button">
                    </form>
                </li>
            <% } %>
            <li>
                <a href="/ProyectoJava/Login">Login</a>
            </li>
        </ul>
    </body>
</html>
