import java.util.ArrayList;
public class Cliente{
    public static int idContador = 0;

    private int id;
    private String nombre = "";
    private ArrayList<Libro> librosRentados = new ArrayList<>();
    private double cuenta;


    public Cliente(){
        idContador++;
        this.id = idContador;
    }
    public Cliente(String nombre){
        idContador++;
        this.id = idContador;
        this.nombre = nombre;
    }

    public void mostrarInfo(){
        System.out.println("ID: "+ id);
        if (nombre.equals("")){
            System.out.println("No se ha asignado un nombre");
        }
        else{
            System.out.println(nombre);
        }
        System.out.println("Cuenta: "+cuenta);

    }

    public void pagarCuenta(double pago){
        cuenta-=pago;
        System.out.println("Su cuenta actual es de: "+ cuenta);
    }

    public void cobrar(double cobro){
        cuenta+=cobro;
        System.out.println("Su cuenta actual es de: "+ cuenta);
    }

    public void agregarLibro(Libro nuevoLibro){
        librosRentados.add(nuevoLibro);
    }
    /*
    * To do :Agregar metodo para devolver libro a inventario
    * */
    public void devolverLibro(int ID){
        int contador =0;
        for(Libro libro: librosRentados){
            if (libro.getId()== ID){
                libro.setEstatus("Disponible");
                librosRentados.remove(contador);


            }
            contador ++;
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