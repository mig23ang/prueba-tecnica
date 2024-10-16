package org.pedidos.services.contract;

import org.pedidos.gen.type.PedidoType;

public interface IPedidosService {

    PedidoType createPedido(PedidoType pedidoType);

    PedidoType updatePedido(Long id, PedidoType pedidoType);

    PedidoType getPedidoById(Long id);

    void deletePedido(Long id);

    PedidoType[] getPedidos();
}
