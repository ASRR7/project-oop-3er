package proyecto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <h2>Clase Inventario</h2>
 * 
 * @author Equipo 13
 * @version 1.0
 */
public class Inventario {
    private HashMap<String, Estante> estantes;
    private HashSet<Alimento> alimentos;

    /**
     * <h2> Constructor Inventario</h2>
     * Inicializa el hashMap y el HashSet.
     *
     * @return Inventario
     * @author Equipo 13
     * @version 1.0
     * */
    Inventario(){
        this.estantes = new HashMap<String, Estante>();
        this.alimentos = new HashSet<Alimento>();
    }

    /**
     * <h2> Metodo getAlimentos</h2>
     * Retorna el HashMap estantes
     *
     * @return HashMap String,Estante
     * @author Equipo 13
     * @version 1.0
     * */
    public HashMap<String, Estante> getEstantes(){
        return this.estantes;
    }
    /**
     * <h2> Metodo getAlimentos</h2>
     * Retorna el HashSet alimentos
     *
     * @return HashSet de Alimento
     * @author Equipo 13
     * @version 1.0
     * */
    public HashSet<Alimento> getAlimentos(){
        return this.alimentos;
    }

    /**
     * <h2> Metodo consultar cantidad</h2>
     * Usa el metodo getEstantes() para obtener el estante según el genero
     * De acuerdo a eso, itera sobre el estante buscando un libro que conincida en título
     *
     * @param genero el género (String) a buscar para el estante
     * @param titulo el título (String) a buscar para el libro
     * @return el conteo total de libros
     * @author Equipo 13
     * @version 1.0
     * */
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
/**
 * <h2>
 *     Metodo getLibro
 * </h2>
 * Dado el título de un libro, se busca en cada uno de los estantes (usando getEstantes)
 *
 * @param titulo el título del libro a buscar
 * @return libro en caso de encontrarse; de lo contrario regresa null
 * @author Equipo 12+1
 * @version 1.0
 * */

    public Libro getLibro(String titulo){
        Libro libro;
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            libro = estante.getValue().getLibro(titulo);
            if(libro != null){
                return libro;
            }
        }
        return null;
    }


    /**
     * <h2>Metodo getLibro</h2>
     * Dado un ID de un libro, devuelve el libro a buscar
     * @param id del libro a buscar
     * @return libro correspondiente; de no encontrarse regresa null
     * @author Equipo 13
     * @version 1.0
     * */
    public Libro getLibro(int id){
        Libro libro;
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            libro = estante.getValue().getLibro(id);
            if(libro != null){
                return libro;
            }
        }
        return null;
    }


    /**
     * <h2>Metodo agregarLibro</h2>
     * Dado los atributos de un líbro, lo genera y lo acomoda en el estante apropiado
     * @param titulo del libro
     * @param genero  del libro
     * @param autor del libro
     * @param editorial del libro
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void agregarLibro(String titulo, String autor, String editorial, String genero){
        Estante estante = this.getEstantes().get(genero);
        Libro libroN = new Libro(titulo, autor, editorial, genero);
        estante.insertarLibro( libroN );
    }

    /**
     * <h2>Metodo consultarCantidad</h2>
     * Dado un género, consulta la cantidad de libros en el estante correspondiente a dicho género
     * @param genero del estante
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public int consultarCantidad(String genero){
        Estante estante = this.getEstantes().get(genero);//Obtiene el estante correspondiente al genero
        return estante.getCantidadLibros();
    }
    /**
     * <h2>Metodo consultarCantidadTitulo</h2>
     * Dado un título, regresa la cantidad de libros con ese mismo título iterando por
     * cada estante dentro del mapa de estantes
     * @param titulo del libro a buscar
     * @return cantidad de libros con el título correspondiente
     * @author Equipo 13
     * @version 1.0
     * */
    public int consultarCantidadTitulo(String titulo){
        int cantidad = 0;
        //Ciclo que itera en el map usando entrySet para recorrer todos los hash (keys)
        for (Map.Entry<String, Estante> estantePar : this.getEstantes().entrySet()) {
            //Se usa el método para buscar cantidad de titulos en un estante especifico
            cantidad += this.consultarCantidad( estantePar.getValue().getGenero(), titulo );
        }
        return cantidad; //Cantidad de libros en todo el inventario
    }
    /**
     * <h2>Metodo getAlimentoNombre</h2>
     * Dado el nombre de un alimento, devuelve el alimento si este se encuentra
     * en la lista de alimentos; de lo contrario se regresa null
     * @param alimentoNombre , nombre del alimentoa buscar
     * @return alimento con el nombre correspondiente, null si no se encuentra
     * @author Equipo 13
     * @version 1.0
     * */
    public Alimento getAlimentoNombre(String alimentoNombre){
        for ( Alimento alimento : this.getAlimentos() ) {
            if( alimentoNombre.equals( alimento.getNombre() ) ){
                return alimento;
            }
        }
        return null;
    }
    /**
     * <h2>Metodo hayAlimento</h2>
     * Dado el nombre de un alimento, devuelve un booleano correspondiente a
     * si se encuentra o no
     * @param alimentoNombre , nombre del alimento a buscar
     * @return true si el alimento con el nombre indicado se encuentra; false de lo contrario
     * @author Equipo 13
     * @version 1.0
     * */
    public boolean hayAlimento(String alimentoNombre){
        for ( Alimento alimento : this.getAlimentos() ) {
            if( alimentoNombre.equals( alimento.getNombre() ) ){
                return true;
            }
        }
        return false;
    }
    /**
     * <h2>Metodo quitarAlimento</h2>
     * Dado el nombre de un alimento, elimina el objeto alimento con el nombre correspondiente
     * @param alimentoNombre , nombre del alimento a eliminar
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void quitarAlimento(String alimentoNombre){
        Alimento alimento = this.getAlimentoNombre(alimentoNombre);
        this.getAlimentos().remove(alimento);
    }
    /**
     * <h2>Metodo mostrarAlimentos</h2>
     * Muestra todos los alimentos en la lista de alimentos actuales
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void mostrarAlimentos(){
        System.out.println("==========================\nAlimentos en inventario: ");
        for ( Alimento alimento : this.getAlimentos() ) {
            System.out.println(alimento.getNombre() + " -  $" + alimento.getPrecio());
        }
        System.out.println("----------------------------------------------\n");
    }
    /**
     * <h2>Metodo mostrarEstantes</h2>
     * Imprime cada uno de los estantes encontrados
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void mostrarEstantes(){
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            estante.getValue().print();
        }
    }
    /**
     * <h2>Metodo mostrarEstantes</h2>
     * Dado un género especificado, imprime el estante con el género correspondiente
     * @param genero del estante a buscar
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void mostrarEstantes(String genero){
        Estante estante = this.getEstantes().get(genero);
        estante.print();
    }

    /**
     * <h2>Metodo agregarEstante</h2>
     * Dado un género y pasillo, se crea un objeto Estante y se agrega al hashMap de estantes
     * @param genero del estante a añadir
     * @param pasillo del estante a añadir
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void agregarEstante(String genero, int pasillo){
        Estante es = new Estante(genero, pasillo);
        this.estantes.put(genero, es);
    }

    /**
     * <h2>Metodo agregarAlimento</h2>
     * Dado el nombre de un alimento y su precio, lo agrega a la lista de alimentos
     * @param nombreAlimento nombre del alimento a agregar
     * @param precio del alimento a agregar
     * @return void
     * @author Equipo 13
     * @version 1.0
     * */
    public void agregarAlimento(String nombreAlimento, double precio){
        Alimento nuevoAlimento = new Alimento(nombreAlimento, precio);
        alimentos.add(nuevoAlimento);
        this.getAlimentos().add(nuevoAlimento);
        System.out.println("Alimento agregado correctamente.");
    }

    /**
     * <h2>Metodo printGeneros</h2>
     * Imprime cada uno de los géneros de los estantes
     * @return el número de estantes
     * @author Equipo 13
     * @version 1.0
     * */
    public int printGeneros(){
        System.out.println("========================\nGeneros");
        int c = 0;
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            c++;
            System.out.println(c+". "+ estante.getValue().getGenero());
        }
        System.out.println("------------------------------------------");
        return c;
    }
    /**
     * <h2>Metodo numToGenero</h2>
     * De acuerdo al número proporcionado al usuario, devuelve el género.
     * Este se usa en el menú para seleccionar el género por medio de un menú.
     * @param numGenero número del género seleccionado por el usuario
     * @return el género seleccionado
     * @author Equipo 13
     * @version 1.0
     * */
    public String numToGenero(int numGenero){
        int c = 1;
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            if(c == numGenero){
                return estante.getValue().getGenero();
            }
            c++;
        }
        return "Mixto";
    }
    /**
     * <h2>Metodo agregarDatosIniciales</h2>
     * Agrega estantes, alimentos y libros de muestra para usarse
     * @author Equipo 13
     * @version 1.0
     * */
    public void agregarDatosIniciales(){
        this.agregarAlimento( "Coca Cola", 18 );
        this.agregarAlimento( "Cafe Express", 28 );
        this.agregarAlimento( "Rol de Canela", 45 );
        this.agregarAlimento( "Rebanada Cheescake", 65 );
        this.agregarAlimento( "Jugo Naranja", 40 );
        this.agregarAlimento( "Ensalada Frutas", 60 );
        this.agregarAlimento( "Dona Chocolate", 30 );
        this.agregarAlimento( "Te Helado", 45 );
        this.agregarAlimento( "Cuernito Relleno", 45 );


        this.agregarEstante("Ciencia",1);
        this.agregarEstante("Ficción", 1);
        this.agregarEstante("Romance",2);
        this.agregarEstante("Terror",2);
        this.agregarEstante("Poesía",3);
        this.agregarEstante("Drama",3);        
        this.agregarEstante("Mixto", 5);


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
