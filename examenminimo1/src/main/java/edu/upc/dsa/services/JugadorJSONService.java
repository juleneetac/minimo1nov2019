package edu.upc.dsa.services;

import edu.upc.dsa.GameManger;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Jugador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Juego", description = "Endpoint to GameManager service")
@Path("/Juego")


public class JugadorJSONService {
    private GameManger tm;

    public JugadorJSONService() {
        this.tm = GameManagerImpl.getInstance();
        if (tm.sizeJugadores() == 0) {
            tm.addJugador("u1", "Julen", "Vava");
            tm.addJugador("u2", "Matias", "Mat");
            tm.addObjeto("espada", "u1");
            tm.addObjeto("martillo", "u1");
            tm.addObjeto("moneda", "u2");
        }
    }

    @GET   //listar todos los ususarios
    @ApiOperation(value = "get all jugadores", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<Jugador> jug = this.tm.listarJugadores();
        GenericEntity<List<Jugador>> entity = new GenericEntity<List<Jugador>>(jug) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET    //consultar objetos de un jugador
    @ApiOperation(value = "Get objetos from a Jugador", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")

    })
    @Path("/getObjetos/{idjugador}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetos(@PathParam("idjugador") String id) {
        List<Objeto> objetos = tm.consultarJugador(id).getObjetos();
        if (objetos == null) return Response.status(404).build()  ;
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET  //consultar a un jugador
    @ApiOperation(value = "obtener informacion de un usuario", notes = "recibe toda la info de usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class),
            @ApiResponse(code = 404, message = "Jugador no encontrado")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarJugador(@PathParam("id") String id) {
        Jugador u = this.tm.consultarJugador(id);
        if (u == null) return Response.status(404).build();
        else return Response.status(201).entity(u).build();
    }
    @POST   //añadir un jugador
    @ApiOperation(value = "crear un nuevo Jugador", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Jugador.class),
            @ApiResponse(code = 500, message = "Error al añadir jugador")
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newJugador(Jugador jugador) {

        if (jugador.getNombre()==null)  return Response.status(500).entity(jugador).build();
        this.tm.addJugador(jugador.getId(), jugador.getNombre(), jugador.getApellido());
        int i=0;
        while(i<jugador.getObjetos().size()) {
           this.tm.addObjeto(jugador.getObjetos().get(i).getNombre(), jugador.getId());
           i++;
        }
        return Response.status(201).entity(jugador).build();
    }
    @POST  //añadir un objeto a un jugador
    @ApiOperation(value = "create a new Object", notes = "crear nuevo objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Object.class),
            @ApiResponse(code = 500, message = "Error, intenta de nuevo")

    })

    @Path("/jugador/{idjugador}/objeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjecto(Objeto o,@PathParam("idjugador") String id ) {

        if (o.getNombre()== null) return Response.status(500).entity(o).build();
        this.tm.addObjeto(o.getNombre(), id);

        return Response.status(201).entity(o).build();
    }

    @PUT
    @ApiOperation(value = "update a Jugador", notes = "debes poner el id del usuario que quieres cambiar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/")
    public Response updateJugador(Jugador jug) {
        Jugador t = this.tm.updateJugador(jug);
        if (t == null) return Response.status(404).build();
        return Response.status(201).build();
    }



}

