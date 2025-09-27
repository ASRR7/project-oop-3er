
import java.util.Random;
//hola

public class Libro {

    Random aleatorio = new Random();
    //atributos perrones 9 
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private double precio;
    private int isbn;
    private String estatus;
    private boolean enInventario;
    private int id;
    public static int idContador=0;

    public Libro(String titulo, String autor, String editorial, String genero, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.isbn=aleatorio.nextInt(50000) + 10000;
        this.precio = precio;
        this.estatus = "Disponible";
        this.enInventario = true;
        this.id = idContador;
    }

    //setters y getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getGenero() {
        return genero;
    }

    public double getPrecio() {
        return precio;
    }

    public int getISBN() {
        return isbn;
    }

    public String getEstatus() {
        return estatus;
    }

    public boolean isEnInventario() {
        return enInventario;
    }

    public int getId() {
        return id;
    }

    public static int getIdContador() {
        return idContador;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setEnInventario(boolean enInventario) {
        this.enInventario = enInventario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + ", precio=" + precio + ", isbn=" + isbn + ", estatus=" + estatus + ", enInventario=" + enInventario + ", id=" + id + '}';
    }
}
