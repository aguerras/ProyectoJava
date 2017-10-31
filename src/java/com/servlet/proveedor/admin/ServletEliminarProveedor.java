package com.servlet.proveedor.admin;

import com.data.ProveedorDatos;
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
@WebServlet(name = "ServletEliminarProveedor", urlPatterns = {"/proveedor/admin/eliminar-proveedor"})
public class ServletEliminarProveedor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        ProveedorDatos.getInstancia().eliminarProveedor(request.getParameter("id_proveedor"));
        response.sendRedirect("../proveedores");
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
