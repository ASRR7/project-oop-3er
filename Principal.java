import java.util.ArrayList; 
import java.util.Scanner; 


public class Principal {
    ArrayList<Cliente> Clientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int opcion; 

    do{
        System.out.println("---Cafe Biblioteca---");
        System.out.println("1.");
        System.out.println("1.");
        System.out.println("1.");
        System.out.println("1.");
        System.out.println("1.");
        System.out.println("6. Salir");
        switch (opcion){
            case 1: 
                System.out.println("Hola");
            case 6: 
                System.out.println("Saliendo");
        }
    } while (opcion != 6);
}
