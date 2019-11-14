package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Objeto;
import org.apache.log4j.Logger;

import java.util.*;

public class GameManagerImpl implements GameManger{
    private static GameManger instance;

    private HashMap<String, Jugador> jugadores;
    //List<Objeto> listaObjetos;

    static Logger logger = Logger.getLogger(GameManagerImpl.class);

    private GameManagerImpl(){
        jugadores = new HashMap<String, Jugador>();
        //listaObjetos = new LinkedList<Objeto>(); //comento porque alomejor no es necesario
    }

    public static GameManger getInstance() {  //singleton
        if(instance == null){
            instance = new GameManagerImpl();
        }
        return instance;
    }


    public void addJugador(String id, String name, String surname) {  //añadir jugador
        logger.info("User added con nombre id: " + name);
        jugadores.put(id, new Jugador(id, name, surname));
    }

    public void addObjeto(String name, String jugadorId){  //añadir un objeto a un jugador
        Jugador u = jugadores.get(jugadorId);
        if(u == null){
            logger.error("User not found. UserId: " + jugadorId);
            //throw new UserNotFoundException();
        }
        u.addObjeto(name);
        logger.info("Objeto added. name: " + name);

    }
/**
    public  HashMap<String, Jugador> listarJugadores()
    {
        logger.info("Listando jugadores ...");
        HashMap<String, Jugador> ordenarAlfa = new HashMap<>(jugadores);
        Collections.sort(ordenarAlfa, Comparator.comparing(Jugador::getNombre));
        return ordenarAlfa;
    }
*/
/**
    public Jugador consultarJugador(String nombre)    //consulto un jugador
    {
        logger.info("Usuario consultado " + nombre);
        for (Jugador userRegis : this.jugadores)
        {
            if (userRegis.getNombre().equals(nombre)) {
                return userRegis;
            }
        return null;

    }

    }
 */


    public List<Objeto> listadoObjetos(String nombre)  {  //objetos de un usuario
        Jugador u = jugadores.get(nombre);
        if(u == null) {
            logger.error("User not found. UserId: " + nombre);
        }
        logger.info("Mostrar objetos de " + nombre);
        return u.objetos;
    }

    public int numerosObjetos(String nombre)  {  //numero de objetos de un usuario
        Jugador u = jugadores.get(nombre);
        if(u == null) {
            logger.error("User not found. Usernombre: " + nombre);
        }
        logger.info("Mostrar objetos de " + nombre);
        return u.objetos.size();
    }
    /**
    public Jugador getJugador(String nombre) {   //como se compara en hashmap
        logger.info("getTrack("+nombre+")");

        for (Jugador t: this.jugadores) {
            if (t.getId().equals(nombre)) {
                logger.info("getTrack("+nombre+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + nombre);
        return null;
    }
     */
/**
    public Jugador modificarJugador(Jugador p) {  //modifica UN jUGADOR
        Jugador t = this.getJugador(p.getId());

        if (t!=null) {
            logger.info(p+" recibido!!!! ");
            t.setNombre(p.getNombre());
            t.setApellido(p.getApellido());
            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
 */


    @Override
    public void clear() {
        jugadores.clear();
        //listaObjetos.clear();
    }

}
