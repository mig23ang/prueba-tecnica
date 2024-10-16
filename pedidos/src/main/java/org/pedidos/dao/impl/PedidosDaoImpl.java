package org.pedidos.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.pedidos.dao.contract.IPedidos;
import org.pedidos.dao.entity.PedidoEntity;
import org.pedidos.dao.entity.ProductoEntity;
import org.pedidos.facade.IProductos;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PedidosDaoImpl implements IPedidos {

    @Inject
    @RestClient
    IProductos productosFacade;

    @Inject
    EntityManager entityManager;

    @Inject
    Logger logger;

    @Override
    @Transactional
    public void deletePedido(Long id) {
        logger.info("Inicia eliminación de pedido con id: " + id);
        try {
            PedidoEntity pedido = entityManager.find(PedidoEntity.class, id);
            if (pedido != null) {
                entityManager.remove(pedido);
                logger.info("Pedido eliminado exitosamente.");
            } else {
                logger.error("No se encontró el pedido con id: " + id);
            }
        } catch (PersistenceException e) {
            logger.error("Error al eliminar el pedido con id " + id + ": " + e.getMessage());
        }
    }

    @Override
    public PedidoEntity getPedido(Long id) {
        logger.info("Inicia búsqueda de pedido con id: " + id);
        try {
            PedidoEntity pedido = entityManager.find(PedidoEntity.class, id);
            if (pedido != null) {
                // Cargar productos desde el servicio externo utilizando productosIds
                List<ProductoEntity> productos = cargarProductosDesdeIds(pedido.getProductosIds());
                pedido.setProductos(productos);
                logger.info("Pedido encontrado: " + pedido);
            } else {
                logger.error("No se encontró el pedido con id: " + id);
            }
            return pedido;
        } catch (PersistenceException e) {
            logger.error("Error al buscar el pedido con id " + id + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<PedidoEntity> getAllPedidos() {
        logger.info("Inicia búsqueda de todos los pedidos");
        try {
            List<PedidoEntity> pedidos = entityManager.createQuery("SELECT p FROM PedidoEntity p", PedidoEntity.class).getResultList();
            // Cargar productos para cada pedido desde el servicio externo utilizando productosIds
            for (PedidoEntity pedido : pedidos) {
                List<ProductoEntity> productos = cargarProductosDesdeIds(pedido.getProductosIds());
                pedido.setProductos(productos);
            }
            logger.info("Total de pedidos encontrados: " + pedidos.size());
            return pedidos;
        } catch (PersistenceException e) {
            logger.error("Error al obtener la lista de pedidos: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    @Transactional
    public PedidoEntity updatePedido(Long id, PedidoEntity pedido) {
        logger.info("Inicia actualización de pedido con id: " + id);
        try {
            PedidoEntity existingPedido = entityManager.find(PedidoEntity.class, id);
            if (existingPedido != null) {
                existingPedido.setEstado(pedido.getEstado());

                // Actualizar productos utilizando productosIds y cargar productos válidos desde el servicio externo
                List<ProductoEntity> productosValidos = cargarProductosDesdeIds(pedido.getProductosIds());
                existingPedido.setProductos(productosValidos);
                existingPedido.setProductosIds(pedido.getProductosIds());

                existingPedido.setTotal(pedido.getTotal());
                entityManager.merge(existingPedido);
                logger.info("Pedido actualizado exitosamente.");
                return existingPedido;
            } else {
                logger.error("No se encontró el pedido con id: " + id);
                return null;
            }
        } catch (PersistenceException e) {
            logger.error("Error al actualizar el pedido con id " + id + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public PedidoEntity createPedido(PedidoEntity pedido) {
        logger.info("Inicia creación de pedido en PedidosDaoImpl");

        try {
            double total = 0.0;
            List<ProductoEntity> productosValidos = new ArrayList<>();

            for (Long productoId : pedido.getProductosIds()) {
                ProductoEntity producto = productosFacade.getProducto(productoId);
                if (producto == null) {
                    logger.error("Producto no disponible: " + productoId);
                    return null;
                }
                if (producto.getStock() == null || producto.getStock() <= 0) {
                    logger.error("Producto sin stock: " + productoId);
                    return null;
                }

                total += producto.getPrecio();
                producto.setStock(producto.getStock() - 1);
                productosValidos.add(producto);
            }

            pedido.setTotal(String.valueOf(total));
            pedido.setProductos(productosValidos);

            entityManager.persist(pedido);
            logger.info("Finaliza creación de pedido en PedidosDaoImpl");
            return pedido;
        } catch (PersistenceException e) {
            logger.error("Error al crear el pedido", e);
            return null;
        } catch (Exception e) {
            logger.error("Error inesperado al crear el pedido", e);
            return null;
        }
    }

    private List<ProductoEntity> cargarProductosDesdeIds(List<Long> productosIds) {
        List<ProductoEntity> productos = new ArrayList<>();
        for (Long productoId : productosIds) {
            ProductoEntity producto = productosFacade.getProducto(productoId);
            if (producto != null) {
                productos.add(producto);
            } else {
                logger.error("Producto no encontrado con id: " + productoId);
            }
        }
        return productos;
    }
}
