package com.example.bodega.entidades;

public class Productos {

    private int id;
    private String nomProd;
    private int precio;
    private int cantidad;

    public Productos(int id, String nomProd, int precio, int cantidad) {
        this.id = id;
        this.nomProd = nomProd;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Productos(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
