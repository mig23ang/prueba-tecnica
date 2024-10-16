package org.products.utils;

import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
import org.products.dao.entity.ProductsEntity;
import org.products.gen.type.ProductoType;

@ApplicationScoped
public class MapperProducto {

    public ProductoType productoEntityToProductType(ProductsEntity productEntity) {

        return new ModelMapper().map(productEntity, ProductoType.class);
    }

    public ProductsEntity producTypeToEntity(ProductoType product) {

        return new ModelMapper().map(product, ProductsEntity.class);
    }
}