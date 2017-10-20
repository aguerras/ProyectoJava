package com.model;

import java.sql.Date;

/**
 *
 * @author kguerra
 */
public class Rol {
    private int id_rol;
    private String nombre_rol;
    private String descripcion;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    
    public Rol (String nombre_rol,String descripcion,Date fecha_creacion,Date fecha_modificacion) {
        this.nombre_rol = nombre_rol;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }
    
    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void SetFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }
    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
