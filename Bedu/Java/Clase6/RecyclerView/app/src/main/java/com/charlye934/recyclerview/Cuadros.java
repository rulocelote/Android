package com.charlye934.recyclerview;

public class Cuadros {
    private int imagen;
    private int foto;
    private String descripcion;
    private String nombre;


    public Cuadros(String nombre, String descripcion, int imagen, int foto) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.foto = foto;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
