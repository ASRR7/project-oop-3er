package proyecto;
import java.util.ArrayList;

/**
 * <h2>Clase Cliente</h2>
 * 
 * @author Equipo 13
 * @version 1.0
 */
public class Cliente{
    public static int idContador = 0;
    private int id;
    private String nombre;
    private ArrayList<Libro> librosRentados;
    private double cuenta;
    /**
     * <h2>Constructor Cliente</h2>
     * <p>
     * Crea un objeto de tipo Cliente con el atributo nombre. Además, asigna un 
     * id automáticamente y le crea un ArrayList de libros rentados
     * </p>
     *
     * @param nombre es el nombre del cliente
     * @author Equipo 13
     * @version 1.0
     */
    Cliente(String nombre){
        idContador++;
        this.id = idContador;
        this.nombre = nombre;
        this.librosRentados = new ArrayList<>();
    }
    /**
     * <h2>Metodo getId</h2>
     * <p>
     * Devuelve el id del cliente.
     * </p>
     *
     * @return id del cliente
     * @author Equipo 13
     * @version 1.0
     */

    public int getId() {
        return id;
    }
    /**
     * <h2>Metodo getNombre</h2>
     * <p>
     * Devuelve el nombre del cliente.
     * </p>
     *
     * @return nombre del cliente
     * @author Equipo 13
     * @version 1.0
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * <h2>Metodo setNombre</h2>
     * <p>
     * Hace autoreferencia al nombre del cliente para modificarlo.
     * </p>
     *
     * @param nombre nuevo del cliente
     * @author Equipo 13
     * @version 1.0
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * <h2>Metodo getLibrosRentados</h2>
     * <p>
     * Devuelve el arreglo de libros rentados del cliente.
     * </p>
     *
     * @return librosRentados son los libros que el cliente ha rentado
     * @author Equipo 13
     * @version 1.0
     */
    public ArrayList<Libro> getLibrosRentados() {
        return librosRentados;
    }
    /**
     * <h2>Metodo setLibrosRentados</h2>
     * <p>
     * Hace autoreferencia al arreglo de librosRentados del cliente para modificarlo.
     * </p>
     *
     * @param librosRentados son los libros que el cliente ha rentado
     * @author Equipo 13
     * @version 1.0
     */
    public void setLibrosRentados(ArrayList<Libro> librosRentados) {
        this.librosRentados = librosRentados;
    }
    /**
     * <h2>Metodo getCuenta</h2>
     * <p>
     * Devuelve la cuenta a pagar del cliente.
     * </p>
     *
     * @return cuenta del cliente
     * @author Equipo 13
     * @version 1.0
     */

    public double getCuenta() {
        return cuenta;
    }
    /**
     * <h2>Metodo setCuenta</h2>
     * <p>
     * Hace autoreferencia a la cuenta del cliente para modificarlo.
     * </p>
     *
     * @param cuenta nuevo del cliente
     * @author Equipo 13
     * @version 1.0
     */

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * <h2> Metodo mostrarInfo </h2>
     * <p>
     * Imprime en consola el id, nombre y cuenta a pagar del cliente.
     * </p>
     * @author Equipo 13
     * @version 1.0
     * */
    public void mostrarInfo(){
        System.out.println("====================================");
        System.out.println("ID: "+ this.getId());
        System.out.println("Nombre: "+ this.getNombre());
        System.out.println("Cuenta: "+ this.getCuenta());
    }

    /**
     * <h2> Metodo pagarCuenta </h2>
     * <p>
     * Recibe el pago del cliente, si no es suficiente no lo acepta.
     * Si es igual o mayor a la cantidad a pagar lo recibe, deja la cuenta en 0.0 y da el cambio.
     * </p>
     * @param pago es la cantidad que va a pagar el cliente
     * @author Equipo 13
     * @version 1.0
     * */
    public void pagarCuenta(double pago){
        double cambio = 0;
        double cuenta = this.getCuenta();
        if(pago>=cuenta){
            cambio = pago - cuenta;
            System.out.println("Cuenta pagada. ($" + cuenta + ")");
            this.setCuenta(0);
            System.out.println("Cambio: $" + cambio);
        } else{
            System.out.println("Pago insuficiente");
        }
    }

    /**
     * <h2> Metodo cobrar </h2>
     * <p>
     * Agrega un cierto cobro a la cuenta del cliente.
     * </p>
     * @param cobro la cantidad a agregar a la cuenta
     * @author Equipo 13
     * @version 1.0
     * */
    public void cobrar(double cobro){
        double cuenta = this.getCuenta();
        if (cobro>0){
            cuenta += cobro;
            this.setCuenta(cuenta);
        } else {
            System.out.println("Cobro erroneo.");
        }
        System.out.println("Su cuenta actual es de: $"+ cuenta);
    }

    /**
     * <h2> Metodo loTengoRentado </h2>
     * <p>
     * Revisa dentro de los libros rentados para buscar una coincidencia de id
     * con el parámetro.
     * </p>
     * @param libro el objeto (Libro) a buscar
     * @author Equipo 13
     * @version 1.0
     * @return boolean para saber si está dentro de los libros rentados
     * @see Libro
     * */
    public boolean loTengoRentado(Libro libro){
        for(Libro libroR : this.getLibrosRentados()){
            if( libro.getId() == libroR.getId() ){
                return true;
            }
        }
        return false;
    }

    /**
     * <h2> Metodo rentarLibro </h2>
     * <p>
     * Actualiza el estatus del libro a "No disponible" dentro del estante correspondiente
     * y después usa el método add() de ArrayList. 
     * </p>
     * @param libroRentado el objeto (Libro) para rentar
     * @param inventario es el objeto (Inventario) principal en el que se realizan las operaciones
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * @see Inventario
     * @see Estante
     * */
    public void rentarLibro(Libro libroRentado, Inventario inventario){
        Estante estante = inventario.getEstantes().get(libroRentado.getGenero());

        for ( Libro libro : estante.getLibros() ) {
            if ( libroRentado.getISBN() == libro.getISBN() ){
                estante.hacerNoDisponible(libroRentado);
                librosRentados.add(libroRentado);
                break;
            }
        }

    }


    /**
     * <h2> Metodo devolverLibro </h2>
     * <p>
     * Actualiza el estatus del libro a "Disponible" dentro del estante correspondiente
     * y después usa el método quitarLibro().
     * </p>
     * @param libroRentado el objeto (Libro) para devolver
     * @param inventario es el objeto (Inventario) principal en el que se realizan las operaciones
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * @see Inventario
     * @see Estante
     * */
    public void devolverLibro(Libro libroRentado, Inventario inventario){
        Estante estante = inventario.getEstantes().get(libroRentado.getGenero());

        for ( Libro libro : estante.getLibros() ) {
            if ( libroRentado.getId() == libro.getId() ){
                estante.hacerDisponible(libroRentado);
                this.quitarLibro(libroRentado);
                break;
            }
        }
    }

    /**
     * <h2> Metodo quitarLibro </h2>
     * <p>
     * Itera sobre los libros rentados y revisa el id de cada libro rentado
     * cuando encuentra el que coincide con el parametro, lo remueve.
     * </p>
     * @param libroRentado el objeto (Libro) para quitar
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void quitarLibro(Libro libroRentado){
        int contador = 0;
        int id = libroRentado.getId();
        for(Libro libro: librosRentados){
            if ( id == libro.getId()){
                this.librosRentados.remove(contador);
                break;
            }
            contador++;
        }
        
    }

    /**
     * <h2> Metodo printLibrosRentados </h2>
     * <p>
     * Itera sobre los libros rentados y de cada uno
     * usa el metodo toString() de Libro para imprimir su información.
     * </p>
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void printLibrosRentados(){
        System.out.println("============================\nLibros rentados:");
        for(Libro libro: this.getLibrosRentados()){
            System.out.println(libro.toString());
        }
        System.out.println("------------------------------------");
    }
}