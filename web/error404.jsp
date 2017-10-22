<%-- 
    Document   : error404
    Created on : Oct 22, 2017, 8:38:57 AM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .content {
                text-align: center !important;
            }
            h1, h2 {
                border: none;
                box-shadow: none;
                margin: 0;
                padding: 0;
            }
            h1 {
                font-size: 8.0em;
                text-shadow: 3px 3px 0 rgba(0, 0, 0, 0.1);
            }
            h2 {
                font-size: 2.0em;
                line-height: 2.0em;
            }
        </style>
        <title>Error 404</title>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>404</h1>
            <h2>Página no encontrada</h2>
            <div class="error-content">
                <p>La página que usted ha intentado entrar no existe.</p>
            </div>
        </div>
    </body>
</html>
