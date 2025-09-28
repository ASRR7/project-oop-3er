import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Inventario {
    private HashMap<String, Estante> estantes;
    private HashSet<Alimento> alimentos;

    Inventario(){
        this.estantes = new HashMap<String, Estante>();
        this.alimentos = new HashSet<Alimento>();
    }

    public HashMap<String, Estante> getEstantes(){
        return this.estantes;
    }
    public HashSet<Alimento> getAlimentos(){
        return this.alimentos;
    }

    public int consultarCantidad(String genero, String titulo){
        int cantidad = 0;
        Estante estante = this.getEstantes().get(genero);//Obtiene el estante correspondiente al genero
        for( Libro libro : estante.getLibros() ){
            if( libro.getTitulo().contains(titulo) ){
                cantidad++; //Suma si el titulo buscado esta en cada libro
            }
        } 
        return cantidad;//Retorna cantidad de libros
    }
    
    public void agregarLibro(String titulo, String autor, String editorial, String genero){
        Estante estante = this.getEstanteGenero(genero);
        Libro libroN = new Libro(titulo, autor, editorial, genero);
        estante.insertarLibro( libroN );
    }

    public int consultarCantidad(String genero){
        Estante estante = this.getEstantes().get(genero);//Obtiene el estante correspondiente al genero
        return estante.getCantidadLibros();
    }

    public int consultarCantidadTitulo(String titulo){
        int cantidad = 0;
        //Ciclo que itera en el map usando entrySet para recorrer todos los hash (keys)
        for (Map.Entry<String, Estante> estantePar : this.getEstantes().entrySet()) {
            //Se usa el método para buscar cantidad de titulos en un estante especifico
            cantidad += this.consultarCantidad( estantePar.getValue().getGenero(), titulo );
        }
        return cantidad; //Cantidad de libros en todo el inventario
    }


    public Estante getEstanteGenero(String genero){
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            if ( genero.equals( estante.getValue().getGenero() ) ) {
                return estante.getValue();
            }
        }
        return null;
    }

    public Alimento getAlimentoNombre(String alimentoNombre){
        for ( Alimento alimento : this.getAlimentos() ) {
            if( alimentoNombre.equals( alimento.getNombre() ) ){
                return alimento;
            }
        }
        return null;
    }

    public boolean hayAlimento(String alimentoNombre){
        for ( Alimento alimento : this.getAlimentos() ) {
            if( alimentoNombre.equals( alimento.getNombre() ) ){
                return true;
            }
        }
        return false;
    }

    public void quitarAlimento(String alimentoNombre){
        Alimento alimento = this.getAlimentoNombre(alimentoNombre);
        this.getAlimentos().remove(alimento);
    }

    public void mostrarAlimentos(){
        System.out.println("Alimentos en inventario: ");
        for ( Alimento alimento : this.getAlimentos() ) {
            System.out.print(alimento + ", ");
        }
        System.out.println("\n");
    }

    public void agregarEstante(String genero, int pasillo){
        Estante es = new Estante(genero, pasillo);
        this.estantes.put(genero, es);
    }

    public void agregarAlimento(String nombreAlimento, double precio){
        Alimento nuevoAlimento = new Alimento(nombreAlimento, precio);
        alimentos.add(nuevoAlimento);
        this.getAlimentos().add(nuevoAlimento);
        System.out.println("Alimento agregado correctamente.");
    }

    public void agregarDatosIniciales(){
        this.agregarAlimento( "Coca Cola", 18 );
        this.agregarAlimento( "Café Express", 28 );
        this.agregarAlimento( "Rol de Canela", 45 );
        this.agregarAlimento( "Rebanada Cheescake", 65 );
        this.agregarAlimento( "Jugo Naranja", 40 );
        this.agregarAlimento( "Ensalada Frutas", 60 );
        this.agregarAlimento( "Dona Chocolate", 30 );
        this.agregarAlimento( "Té Helado", 45 );
        this.agregarAlimento( "Cuernito Relleno", 45 );


        this.agregarEstante("Ciencia",1);
        this.agregarEstante("Ficción", 1);
        this.agregarEstante("Romance",2);
        this.agregarEstante("Terror",2);
        this.agregarEstante("Poesía",3);
        this.agregarEstante("Drama",3);        


        this.agregarLibro("100 años de soledad", "Gabriel García", "Editorial Diana", "Ficción");
        this.agregarLibro("Breve historia del tiempo", "Stephen Hawking", "Crítica", "Ciencia");
        this.agregarLibro("Cosmos", "Carl Sagan", "Planeta", "Ciencia");
        this.agregarLibro("Sapiens: De animales a dioses", "Yuval Noah Harari", "Debate", "Ciencia");
        this.agregarLibro("Dune", "Frank Herbert", "Debolsillo", "Ficción");
        this.agregarLibro("100 años de soledad", "Gabriel García", "Editorial Diana", "Ficción");
        this.agregarLibro("1984", "George Orwell", "Debolsillo", "Ficción");
        this.agregarLibro("Un mundo feliz", "Aldous Huxley", "Debolsillo", "Ficción");
        this.agregarLibro("Fahrenheit 451", "Ray Bradbury", "Debolsillo", "Ficción");
        this.agregarLibro("Orgullo y prejuicio", "Jane Austen", "Penguin Clásicos", "Romance");
        this.agregarLibro("Como agua para chocolate", "Laura Esquivel", "Debolsillo", "Romance");
        this.agregarLibro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Diana", "Romance");
        this.agregarLibro("Frankenstein", "Mary Shelley", "Penguin Clásicos", "Terror");
        this.agregarLibro("Drácula", "Bram Stoker", "Alianza Editorial", "Terror");
        this.agregarLibro("It (Eso)", "Stephen King", "Debolsillo", "Terror");
        this.agregarLibro("La llamada de Cthulhu", "H.P. Lovecraft", "Alianza Editorial", "Terror");
        this.agregarLibro("Veinte poemas de amor y una canción desesperada", "Pablo Neruda", "Seix Barral", "Poesía");
        this.agregarLibro("Hojas de hierba", "Walt Whitman", "Alianza Editorial", "Poesía");
        this.agregarLibro("Las flores del mal", "Charles Baudelaire", "Cátedra", "Poesía");
        this.agregarLibro("Hamlet", "William Shakespeare", "Cátedra", "Drama");
        this.agregarLibro( "La casa de Bernarda Alba", "Federico García Lorca", "Cátedra", "Drama");
        this.agregarLibro("Romeo y Julieta", "William Shakespeare", "Austral", "Drama");



    }
}
