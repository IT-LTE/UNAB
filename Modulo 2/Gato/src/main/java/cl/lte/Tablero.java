package cl.lte;

public class Tablero {
    private char[][] tablero = new char[3][3];

    public Tablero() {
        // Inicializa con espacios vacíos
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = '-';
    }

    public void mostrar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
