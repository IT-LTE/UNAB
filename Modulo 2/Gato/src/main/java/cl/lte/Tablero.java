package cl.lte;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
        inicializar();
    }

    // Llena el tablero con espacios vacíos
    public void inicializar() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = ' ';
            }
        }
    }

    // Dibuja el tablero con indicadores de filas y columnas
    public void mostrar() {
        System.out.println("\n     → Columnas");
        System.out.println("     0   1   2");
        System.out.println("   ┌───┬───┬───┐");
        for (int fila = 0; fila < 3; fila++) {
            System.out.print(" " + fila + " │"); // ← Fila
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(" " + tablero[fila][columna] + " │");
            }
            System.out.println();
            if (fila < 2) {
                System.out.println("   ├───┼───┼───┤");
            }
        }
        System.out.println("   └───┴───┴───┘");
        System.out.println(" ↑");
        System.out.println(" Fila\n");
    }
}
