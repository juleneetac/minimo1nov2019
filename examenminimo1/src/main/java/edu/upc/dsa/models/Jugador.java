package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Jugador {
    public List<Objeto> objetos;
    String id;
    String nombre;
    String apellido;

    public Jugador(String id, String name, String surname){
        this.id = id;
        this.nombre = name;
        this.apellido = surname;
        objetos = new ArrayList<Objeto>();
    }
    public Jugador(){} //constructor vacio

/** //quito esto
    public ArrayList getObjetos(){
        objetos = new ArrayList<Objeto>();
        //Aquí escribes el código con el que quieras rellenar la ArrayList
        return objetos;
    }
 */

    public void addObjeto(String name){   //añadir un objeto a un usuario
        objetos.add(new Objeto(name));
    }

    public Objeto getObjeto(String nom) throws ObjectoNotFoundException{    // me devuelve el onjeto que yo le he pasado
        for (Objeto o : objetos){
            if (o.getNombre().equals(nom)){
                return o;
            }
        }
        throw new ObjectoNotFoundException();
    }

    public void setId(String id) {
        this.nombre=id;
    }
    public String getId() {
        return this.id;
    }
    public void setNombre(String name) {
        this.nombre=name;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setApellido(String surname) {
        this.apellido=surname;
    }
    public String getApellido() {
        return this.apellido;
    }


    private class ObjectoNotFoundException extends Exception {
    }
}
