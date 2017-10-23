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
                <div class="container-form">
                    <div class="form-element">
                        <div class="form-label">Nombre:</div>
                        <div class="form-widget"><input type="text" name="nombre" id="nombre"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Dirección:</div>
                        <div class="form-widget"><input type="text" name="direccion" id="direccion"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Teléfono:</div>
                        <div class="form-widget"><input type="text" name="telefono" id="telefono"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Fax:</div>
                        <div class="form-widget"><input type="text" name="fax" id="fax"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Nombre comercial:</div>
                        <div class="form-widget"><input type="text" name="nombre_comercial" id="nombre_comercial"></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">NIT:</div>
                        <div class="form-widget"><input type="text" name="nit" id="nit"></div>
                    </div>
                    <br><input class="button" type="submit" value="Submit">
                </div>
            </form>
        </div>
    </body>
</html>
