/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cl.unab.android.ae2abpro3.ae2abpro3;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Alejandra Flaño Fecha 2/07/2028 Funcion que muestra el menu a
 * utilizar en la consola
 *
 */


public class Menu {

    // Lista para almacenar a todos los clientes
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void despliegueMenu() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        do {
            limpiarConsola();
            System.out.println("Bienvenido a la compañía de seguros");
            System.out.println(" --------------------------------");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Mostrar lista de Clientes");
            System.out.println("3. Salir");
            System.out.println(" --------------------------------");
            System.out.print("Opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar salto de línea
            } else {
                System.out.println("Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar entrada errónea
            }

            switch (opcion) {
                case 1:
                    Cliente nuevoCliente = new Cliente();
                    nuevoCliente.agregarCliente();
                    listaClientes.add(nuevoCliente);
                    break;

                case 2:
                    if (listaClientes.isEmpty()) {
                        System.out.println("No hay clientes registrados aún.");
                    } else {
                        System.out.println("Lista de clientes:");
                        for (int i = 0; i < listaClientes.size(); i++) {
                            System.out.println("\nCliente #" + (i + 1));
                            listaClientes.get(i).mostrarCliente();
                        }
                    }
                   break;

                case 3:
                    System.out.println(" Muchas gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente nuevamente.");
                    break;
            }

        } while (opcion != 3);
    }

    private void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
        }
    }
}