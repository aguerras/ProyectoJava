package com.servlet.proveedor.admin;

import com.db.Conexion;
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
        Conexion.getInstancia().db_exec("INSERT INTO proveedor (nombre,direccion,telefono,fax,estado,fecha_creacion,nombre_comercial,nit,documentacion_completa,observaciones) "
                + "VALUES ('"+ request.getParameter("nombre")
                + "','"+ request.getParameter("direccion")
                + "',"+ request.getParameter("telefono")
                + ",'"+ request.getParameter("fax")
                + "',1,now(),'"+ request.getParameter("nombre_comercial")
                + "','"+ request.getParameter("nit")
                + "',0,'')");
        
        response.sendRedirect("../proveedores");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
