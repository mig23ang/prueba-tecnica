package org.pedidos.gen.type;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ProductoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-10-16T15:12:08.326193900-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public class ProductoType   {
  private Long id;
  private String nombre;
  private String descripcion;
  private Integer precio;

  /**
   **/
  public ProductoType id(Long id) {
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
  public ProductoType nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  @JsonProperty("nombre")
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   **/
  public ProductoType descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  
  @JsonProperty("descripcion")
  public String getDescripcion() {
    return descripcion;
  }

  @JsonProperty("descripcion")
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   **/
  public ProductoType precio(Integer precio) {
    this.precio = precio;
    return this;
  }

  
  @JsonProperty("precio")
  public Integer getPrecio() {
    return precio;
  }

  @JsonProperty("precio")
  public void setPrecio(Integer precio) {
    this.precio = precio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductoType productoType = (ProductoType) o;
    return Objects.equals(this.id, productoType.id) &&
        Objects.equals(this.nombre, productoType.nombre) &&
        Objects.equals(this.descripcion, productoType.descripcion) &&
        Objects.equals(this.precio, productoType.precio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, descripcion, precio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductoType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    precio: ").append(toIndentedString(precio)).append("\n");
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

