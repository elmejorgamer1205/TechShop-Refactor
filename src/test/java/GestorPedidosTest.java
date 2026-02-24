import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GestorPedidosTest {

    private GestorPedidos gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorPedidos();
    }

    @ParameterizedTest(name = "Con {0} productos el envío debe ser: {1}")
    @CsvSource({
            "1, Envío Estándar", // Límite inferior Envío Estándar
            "5, Envío Estándar", // Límite inferior Envío Estándar
            "6, Envío Descuento", // Límite inferior Envío Descuento
            "9, Envío Premium", // Límite superior Envío Descuento
            "10, Envío Premium", // Límite inferior Envío Premium
            "15, Envío Premium" // Valor extra por encima del límite
    })
    void evaluarEnvio_valoresFrontera_devuelveEnvioCorrecto(int numeroProductos, String envioEsperado) {
        assertEquals(envioEsperado, gestor.evaluarEnvio(numeroProductos));
    }

    @Test
    void evaluarEnvio_valorCero_lanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.evaluarEnvio(0); // El valor 0 causaba el bug original
        });

        assertEquals("El número de productos debe ser mayor a 0", exception.getMessage());
    }

    @Test
    void evaluarEnvio_valorNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.evaluarEnvio(-1); // Probamos un valor negativo cualquiera
        });
    }

    @Test
    void calcularPrecioTotal_arrayConNulos_losOmiteYCalculaBien() {
        // Orden correcto: String nombre, double precio, int tipo
        Producto p1 = new Producto("Servicio de prueba", 100.0, 3);
        Producto[] productos = { p1, null, null };

        assertEquals(100.0, gestor.calcularPrecioTotal(productos),
                "Debe ignorar los valores null y sumar solo el producto válido");
    }

    @Test
    void calcularPrecioTotal_aplicaImpuestosCorrectamente() {
        // Añadimos nombres de ejemplo y ordenamos: (String, double, int)
        Producto[] productos = {
                new Producto("Procesador", 100.0, 1), // 1 = Componente (+ 21% IVA = 121.0)
                new Producto("Ratón", 100.0, 2),      // 2 = Periférico (+ 10% IVA = 110.0)
                new Producto("Montaje", 100.0, 3)     // 3 = Servicio (Sin IVA = 100.0)
        };

        // Ejecución
        double resultado = gestor.calcularPrecioTotal(productos);

        // Comprobación - Esperamos 331.0
        assertEquals(331.0, resultado, 0.001, "El cálculo de impuestos y suma total es incorrecto");
    }
}


