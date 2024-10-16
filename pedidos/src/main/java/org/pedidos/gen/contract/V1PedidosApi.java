package org.pedidos.gen.contract;

import org.pedidos.gen.type.PedidoType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;



@Path("/v1/pedidos")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-10-16T15:12:08.326193900-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1PedidosApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response createPedido(PedidoType pedidoType);

    @DELETE
    @Path("/{id}")
    Response deletePedido(@PathParam("id") Long id);

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    Response getPedidoById(@PathParam("id") Long id);

    @GET
    @Produces({ "application/json" })
    Response getPedidos();

    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updatePedido(@PathParam("id") Long id,PedidoType pedidoType);
}
