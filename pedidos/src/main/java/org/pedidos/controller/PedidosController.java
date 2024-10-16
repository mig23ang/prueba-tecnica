package org.pedidos.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.pedidos.gen.contract.V1PedidosApi;
import org.pedidos.gen.type.PedidoType;
import org.pedidos.services.impl.PedidosServiceImpl;

public class PedidosController implements V1PedidosApi {

    @Inject
    PedidosServiceImpl pedidosService;

    @Inject
    Logger logger;

    @Override
    public Response createPedido(PedidoType pedidoType) {
        logger.info("inicia creacion de pedido en PedidosController");
        try {
            return Response.ok(pedidosService.createPedido(pedidoType)).build();
        } catch (Exception e) {
            logger.error("Error al crear pedido", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response deletePedido(Long id) {
       logger.info("inicia eliminacion de pedido en PedidosController");
        try {
            pedidosService.deletePedido(id);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Error al eliminar pedido", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getPedidoById(Long id) {
        logger.info("inicia busqueda de pedido en PedidosController");
        try {
            return Response.ok(pedidosService.getPedidoById(id)).build();
        } catch (Exception e) {
            logger.error("Error al buscar pedido", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getPedidos() {
        logger.info("inicia busqueda de pedidos en PedidosController");
        try {
            return Response.ok(pedidosService.getPedidos()).build();
        } catch (Exception e) {
            logger.error("Error al buscar pedidos", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response updatePedido(Long id, PedidoType pedidoType) {
        logger.info("inicia actualizacion de pedido en PedidosController");
        try {
            return Response.ok(pedidosService.updatePedido(id, pedidoType)).build();
        } catch (Exception e) {
            logger.error("Error al actualizar pedido", e);
            return Response.serverError().build();
        }
    }
}
