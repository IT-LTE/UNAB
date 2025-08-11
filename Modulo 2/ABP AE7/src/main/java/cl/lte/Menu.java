package cl.lte;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Sistema de Pedidos ===");
            System.out.println("1: Realizar pedido");
            System.out.println("2: Cancelar pedido");
            System.out.println("3: Salir");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Realizarndo pedido...");
                    break;
                case 2:
                    System.out.println("Cancelando pedido...");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
}