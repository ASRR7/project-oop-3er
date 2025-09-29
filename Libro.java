import java.util.Random;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private int ISBN;
    private String estatus;
    private boolean enInventario;
    private int id;
    public static int idContador;
    /**
     * <h2>Constructor Libro</h2>
     * <p>
     * Crea un objeto de tipo Libro asignándole título, autor, editorial y
     * género. También inicia con dos atributos predeterminados: estatus en
     * "Disponible" y enInventario en "true". Además, le asigna un identificador
     * al libro automáticamente.
     * </p>
     * @param titulo el nombre del libro
     * @param autor el autor del libro
     * @param editorial la editorial del libro
     * @param genero el género del libro
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * 
     */
    public Libro(String titulo, String autor, String editorial, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.ISBN = Libro.genISBN();
        this.estatus = "Disponible";
        this.enInventario = true;
        this.id = Libro.getIdContador();
    }
    /**
     * <h2>Metodo genISBN</h2>
     * <p>
     * Crea aleatoriamente un ISBN que esta entre 10,000 y 60,000.
     * </p>
     * @return isbn del Libro
     * @author Equipo 13
     * @version 1.0
     */
    private static int genISBN(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(50000) + 10000;
    }
    //setters y getters
    /**
     * <h2>Metodo getTitulo</h2>
     * <p>
     * Devuelve el titulo del libro.
     * </p>
     * @return titulo del libro
     * @author Equipo 13
     * @version 1.0
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * <h2>Metodo getAutor</h2>
     * <p>
     * Devuelve el autor del libro.
     * </p>
     * @return autor del libro
     * @author Equipo 13
     * @version 1.0
     */
    public String getAutor() {
        return autor;
    }
    /**
     * <h2>Metodo getEditorial</h2>
     * <p>
     * Devuelve la editorial del libro.
     * </p>
     * @return editorial del libro
     * @author Equipo 13
     * @version 1.0
     */
    public String getEditorial() {
        return editorial;
    }
    /**
     * <h2>Metodo getGenero</h2>
     * <p>
     * Devuelve el genero del libro.
     * </p>
     * @return genero del libro
     * @author Equipo 13
     * @version 1.0
     */
    public String getGenero() {
        return genero;
    }
    /**
     * <h2>Metodo getISBN</h2>
     * <p>
     * Devuelve el ISBN del libro.
     * </p>
     * @return ISBN del libro
     * @author Equipo 13
     * @version 1.0
     */
    public int getISBN() {
        return ISBN;
    }
    /**
     * <h2>Metodo getEstatus</h2>
     * <p>
     * Devuelve el estatus del libro.
     * </p>
     * @return estatus del libro
     * @author Equipo 13
     * @version 1.0
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * <h2>Metodo isEnInventario</h2>
     * <p>
     * Devuelve un booleano si está en el inventario.
     * </p>
     * @return "True" o "False"
     * @author Equipo 13
     * @version 1.0
     */
    public boolean isEnInventario() {
        return enInventario;
    }
    /**
     * <h2>Metodo getId</h2>
     * <p>
     * Devuelve el identificador del libro.
     * </p>
     * @return id del libro
     * @author Equipo 13
     * @version 1.0
     */
    public int getId() {
        return id;
    }
    /**
     * <h2>Metodo getIdContador</h2>
     * <p>
     * Devuelve el contador de libros.
     * </p>
     * @return idContador de libros
     * @author Equipo 13
     * @version 1.0
     */
    public static int getIdContador() {
        return idContador++;
    }
    /**
     * <h2>Metodo setTitulo</h2>
     * <p>
     * Hace autoreferencia al titulo del libro para modificarlo.
     * </p>
     * @param titulo nuevo del libro
     * @author Equipo 13
     * @version 1.0
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * <h2>Metodo setAutor</h2>
     * <p>
     * Hace autoreferencia al autor del libro para modificarlo.
     * </p>
     * @param autor nuevo del libro
     * @author Equipo 13
     * @version 1.0
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * <h2>Metodo setEditorial</h2>
     * <p>
     * Hace autoreferencia a la editorial del libro para modificarla.
     * </p>
     * @param editorial nuevo del libro
     * @author Equipo 13
     * @version 1.0
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    /**
     * <h2>Metodo setGenero</h2>
     * <p>
     * Hace autoreferencia al genero del libro para modificarla.
     * </p>
     * @param genero nuevo del libro
     * @author Equipo 13
     * @version 1.0
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * <h2>Metodo setEstatus</h2>
     * <p>
     * Hace autoreferencia al estatus del libro para modificarla.
     * </p>
     * @param estatus nuevo del libro "Disponible" o "No disponible".
     * @author Equipo 13
     * @version 1.0
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    /**
     * <h2>Metodo setEnInventario</h2>
     * <p>
     * Hace autoreferencia al estado del libro en el inventario para modificarla.
     * </p>
     * @param enInventario sí esta en inventario o no "True" o "False". 
     * @author Equipo 13
     * @version 1.0
     */
    public void setEnInventario(boolean enInventario) {
        this.enInventario = enInventario;
    }
    /**
     * <h2> Metodo toString </h2>
     * <p>
     * Imprime el libro: título, autor, editorial, genero, ISBN, estatus, en Inventario e ID.  
     * </p>
     * @author Equipo 13
     * @version 1.0
     * @return Cadena de texto con todos los atributos mencionados. 
     * @see Libro
     */
    public String toString() {
        return "Libro {" + "titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + ", isbn=" + ISBN + ", estatus=" + estatus + ", enInventario=" + enInventario + ", id=" + id + '}';
    }
}