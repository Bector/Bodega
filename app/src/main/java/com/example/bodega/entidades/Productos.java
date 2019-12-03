package com.example.bodega.entidades;

public class Productos {

    private int id;
    private String nomProd;
    private int precio;
    private int cantidad;
    private String categoria;

    public Productos(int id, String nomProd, int precio, int cantidad, String categoria) {
        this.id = id;
        this.nomProd = nomProd;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria=categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
