package com.servlet.producto.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.ProveedorDatos;
import com.data.ProductoDatos;

/**
 *
 * @author Alexis
 */
@WebServlet(name = "ServletAgregarProducto", urlPatterns = {"/producto/admin/agregar-producto"})
public class ServletAgregarProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        request.setAttribute("listaProveedor", ProveedorDatos.getInstancia().getProveedores());
        despachador = request.getRequestDispatcher("/producto/admin/agregar-producto.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        
        ProductoDatos.getInstancia().insertarProducto(request.getParameter("nombre_producto"), request.getParameter("descripcion"), request.getParameter("id_proveedor"), request.getParameter("precio"), request.getParameter("descuento"));
        
        response.sendRedirect("../productos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
