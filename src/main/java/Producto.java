/**
 * Clase que representa un producto de la tienda TechShop.
 *
 * @author Javier Garrocho, Moisés Cabanillas, Alejandro Hernández, Carlos Simoes
 * @version 1.0
 */
// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    private String nombre;
    private double precio;
    private int tipo; // 1 = Componente, 2 = Periférico, 3 = Servicio

    /**
     * Constructor que inicializa un producto con todos sus atributos.
     *
     * @author Javier Garrocho, Moisés Cabanillas, Alejandro Hernández, Carlos Simoes
     * @param nombre El nombre descriptivo del producto (ej: "Intel i9")
     * @param precio El precio base del producto sin impuestos aplicados
     * @param tipo La categoría del producto (1=Componente, 2=Periférico, 3=Servicio)
     */

    public Producto(String nombre, double precio, int tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}