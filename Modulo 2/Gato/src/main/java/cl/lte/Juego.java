package cl.lte;

import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private char turnoActual; // 'X' para jugador, 'O' para CPU
    private Scanner sc;

    public Juego() {
        tablero = new Tablero();
        sc = new Scanner(System.in);
    }

    // Inicia el flujo principal del juego
    public void iniciar() {
        System.out.println("Bienvenido al Juego del Gato 🐱\n");
        tablero.mostrar();

        elegirQuienParte();
        System.out.println("Turno inicial: " + (turnoActual == 'X' ? "Jugador (X)" : "CPU (O)"));

        // Aún no implementamos jugadas, eso será en próximas etapas
        System.out.println("\n[Etapa 2] Juego listo para avanzar con lógica de turnos...");
    }

    // Pregunta quién comienza el juego
    private void elegirQuienParte() {
        int eleccion = 0;

        do {
            System.out.println("¿Quién comienza?");
            System.out.println("1. Jugador (X)");
            System.out.println("2. CPU (O)");
            System.out.print("Seleccione una opción (1 o 2): ");
            String entrada = sc.nextLine().trim();

            if (entrada.equals("1")) {
                turnoActual = 'X';
                eleccion = 1;
            } else if (entrada.equals("2")) {
                turnoActual = 'O';
                eleccion = 2;
            } else {
                System.out.println("⚠️ Opción inválida. Intente nuevamente.\n");
            }

        } while (eleccion == 0);
    }
}