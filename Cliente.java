import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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

    public void mostrarInfo(){
        System.out.println("====================================");
        System.out.println("ID: "+ id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Cuenta: "+ cuenta);
    }

    public void pagarCuenta(double pago){
        double cambio = 0;
        if(pago>=cuenta){
            cambio = cuenta - pago;
            System.out.println("Cuenta pagada. ($" + cuenta + ")");
            cuenta -= pago;
            System.out.println("Cambio: $" + cambio);
        } else{
            System.out.println("Pago insuficiente");
        }
    }

    public void cobrar(double cobro){
        if (cobro>0){
            cuenta += cobro;
        } else {
            System.out.println("Cobro erroneo.");
        }
        System.out.println("Su cuenta actual es de: "+ cuenta);
    }

    public void agregarLibro(Libro nuevoLibro){
        librosRentados.add(nuevoLibro);
    }
    /*
    * To do :Agregar metodo para devolver libro a inventario
    * */
    public void rentarLibro(Libro libroRentado, Inventario inventario){
        Estante estante = inventario.getEstanteGenero(libroRentado.getGenero());

        for ( Libro libro : estante.getLibros() ) {
            if ( libroRentado.getISBN() == libro.getISBN() ){
                estante.hacerNoDisponible(libroRentado);
                librosRentados.add(libroRentado);
                break;
            }
        }

    }
    public void devolverLibro(Libro libroRentado, Inventario inventario){
        HashMap<String, Estante> estantes = inventario.getEstantes();

        for (Map.Entry<String, Estante> estante : estantes.entrySet()) {
            if ( libroRentado.getGenero().equals( estante.getValue().getGenero() ) ){
                estante.getValue().hacerDisponible(libroRentado);
                int contador = 0;
                for(Libro libro: librosRentados){
                    if (libroRentado.getId() == libro.getId()){
                        librosRentados.remove(contador);
                        break;
                    }
                    contador++;
                }
                break;
            }
        }
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
}