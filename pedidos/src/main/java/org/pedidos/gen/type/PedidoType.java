package org.pedidos.gen.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.pedidos.gen.type.ProductoType;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("PedidoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-10-16T15:12:08.326193900-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public class PedidoType   {
  private Long id;
  private List<ProductoType> productos;
  private List<Long> productosIds = new ArrayList<>();
  private Float total;
  public enum EstadoEnum {

    PENDIENTE(String.valueOf("PENDIENTE")), PROCESANDO(String.valueOf("PROCESANDO")), COMPLETADO(String.valueOf("COMPLETADO")), CANCELADO(String.valueOf("CANCELADO"));


    private String value;

    EstadoEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
    public static EstadoEnum fromString(String s) {
        for (EstadoEnum b : EstadoEnum.values()) {
            // using Objects.toString() to be safe if value type non-object type
            // because types like 'int' etc. will be auto-boxed
            if (java.util.Objects.toString(b.value).equals(s)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected string value '" + s + "'");
    }

    @JsonCreator
    public static EstadoEnum fromValue(String value) {
        for (EstadoEnum b : EstadoEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  private EstadoEnum estado;

  /**
   **/
  public PedidoType id(Long id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public PedidoType productos(List<ProductoType> productos) {
    this.productos = productos;
    return this;
  }

  
  @JsonProperty("productos")
  public List<ProductoType> getProductos() {
    return productos;
  }

  @JsonProperty("productos")
  public void setProductos(List<ProductoType> productos) {
    this.productos = productos;
  }

  public PedidoType addProductosItem(ProductoType productosItem) {
    if (this.productos == null) {
      this.productos = new ArrayList<>();
    }

    this.productos.add(productosItem);
    return this;
  }

  public PedidoType removeProductosItem(ProductoType productosItem) {
    if (productosItem != null && this.productos != null) {
      this.productos.remove(productosItem);
    }

    return this;
  }
  /**
   **/
  public PedidoType productosIds(List<Long> productosIds) {
    this.productosIds = productosIds;
    return this;
  }

  
  @JsonProperty("productosIds")
  public List<Long> getProductosIds() {
    return productosIds;
  }

  @JsonProperty("productosIds")
  public void setProductosIds(List<Long> productosIds) {
    this.productosIds = productosIds;
  }

  public PedidoType addProductosIdsItem(Long productosIdsItem) {
    if (this.productosIds == null) {
      this.productosIds = new ArrayList<>();
    }

    this.productosIds.add(productosIdsItem);
    return this;
  }

  public PedidoType removeProductosIdsItem(Long productosIdsItem) {
    if (productosIdsItem != null && this.productosIds != null) {
      this.productosIds.remove(productosIdsItem);
    }

    return this;
  }
  /**
   **/
  public PedidoType total(Float total) {
    this.total = total;
    return this;
  }

  
  @JsonProperty("total")
  public Float getTotal() {
    return total;
  }

  @JsonProperty("total")
  public void setTotal(Float total) {
    this.total = total;
  }

  /**
   **/
  public PedidoType estado(EstadoEnum estado) {
    this.estado = estado;
    return this;
  }

  
  @JsonProperty("estado")
  public EstadoEnum getEstado() {
    return estado;
  }

  @JsonProperty("estado")
  public void setEstado(EstadoEnum estado) {
    this.estado = estado;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PedidoType pedidoType = (PedidoType) o;
    return Objects.equals(this.id, pedidoType.id) &&
        Objects.equals(this.productos, pedidoType.productos) &&
        Objects.equals(this.productosIds, pedidoType.productosIds) &&
        Objects.equals(this.total, pedidoType.total) &&
        Objects.equals(this.estado, pedidoType.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productos, productosIds, total, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PedidoType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productos: ").append(toIndentedString(productos)).append("\n");
    sb.append("    productosIds: ").append(toIndentedString(productosIds)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

