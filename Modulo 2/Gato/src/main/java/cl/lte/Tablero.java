package cl.lte;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrar() {
        System.out.println("     → Columnas");
        System.out.println("     0   1   2");
        System.out.println("   ┌───┬───┬───┐");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + i + " │");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j] + " │");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("   ├───┼───┼───┤");
            }
        }
        System.out.println("   └───┴───┴───┘");
        System.out.println(" ↑\n Fila");
    }

    public boolean estaVacia(int fila, int columna) {
        return tablero[fila][columna] == ' ';
    }

    public void marcarCasilla(int fila, int columna, char simbolo) {
        tablero[fila][columna] = simbolo;
    }
}
