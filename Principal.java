import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
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

        int opcion, opcionCliente, opcionTrabajador, opcionBusqueda, opcionTAgregarQuitar, idLibro, isbn, idCliente, pasillo;
        double pago, precio; 
        String nombreCliente, orden, rentaLibro, genero, nombreAlimento, generoEstante, nombreNuevoLibro, autorNuevoLibro, editorialNuevoLibro, generoNuevoLibro;

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
                                            if (seleccionLibro.getEstatus() == "Disponible"){
                                                seleccionado.rentarLibro(seleccionLibro, inventario);
                                                System.out.println("El libro: " + seleccionLibro.toString() + " ha sido rentado");
                                            }
                                            else 
                                                System.out.println("El libro ya fue rentado");     
                                    }
                                    break;
                                case 3: 
                                    break;
                                case 4: 
                                    do { 
                                        System.out.println("Su cuenta actual es de: $" + seleccionado.getCuenta());
                                        System.out.print("Ingresa tu pago: $");
                                        pago = sc.nextDouble(); 
                                        sc.nextLine(); 
                                        seleccionado.pagarCuenta(pago);
                                    } while (seleccionado.getCuenta()>0);
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
                        System.out.println("3. Agregar estante de libros");
                        System.out.println("4. Salir");
                        System.out.print("Opcion trabajador: ");
                        opcionTrabajador = sc.nextInt();
                        sc.nextLine();
                        switch (opcionTrabajador) {
                            case 1://Agregar/quitar comida
                                System.out.println("1. Agregar comida");
                                System.out.println("2. Quitar comida");
                                System.out.println("3. Salir");
                                opcionTAgregarQuitar=sc.nextInt(); 
                                sc.nextLine(); 
                                switch (opcionTAgregarQuitar){
                                    case 1: 
                                        System.out.print("Cuál es el nombre del nuevo alimento: ");
                                        nombreAlimento=sc.nextLine(); 
                                        System.out.print("Cual es el precio del nuevo alimento: "); 
                                        precio=sc.nextInt(); 
                                        sc.nextLine(); 
                                        inventario.agregarAlimento(nombreAlimento, precio);
                                        seleccionAlimento = inventario.getAlimentoNombre(nombreAlimento);
                                        if (seleccionAlimento != null) 
                                            System.out.println("Se agrego el alimento: " + seleccionAlimento.getNombre() + " que tiene un precio de: " + seleccionAlimento.getPrecio());
                                        break; 
                                    case 2: 
                                        inventario.mostrarAlimentos();
                                        System.out.print("Cual es el nombre del alimento que se va a retirar: ");
                                        nombreAlimento = sc.nextLine();
                                        inventario.quitarAlimento(nombreAlimento);
                                        break; 
                                    case 3: 
                                        System.out.println("Saliendo...");
                                        break;
                                    default:
                                        System.out.println("Opcion invalida.");
                                }
                                
                                break;
                            case 2://Agregar/quitar libros
                                System.out.println("1. Agregar libro");
                                System.out.println("2. Quitar libro");
                                System.out.println("3. Salir");
                                opcionTAgregarQuitar = sc.nextInt();
                                sc.nextLine();
                                switch (opcionTAgregarQuitar) {
                                    case 1:
                                        System.out.print("Cuál es el nombre del nuevo libro: "); //titulo, autor, editorial, genero 
                                        nombreNuevoLibro = sc.nextLine();
                                        autorNuevoLibro = sc.nextLine();
                                        editorialNuevoLibro = sc.nextLine();
                                        generoNuevoLibro = sc.nextLine();

                                        
                                        inventario.agregarLibro(nombreNuevoLibro, autorNuevoLibro, editorialNuevoLibro, generoNuevoLibro); 
                                        seleccionLibro = inventario.getLibro(rentaLibro);

                                        if (seleccionAlimento != null) {
                                            System.out.println("El libro: " + seleccionLibro.toString() + " se agrego exitosamente");
                                        }
                                        break;
                                    case 2:
                                        inventario.mostrarAlimentos();
                                        System.out.print("Cual es el nombre del alimento que se va a retirar: ");
                                        nombreAlimento = sc.nextLine();
                                        inventario.quitarAlimento(nombreAlimento);
                                        break;
                                    case 3:
                                        System.out.println("Saliendo...");
                                        break;
                                    default:
                                        System.out.println("Opcion invalida.");
                                }
                                break;
                            case 3://Agregar estantes
                                System.out.print("Que genero de libros tendra el estante: ");
                                generoEstante=sc.nextLine(); 
                                System.out.print("En que pasillo se ubicara el nuevo estante: "); 
                                pasillo=sc.nextInt();
                                sc.nextLine(); 
                                inventario.agregarEstante(generoEstante, pasillo);
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