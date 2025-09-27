public class Alimento{
    private String nombreAlimento;
    private double precio;
    private int codigoBarras;
    private static int codigoBarrasInicial = 576235420;

    public Alimento(String nombreAlimento, double precio){
        this.nombreAlimento = nombreAlimento;
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

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }


}