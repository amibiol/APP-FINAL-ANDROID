package com.example.biblio_mb;

public class Libro {


    int id,isbn,estado;
    String nombre;

    public Libro() {
    }

    public Libro(int id) {
        this.id = id;
    }


    public Libro(int id, int isbn, String nombre, int estado) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", isnb='" + isbn + '\'' +
                '}';
    }



}
