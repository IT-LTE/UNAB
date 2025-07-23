package cl.lte;

/**
 * Autor: Alejandra Flaño
 * Fecha: 21/7/2025
 *
 * Ejercicio de caja chica
 */

public class App {
    public static void main(String[] args) {
        GestionUsuario gestionUsuario = new GestionUsuario();
        boolean accesoOk = gestionUsuario.iniciarSesion();

        if (accesoOk) {
            GestionProyecto gestionProyecto = new GestionProyecto();
            gestionProyecto.mostrarProyectosDisponibles();
        }
    }
}
