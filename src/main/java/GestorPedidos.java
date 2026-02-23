/**
 * Clase encargada de gestionar la lógica de negocio de los pedidos de TechShop.
 * Se encarga de cálculos de importes, impuestos y evaluación de logística de envíos.
 * * @author Javier Garrocho, Moisés Cabanillas, Alejandro Hernández, Carlos Simoes
 */
public class GestorPedidos {

    private static final int TIPO_COMPONENTE = 1;
    private static final int TIPO_PERIFERICO = 2;
    private static final int TIPO_SERVICIO = 3;

    private static final double IVA_COMPONENTE = 1.21;
    private static final double IVA_PERIFERICO = 1.10;

    /**
     * Calcula el precio total de un array de productos, aplicando el IVA
     * según su categoría y omitiendo posiciones vacías.
     * * @param productos Array de productos del pedido.
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
     * Determina el tipo de envío basado en el volumen de productos.
     * * @param numeroProductos Cantidad total de artículos en el carrito.
     * @return Etiqueta del tipo de envío (Estandar, Descuento o Premium).
     */
    public String evaluarEnvio(int numeroProductos) {
        if (numeroProductos <= 5) {
            return "Envio Estandar";
        } else if (numeroProductos < 10) {
            return "Envio Descuento";
        } else {
            return "Envio Premium";
        }
    }
}