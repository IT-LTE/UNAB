/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.android.ae2abpro3.ae2abpro3;

import java.util.Scanner;

/**
 *
 * @author Alejandra Flaño
 * fecha 7/7/2025
 * 
 */

public class Cliente {

    private int rut = 0, salud = 0, edad = 0;
    private String nombres, apellidos, fono, afp, direccion, comuna;

    public void agregarCliente() {
        Scanner sc = new Scanner(System.in); // Solo un Scanner

        agregarRut(sc);
        agregarNombres(sc);
        agregarApellidos(sc);
        agregarTelefono(sc);
        agregarAfp(sc);
        agregarDireccion(sc);
        agregarComuna(sc);

        System.out.println("\nCliente ingresado exitosamente.\n");
        mostrarCliente();
    }

    private void agregarNombres(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese el nombre del cliente: ");
            String input = sc.nextLine().trim().toUpperCase();
            if (!input.isEmpty()) {
                nombres = input;
                estaOk=true;
            } else {
                System.out.println("El nombre no puede estar en blanco.");
            }
        } while (!(estaOk));
    }

    private void agregarRut(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese el Rut del cliente (solo números): ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d+")) {
                int valor = Integer.parseInt(input);
                if (valor >= 0 && valor <= 99999999) {
                    rut = valor;
                    estaOk=true;
                } else {
                    System.out.println("El rut debe estar entre 0 y 99999999.");
                }
            } else {
                System.out.println("Debe Ingresar solo números.");
            }
        } while (!(estaOk));
    }

    private void agregarApellidos(Scanner sc) {
        boolean estaOk =false;
        do {
            System.out.println("Ingrese los apellidos del cliente: ");
            String input = sc.nextLine().trim().toUpperCase();
            if (!input.isEmpty()) {
                apellidos = input;
                estaOk=true;
            } else {
                System.out.println("Los apellidos no puede estar en blanco.");
            }
        } while (!(estaOk));
    }

    private void agregarTelefono(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese el número de teléfono del cliente: ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.length() <= 15) {
                fono = input;
                estaOk=true;
            } else {
                System.out.println("Teléfono inválido. Máximo 15 caracteres.");
            }
        } while (!(estaOk));
    }

    private void agregarAfp(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese la AFP del cliente: ");
            String input = sc.nextLine().trim().toUpperCase();
            if (!input.isEmpty()) {
                afp = input;
                estaOk =true;
            } else {
                System.out.println("La AFP no puede estar en blanco.");
            }
        } while (!(estaOk));
    }

    private void agregarDireccion(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese la dirección del cliente: ");
            String input = sc.nextLine().trim().toUpperCase();
            if (!input.isEmpty() && input.length() <= 50) {
                direccion = input;
                estaOk=true;
            } else {
                System.out.println("Dirección inválida. Máximo 50 caracteres.");
            }
        } while (!(estaOk));
    }

    private void agregarComuna(Scanner sc) {
        boolean estaOk=false;
        
        do {
            System.out.println("Ingrese la comuna del cliente: ");
            String input = sc.nextLine().trim().toUpperCase();
            if (!input.isEmpty()) {
                comuna = input;
                estaOk=true;
            } else {
                System.out.println("La comuna no puede estar en blanco.");
            }
        } while (!(estaOk));
    }

    public void mostrarCliente() {
        System.out.println("----------------------------------");
        System.out.println("RUT       : " + rut);
        System.out.println("Nombre    : " + nombres + " " + apellidos);
        System.out.println("Teléfono  : " + fono);
        System.out.println("AFP       : " + afp);
        System.out.println("Dirección : " + direccion);
        System.out.println("Comuna    : " + comuna);
        System.out.println("----------------------------------");
    }
}