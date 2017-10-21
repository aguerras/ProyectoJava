package com.servlet.proveedor.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.ProveedorDatos;

/**
 *
 * @author kguerra
 */
@WebServlet(name = "ServletAgregarProveedor", urlPatterns = {"/proveedor/admin/agregar-proveedor"})
public class ServletAgregarProveedor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        despachador = request.getRequestDispatcher("/proveedor/admin/agregar-proveedor.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher despachador=null;
        
        ProveedorDatos.getInstancia().insertarProveedor(request.getParameter("nombre"), request.getParameter("direccion"), request.getParameter("telefono"), request.getParameter("fax"), request.getParameter("nombre_comercial"), request.getParameter("nit"));
        
        response.sendRedirect("../proveedores");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
