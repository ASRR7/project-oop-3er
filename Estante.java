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

    public void insertarLibro(Libro libro){
        libros.add(libro); //Añadir al final de la lista
        this.masUnoCantidadLibros();
    }
    public boolean  libroEncontrado(Libro libroBuscar){
        for(Libro libro: libros){
            if (libro.getId() ==libroBuscar.getId){
                return true
            }
        }
        return false
    }

    public int buscarISBN(String titulo){ //Retorna el libro encontrado
        for (Libro libro : this.getLibros()) {
            if( titulo.equals( libro.getTitulo() ) ){
                return libro.getISBN();
            }
        }
        return -1;
    }
}
