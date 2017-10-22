<%-- 
    Document   : error
    Created on : Oct 22, 2017, 8:08:43 AM
    Author     : kguerra
--%>

<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        <style>
            h1 {
                color: #89324e;
            }
            .box-error {
                background: #ffffff;
                display: inline-block;
                padding: 10px;
                box-sizing: border-box;
                box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
                width: 90%;
                font-family: "Lucida Console", Monaco, monospace;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/theme.jsp" />
        <div class="content">
            <h1>Error!</h1>
            <br>
            <h3>Message:</h3>
            <div class="box-error">
                <%=exception.getMessage()%>
            </div>
            <br><br>
            <h3>StackTrace:</h3>
            <div class="box-error">
                <%
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    exception.printStackTrace(printWriter);
                    out.println(stringWriter);
                    printWriter.close();
                    stringWriter.close();
                %>
            </div>
        </div>
    </body>
</html>
