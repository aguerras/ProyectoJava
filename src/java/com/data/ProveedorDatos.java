package com.data;

import com.db.Conexion;
import com.model.Proveedor;
import java.util.ArrayList;
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
        Conexion.getInstancia().db_object(Proveedor.class);
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        for (ArrayList<String> lista : (Conexion.getInstancia().db_list_of_lists("SELECT nombre,direccion,telefono,fax,nombre_comercial,DATE_FORMAT(fecha_creacion,'%d-%m-%Y'),nit FROM proveedor"))) {
            String nombre = lista.get(0);
            String direccion = lista.get(1);
            int telefono = Integer.parseInt(lista.get(2));
            String fax = lista.get(3);
            String nombre_comercial = lista.get(4);
            String fecha_creacion = lista.get(5);
            //Date fecha_creacion = Date.valueOf(lista.get(5));
            String nit = lista.get(6);
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
