package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;

import java.util.Comparator;

public class ComparadorJugadores implements Comparator<Jugador> {
    @Override
    public int compare (Jugador j1, Jugador j2)  //he necesitado crear una clase para compara el hashmap de los jugadores
    {
        return j1.getNombre().compareTo(j2.getNombre());
    }

}
