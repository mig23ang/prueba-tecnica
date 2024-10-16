package org.products.dao.contract;

import org.products.dao.entity.ProductsEntity;
import java.util.List;


public interface IProductoDAO  {

    void deleteProducto(Long id);

    ProductsEntity getProducto(Long id);

    List<ProductsEntity> getAllProductos();

    ProductsEntity updateProducto(Long id, ProductsEntity producto);

    ProductsEntity createProducto(ProductsEntity producto);

    ProductsEntity findById(Long id);

}
