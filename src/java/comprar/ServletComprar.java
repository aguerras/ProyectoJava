package comprar;

import com.data.FacturaDatos;
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
@WebServlet(name = "ServletComprar", urlPatterns = {"/producto/comprar"})
public class ServletComprar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            int id_usuario = ((Usuario) session.getAttribute("user")).getId_usuario();
            RequestDispatcher despachador=null;
            FacturaDatos.getInstancia().insertarFactura(String.valueOf(id_usuario));
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
