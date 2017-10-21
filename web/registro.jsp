<%-- 
    Document   : registro
    Created on : Oct 21, 2017, 4:35:35 AM
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
            <div class="box-registro">
                <header class="header">
                    <h1>Registrarse</h1>
                </header>
                <form action="Registro" method="POST">
                    <div class="form-group">
                        <input type="text" id="nombres" placeholder="Nombres" name="nombres" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" id="apellidos" placeholder="Apellidos" name="apellidos" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <select id="sexo"  name="sexo">
                            <option value="0">Hombre</option>
                            <option value="1">Mujer</option>
                        </select>
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" id="email" placeholder="Correo Electronico" name="email" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" id="dia" placeholder="dia" name="dia" required="required">
                        <input type="text" id="mes" placeholder="mes" name="mes" required="required">
                        <input type="text" id="anio"placeholder="año"  name="anio" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <select id="pais"  name="pais">
                            <option value="1">Guatemala</option>
                        </select>
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" id="telefono" placeholder="Telefono" name="telefono" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" placeholder="Contraseña" name="clave" required="required">
                        <div class="line"></div>
                    </div>
                    <br>
                    <button class="button">Registrarse</button>
                </form>
            </div>
        </div>
    </body>
</html>
