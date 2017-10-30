package com.servlet.producto.admin;

import com.data.ProductoDatos;
import com.db.Conexion;
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
@WebServlet(name = "ServletAgregarEditarTipo", urlPatterns = {"/producto/admin/agregar-editar-tipo"})
public class ServletAgregarEditarTipo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        String editar = "0";
        if(request.getParameter("editar") != null) {
            if (request.getParameter("editar").equals("1")) {
                editar = "1";
                request.setAttribute("tipo", Conexion.getInstancia().db_object(Tipo_producto.class,"id_tipo = " + request.getParameter("id_tipo")).get(0));
            }
        }
        request.setAttribute("editar", editar);
        despachador = request.getRequestDispatcher("/producto/admin/agregar-editar-tipo.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("editar") != null) {
            if (request.getParameter("editar").equals("1")) {
                ProductoDatos.getInstancia().editarTipoProducto(request.getParameter("id_tipo"),request.getParameter("nombre_tipo"));
            } else {
                ProductoDatos.getInstancia().insertarTipoProducto(request.getParameter("nombre_tipo"));
            }
        } else {
            ProductoDatos.getInstancia().insertarTipoProducto(request.getParameter("nombre_tipo"));
        }
        
        response.sendRedirect("../tipos-producto");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
