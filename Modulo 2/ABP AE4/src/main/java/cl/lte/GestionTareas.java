package cl.lte;

import java.util.Scanner;

/**
 * Clase que permite gestionar una lista de tareas.
 */
public class GestionTareas {
    private Tarea[] tareas;
    private int cantidad;
    private Scanner sc;

    /**
     * Constructor que inicializa la lista de tareas.
     */
    public GestionTareas() {
        tareas = new Tarea[100];
        cantidad = 0;
        sc = new Scanner(System.in);
    }

    /**
     * Muestra el menú interactivo de opciones.
     */
    public void mostrarMenu() {
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- MENÚ DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Mostrar todas las tareas");
            System.out.println("5. Mostrar tareas pendientes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    eliminarTarea();
                    break;
                case 3:
                    marcarTareaComoCompletada();
                    break;
                case 4:
                    mostrarTodasLasTareas();
                    break;
                case 5:
                    mostrarTareasPendientes();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Agrega una nueva tarea a la lista.
     */
    public void agregarTarea() {
        System.out.print("Ingrese la descripción de la tarea: ");
        String descripcion = sc.nextLine();
        tareas[cantidad] = new Tarea(descripcion);
        cantidad++;
        System.out.println("Tarea agregada correctamente.");
    }

    /**
     * Elimina una tarea buscándola por descripción.
     */
    public void eliminarTarea() {
        System.out.print("Ingrese la descripción de la tarea a eliminar: ");
        String descripcion = sc.nextLine();
        boolean encontrada = false;

        for (int i = 0; i < cantidad; i++) {
            if (tareas[i].getDescripcion().equalsIgnoreCase(descripcion)) {
                for (int j = i; j < cantidad - 1; j++) {
                    tareas[j] = tareas[j + 1];
                }
                tareas[cantidad - 1] = null;
                cantidad--;
                encontrada = true;
                System.out.println("Tarea eliminada.");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Tarea no encontrada.");
        }
    }

    /**
     * Marca una tarea como completada buscándola por descripción.
     */
    public void marcarTareaComoCompletada() {
        System.out.print("Ingrese la descripción de la tarea a marcar como completada: ");
        String descripcion = sc.nextLine();
        boolean encontrada = false;

        for (int i = 0; i < cantidad; i++) {
            if (tareas[i].getDescripcion().equalsIgnoreCase(descripcion)) {
                if (!tareas[i].estaCompletada()) {
                    tareas[i].marcarComoCompletada();
                    System.out.println("Tarea marcada como completada.");
                } else {
                    System.out.println("La tarea ya estaba completada.");
                }
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Tarea no encontrada.");
        }
    }

    /**
     * Muestra todas las tareas, indicando si están completadas o no.
     */
    public void mostrarTodasLasTareas() {
        System.out.println("\n--- TODAS LAS TAREAS ---");
        if (cantidad == 0) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + tareas[i].mostrar());
            }
        }
    }

    /**
     * Muestra únicamente las tareas que aún no están completadas.
     */
    public void mostrarTareasPendientes() {
        System.out.println("\n--- TAREAS PENDIENTES ---");
        boolean hayPendientes = false;

        for (int i = 0; i < cantidad; i++) {
            if (!tareas[i].estaCompletada()) {
                System.out.println((i + 1) + ". " + tareas[i].mostrar());
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("No hay tareas pendientes.");
        }
    }
}
