package com.servlet.proveedor;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.model.Proveedor;
import com.db.Conexion;
import java.text.SimpleDateFormat;

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
        
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        List<ArrayList> lista = new ArrayList<ArrayList>(Conexion.getInstancia().db_list_of_lists("SELECT nombre,direccion,telefono,fax,nombre_comercial,DATE_FORMAT(fecha_creacion,'%d-%m-%Y'),nit FROM proveedor"));
        for (Iterator<ArrayList> i = lista.iterator(); i.hasNext();) {
            ArrayList<String> lista2 = new ArrayList<String>(i.next());
            String nombre = lista2.get(0);
            String direccion = lista2.get(1);
            int telefono = Integer.parseInt(lista2.get(2));
            String fax = lista2.get(3);
            String nombre_comercial = lista2.get(4);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            Calendar currenttime = Calendar.getInstance();
            Date fecha_creacion = new Date((currenttime.getTime()).getTime());
            try {
                java.util.Date date = sdf1.parse(lista2.get(5));
                Date fecha_creacion2 = new Date(date.getTime());
                fecha_creacion = fecha_creacion2;
            } catch (Exception e) {
                
            }
            //Date fecha_creacion = Date.valueOf(lista2.get(5));
            String nit = lista2.get(6);
            Proveedor proveedor = new Proveedor(0,nombre,direccion,telefono,fax,1,fecha_creacion,nombre_comercial,nit,0,"a");
            listaProveedor.add(proveedor);
        }
        request.setAttribute("listaProveedor", listaProveedor);
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