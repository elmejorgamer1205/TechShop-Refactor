TechShop - Sistema de Gestión de Pedidos

Este proyecto es para gestionar pedidos de la tienda TechShop. El sistema procesa los productos del carrito de la compra, calcula los importes totales con los impuestos correspondientes y determina la logística de envío óptima según el volumen del pedido.


Características Principales

El sistema se enfoca en dos áreas del proceso de compra:

1. Cálculo de Importes e Impuestos

El sistema calcula el precio total de los productos, omitiendo las posiciones vacías y aplicando el impuesto correspondiente:

- Componentes: 21% de impuesto.

- Periféricos: 10% de impuesto.

- Servicios: sin impuesto.

2. Evaluación de Logística de Envío

El sistema asigna una categoría de envío según el número de artículos:

- Envío Estandar: 1 a 5 productos.

- Envío Descuento: 6 a 9 productos.

- Envío Premium: 10 productos o más.


Seguridad

El sistema incluye una validación que bloquea valores ilógicos, como 0 o números negativos, y lanza una excepción para evitar comportamientos inesperados.


Estructura de Clases

- Producto.java: representa un artículo de la tienda con atributos como nombre, precio y tipo.

- GestorPedidos.java: contiene la lógica de negocio para calcular precios y evaluar envíos.

- GestorPedidosTest.java: pruebas unitarias para asegurar la calidad del software.


Pruebas

El proyecto incluye pruebas unitarias para garantizar la integridad de la lógica de negocio. Se utilizan diferentes enfoques de testing:

- Tests Parametrizados: para validar valores límite y fronterizos.

- Tests de Excepciones: para verificar el comportamiento con datos inválidos.

- Tests de Estado: para comprobar la aplicación del impuesto y la resistencia del código.


Tecnologías y Herramientas

- Lenguaje: Java.

- Testing: JUnit 5.

- Gestor de Dependencias: Maven.

- Documentación: JavaDoc.


Autores

El código fue desarrollado por:

- Javier Garrocho.

- Moisés Cabanillas.

- Alejandro Hernández.

- Carlos Simoes.
