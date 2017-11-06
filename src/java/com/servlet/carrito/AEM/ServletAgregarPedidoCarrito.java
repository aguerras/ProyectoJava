package com.servlet.carrito.AEM;

import com.data.PedidoDatos;
import com.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexis
 */
@WebServlet(name = "ServletAgregarCarrito", urlPatterns = {"/carritoDeCompras/agregar"})
public class ServletAgregarPedidoCarrito extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            Usuario user = (Usuario) session.getAttribute("user");
            String id_usuario = String.valueOf(user.getId_usuario());
            String id_producto = "";
            if(request.getParameter("id_producto") != null) {
                id_producto = request.getParameter("id_producto");
                PedidoDatos.getInstancia().insertarPedido(id_usuario, id_producto);
            }
            response.sendRedirect(request.getContextPath() + "/carritoDeCompras/carrito");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
