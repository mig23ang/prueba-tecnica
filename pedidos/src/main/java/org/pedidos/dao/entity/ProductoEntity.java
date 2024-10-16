package org.pedidos.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer stock;

}
