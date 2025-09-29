public class Alimento{
    private String nombre;
    private double precio;
    private int codigoBarras;
    private static int codigoBarrasInicial = 576235420;
    /**
     * <h2>Constructor Alimento</h2>
     * <p>
     * Inicializa un objeto de tipo Alimento asignándole nombre, precio y un
     * código de barras único generado automáticamente.
     *
     * @param nombre el nombre del alimento
     * @param precio el precio del alimento
     * @author Equipo 13
     * @version 1.0
     * @see Alimento
     */
    public Alimento(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.codigoBarras = codigoBarrasInicial;
        codigoBarrasInicial++;
    }
    /**
     * <h2>Metodo getPrecio</h2>
     * Devuelve el precio del alimento.
     * @return precio del alimento
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * <h2>Metodo setPrecio</h2>
     * Hace autoreferencia al precio del alimento para modificarlo. 
     * @param precio nuevo del alimento
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * <h2>Metodo getNombre</h2>
     * Devuelve el nombre del alimento.
     * @return nombre del alimento
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * <h2>Metodo setNombre</h2>
     * Hace autoreferencia al nombre del alimento para modificarlo.
     * @param nuevo nombre del alimento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * <h2>Metodo getCodigoBarras</h2>
     * Devuelve el código de barras del alimento.
     * @return código de barras del alimento.
     */
    public int getCodigoBarras() {
        return codigoBarras;
    }
}