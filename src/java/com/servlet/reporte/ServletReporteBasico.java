package com.servlet.reporte;

import com.db.Conexion;
import com.model.Factura;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kguerra
 */
@WebServlet(name = "ServletReporteBasico", urlPatterns = {"/reportes/reporteBasico"})
public class ServletReporteBasico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        String clausula = "";
        if(request.getParameter("fecha_inicial") != null) {
            request.setAttribute("fecha_inicial", request.getParameter("fecha_inicial"));
            request.setAttribute("fecha_final", request.getParameter("fecha_final"));
            //clausula = "WHERE STR_TO_DATE(fecha_facturacion, '%Y %M %d') > STR_TO_DATE('" + request.getParameter("fecha_inicial") + "', '%d %M %Y') AND STR_TO_DATE(fecha_facturacion, '%Y %M %d') < STR_TO_DATE('" + request.getParameter("fecha_final") + "', '%d %M %Y')";
        }
        request.setAttribute("listaFactura", Conexion.getInstancia().db_object(Factura.class));
        despachador = request.getRequestDispatcher("/reportes/reporteBasico.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
