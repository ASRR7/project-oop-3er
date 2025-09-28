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

    public HashMap<String, Estante> getEstantes(){
        return this.estantes;
    }

    public Estante getEstanteGenero(String genero){
        for (Map.Entry<String, Estante> estante : this.getEstantes().entrySet()) {
            if ( genero.equals( estante.getValue().getGenero() ) ) {
                return estante.getValue();
            }
        }
        return -1; //TODO: Arreglar retorno
    }

    public HashSet<Alimento> getAlimentos(){
        return this.alimentos;
    }

    public Alimento hayAlimento(String alimentoNombre){
        for ( Alimento alimento : this.getAlimentos() ) {
            if( alimentoNombre.equals( alimento.getNombreAlimento() ) ){
                return alimento;
            }
        }
        return null;
    }

    public void quitarAlimento(String alimentoNombre){
        Alimento alimento = this.hayAlimento(alimentoNombre);
        this.getAlimentos().remove(alimento);
    }

    public void mostrarAlimentos(){
        System.out.println("Alimentos en inventario: ");
        for ( Alimento alimento : this.getAlimentos() ) {
            System.out.print(alimento + ", ");
        }
        System.out.println("\n");
    }
    public void agregarAlimento(String nombreAlimento, double precio){
        Alimento nuevoAlimento = new Alimento(nombreAlimento,precio);
        alimentos.add(nuevoAlimento);
        System.out.println("Alimento agregado correctamente");
    }


}
