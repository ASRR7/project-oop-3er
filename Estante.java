import java.util.ArrayList;

public class Estante {
    private int cantidadLibros;
    private String genero;
    private int pasillo;
    private ArrayList<Libro> libros;

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
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    private void masUnoCantidadLibros(){
        this.cantidadLibros++;
    }
    public int getCantidadLibros(){
        return this.cantidadLibros;
    }

    public String getGenero(){
        return this.genero;
    }

    public ArrayList<Libro> getLibros(){
        return this.libros;
    }

    public int getPasillo(){
        return this.pasillo;
    }

    /**
     * <h2> Metodo insertarLibro </h2>
     * <p>
     * Agrega el Libro al estante y usa el método insertarLibro() para sumar +1 a la cantidad de libros.
     * @param libro es el objeto (Libro) que se va a agregar al estante
     * @author Equipo 13
     * @version 1.0
     * @see Libro
     * */
    public void insertarLibro(Libro libro){
        libros.add(libro); //Añadir al final de la lista
        this.masUnoCantidadLibros();
    }

    public Libro getLibro(Libro libroBuscar){
        for(Libro libro: this.getLibros()){
            if(libro.getId() == libroBuscar.getId()){
                return libro;
            }
        }
        return null;
    }

    public Libro getLibro(String titulo){
        for(Libro libro: this.getLibros()){
            if(titulo.equals( libro.getTitulo() )){
                return libro;
            }
        }
        return null;
    }

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
