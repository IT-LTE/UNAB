package cl.lte;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
        inicializar();
    }

    // Inicializa el tablero con guiones
    public void inicializar() {
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                tablero[fila][col] = '-';
            }
        }
    }

    // Dibuja el tablero en consola con flechas guía
    public void mostrar() {
        System.out.println("\n   ↘ columnas");
        System.out.println("    0   1   2 ");
        for (int fila = 0; fila < 3; fila++) {
            System.out.print(fila + " | ");
            for (int col = 0; col < 3; col++) {
                System.out.print(tablero[fila][col] + " | ");
            }
            System.out.println();
        }
        System.out.println("↑\nfilas");
    }

    // Coloca ficha en una posición dada
    public void colocarFicha(int fila, int columna, char ficha) {
        tablero[fila][columna] = ficha;
    }

    // Verifica si la celda está vacía
    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == '-';
    }

    // Revisa si quedan espacios para jugar
    public boolean hayEspaciosDisponibles() {
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                if (tablero[fila][col] == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    // Devuelve el símbolo de una celda
    public char getFicha(int fila, int columna) {
        return tablero[fila][columna];
    }
}
