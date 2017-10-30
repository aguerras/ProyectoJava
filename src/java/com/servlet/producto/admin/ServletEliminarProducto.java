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
@WebServlet(name = "ServletEliminarProducto", urlPatterns = {"/producto/admin/eliminar-producto"})
public class ServletEliminarProducto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        ProductoDatos.getInstancia().eliminarProducto(request.getParameter("id_producto"));
        response.sendRedirect("../productos");
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
