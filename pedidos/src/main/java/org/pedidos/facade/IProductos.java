package org.pedidos.facade;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.pedidos.dao.entity.ProductoEntity;

import java.util.List;

@RegisterRestClient(configKey = "productos")
@Consumes("application/json")
@Produces("application/json")
public interface IProductos {

    //obtener un producto por id
    @GET
    @Path("/v1/productos/{id}")
    public ProductoEntity getProducto(Long id);

    //obtener todos los productos
    @GET
    @Path("/v1/productos")
    public List<ProductoEntity> getProductos();
}
