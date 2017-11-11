package comprar;

import com.data.FacturaDatos;
import com.db.Conexion;
import com.model.Detalle_factura;
import com.model.Factura;
import com.model.Usuario;
import java.io.IOException;
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
            String id_factura = FacturaDatos.getInstancia().insertarFactura(String.valueOf(id_usuario));
            request.setAttribute("usuarioNombre",((Usuario) session.getAttribute("user")).getNombres() + " " + ((Usuario) session.getAttribute("user")).getApellidos());
            request.setAttribute("listaDetalleFactura",Conexion.getInstancia().db_object(Detalle_factura.class,"id_factura = " + id_factura));
            request.setAttribute("factura",Conexion.getInstancia().db_object(Factura.class,"id_factura = " + id_factura).get(0));
            despachador = request.getRequestDispatcher("/producto/comprar.jsp");
            despachador.forward(request, response);
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
