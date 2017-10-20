/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author kguerra
 */
public class Tipo_factura {
    private int id_tipo;
    private int nombre_factura;

    public Tipo_factura (int id_tipo,int nombre_factura) {
        this.id_tipo = id_tipo;
        this.nombre_factura = nombre_factura;
    }

    public int getId_tipo() {
        return id_tipo;
    }
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getNombre_factura() {
        return nombre_factura;
    }
    public void setNombre_factura(int nombre_factura) {
        this.nombre_factura = nombre_factura;
    }
}
