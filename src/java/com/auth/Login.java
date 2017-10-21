/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

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
        String date = "2000-11-01"; // YYYY-MM-DD
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        Usuario user = new Usuario(1, "Alexis", "Guerra", 1, "aguerra2012201@gmail.com", sqlDate, sqlDate, 1, "", 1, "1222376", "abc", 1);
        HttpSession session = request.getSession();
        String nombre = "";
        if (session.getAttribute("nombre") == null) {
            Usuario usuario = (Usuario)user;
            // usuario = (Usuario)query.list().get(0);
            try {
                session.setAttribute("user", usuario);
                response.sendRedirect(request.getContextPath() + "/Test");
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            nombre = (String)session.getAttribute("nombre");
            response.sendRedirect(request.getContextPath() + "/Test");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
