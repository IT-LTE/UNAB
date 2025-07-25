package cl.lte;

import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private char turnoActual; // 'X' jugador, 'O' CPU
    private Scanner sc;

    public Juego() {
        tablero = new Tablero();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bienvenido al Juego del Gato 🐱\n");
        tablero.mostrar();

        elegirQuienParte();
        System.out.println("Turno inicial: " + (turnoActual == 'X' ? "Jugador (X)" : "CPU (O)"));
        System.out.println();

        // Jugada inicial si parte el jugador (por ahora solo jugamos una vez)
        if (turnoActual == 'X') {
            turnoJugador();
        } else {
            System.out.println("[⚠️ CPU aún no implementado en esta etapa]");
        }

        System.out.println("\n[Etapa 3] Jugada realizada. Continuaremos con más lógica en próximas etapas.");
    }

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

    // Nueva lógica para que el jugador haga una jugada
    private void turnoJugador() {
        int fila = -1;
        int columna = -1;

        System.out.println("Tu turno, Jugador (X)");

        while (true) {
            System.out.print("Ingrese fila (0-2): ");
            fila = leerNumero();

            System.out.print("Ingrese columna (0-2): ");
            columna = leerNumero();

            if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
                if (tablero.estaVacia(fila, columna)) {
                    tablero.marcarCasilla(fila, columna, 'X');
                    tablero.mostrar();
                    break;
                } else {
                    System.out.println("⚠️ Esa casilla ya está ocupada. Intente otra.\n");
                }
            } else {
                System.out.println("⚠️ Posición inválida. Use valores entre 0 y 2.\n");
            }
        }
    }

    // Método auxiliar para leer número del teclado
    private int leerNumero() {
        String entrada = sc.nextLine().trim();
        if (entrada.length() == 1 && Character.isDigit(entrada.charAt(0))) {
            return Integer.parseInt(entrada);
        }
        return -1;
    }
}