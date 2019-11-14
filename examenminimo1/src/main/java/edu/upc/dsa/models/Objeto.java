package edu.upc.dsa.models;

public class Objeto {
     String nombre;

    public Objeto(String nom) {
        this.nombre = nom;
    }
    public Objeto() {};

    public void setNombre(String nom) {
        this.nombre=nom;
    }
    public String getNombre() {
        return this.nombre;
    }


}
