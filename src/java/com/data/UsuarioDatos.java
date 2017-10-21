package com.data;

import com.db.Conexion;

/**
 *
 * @author Alexis
 */
public class UsuarioDatos {
    // Usamos singleton
    private static UsuarioDatos instancia;
    private UsuarioDatos() {
    }
    public static synchronized UsuarioDatos getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDatos();
        }
        return instancia;
    }
    
    public void insertarUsuario(String nombres, String apellidos, String sexo, String email, String fecha_nacimiento, String foto, String id_pais, String telefono, String clave) {
        Conexion.getInstancia().db_exec("INSERT INTO usuario (nombres, apellidos, sexo, email, fecha_nacimiento, fecha_creacion, id_rol, foto, id_pais, telefono, clave_acceso, estado) "
            + "VALUES ('"+ nombres
            + "','"+ apellidos
            + "',"+ sexo
            + ",'"+ email
            + "',now(), now(), 2,'"+ foto
            + "',"+ id_pais
            + ","+ telefono
            + ",md5('"+ clave + "'),1)");
    }
}
