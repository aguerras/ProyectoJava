package com.servlet.producto;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.db.Conexion;
import com.model.Producto;

/**
 *
 * @author kguerra
 */
@WebServlet(name = "ServletProductos", urlPatterns = {"/producto/productos"})
public class ServletProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        
        request.setAttribute("listaProductos", Conexion.getInstancia().db_object(Producto.class));
        despachador = request.getRequestDispatcher("/producto/productos.jsp");
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
