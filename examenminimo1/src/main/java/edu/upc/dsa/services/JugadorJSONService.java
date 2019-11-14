package edu.upc.dsa.services;

import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.GameManger;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Objeto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/objetos", description = "Endpoint to GameManager service")
@Path("/objetos")


public class JugadorJSONService {
    private GameManger tm;

    public JugadorJSONService() {
        this.tm = GameManagerImpl.getInstance();
            tm.addJugador("u1", "Julen", "vava");
            tm.addObjeto("espada", "u1");
            tm.addObjeto("martillo", "u1");
            tm.addObjeto("moneda", "u1");

    }
    @GET
    @ApiOperation(value = "Get all objetos from a Jugador", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),

    })
    @Path("/getObjetos/{nombre}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetos(@PathParam("nombre") String nombre) {
        List<Objeto> objetos = tm.listadoObjetos(nombre);
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Jugador.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newJugador(Jugador jugador) {

        if (jugador.getId()==null || jugador.getNombre()==null || jugador.getApellido()==null)  return Response.status(500).entity(jugador).build();
        this.tm.addJugador(jugador.getId(), jugador.getNombre(), jugador.getApellido());
        return Response.status(201).entity(jugador).build();
    }
/**
    @GET
    @Path("/user/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public Jugador getUser(@PathParam("nom") String nom) {
        return this.tm.(nom);
    }


    @GET
    @ApiOperation(value = "get all Objetos", notes = "me da todos los productos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer = "List"),
    })
    @Path("/")     //ordena por precio
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsporPrecio() {
        List<Producto> products = this.tm.listarProductos();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(products) {
        };
        return Response.status(201).entity(entity).build();
    }
    /**
     @GET  //otra forma de listar por precio, mejor hacer la del profe
     @Path("/listarProductos")
     @Produces(MediaType.APPLICATION_JSON)
     public List<Producto> getListarProductos() {
     List<Producto> listarProductosPorPrecio = null;
     listarProductosPorPrecio = this.tm.listarProductos();
     return listarProductosPorPrecio;
     }
     */
/**
    @GET
    @ApiOperation(value = "get Pedidos de un User", notes = "me da los pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pedido.class, responseContainer = "List"),
    })
    @Path("/listar/{user}")     //pedidos de un user
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedidosdeUser(@PathParam("user") String user) {
        List<Pedido> pedidos = this.tm.listadoPedidos(user);
        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidos) {
        };
        return Response.status(201).entity(entity).build();
    }
    */

    /**
     @GET
     @Path("/listar/{user}")
     @Produces(MediaType.APPLICATION_JSON)
     public List<Pedido> getListar(@PathParam("user") String user) {
     return tm.listadoPedidos(user);
     }
     */
   /** @POST
    @ApiOperation(value = "create a new Product", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Producto.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Producto producto) {
        if (producto.getNombre()==null || producto.getPrecio()==0)  return Response.status(500).entity(producto).build();
        this.tm.addProduct(producto);
        return Response.status(201).entity(producto).build();
    }
    @DELETE
    @ApiOperation(value = "delete a Product", notes = "borra un producto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{nom}")
    public Response deleteProduct(@PathParam("nom") String nom) {
        Producto t = this.tm.consultarProducto(nom);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteProducto(t);
        return Response.status(201).build();
    }
*/



}

