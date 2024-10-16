package org.products.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.products.dao.entity.ProductsEntity;
import org.products.dao.impl.ProductDAOImpl;
import org.products.gen.type.ProductoType;
import org.products.services.contract.IProductoService;
import org.products.utils.MapperProducto;

@ApplicationScoped
public class ProductsService implements IProductoService {

    @Inject
    ProductDAOImpl productoDAO;

    @Inject
    MapperProducto mapperProducto;

    @Inject
    Logger logger;

    @Override
    public void deleteProducto(Long id) {
        logger.info("inicia eliminacion de producto en ProductsService");
        productoDAO.deleteProducto(id);
    }

    @Override
    public ProductoType getProducto(Long id) {
        logger.info("inicia busqueda de producto en ProductsService");
        ProductsEntity productEntity = productoDAO.getProducto(id);
        logger.info("termina busqueda de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(productEntity);
    }

    @Override
    public List<ProductoType> getAllProductos() {
        logger.info("Inicia búsqueda de productos en ProductsService");
        List<ProductsEntity> productsEntityList = productoDAO.getAllProductos();
        logger.info("Termina búsqueda de productos en ProductsService");
        return productsEntityList.stream()
                .map(mapperProducto::productoEntityToProductType)
                .collect(Collectors.toList());
    }


    @Override
    public ProductoType updateProducto(Long id, ProductoType producto) {
        logger.info("inicia actualizacion de producto en ProductsService");
        ProductsEntity productEntity = mapperProducto.producTypeToEntity(producto);
        ProductsEntity updatedProduct = productoDAO.updateProducto(id, productEntity);
        logger.info("termina actualizacion de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(updatedProduct);
    }

    @Override
    public ProductoType createProducto(ProductoType producto) {
        logger.info("inicia creacion de producto en ProductsService");

        ProductsEntity productEntity = mapperProducto.producTypeToEntity(producto);
        ProductsEntity createdProduct = productoDAO.createProducto(productEntity);
        logger.info("termina creacion de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(createdProduct);

    }

    @Override
    public ProductoType findById(Long id) {
        logger.info("inicia busqueda de producto por id en ProductsService");
        ProductsEntity productEntity = productoDAO.findById(id);
        logger.info("termina busqueda de producto por id en ProductsService");
        return mapperProducto.productoEntityToProductType(productEntity);
    }
}
