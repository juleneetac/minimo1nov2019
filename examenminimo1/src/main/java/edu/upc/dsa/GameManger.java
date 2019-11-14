package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Objeto;

import java.util.HashMap;
import java.util.List;

public interface GameManger {
    public void addJugador(String id, String name, String surname);
    public void addObjeto(String name, String jugadorId);
    public List<Objeto> listadoObjetos(String id);
    public List<Jugador> listarJugadores();
    public int sizeJugadores();
    public Jugador consultarJugador(String id);
    public int numerosObjetos(String nombre); // me da el numero de objetos de un user
    public Jugador updateJugador(Jugador p);



    public Jugador getJugador(String id); //necesaria pero no me la piden
    public void clear();  // para el teardown


}
