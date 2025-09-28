import java.util.Random;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private double precio;
    private int ISBN;
    private String estatus;
    private boolean enInventario;
    private int id;
    public static int idContador;

    public Libro(String titulo, String autor, String editorial, String genero, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.ISBN = Libro.genISBN();
        this.estatus = "Disponible";
        this.enInventario = true;
        this.id = Libro.getIdContador();
    }

    private static int genISBN(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(50000) + 10000;
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

    public int getISBN() {
        return ISBN;
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
        return idContador++;
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

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setEnInventario(boolean enInventario) {
        this.enInventario = enInventario;
    }

    public String toString() {
        return "Libro {" + "titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + ", isbn=" + ISBN + ", estatus=" + estatus + ", enInventario=" + enInventario + ", id=" + id + '}';
    }
}