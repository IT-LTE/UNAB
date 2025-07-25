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

        String turno = "JUGADOR"; // Comienza el jugador

        System.out.println("¡Bienvenido al juego del Gato!");
        tablero.mostrar(); // Mostrar el tablero inicial

        // Bucle principal del juego
        do {
            if (turno.equals("JUGADOR")) {
                System.out.print(">> Tu turno (X). Ingresa fila y columna (ej: 0 2): ");
                int fila = sc.nextInt();
                int columna = sc.nextInt();

                // Validar posición libre
                if (tablero.estaVacio(fila, columna)) {
                    tablero.colocarFicha(fila, columna, 'X');
                    turno = "CPU"; // Cambiar el turno
                } else {
                    System.out.println("¡Esa posición ya está ocupada!");
                }
            } else {
                cpu.realizarJugada(tablero);
                turno = "JUGADOR"; // Cambiar el turno
            }

            tablero.mostrar(); // Mostrar el tablero después de cada jugada

        } while (tablero.hayEspaciosDisponibles());

        System.out.println(">> ¡El tablero está lleno!");
        System.out.println(">> Fin de la partida.");
    }
}