public class Alimento{
    private String nombre;
    private double precio;
    private int codigoBarras;
    private static int codigoBarrasInicial = 576235420;

    public Alimento(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.codigoBarras = codigoBarrasInicial;
        codigoBarrasInicial++;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

}