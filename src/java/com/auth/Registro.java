package com.auth;

import com.data.UsuarioDatos;
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
 * @author Alexis
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador=null;
        despachador = request.getRequestDispatcher("/registro.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDatos.getInstancia().insertarUsuario(
                request.getParameter("nombres"),
                request.getParameter("apellidos"),
                request.getParameter("sexo"),
                request.getParameter("email"),
                request.getParameter("dia") + "/" + request.getParameter("mes") + "/" + request.getParameter("anio"),
                request.getParameter("foto"),
                request.getParameter("pais"),
                request.getParameter("telefono"),
                request.getParameter("clave")
        );
        response.sendRedirect(request.getContextPath() + "/Login");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
