package org.products.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.products.dao.contract.IProductoDAO;
import org.products.dao.entity.ProductsEntity;

import java.util.List;

@ApplicationScoped
public class ProductDAOImpl implements IProductoDAO {

    @Inject
    EntityManager entityManager;

    @Inject
    Logger logger;

    @Override
    @Transactional
    public void deleteProducto(Long id) {
        logger.info("Inicia eliminación de producto en ProductsDaoImpl");
        try {
            ProductsEntity product = entityManager.find(ProductsEntity.class, id);
            if (product != null) {
                entityManager.remove(product);
            }
        } catch (PersistenceException e) {
            logger.error("Error al eliminar el producto con id " + id, e);
        } catch (Exception e) {
            logger.error("Error inesperado al eliminar el producto con id " + id, e);
        }
    }

    @Override
    public ProductsEntity getProducto(Long id) {
        logger.info("Inicia búsqueda de producto en ProductsDaoImpl");
        try {
            return entityManager.find(ProductsEntity.class, id);
        } catch (PersistenceException e) {
            logger.error("Error al buscar el producto con id " + id, e);
            return null;
        } catch (Exception e) {
            logger.error("Error inesperado al buscar el producto con id " + id, e);
            return null;
        }
    }

    @Override
    public List<ProductsEntity> getAllProductos() {
        logger.info("Inicia búsqueda de productos en ProductsDaoImpl");
        try {
            return entityManager.createQuery("SELECT p FROM ProductsEntity p", ProductsEntity.class).getResultList();
        } catch (PersistenceException e) {
            logger.error("Error al obtener la lista de productos", e);
            return List.of();
        } catch (Exception e) {
            logger.error("Error inesperado al obtener la lista de productos", e);
            return List.of();
        }
    }

    @Override
    @Transactional
    public ProductsEntity updateProducto(Long id, ProductsEntity producto) {
        logger.info("Inicia actualización de producto en ProductsDaoImpl");
        try {
            ProductsEntity existingProduct = entityManager.find(ProductsEntity.class, id);
            if (existingProduct != null) {
                existingProduct.nombre = producto.nombre;
                existingProduct.descripcion = producto.descripcion;
                existingProduct.stock = producto.stock;
                existingProduct.precio = producto.precio;
                entityManager.merge(existingProduct);
            }
            return existingProduct;
        } catch (PersistenceException e) {
            logger.error("Error al actualizar el producto con id " + id, e);
            return null;
        } catch (Exception e) {
            logger.error("Error inesperado al actualizar el producto con id " + id, e);
            return null;
        }
    }

    @Override
    @Transactional
    public ProductsEntity createProducto(ProductsEntity producto) {
        logger.info("Inicia creación de producto en ProductsDaoImpl");
        try {
            entityManager.persist(producto);
            return producto;
        } catch (PersistenceException e) {
            logger.error("Error al crear el producto", e);
            return null;
        } catch (Exception e) {
            logger.error("Error inesperado al crear el producto", e);
            return null;
        }
    }

    @Override
    public ProductsEntity findById(Long id) {
        logger.info("Inicia búsqueda de producto en ProductsDaoImpl");
        try {
            return entityManager.find(ProductsEntity.class, id);
        } catch (PersistenceException e) {
            logger.error("Error al buscar el producto con id " + id, e);
            return null;
        } catch (Exception e) {
            logger.error("Error inesperado al buscar el producto con id " + id, e);
            return null;
        }
    }
}
