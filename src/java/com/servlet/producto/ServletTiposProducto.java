package com.servlet.producto;

import com.db.Conexion;
import com.model.Tipo_producto;
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
@WebServlet(name = "ServletTiposProducto", urlPatterns = {"/producto/tipos-producto"})
public class ServletTiposProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        
        request.setAttribute("listaTiposProducto", Conexion.getInstancia().db_object(Tipo_producto.class));
        despachador = request.getRequestDispatcher("/producto/tipos-producto.jsp");
        despachador.forward(request, response);
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
