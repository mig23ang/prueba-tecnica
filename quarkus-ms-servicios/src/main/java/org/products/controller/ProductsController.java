package org.products.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.products.gen.contract.V1ProductosApi;
import org.products.gen.type.ProductoType;
import org.products.services.impl.ProductsService;
import org.products.utils.ApplicationException;

public class ProductsController implements V1ProductosApi {

    @Inject
    ProductsService productsService;
    @Inject
    Logger logger;

    @Override
    public Response createProduct(ProductoType productoType) {
        logger.info("inicia creacion de producto en ProductsController");
        try {
            return Response.ok(productsService.createProducto(productoType)).build();
        } catch (ApplicationException e) {
            logger.error("Error al crear producto", e);
            throw new ApplicationException("Error al crear producto");
        } catch (Exception e) {
            logger.error("Error al crear producto", e);
            return Response.serverError().build();

        }
    }

    @Override
    public Response deleteProduct(Long id) {
        logger.info("inicia eliminacion de producto en ProductsController");
        try {
            productsService.deleteProducto(id);
            return Response.ok().build();
        } catch (ApplicationException e) {
            logger.error("Error al eliminar producto", e);
            throw new ApplicationException("Error al eliminar producto");
        } catch (Exception e) {
            logger.error("Error al eliminar producto", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getProductById(Long id) {
        logger.info("inicia busqueda de producto en ProductsController");
        try {
            return Response.ok(productsService.getProducto(id)).build();
        } catch (ApplicationException e) {
            logger.error("Error al buscar producto", e);
            throw new ApplicationException("Error al buscar producto");
        } catch (Exception e) {
            logger.error("Error al buscar producto", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getProducts() {
        logger.info("inicia busqueda de productos en ProductsController");
        try {
            return Response.ok(productsService.getAllProductos()).build();
        } catch (ApplicationException e) {
            logger.error("Error al buscar productos", e);
            throw new ApplicationException("Error al buscar productos");
        } catch (Exception e) {
            logger.error("Error al buscar productos", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response updateProduct(Long id, ProductoType productoType) {
        logger.info("inicia actualizacion de producto en ProductsController");
        try {
            return Response.ok(productsService.updateProducto(id, productoType)).build();
        } catch (ApplicationException e) {
            logger.error("Error al actualizar producto", e);
            throw new ApplicationException("Error al actualizar producto");
        } catch (Exception e) {
            logger.error("Error al actualizar producto", e);
            return Response.serverError().build();
        }
    }


}