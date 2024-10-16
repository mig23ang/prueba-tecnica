package org.pedidos.utils;

import jakarta.inject.Singleton;
import org.modelmapper.ModelMapper;
import org.pedidos.dao.entity.PedidoEntity;
import org.pedidos.gen.type.PedidoType;

import java.util.List;

@Singleton
public class MapperPedidos {

    public PedidoType pedidosEntityToPedidosType(PedidoEntity pedidoEntity) {
        return new ModelMapper().map(pedidoEntity, PedidoType.class);
    }

    public PedidoEntity pedidosTypeToPedidosEntity(PedidoType pedidoType) {
        return new ModelMapper().map(pedidoType, PedidoEntity.class);
    }

    public PedidoType[] pedidosEntityListToPedidosTypeArray(List<PedidoEntity> pedidoEntities) {
        return pedidoEntities.stream()
                .map(this::pedidosEntityToPedidosType) // Convierte cada PedidoEntity a PedidoType
                .toArray(PedidoType[]::new); // Convierte el Stream a un array
    }
}
