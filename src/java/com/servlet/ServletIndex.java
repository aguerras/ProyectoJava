package com.servlet;

import com.db.Conexion;
import com.model.Producto;
import com.model.Tipo_producto;
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
@WebServlet(name = "ServletIndex", urlPatterns = {"/index"})
public class ServletIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        String clausula_tipo = "";
        String id_tipo = "";
        if(request.getParameter("id_tipo") != null) {
            clausula_tipo = " and id_tipo = "+request.getParameter("id_tipo");
            id_tipo = request.getParameter("id_tipo");
        }
        request.setAttribute("listaProductos", Conexion.getInstancia().db_object(Producto.class,"estado = 1" + clausula_tipo));
        request.setAttribute("listaTipo", Conexion.getInstancia().db_object(Tipo_producto.class));
        request.setAttribute("id_tipo", id_tipo);
        despachador = request.getRequestDispatcher("/index.jsp");
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
