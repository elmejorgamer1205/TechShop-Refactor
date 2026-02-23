/**
 * Clase encargada de gestionar la lógica de negocio de los pedidos de TechShop.
 * Se encarga de cálculos de importes, impuestos y evaluación de logística de envíos.
 * * @author Javier Garrocho, Moisés Cabanillas, Alejandro Hernández, Carlos Simoes
 */
public class GestorPedidos {

    // Constantes para tipos de producto
    private static final int TIPO_COMPONENTE = 1;
    private static final int TIPO_PERIFERICO = 2;
    private static final int TIPO_SERVICIO = 3;

    // Constantes de IVA por categoría
    private static final double IVA_COMPONENTE = 1.21;
    private static final double IVA_PERIFERICO = 1.10;

    // Constantes para los umbrales de evaluación de envío
    private static final int LIMITE_ENVIO_ESTANDAR = 5;
    private static final int LIMITE_ENVIO_PREMIUM  = 10;

    /**
     * Calcula el precio total de un array de productos, aplicando el IVA
     * según su categoría y omitiendo posiciones vacías.
     * @param productos Array de productos del pedido.
     * @return Suma total de los precios con impuestos.
     */
    public double calcularPrecioTotal(Producto[] productos) {
        double acumuladorPrecioTotal = 0;

        if (productos == null) {
            return 0;
        }

        for (Producto p : productos) {
            if (p == null) {
                continue;
            }

            if (p.getTipo() == TIPO_COMPONENTE) {
                acumuladorPrecioTotal += p.getPrecio() * IVA_COMPONENTE;
            } else if (p.getTipo() == TIPO_PERIFERICO) {
                acumuladorPrecioTotal += p.getPrecio() * IVA_PERIFERICO;
            } else if (p.getTipo() == TIPO_SERVICIO) {
                acumuladorPrecioTotal += p.getPrecio();
            }
        }

        return acumuladorPrecioTotal;
    }

    /**
     * Determina el tipo de envío asignado al pedido según el número de
     * productos que contiene, aplicando las reglas logísticas de TechShop.
     *
     * @author Javier Garrocho, Moisés Cabanillas, Alejandro Hernández, Carlos Simoes
     * @param numeroProductos La cantidad total de artículos incluidos en el pedido
     * @return Una cadena de texto con la etiqueta del tipo de envío:
     *         "Envio Estandar" para menos de 5 productos (inclusive),
     *         "Envio Descuento" para entre 6 y 9 productos,
     *         "Envio Premium" para 10 o más productos
     */
    public String evaluarEnvio(int numeroProductos) {
        if (numeroProductos <= LIMITE_ENVIO_ESTANDAR) {
            return "Envio Estandar";
        } else if (numeroProductos < LIMITE_ENVIO_PREMIUM) {
            return "Envio Descuento";
        } else {
            return "Envio Premium";
        }
    }
}