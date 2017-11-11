<%-- 
    Document   : reporteBasico
    Created on : Nov 5, 2017, 2:18:32 PM
    Author     : kguerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Básico</title>
        <link rel="stylesheet" href="/ProyectoJava/resources/css/JQuery/jquery-ui.css">
        <link rel="stylesheet" href="/ProyectoJava/resources/css/JQuery/style.css">
        <script src="/ProyectoJava/resources/js/JQuery/jquery-1.12.4.js"></script>
        <script src="/ProyectoJava/resources/js/JQuery/jquery-ui.js"></script>
        <script>
            $( function() {
                $( "#fecha_inicial" ).datepicker({ dateFormat: 'dd-mm-yy' });
                $( "#fecha_final" ).datepicker({ dateFormat: 'dd-mm-yy' });
            } );
        </script>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Reporte de Facturas</h1>
            <%-- <form method="get" action="reporteBasico">
                <div class="container-form">
                    <div class="form-element">
                        <div class="form-label">Fecha inicial</div>
                        <div class="form-widget"><input type="text" name="fecha_inicial" id="fecha_inicial" value="${fecha_inicial}" required></div>
                    </div>
                    <div class="form-element">
                        <div class="form-label">Fecha final</div>
                        <div class="form-widget"><input type="text" name="fecha_final" id="fecha_final" value="${fecha_final}" required></div>
                    </div>
                    <br><center><input class="button" type="submit" value="Aceptar"></center>
                </div>
            </form>
            <br><br>--%>
            <table>
                <thead>
                    <tr>
                        <th>No. Factura</th>
                        <th>Fecha de factura</th>
                        <th>Usuario</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaFactura}" var="factura">
                        <tr>
                            <td>${factura.getId_factura()}</td>
                            <td>${factura.getFecha_facturacion()}</td>
                            <td>${factura.getId_usuario().getNombres()} ${factura.getId_usuario().getApellidos()}</td>
                            <td>${factura.getPrecio_total()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
