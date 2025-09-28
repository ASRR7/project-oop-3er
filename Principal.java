import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main (String[] args){
        ArrayList<Cliente> Clientes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Cliente seleccionado = null;

        int opcion, opcionCliente, opcionTrabajador, idCliente;

        String nombreCliente;
        do {
            System.out.println("---Cafe Biblioteca---");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Eres un cliente");
            System.out.println("3. Eres un trabajdor");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Cual es tu nombre");
                    nombreCliente = sc.nextLine();
                    Cliente nuevo = new Cliente(nombreCliente);
                    Clientes.add(nuevo);
                    break; 
                case 2: 
                    
                    if (Clientes.isEmpty()) 
                        System.out.println("No hay clientes registrados");
                    else {
                        for (Cliente c : Clientes) {
                            c.mostrarInfo();
                        }
                        do {
                            System.out.println("Selecciona tu ID: ");
                            idCliente = sc.nextInt();
                            sc.nextLine();
                            for (Cliente c : Clientes){
                                if (c.getId() == idCliente); 
                                    seleccionado = c; 
                                    break; 
                            }


                            if (seleccionado == null) {
                                System.out.println("ID de cliente invalido, ingresa un ID valido"); 
                            }
                        } while (seleccionado==null);
                    } 
            
                    System.out.println("Bienvenido cliente: " + seleccionado.getNombre());
                    do { 
                        System.out.println("1. Ordenar comida"); 
                        System.out.println("2. Rentar libro");
                        System.out.println("3. Devolver libro rentado");
                        System.out.println("4. Pagar cuenta"); 
                        System.out.println("5. Slir");
                        opcionCliente=sc.nextInt();
                        sc.nextLine(); 
                        switch (opcionCliente) {
                            case 4:
                                seleccionado = null; 
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opcion invalida...");
                        }
                    } while (opcionCliente!=5);
                    
                case 4:
                    System.out.println("Saliendo");
                default:
                    System.out.println("Opcion no valida"); 
            }
        } while (opcion != 4);
        sc.close();
    }

    
}