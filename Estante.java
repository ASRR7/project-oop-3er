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

    public Libro getLibro(int isbn, String genero){
        for(Libro libro: this.getLibros()){
            if(libro.getISBN() == isbn){
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

    public boolean libroEncontrado(Libro libroBuscar){
        for(Libro libro: libros){
            if(libro.getId() == libroBuscar.getId()){
                return true;
            }
        }
        return false;
    }

    public void hacerDisponible(Libro libroDisponible){
        for(Libro libro: libros){
            if (libroDisponible.getId()== libro.getId()) {
                libro.setEstatus("Disponible");
                break;
            }
        }
    }
    public void hacerNoDisponible(Libro libroNoDisponible){
        for(Libro libro: libros){
            if (libroNoDisponible.getId() == libro.getId()) {
                libro.setEstatus("No disponible");
                break;
            }
        }
    }


    public int buscarISBN(String titulo){ //Retorna el isbn del libro encontrado
        for (Libro libro : this.getLibros()) {
            if( titulo.equals( libro.getTitulo() ) ){
                return libro.getISBN();
            }
        }
        return -1;
    }

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
