# Plataforma de Comercio Electrónico Simplificada con Quarkus

Este proyecto es una plataforma de comercio electrónico simplificada, desarrollada con Quarkus, que permite la gestión de catálogo de productos y la gestión de pedidos. Utiliza una arquitectura de microservicios, donde el servicio de pedidos interactúa con el servicio de productos para realizar consultas y operaciones. La persistencia de datos se maneja con una base de datos MySQL.

## Tabla de Contenidos

- [Arquitectura](#arquitectura)
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Levantamiento del Proyecto](#levantamiento-del-proyecto)
- [Descripción de la Base de Datos](#descripción-de-la-base-de-datos)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Configuración](#instalación-y-configuración)

## Arquitectura

La plataforma de comercio electrónico utiliza una **arquitectura de microservicios** que consta de los siguientes componentes principales:

1. **Microservicio de Productos**: Proporciona la información del catálogo de productos. Expone endpoints para consultar y gestionar productos, y se comunica con el microservicio de pedidos para validar la existencia y el stock de productos.

2. **Microservicio de Pedidos**: Se encarga de gestionar los pedidos realizados por los clientes. Este servicio persiste la información del pedido y consulta al microservicio de productos para verificar la disponibilidad de los mismos.

3. **Base de Datos MySQL**: Se utiliza para la persistencia de datos tanto de productos como de pedidos.

### Componentes Tecnológicos

- **Quarkus**: Framework principal para el desarrollo del proyecto, optimizado para un rendimiento y tiempos de arranque rápidos.
- **Jakarta Persistence (JPA)**: Para la gestión de la persistencia de datos.
- **Rest Client de MicroProfile**: Para la comunicación entre microservicios (Pedidos y Productos).
- **MySQL**: Base de datos relacional utilizada para almacenar la información de productos y pedidos.
- **Docker**: Para la contenedorización y despliegue de los microservicios.
- **AWS S3** (Opcional): Utilizado para el almacenamiento de documentos o archivos asociados a los pedidos, con medidas de seguridad para prevenir el borrado accidental.

## Descripción del Proyecto

El objetivo del proyecto es implementar una plataforma de comercio electrónico simplificada con las siguientes características:
- **Gestión de Productos**: Capacidad para añadir, modificar, consultar y eliminar productos del catálogo.
- **Gestión de Pedidos**: Crear pedidos con productos seleccionados, validando la disponibilidad y actualizando el stock de cada producto.
- **Persistencia y Consulta de Datos**: Uso de una base de datos relacional para almacenar la información de productos y pedidos.

### Flujo del Proceso de Pedidos

1. **Creación de Pedido**: Se recibe un pedido que incluye una lista de IDs de productos. El sistema valida la disponibilidad y el stock de cada producto antes de procesar el pedido.
2. **Actualización del Stock**: Se decrementa el stock de los productos correspondientes en el catálogo una vez que el pedido ha sido creado exitosamente.
3. **Persistencia del Pedido**: El pedido se guarda en la base de datos con los detalles y el estado actualizado.

## Levantamiento del Proyecto

Para levantar el proyecto, se sigue el siguiente procedimiento:

1. **Clonar el repositorio**: Descargar el código fuente del proyecto.
2. **Construir el proyecto**:
   ```bash
   ./mvnw clean package

Descripción de la Base de Datos
La base de datos utilizada es MySQL y contiene las siguientes tablas principales:

Tabla de Productos (productos)

id: Identificador único del producto.
nombre: Nombre del producto.
precio: Precio del producto.
stock: Cantidad de unidades disponibles.
descripcion: Descripción detallada del producto.
Tabla de Pedidos (pedidos)

id: Identificador único del pedido.
estado: Estado del pedido (e.g., PENDIENTE, COMPLETADO, CANCELADO).
total: Precio total del pedido.
productosIds: Lista de IDs de productos incluidos en el pedido.
Nota: Los productos del pedido se gestionan a través de sus IDs, y la información detallada del producto se consulta mediante el servicio de productos.

Requisitos Previos
Java 17+
Maven 3.6.3+
Docker
MySQL 8.0+
Quarkus CLI (Opcional, para facilitar el desarrollo)

