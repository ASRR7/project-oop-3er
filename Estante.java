package proyecto;
import java.util.ArrayList;

/**
 * <h2>Clase Estante</h2>
 * 
 * @author Equipo 13
 * @version 1.0
 */
public class Estante {
    private int cantidadLibros;
    private String genero;
    private int pasillo;
    private ArrayList<Libro> libros;
    /**
     * <h2>Constructor Estante</h2>
     * <p>
     * Crea un objeto de tipo Estante con los atributos iniciales:
     * cantidadLibros en 0, género del estante, pasillo en el que se ubica y una
     * lista vacía de libros. Además, asigna un código de barras único generado
     * automáticamente.
     * </p>
     *
     * @param genero género de los libros que almacenará el estante
     * @param pasillo pasillo en el que se encuentra el estante
     * @author Equipo 13
     * @version 1.0
     */
    Estante(String genero, int pasillo){
        this.cantidadLibros = 0;
        this.genero = genero; //El genero y el pasillo son permanentes
        this.pasillo = pasillo;
        this.libros = new ArrayList<Libro>();
    }

    /**
     * <h2> Metodo masUnoCantidadLibros </h2>
     * <p>
     * Suma 1 en la cantidad de libros del estante.
     * </p>
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    private void masUnoCantidadLibros(){
        this.cantidadLibros++;
    }
    /**
     * <h2>Metodo getCantidadLibros</h2>
     * <p>
     * Devuelve la cantidad de libros en el estante.
     * </p>
     *
     * @return prcantidadLibros en el estante
     * @author Equipo 13
     * @version 1.0
     */

    public int getCantidadLibros(){
        return this.cantidadLibros;
    }
    /**
     * <h2>Metodo getGenero</h2>
     * <p>
     * Devuelve el genero del estante.
     * </p>
     *
     * @return genero del estante
     * @author Equipo 13
     * @version 1.0
     */
    public String getGenero(){
        return this.genero;
    }
    /**
     * <h2>Metodo getLibros</h2>
     * <p>
     * Devuelve el arreglo de libros del estante.
     * </p>
     *
     * @return libros en un arreglo
     * @author Equipo 13
     * @version 1.0
     */
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }
    /**
     * <h2>Metodo getPasillo</h2>
     * <p>
     * Devuelve el pasillo en el que está ubicado el estante.
     * </p>
     *
     * @return pasillo del estante
     * @author Equipo 13
     * @version 1.0
     */
    public int getPasillo(){
        return this.pasillo;
    }

    /**
     * <h2> Metodo insertarLibro </h2>
     * <p>
     * Agrega el Libro al estante y usa el método insertarLibro() para sumar +1 a la cantidad de libros.
     * </p>
     * @param libro es el objeto (Libro) que se va a agregar al estante
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void insertarLibro(Libro libro){
        libros.add(libro); //Añadir al final de la lista
        this.masUnoCantidadLibros();
    }
    /**
     * <h2>Metodo getLibro</h2>
     * <p>
     * Devuelve el libro que coincide con el objeto libro a buscar. 
     * </p>
     *
     * @return libro a buscar o null si no lo encontró
     */
    public Libro getLibro(Libro libroBuscar){
        for(Libro libro: this.getLibros()){
            if(libro.getId() == libroBuscar.getId()){
                return libro;
            }
        }
        return null;
    }
    /**
     * <h2>Metodo getLibro</h2>
     * <p>
     * Devuelve el libro que coincide con el titulo del libro a buscar.
     * </p>
     *
     * @return libro a buscar o null si no lo encontró
     */
    public Libro getLibro(String titulo){
        for(Libro libro: this.getLibros()){
            if(titulo.equals( libro.getTitulo() )){
                return libro;
            }
        }
        return null;
    }
    /**
     * <h2>Metodo getLibro</h2>
     * <p>
     * Devuelve el libro que coincide con el id del libro a buscar.
     * </p>
     *
     * @return libro a buscar o null si no lo encontró
     */
    public Libro getLibro(int id){
        for(Libro libro: this.getLibros()){
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    /**
     * <h2> Metodo libroEncontrado </h2>
     * <p>
     * Recorre los libros del estante y en cada uno con el método getId() lo
     * utiliza para comparar si es igul al id del Libro del parametro. 
     * </p>
     * @param libroBuscar es el objeto (Libro) que se va a buscar en el estante
     * @author Equipo 13
     * @return true si es encontrado, false en caso contrario
     * @version 1.0
     * @see Libro
     * */
    public boolean libroEncontrado(Libro libroBuscar){
        for(Libro libro: libros){
            if(libro.getId() == libroBuscar.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * <h2> Metodo hacerDisponible </h2>
     * <p>
     * Recorre los libros del estante y en cada uno con el método getId() lo
     * utiliza para comparar si es igul al parametro. Cuando encuentra al que coincide,
     * con setEstatus() actualiza a "Disponible" para que sí se pueda rentar.
     * </p>
     * @param libroDisponible es el objeto (Libro) que sí estará disponible
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void hacerDisponible(Libro libroDisponible){
        for(Libro libro: libros){
            if (libroDisponible.getId()== libro.getId()) {
                libro.setEstatus("Disponible");
                break;
            }
        }
    }

    /**
     * <h2> Metodo hacerNoDisponible </h2>
     * <p>
     * Recorre los libros del estante y en cada uno con el método getId() lo
     * utiliza para comparar si es igul al parametro. Cuando encuentra al que coincide,
     * con setEstatus() actualiza a "No disponible" para que no se pueda rentar.
     * </p>
     * @param libroNoDisponible es el objeto (Libro) que ya no estará disponible
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void hacerNoDisponible(Libro libroNoDisponible){
        for(Libro libro: libros){
            if (libroNoDisponible.getId() == libro.getId()) {
                libro.setEstatus("No disponible");
                break;
            }
        }
    }


    /**
     * <h2> Metodo buscarISBN </h2>
     * <p>
     * Recorre los libros del estante y en cada uno con el método getTitulo() lo
     * utiliza el método equals() de String para comparar si es igul al parametro.
     * </p>
     * @param titulo es el nombre (String) del libro a buscar dentro del estante
     * @author Equipo 13
     * @version 1.0
     * @return regresa el ISBN del libro
     * @see Libro
     * */
    public int buscarISBN(String titulo){ //Retorna el isbn del libro encontrado
        for (Libro libro : this.getLibros()) {
            if( titulo.equals( libro.getTitulo() ) ){
                return libro.getISBN();
            }
        }
        return -1;
    }

    /**
     * <h2> Metodo print </h2>
     * <p>
     * Imprime el estante: género y pasillo.
     * Además, recorre los libros del estante y con el método toString() de Libro
     * imprime la información de cada libro.
     * </p>
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void print(){
        System.out.println("---------------------------------------");
        System.out.println("Estante: " +this.getGenero() + " | Pasillo: " + this.getPasillo());
        System.out.println("Libros\n===========================================");
        for (Libro libro : this.getLibros()) {
            System.out.println(libro.toString());
        }
        System.out.println("---------------------------------------");
    }
}
