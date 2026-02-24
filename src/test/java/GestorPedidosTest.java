import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GestorPedidosTest {

    private GestorPedidos gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorPedidos();
    }

    @Test
    void evaluarEnvio_valoresIlogicos_lanzaExcepcion() {
        // Verificamos que el bug está arreglado comprobando el límite 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.evaluarEnvio(0);
        });
        assertEquals("El número de productos debe ser mayor a 0", exception.getMessage());

        // Verificamos también un número negativo
        assertThrows(IllegalArgumentException.class, () -> gestor.evaluarEnvio(-5));
    }

    @ParameterizedTest(name = "Frontera: {0} productos -> {1}")
    @CsvSource({
            "1, Envío Estándar",   // Límite inferior (Estándar)
            "5, Envío Estándar",   // Límite superior (Estándar)
            "6, Envío Descuento",  // Límite inferior (Descuento)
            "9, Envío Descuento",  // Límite superior (Descuento)
            "10, Envío Premium",   // Límite inferior (Premium)
            "15, Envío Premium"    // Valor seguro (Premium)
    })
    void evaluarEnvio_limitesFrontera_devuelveCorrecto(int cantidad, String envioEsperado) {
        // Este tipo de test ejecuta la misma aserción múltiples veces con distintos datos
        assertEquals(envioEsperado, gestor.evaluarEnvio(cantidad));
    }


    @Test
    void calcularPrecioTotal_arrayNulo_devuelveCero() {
        // Aseguramos que el sistema no colapse con un NullPointerException
        assertEquals(0.0, gestor.calcularPrecioTotal(null));
    }

    @Test
    void calcularPrecioTotal_arrayConNulos_losOmiteYCalculaBien() {
        // Orden correcto: String nombre, double precio, int tipo
        Producto p1 = new Producto("Servicio prueba", 100.0, 3);
        Producto[] productos = { p1, null, null };

        assertEquals(100.0, gestor.calcularPrecioTotal(productos), 0.001);
    }

    @Test
    void calcularPrecioTotal_aplicaImpuestosCorrectos() {
        // Añadimos textos al principio para cumplir con el constructor
        Producto[] productos = {
                new Producto("Placa Base", 100.0, 1), // 1 = Componente (21% IVA) -> 121.0
                new Producto("Monitor", 100.0, 2),    // 2 = Periférico (10% IVA) -> 110.0
                new Producto("Garantía", 100.0, 3)    // 3 = Servicio (Sin IVA)   -> 100.0
        };

        // Verificamos la suma final
        double total = gestor.calcularPrecioTotal(productos);
        assertEquals(331.0, total, 0.001);
    }
}