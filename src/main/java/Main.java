public class Main {
    public static void main(String[] args) {
        GestorPedidos g = new GestorPedidos();

        // Array con huecos (provocará error en el bucle for.)
        Producto[] lista = new Producto[3];
        lista[0] = new Producto("Intel i9", 450, 1);
        lista[1] = new Producto("Razer Mouse", 50, 2);
        // lista[2] es NULL

        System.out.println("Iniciando procesamiento...");

        double total = g.calcularPrecioTotal(lista);
        System.out.println("Total del pedido: " + total + " €");
        System.out.println("Tipo de envío: " + g.evaluarEnvio(lista.length));
    }
}