package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Objeto;

import java.util.HashMap;
import java.util.List;

public interface GameManger {
    public void addJugador(String id, String name, String surname);
    public void addObjeto(String name, String jugadorId);
    public List<Objeto> listadoObjetos(String nombre);
    //public  HashMap<String, Jugador> listarJugadores();
    //public Jugador consultarJugador(String nombre);
    //public int numerosObjetos(String nombre); // me da el numero de objetos de un user
    //public Jugador modificarJugador(Jugador p);

    //public Jugador getJugador(String nombre);  //obtengo un jugador segun su nombre


    //public int size();
    public void clear();

}
