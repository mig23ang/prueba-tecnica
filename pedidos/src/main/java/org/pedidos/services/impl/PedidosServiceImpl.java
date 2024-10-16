package org.pedidos.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.pedidos.dao.impl.PedidosDaoImpl;
import org.pedidos.gen.type.PedidoType;
import org.pedidos.services.contract.IPedidosService;
import org.pedidos.utils.MapperPedidos;


@ApplicationScoped
public class PedidosServiceImpl implements IPedidosService {

    @Inject
    Logger logger;

    @Inject
    PedidosDaoImpl pedidosDaoImpl;

    @Inject
    MapperPedidos mapperPedidos;

    @Override
    public PedidoType createPedido(PedidoType pedidoType) {
        System.out.println("Inicia creación de pedido en PedidosServiceImpl" + pedidoType);
        logger.info("Inicia creación de pedido en PedidosServiceImpl");
        return mapperPedidos.pedidosEntityToPedidosType(pedidosDaoImpl.createPedido(mapperPedidos.pedidosTypeToPedidosEntity(pedidoType)));
    }

    @Override
    public PedidoType updatePedido(Long id, PedidoType pedidoType) {
        logger.info("Inicia actualización de pedido en PedidosServiceImpl");
        return mapperPedidos.pedidosEntityToPedidosType(pedidosDaoImpl.updatePedido(id, mapperPedidos.pedidosTypeToPedidosEntity(pedidoType)));
    }

    @Override
    public PedidoType getPedidoById(Long id) {
        logger.info("Inicia búsqueda de pedido por id en PedidosServiceImpl");
        return mapperPedidos.pedidosEntityToPedidosType(pedidosDaoImpl.getPedido(id));
    }

    @Override
    public void deletePedido(Long id) {
        logger.info("Inicia eliminación de pedido en PedidosServiceImpl");
        pedidosDaoImpl.deletePedido(id);
    }

    @Override
    public PedidoType[] getPedidos() {
        logger.info("Inicia búsqueda de pedidos en PedidosServiceImpl");
        return mapperPedidos.pedidosEntityListToPedidosTypeArray(pedidosDaoImpl.getAllPedidos());
    }
}
