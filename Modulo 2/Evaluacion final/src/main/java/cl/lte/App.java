package cl.lte;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contenedor contenedor = new Contenedor();
        int opcion;

        do {
            System.out.println("\n=== Sistema de asesorías ===");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Profesional");
            System.out.println("3. Agregar Administrativo");
            System.out.println("4. Agregar Capacitación");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Listar Usuarios");
            System.out.println("7. Listar Usuario por Tipo");
            System.out.println("8. Listar Capacitaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    almacenarCliente(contenedor, scanner);
                    break;

                case 2:
                    almacenarProfesional(contenedor, scanner);
                    break;

                case 3:
                    almacenarAdministrativo(contenedor, scanner);
                    break;

                case 4:
                    almacenarCapacitacion(contenedor, scanner);
                    break;

                case 5:
                    System.out.print("Ingrese el RUN del usuario a eliminar: ");
                    int runEliminar = scanner.nextInt();
                    scanner.nextLine();
                    boolean eliminado = contenedor.eliminarUsuario(runEliminar);
                    if (eliminado) {
                        System.out.println("Usuario eliminado exitosamente.");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 6:
                    contenedor.listarUsuarios();
                    break;

                case 7:
                    System.out.print("Ingrese el tipo de usuario a listar (Cliente, Profesional, Administrativo): ");
                    String tipo = scanner.nextLine();
                    contenedor.Listar_usuarios_por_tipo(tipo);
                    break;

                case 8:
                    // Lógica para listar capacitaciones
                    contenedor.listar_capacitacion();
                    break;

                default:
                    break;
            }

        } while (opcion != 0);
    }

    private static void almacenarCliente(Contenedor contenedor, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("RUN: ");
        int run = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("AFP: ");
        String afp = scanner.nextLine();
        System.out.print("Sistema de Salud (1: Fonasa, 2: Isapre): ");
        int sistemaSalud = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Comuna: ");
        String comuna = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nombre, fechaNacimiento, run, run, nombres, apellidos,
                telefono, afp, sistemaSalud, direccion, comuna, edad);
        contenedor.agregar_cliente(cliente);

        System.out.println("Cliente " + cliente.obtenerNombre() + " agregado exitosamente.");

    }

    private static void almacenarProfesional(Contenedor contenedor, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("RUN: ");
        int run = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Fecha de ingreso (dd/mm/yyyy): ");
        String fechaIngreso = scanner.nextLine();

        Profesional profesional = new Profesional(nombre, fechaNacimiento, run, titulo, fechaIngreso);
        contenedor.agregar_profesional(profesional);

        System.out.println("Profesional " + profesional.getNombre() + " agregado exitosamente.");
    }

    private static void almacenarAdministrativo(Contenedor contenedor, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("RUN: ");
        int run = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
        System.out.print("Experiencia previa: ");
        String experienciaPrevia = scanner.nextLine();

        Administrativo administrativo = new Administrativo(nombre, fechaNacimiento, run, area,
                experienciaPrevia);
        contenedor.agregar_administrativo(administrativo);

        System.out.println("Administrativo " + administrativo.getNombre() + " agregado exitosamente.");
    }

    private static void almacenarCapacitacion(Contenedor contenedor, Scanner scanner) {
        int idCapacitacion = contenedor.getCapacitaciones().size() + 1;
        System.out.println("Rut del cliente: ");
        int rutCliente = scanner.nextInt();
        scanner.nextLine();

        boolean usuarioValido = contenedor.existeUsuario(rutCliente);
        if (!usuarioValido) {
            System.out.println("El usuario con RUN " + rutCliente + " no existe.");
            return;
        }
        System.out.println("Dia (Lunes, Martes, etc): ");
        String dia = scanner.nextLine();

        System.out.println("Hora (HH:mm): ");
        String hora = scanner.nextLine();

        System.out.println("Lugar: ");
        String lugar = scanner.nextLine();

        System.out.println("Duracion: ");
        String duracion = scanner.nextLine();

        System.out.println("Cantidad de asistentes: ");
        int cantidadAsistentes = scanner.nextInt();
        scanner.nextLine();

        Capacitacion capacitacion = new Capacitacion(idCapacitacion, rutCliente, dia, hora, lugar, duracion,
                cantidadAsistentes);
        contenedor.agregar_capacitacion(capacitacion);

        System.out.println("Capacitación almacenada exitosamente.");
        System.out.println(capacitacion.mostrarDetalle());
    }
}