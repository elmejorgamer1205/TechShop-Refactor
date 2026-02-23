// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    private String nombre;
    private double precio;
    private int tipo; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public Producto(String n, double p, int t) {
        this.nombre = n;
        this.precio = p;
        this.tipo = t;
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