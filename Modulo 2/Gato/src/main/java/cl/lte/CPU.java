package cl.lte;

import java.util.Random;

public class CPU {

    public void realizarJugada(Tablero tablero) {
        Random random = new Random();
        int fila, columna;

        // Busca una celda vacía al azar
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!tablero.estaVacio(fila, columna));

        tablero.colocarFicha(fila, columna, 'O');
        System.out.println(">> CPU ha jugado en posición (" + fila + ", " + columna + ")");
    }
}
