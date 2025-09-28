import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main (String[] args){
        ArrayList<Cliente> Clientes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        String nombreCliente;
        do {
            System.out.println("---Cafe Biblioteca---");
            System.out.println("1. Nuevo cliente");
            System.out.println("1.");
            System.out.println("1.");
            System.out.println("1.");
            System.out.println("1.");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa tu nombre");
                    nombreCliente = sc.nextLine();
                    Cliente nuevo = new Cliente(nombreCliente);
                    Clientes.add(nuevo);
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida"); 
            }
        } while (opcion != 6);
        sc.close();
    }
}
