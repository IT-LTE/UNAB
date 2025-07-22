package cl.lte;

public class App {
    public static void main(String[] args) {
        // Clase principal limpia, delega funciones
        EntradaTexto entrada = new EntradaTexto();
        String texto = entrada.pedirTexto();

        LeerCaracteres lector = new LeerCaracteres();
        char[] arregloCaracteres = lector.obtenerCaracteres(texto);

        ContarLetras contador = new ContarLetras();
        contador.contarYMostrar(arregloCaracteres);
    }
}