package cl.lte;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        GestorPedidos gestor = new GestorPedidos();

        // Productos predefinidos
        Producto prod1 = new Producto(1, "Pan", 1000, 10);
        Producto prod2 = new Producto(2, "Leche", 1200, 8);
        Producto prod3 = new Producto(3, "Cafe", 3000, 5);

        do {
            System.out.println("=== Sistema de Pedidos ===");
            System.out.println("1: Realizar pedido");
            System.out.println("2: Cancelar pedido");
            System.out.println("3: Salir");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Pedido pedido = new Pedido();
                    pedido.agregarProducto(prod1, 2);
                    pedido.agregarProducto(prod2, 1);

                    if (gestor.validarStock(pedido)) {
                        gestor.realizarPedido(pedido);
                        System.out.println("Total del pedido: $" + pedido.calcularTotal());
                    } else {
                        System.out.println("Stock insuficiente para realizar el pedido");
                    }
                    break;

                case 2:
                    Pedido pedidoCancelado = new Pedido();
                    pedidoCancelado.agregarProducto(prod3, 1);
                    gestor.cancelarPedido(pedidoCancelado);
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