package org.products.services.contract;

import org.products.gen.type.ProductoType;

import java.util.List;

public interface IProductoService {

    void deleteProducto(Long id);

    ProductoType getProducto(Long id);

    List<ProductoType> getAllProductos();

    ProductoType updateProducto(Long id, ProductoType producto);

    ProductoType createProducto(ProductoType producto);

    ProductoType findById(Long id);
}
