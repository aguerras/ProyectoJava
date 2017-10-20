package com.model;

/**
 *
 * @author kguerra
 */
public class Facturacion {
    private int id_facturacion;
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String nit;
    private String direccion;
    private int estado;

    public Facturacion (int id_facturacion,int id_usuario,String nombres,String apellidos,String nit,String direccion,int estado) {
        this.id_facturacion = id_facturacion;
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nit = nit;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_facturacion() {
        return id_facturacion;
    }
    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
