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

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}