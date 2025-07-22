package cl.lte;

import java.util.Scanner;

public class EntradaTexto {

    // Pide al usuario un texto, validando que no esté vacío
    public String pedirTexto() {
        Scanner sc = new Scanner(System.in);
        String texto;

        do {
            System.out.print("Ingrese una cadena de texto: ");
            texto = sc.nextLine().trim().toUpperCase();
        } while (texto.isEmpty());

        return texto;
    }
}