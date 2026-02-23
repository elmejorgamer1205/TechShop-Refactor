// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    private String n;
    private double p;
    private int t; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public Producto(String n, double p, int t) {
        this.n = n;
        this.p = p;
        this.t = t;
    }
}