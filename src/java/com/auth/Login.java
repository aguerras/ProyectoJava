/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

import com.db.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Usuario;
import java.sql.Date;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Alexis
 */
@WebServlet(name = "Autenticacion", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher despachador=null;
        despachador = request.getRequestDispatcher("/login.jsp");
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            try {
                Usuario user = (Usuario) Conexion.getInstancia().db_object(Usuario.class, "email = '" + request.getParameter("email") + "' AND clave_acceso = md5('" + request.getParameter("clave") + "');").get(0);
                if (user != null) {
                    session.setAttribute("user", user);
                    // response.sendRedirect(request.getContextPath() + "/index");
                }
            } catch(Exception e) {
                session.setAttribute("error", "Los datos estan incorrectos.");
                System.out.println(e);
            }
        }
        response.sendRedirect(request.getContextPath() + "/Login");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
