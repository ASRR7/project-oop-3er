import java.util.ArrayList;
import java.util.Scanner;


public class Test {
    public static void main (String[] args){
        ArrayList<Cliente> Clientes = new ArrayList<>();
        Cliente c1 = new Cliente ("Cesar");
        Cliente c2 = new Cliente("Julio");
        Cliente c3 = new Cliente("Ivan");
        Clientes.add(c1);
        Clientes.add(c2);
        Clientes.add(c3);

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario (); 
        inventario.agregarDatosIniciales();
        Cliente seleccionado = null;
        Alimento seleccionAlimento = null; 
        Libro seleccionLibro = null; 
        Estante seleccionEstante=null; 

        int opcion, opcionCliente, opcionTrabajador, opcionBusqueda, idLibro, isbn, idCliente;
        double pago; 
        String nombreCliente, orden, rentaLibro, genero;

        do {
            System.out.println("---Cafe Biblioteca---");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Eres un cliente");
            System.out.println("3. Eres un trabajdor");
            System.out.println("4. Salir");
            System.out.print("Opcion: "); 
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Cual es tu nombre: ");
                    nombreCliente = sc.nextLine();
                    Cliente nuevo = new Cliente(nombreCliente);
                    Clientes.add(nuevo);
                    System.out.println("Registro exitoso...");
                    break; 
                case 2: 
                    
                    if (Clientes.isEmpty()) 
                        System.out.println("No hay clientes registrados...");
                    else {
                        for (Cliente c : Clientes) {
                            c.mostrarInfo();
                        }
                        do {
                            System.out.print("Selecciona tu ID: ");
                            idCliente = sc.nextInt();
                            sc.nextLine();
                            for (Cliente c : Clientes){
                                if (c.getId() == idCliente)
                                {
                                    seleccionado = c;
                                    break;
                                }
                            }
                            if (seleccionado == null) {
                                System.out.println("ID de cliente invalido, ingresa un ID valido..."); 
                            }
                        } while (seleccionado==null);
                        System.out.println("Bienvenido cliente: " + seleccionado.getNombre());
                        do {
                            System.out.println("1. Ordenar comida");
                            System.out.println("2. Rentar libro");
                            System.out.println("3. Devolver libro rentado");
                            System.out.println("4. Pagar cuenta");
                            System.out.println("5. Salir");
                            System.out.print("Opcion Cliente: ");
                            opcionCliente = sc.nextInt();
                            sc.nextLine();
                            switch (opcionCliente) {
                                case 1: 
                                    inventario.mostrarAlimentos(); 
                                    System.out.print("Tu orden debe de coincidir exactamente con el nombre del alimentolo que esta en inventario\n¿Que desea ordenar?: "); 
                                    orden = sc.nextLine(); 
                                    seleccionAlimento = inventario.getAlimentoNombre(orden); 
                                    if (seleccionAlimento != null){
                                        System.out.println("Pediste: "+seleccionAlimento.getNombre()+" que tiene un precio de: "+seleccionAlimento.getPrecio()); 
                                        seleccionado.cobrar(seleccionAlimento.getPrecio()); 
                                    }
                                    else 
                                        System.out.println("No tenemos '"+orden +"' en inventario"); 
                                    break; 
                                case 2: 
                                    inventario.mostrarEstantes(); 
                                    System.out.print("La busqueda la realizaras por: \n1. Nombre del libro\n2. ISBN y género\n3. ID\n4. Ya no deseo rentar un libro\nOpcion: ");
                                    opcionBusqueda = sc.nextInt();
                                    sc.nextLine();
                                    switch (opcionBusqueda) {
                                        case 1: 
                                            System.out.print("Ingresa el nombre del libro que deseas rentar, el nombre debe de ser idéntico: ");
                                            rentaLibro = sc.nextLine();
                                            seleccionLibro = inventario.getLibro(rentaLibro); 
                                            break; 
                                        case 2: 
                                            System.out.print("Ingresa exactamente el ISBN del libro: ");
                                            isbn = sc.nextInt(); 
                                            sc.nextLine(); 
                                            System.out.print("Ingresa el genero: ");
                                            genero = sc.nextLine(); 
                                            seleccionLibro = inventario.getLibro(isbn, genero);
                                            break;
                                        case 3: 
                                            System.out.print("Ingresa el ID del libro: ");
                                            idLibro = sc.nextInt();
                                            sc.nextLine();
                                            seleccionLibro = inventario.getLibro(idLibro); 
                                            break;
                                        case 4:    
                                            System.out.println("No rentaste nada..."); 
                                        default:
                                            System.out.println("Opcion invalida...");
                                    }
                                    if (opcionBusqueda!=4){
                                        if (seleccionLibro == null)
                                            System.out.println("No tenemos ese libro...");
                                        else
                                            seleccionado.rentarLibro(seleccionLibro, inventario);
                                            System.out.println("El libro: "+seleccionLibro.toString()+" ha sido rentado");
                                    }
                                    break;
                                case 3: 
                                    seleccionLibro = null;
                                    seleccionado.printLibrosRentados();
                                    System.out.print("Ingresa el ID del libro que deseas devolver: ");
                                    idLibro = sc.nextInt();
                                    sc.nextLine();
                                    seleccionLibro = inventario.getLibro(idLibro); 

                                    if( seleccionado.loTengoRentado( seleccionLibro ) ){
                                        seleccionado.devolverLibro(seleccionLibro, inventario);
                                        System.out.println("Libro devuelto con exito.");
                                    }else {
                                        System.out.println("Ese libro no lo tienes.");
                                    }
                                    break;

                                case 4: 
                                    do { 
                                        seleccionado.cobrar(0);
                                        System.out.print("Ingresa tu pago: $");
                                        pago = sc.nextDouble(); 
                                        sc.nextLine(); 
                                        seleccionado.pagarCuenta(pago);
                                    } while (seleccionado.getCuenta()>=0);
                                    break; 
                                case 5:
                                    seleccionado = null;
                                    seleccionAlimento = null;
                                    seleccionEstante = null;
                                    seleccionLibro = null; 

                                    System.out.println("Saliendo...");
                                    break;
                                default:
                                    System.out.println("Opcion invalida...");
                            }
                        } while (opcionCliente != 5);
                    } 
                    break; 
                case 3: 
                    System.out.println("Bienvenido Esclavo"); 
                    do { 
                        System.out.println("1. Agregar/quitar comida");
                        System.out.println("2. Agregar/quitar libros");
                        System.out.println("3. Agregar/quitar estantes");
                        System.out.println("4. Salir");
                        System.out.print("Opcion trabajador: ");
                        opcionTrabajador = sc.nextInt();
                        sc.nextLine();
                        switch (opcionTrabajador) {
                            case 1://Agregar/quitar comida
                                break;
                            case 2://Agregar/quitar libros
                                break;
                            case 3://Agregar/quitar estantes
                                break;
                            case 4:
                                seleccionado = null;
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }
                    }
                    while (opcionTrabajador != 4);
                    break; 
                case 4:
                    System.out.println("Terminando programa...");
                    break; 
                default:
                    System.out.println("Opcion no valida..."); 
            }
        } while (opcion != 4);
        sc.close();
    }
}