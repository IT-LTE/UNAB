package cl.lte;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GestionUsuario {
    private final Scanner sc = new Scanner(System.in);

    public Usuario ingresarUsuario() {
        System.out.println("Ingrese nombre de usuario:");
        String nombre = sc.nextLine().trim().toUpperCase();

        Usuario usuario = new Usuario("FTAPIA", "1234", "5678");

        if (!usuario.getNombre().equals(nombre)) {
            System.out.println("Usuario no válido");
            return null;
        }

        System.out.println("Ingrese clave:");
        String clave = sc.nextLine().trim();

        int minuto = LocalDateTime.now().getMinute();
        boolean esPar = minuto % 2 == 0;

        if (esPar && clave.equals(usuario.getClavePar())) {
            return usuario;
        } else if (!esPar && clave.equals(usuario.getClaveImpar())) {
            return usuario;
        } else {
            System.out.println("Clave incorrecta para el minuto actual");
            return null;
        }
    }
}
