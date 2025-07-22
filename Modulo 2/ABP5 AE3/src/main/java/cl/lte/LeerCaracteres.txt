package cl.lte;

public class LeerCaracteres {

    // Lee el texto y lo convierte en un arreglo de caracteres
    public char[] obtenerCaracteres(String texto) {
        char[] letras = new char[texto.length()];

        System.out.println("\nCaracteres ingresados:");
        for (int i = 0; i < texto.length(); i++) {
            letras[i] = texto.charAt(i);
            System.out.println("[" + i + "]: " + letras[i]);
        }

        return letras;
    }
}
