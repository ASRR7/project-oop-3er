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

    public void mostrarInfo(){
        System.out.println("====================================");
        System.out.println("ID: "+ this.getId());
        System.out.println("Nombre: "+ this.getNombre());
        System.out.println("Cuenta: "+ this.getCuenta());
    }

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

    public void printLibrosRentados(){
        System.out.println("============================\nLibros rentados:");
        for(Libro libro: this.getLibrosRentados()){
            System.out.println(libro.toString());
        }
    }

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
}