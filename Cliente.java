import java.util.ArrayList;

public class Cliente{
    public static int idContador = 0;
    private int id;
    private String nombre;
    private ArrayList<Libro> librosRentados;
    private double cuenta;

    Cliente(String nombre){
        idContador++;
        this.id = idContador;
        this.nombre = nombre;
        this.librosRentados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibrosRentados() {
        return librosRentados;
    }

    public void setLibrosRentados(ArrayList<Libro> librosRentados) {
        this.librosRentados = librosRentados;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * <h2> Metodo mostrarInfo </h2>
     * <p>
     * Imprime en consola el id, nombre y cuenta a pagar del cliente.
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
     * Si es igual o mayor a la cantidad a pagar lo recibe, deja la cuenta en 0.0 y da el cambio
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
     * y después usa el método add() de ArrayList
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
     * y después usa el método quitarLibro()
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
     * usa el metodo toString() de Libro para imprimir su información
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