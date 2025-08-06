package cl.lte;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        Menu menu = new Menu(sistema);
        menu.mostrar();
    }
}
