<%-- 
    Document   : agregar-proveedor
    Created on : Oct 20, 2017, 5:14:05 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar proveedor</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Agregar proveedor</h1>
            <form method="post" action="agregar-proveedor">
                Nombre:
                <input type="text" name="nombre" id="nombre">
                <br>
                Dirección:
                <input type="text" name="direccion" id="direccion">
                <br>
                Teléfono:
                <input type="text" name="telefono" id="telefono">
                <br>
                Fax:
                <input type="text" name="fax" id="fax">
                <br>
                Nombre comercial:
                <input type="text" name="nombre_comercial" id="nombre_comercial">
                <br>
                NIT:
                <input type="text" name="nit" id="nit">
                <br><br>
                <button type="submit">Crear</button>
            </form>
        </div>
    </body>
</html>
