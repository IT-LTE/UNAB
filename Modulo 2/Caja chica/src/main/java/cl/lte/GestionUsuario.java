package cl.lte;

import java.util.Scanner;
import java.time.LocalTime;

public class GestionUsuario {
    private Usuario usuario;

    public GestionUsuario() {
        this.usuario = new Usuario("ftapia", "clavePAR", "claveIMPAR");
    }

    public boolean iniciarSesion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre de usuario: ");
        String nombreIngresado = sc.nextLine().trim().toLowerCase();

        if (!validarNombre(nombreIngresado)) {
            System.out.println("Usuario no valido");
            return false;
        }

        System.out.print("Ingrese clave: ");
        String claveIngresada = sc.nextLine().trim();

        int minuto = LocalTime.now().getMinute();

        if (usuario.claveValida(claveIngresada, minuto)) {
            System.out.println("Acceso concedido");
            return true;
        }

        mostrarMensajeErrorClave(minuto);
        return false;
    }

    private boolean validarNombre(String nombre) {
        return nombre.equals(usuario.getNombre());
    }

    private void mostrarMensajeErrorClave(int minuto) {
        if (minuto % 2 == 0) {
            System.out.println("Clave incorrecta para minuto par");
        } else {
            System.out.println("Clave incorrecta para minuto impar");
        }
    }
}
