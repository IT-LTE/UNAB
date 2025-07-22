package cl.lte;

public class ContarLetras{

    // Cuenta y muestra la cantidad de letras del abecedario
    public void contarYMostrar(char[] letras) {
        int[] conteo = new int[26]; // A-Z

        for (char letra : letras) {
            // Convertimos a mayúscula y validamos si es letra A-Z
            if (letra >= 'A' && letra <= 'Z') {
                int posicion = letra - 'A';
                conteo[posicion]++;
            }
        }

        System.out.println("\nConteo de letras (A-Z):");
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            int posicion = letra - 'A';
            System.out.println(letra + ": " + conteo[posicion]);
        }
    }
}
