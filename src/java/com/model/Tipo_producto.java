package com.model;

/**
 *
 * @author kguerra
 */
public class Tipo_producto {
    private int id_tipo;
    private String nombre_tipo;
    private int estado;

    public Tipo_producto () {
    }

    public Tipo_producto (int id_tipo,String nombre_tipo,int estado) {
        this.id_tipo = id_tipo;
        this.nombre_tipo = nombre_tipo;
        this.estado = estado;
    }

    public int getId_tipo() {
        return id_tipo;
    }
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }
    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
    
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
