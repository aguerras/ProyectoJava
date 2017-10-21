<%-- 
    Document   : agregar-producto
    Created on : Oct 21, 2017, 12:30:26 AM
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                Nombre:
                <input type="text" name="nombre_producto" id="nombre_producto">
                <br>
                Descripcion:
                <input type="text" name="descripcion" id="descripcion">
                <br>
                Proveedor:
                <input type="text" name="id_proveedor" id="id_proveedor">
                <br>
                Precio:
                <input type="text" name="precio" id="precio">
                <br>
                Descuento:
                <input type="text" name="descuento" id="descuento">
                <br><br>
                <button type="submit">Crear</button>
            </form>
        </div>
    </body>
</html>
