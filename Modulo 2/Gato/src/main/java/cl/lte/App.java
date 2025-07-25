package cl.lte;

/**
 * Hello world!
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tablero tablero = new Tablero();
        CPU cpu = new CPU();

        String turno = "JUGADOR";
        boolean hayGanador = false;

        System.out.println("¡Bienvenido al juego del Gato!");
        tablero.mostrar();

        do {
            if (turno.equals("JUGADOR")) {
                System.out.print(">> Tu turno (X). Ingresa fila y columna (ej: 0 2): ");
                int fila = sc.nextInt();
                int columna = sc.nextInt();

                if (tablero.estaVacio(fila, columna)) {
                    tablero.colocarFicha(fila, columna, 'X');

                    if (tablero.verificarGanador('X')) {
                        hayGanador = true;
                        System.out.println("🎉 ¡Felicidades! ¡Ganaste!");
                        tablero.mostrar();
                        break;
                    }

                    turno = "CPU";
                } else {
                    System.out.println("⚠ Esa posición ya está ocupada.");
                }

            } else {
                cpu.realizarJugada(tablero);

                if (tablero.verificarGanador('O')) {
                    hayGanador = true;
                    System.out.println("💻 La CPU ha ganado.");
                    tablero.mostrar();
                    break;
                }

                turno = "JUGADOR";
            }

            tablero.mostrar();

        } while (!hayGanador && tablero.hayEspaciosDisponibles());

        if (!hayGanador) {
            System.out.println("🤝 ¡Empate! El tablero está lleno.");
        }

        System.out.println(">> Fin de la partida.");
    }
}