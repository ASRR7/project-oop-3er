import java.util.ArrayList;
public class Cliente{
    public static int idContador = 0;
    public int id;
    ArrayList<Libro> librosRentados = new ArrayList<>();
    public double cuenta;


    Cliente(){
        idContador++;
        this.id = idContador;
    }


}