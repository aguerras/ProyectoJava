package com.model;

import java.sql.Date;

/**
 *
 * @author kguerra
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String direccion;
    private int telefono;
    private String fax;
    private int estado;
    private Date fecha_creacion;
    private String nombre_comercial;
    private String nit;
    private int documentacion_completa;
    private String observaciones;

    public Proveedor (int id_proveedor,String nombre,String direccion,int telefono,String fax,int estado,Date fecha_creacion,String nombre_comercial,String nit,int documentacion_completa,String observaciones) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fax = fax;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.nombre_comercial = nombre_comercial;
        this.nit = nit;
        this.documentacion_completa = documentacion_completa;
        this.observaciones = observaciones;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }
    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getDocumentacion_completa() {
        return documentacion_completa;
    }
    public void setDocumentacion_completa(int documentacion_completa) {
        this.documentacion_completa = documentacion_completa;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
