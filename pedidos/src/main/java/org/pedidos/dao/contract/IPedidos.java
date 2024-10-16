package org.pedidos.dao.contract;

import org.pedidos.dao.entity.PedidoEntity;

import java.util.List;

public interface IPedidos {

    //crear metodos para la creacion, eliminacion, busqueda, actualizacion y listado de pedidos

    void deletePedido(Long id);

    PedidoEntity getPedido(Long id);

    List<PedidoEntity> getAllPedidos();

    PedidoEntity updatePedido(Long id, PedidoEntity pedido);

    PedidoEntity createPedido(PedidoEntity pedido);


}
