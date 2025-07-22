package cl.lte;

import java.util.Scanner;
import java.time.LocalTime;

public class GestionUsuario {
    private Usuario usuario;

    public GestionUsuario() {
        this.usuario = new Usuario("aflano", "AB02", "CD01");
    }

    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre de usuario: ");
        String nombreIngresado = sc.nextLine().trim().toLowerCase();

        if (!nombreIngresado.equals(usuario.getNombre())) {
            System.out.println("Usuario no valido");
            return;
        }

        System.out.print("Ingrese clave: ");
        String claveIngresada = sc.nextLine().trim();

        int minuto = LocalTime.now().getMinute();

        if (usuario.claveValida(claveIngresada, minuto)) {
            System.out.println("Acceso concedido");
        } else {
            if (minuto % 2 == 0) {
                System.out.println("Clave incorrecta para minuto par");
            } else {
                System.out.println("Clave incorrecta para minuto impar");
            }
        }
    }
}
