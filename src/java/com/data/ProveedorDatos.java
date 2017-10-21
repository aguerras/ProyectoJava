package com.data;

import com.db.Conexion;
import com.model.Proveedor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alexis
 */

// La clase ProveedorDatos es un mediador del servlet y la base de datos.
public class ProveedorDatos {
    // Usamos singleton
    private static ProveedorDatos instancia;
    private ProveedorDatos() {
    }
    public static synchronized ProveedorDatos getInstancia() {
        if (instancia == null) {
            instancia = new ProveedorDatos();
        }
        return instancia;
    }
    
    // Funcion getProveedores para traer todos los proveedores de la base de datos.
    public List<Proveedor> getProveedores() {
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
        
        return listaProveedor;
    }
    
    // Funcion insertarProveedor para insertar un proveedor en la base de datos.
    public void insertarProveedor(String nombre, String direccion, String telefono, String fax, String nombre_comercial, String nit) {
        Conexion.getInstancia().db_exec("INSERT INTO proveedor (nombre,direccion,telefono,fax,estado,fecha_creacion,nombre_comercial,nit,documentacion_completa,observaciones) "
            + "VALUES ('"+ nombre
            + "','"+ direccion
            + "',"+ telefono
            + ",'"+ fax
            + "',1,now(),'"+ nombre_comercial
            + "','"+ nit
            + "',0,'')");
    }
}
