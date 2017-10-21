<%-- 
    Document   : login
    Created on : Oct 21, 2017, 4:30:12 AM
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
            <div class="box-login">
                <header class="header">
                    <h1>Iniciar sesión</h1>
                </header>
                <form action="Login" method="POST">
                    <div class="form-group">
                        <input type="text" id="username" placeholder="Correo electronico" name="email" required="required">
                        <div class="line"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" placeholder="Contraseña" name="clave" required="required">
                        <div class="line"></div>
                    </div>
                    <br>
                    <button class="button">Login</button>
                </form>
                <a href="/ProyectoJava/Registro">Registrarse</a>
            </div>
        </div>
    </body>
</html>
