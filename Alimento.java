public class Alimento{
    private String nombre;
    private double precio;
    private int codigoBarras;
    private static int codigoBarrasInicial = 576235420;
    /**
     * <h2>Constructor Alimento</h2>
     * <p>
     * Crea un objeto de tipo Alimento asignándole nombre, precio y un
     * código de barras único generado automáticamente.
     * </p>
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
     * <p>
     * Devuelve el precio del alimento.
     * </p>
     * @return precio del alimento
     * @author Equipo 13
     * @version 1.0
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * <h2>Metodo setPrecio</h2>
     * <p>
     * Hace autoreferencia al precio del alimento para modificarlo. 
     * </p>
     * @param precio nuevo del alimento
     * @author Equipo 13
     * @version 1.0
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * <h2>Metodo getNombre</h2>
     * <p>
     * Devuelve el nombre del alimento.
     * </p>
     * @return nombre del alimento
     * @author Equipo 13
     * @version 1.0
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * <h2>Metodo setNombre</h2>
     * <p>
     * Hace autoreferencia al nombre del alimento para modificarlo.
     * </p>
     * @param nuevo nombre del alimento
     * @author Equipo 13
     * @version 1.0
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * <h2>Metodo getCodigoBarras</h2>
     * <p>
     * Devuelve el código de barras del alimento.
     * </p>
     * @return código de barras del alimento.
     * @author Equipo 13
     * @version 1.0
     */
    public int getCodigoBarras() {
        return codigoBarras;
    }
}