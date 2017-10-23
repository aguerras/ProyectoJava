package com.servlet.proveedor;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.ProveedorDatos;
import com.db.Conexion;
import com.model.Proveedor;

/**
 *
 * @author kguerra
 */
@WebServlet(name = "ServletProveedor", urlPatterns = {"/proveedor/proveedores"})
public class ServletProveedor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        //request.setAttribute("listaProveedor", ProveedorDatos.getInstancia().getProveedores());
        request.setAttribute("listaProveedor", Conexion.getInstancia().db_object(Proveedor.class));
        despachador = request.getRequestDispatcher("/proveedor/proveedores.jsp");
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