package com.servlet.producto.admin;

import com.data.ProductoDatos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletEliminarTipo", urlPatterns = {"/producto/admin/eliminar-tipo"})
public class ServletEliminarTipo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        ProductoDatos.getInstancia().eliminarTipoProducto(request.getParameter("id_tipo"));
        response.sendRedirect("../tipos-producto");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
