import java.util.ArrayList;

/**
 * CÓDIGO LEGACY - PROYECTO TECHSHOP
 * * Esta clase contiene la lógica de negocio antigua que debe ser refactorizada.
 * Está llena de "Code Smells" (malas prácticas) y errores de diseño intencionados
 * para que los alumnos practiquen la limpieza de código y el uso de Linters.
 */
public class GestorPedidos {

    /**
     * ERROR 1: Naming (Nombrado) - El nombre 'calcular' es muy genérico.
     * FUNCIONALIDAD: Este método recibe una lista de productos, recorre cada uno, determina su tipo,
     * le aplica el impuesto correspondiente (IVA) y suma todos los importes para obtener el coste final del pedido.
     * DEBERÍA HACERSE: Renombrar el método para que refleje esta operación de cálculo total con impuestos.
     */

    private static final int TIPO_COMPONENTE = 1;
    private static final int TIPO_PERIFERICO = 2;
    private static final int TIPO_SERVICIO = 3;

    private static final double IVA_COMPONENTE = 1.21;
    private static final double IVA_PERIFERICO = 1.10;
    private static final double UMBRAL_PEDIDO_GRANDE = 1000.0;


    public double calcularPrecioTotal(Producto[] productos) {
        double acumuladorPrecioTotal = 0; // Nombre de variable más descriptivo

        if (productos == null) {
            return 0;
        }

        for (Producto p : productos) {
            // Solución al ERROR 3: Control de nulos
            if (p == null) {
                continue;
            }

            // Solución al ERROR 4: Uso de constantes en lugar de números mágicos
            if (p.getTipo() == TIPO_COMPONENTE) {
                acumuladorPrecioTotal += p.getPrecio() * IVA_COMPONENTE;
            } else if (p.getTipo() == TIPO_PERIFERICO) {
                acumuladorPrecioTotal += p.getPrecio() * IVA_PERIFERICO;
            } else if (p.getTipo() == TIPO_SERVICIO) {
                acumuladorPrecioTotal += p.getPrecio();
            }
        }

        // Solución al ERROR 5: Devolver el valor
        return acumuladorPrecioTotal;
    }

        // ERROR 5: Responsabilidad Única / Salida por Consola
        // Este método mezcla la lógica de cálculo con la presentación de datos por consola.
        // Esto limita la reutilización del código, ya que no permite obtener el resultado para usarlo en otra parte.
        // DEBERÍA HACERSE: Modificar el método para que devuelva el dato calculado en lugar de imprimirlo.
        if (precioTotal > 1000) {
            System.out.println("Pedido Grande: " + precioTotal);
        } else {
            System.out.println("Pedido Normal: " + precioTotal);
        }

        try {
            // Simulación de envío a base de datos legacy
            // Esto provocará una ArithmeticException (división por cero) intencionada
            int check = 10 / 0;
        } catch (Exception e) {
            // ERROR 6: Silenciamiento de Excepciones (Swallowed Exception)
            // Se captura la excepción pero no se hace nada con ella. El error pasa desapercibido.
            // DEBERÍA HACERSE: Gestionar la excepción adecuadamente, registrando el error (Log) o notificándolo.
        }
    }

    // ERROR 7: Código Muerto (Dead Code)
    // El análisis del código revela que este método nunca es invocado desde ninguna parte del proyecto.
    // DEBERÍA HACERSE: Eliminar el código innecesario para mantener el proyecto limpio.
    public boolean checkStock(String n) {
        return true;
    }

    /**
     * ERROR 8: Bug Lógico en Límites (Boundary Testing)
     * La lógica condicional deja un caso sin cubrir explícitamente, provocando un comportamiento erróneo.
     * Analiza qué ocurre exactamente cuando el número de productos coincide con el valor frontera (5).
     * * DEBERÍA HACERSE: Ajustar los operadores de comparación para asegurar que todos los casos posibles están cubiertos correctamente.
     */
    public String evaluarEnvio(int numeroProductos) {
        if (numeroProductos < 5) {
            return "Envio Estandar";
        } else if (numeroProductos > 5 && numeroProductos < 10) {
            return "Envio Descuento";
        } else {
            return "Envio Premium";
        }
    }
}