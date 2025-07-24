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
        Usuario usuario = gestionUsuario.ingresarUsuario();

        if (usuario != null) {
            GestionCajaChica gestionCajaChica = new GestionCajaChica();
            gestionCajaChica.mostrarCajasDisponibles(usuario);
            gestionCajaChica.simularRegistrosCaja();
        }
    }
}