package com.servlet.carrito;

import com.data.PedidoDatos;
import com.db.Conexion;
import com.model.Detalle_pedido;
import com.model.Pedido;
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

@WebServlet(name = "ServletCarrito", urlPatterns = {"/carritoDeCompras/carrito"})
public class ServletCarrito extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            Usuario user = (Usuario) session.getAttribute("user");
            String id_usuario = String.valueOf(user.getId_usuario());
            String id_pedido = "";
            RequestDispatcher despachador=null;
            Pedido pedido = (Pedido) Conexion.getInstancia().db_object(Pedido.class, "id_usuario = " + id_usuario).get(0);
            id_pedido = String.valueOf(pedido.getId_pedido());
            request.setAttribute("articulos", PedidoDatos.getInstancia().numeroArticulos(id_pedido));
            request.setAttribute("total", pedido.getPrecio_total());
            
            request.setAttribute("listaDetallePedidos", PedidoDatos.getInstancia().getPedidos(id_pedido));
            despachador = request.getRequestDispatcher("/carritoDeCompras/carrito.jsp");
            despachador.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
