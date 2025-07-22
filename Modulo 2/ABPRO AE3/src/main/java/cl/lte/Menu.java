package cl.lte;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    GestionNotas gestion = new GestionNotas(50);

    public void mostrar() {
        System.out.println("===================================");
        System.out.println(" Bienvenido al Sistema de Notas ");
        System.out.println("===================================");

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Mostrar estudiantes aprobados");
            System.out.println("4. Ordenar estudiantes por promedio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    gestion.mostrarTodos();
                    break;
                case 3:
                    gestion.mostrarAprobados();
                    break;
                case 4:
                    gestion.ordenarPorPromedioDesc();
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro sistema.");
                    break;
                default:
                    System.out.println("Esta opcion no existe, vuelve a ingresar.\n");
                    break;
            }

        } while (opcion != 5);
        sc.close();
    }

    void agregarEstudiante() {
        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();

        ArrayList<Double> notas = new ArrayList<>();
        System.out.print("¿Cuantas notas desea ingresar? ");
        int cantidadNotas = sc.nextInt();

        for (int i = 0; i < cantidadNotas; i++) {
            double nota;
            do {
                System.out.print("Nota " + (i + 1) + " (1.0 a 7.0): ");
                nota = sc.nextDouble();
                if (nota < 1.0 || nota > 7.0) {
                    System.out.println("Nota invalida. Ingrese una nota entre 1.0 y 7.0.");
                }
            } while (nota < 1.0 || nota > 7.0);
            notas.add(nota);
        }
        sc.nextLine(); // limpiar buffer

        gestion.agregarEstudiante(nombre, notas);
    }
}