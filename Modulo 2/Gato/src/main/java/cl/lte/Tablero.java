package cl.lte;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
        inicializar();
    }

    public void inicializar() {
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                tablero[fila][col] = '-';
            }
        }
    }

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

    public void colocarFicha(int fila, int columna, char ficha) {
        tablero[fila][columna] = ficha;
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == '-';
    }

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

    public char getFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    // ✅ Nuevo: Verificar si la ficha dada ha ganado
    public boolean verificarGanador(char ficha) {
        // Verificar filas
        for (int fila = 0; fila < 3; fila++) {
            if (tablero[fila][0] == ficha && tablero[fila][1] == ficha && tablero[fila][2] == ficha) {
                return true;
            }
        }

        // Verificar columnas
        for (int col = 0; col < 3; col++) {
            if (tablero[0][col] == ficha && tablero[1][col] == ficha && tablero[2][col] == ficha) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            return true;
        }
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
            return true;
        }

        return false;
    }
}
