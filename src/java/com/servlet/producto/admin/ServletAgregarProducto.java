package com.servlet.producto.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.ProductoDatos;
import com.db.Conexion;
import com.model.Producto;
import com.model.Proveedor;
import com.model.Tipo_producto;

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
        String editar = "0";
        if(request.getParameter("editar") != null) {
            if (request.getParameter("editar").equals("1")) {
                editar = "1";
                request.setAttribute("producto", Conexion.getInstancia().db_object(Producto.class,"id_producto = " + request.getParameter("id_producto")).get(0));
            }
        }
        request.setAttribute("editar", editar);
        request.setAttribute("listaTiposProducto", Conexion.getInstancia().db_object(Tipo_producto.class));
        request.setAttribute("listaProveedor", Conexion.getInstancia().db_object(Proveedor.class));
        despachador = request.getRequestDispatcher("/producto/admin/agregar-producto.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        
        if(request.getParameter("editar") != null) {
            if (request.getParameter("editar").equals("1")) {
                ProductoDatos.getInstancia().editarProducto(request.getParameter("id_producto"),request.getParameter("nombre_producto"), request.getParameter("descripcion"), request.getParameter("id_proveedor"), request.getParameter("id_tipo"), request.getParameter("precio"), request.getParameter("descuento"), request.getParameter("path_img"), request.getParameter("cantidad"));
            } else {
                ProductoDatos.getInstancia().insertarProducto(request.getParameter("nombre_producto"), request.getParameter("descripcion"), request.getParameter("id_proveedor"), request.getParameter("id_tipo"), request.getParameter("precio"), request.getParameter("descuento"), request.getParameter("path_img"), request.getParameter("cantidad"));
            }
        } else {
            ProductoDatos.getInstancia().insertarProducto(request.getParameter("nombre_producto"), request.getParameter("descripcion"), request.getParameter("id_proveedor"), request.getParameter("id_tipo"), request.getParameter("precio"), request.getParameter("descuento"), request.getParameter("path_img"), request.getParameter("cantidad"));
        }
        
        response.sendRedirect("../productos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
