package cl.lte;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoNotas {
    Scanner sc = new Scanner(System.in);
    ArrayList<Alumno> lista = new ArrayList<>();

    public void iniciar() {
        System.out.println("=== Sistema de Notas ===");

        String nombre;

        do {
            System.out.print("Ingrese nombre del alumno (o SALIR para terminar): ");
            nombre = sc.nextLine().trim().toUpperCase();

            if (!nombre.equals("SALIR")) {
                System.out.print("Ingrese la nota del alumno (1.0 a 7.0): ");
                double nota = leerNota();
                Alumno alumno = new Alumno(nombre, nota);
                lista.add(alumno);
            }

        } while (!nombre.equals("SALIR"));

        if (lista.size() < 2) {
            System.out.println("Debe ingresar al menos dos alumnos.");
        } else {
            mostrarResultados();
        }
    }

    private double leerNota() {
        double nota = 0;
        boolean valido = false;

        while (!valido) {
            if (sc.hasNextDouble()) {
                nota = sc.nextDouble();
                sc.nextLine(); // limpiar salto de línea
                if (nota >= 1.0 && nota <= 7.0) {
                    valido = true;
                } else {
                    System.out.print("Nota fuera de rango. Ingrese nuevamente (1.0 a 7.0): ");
                }
            } else {
                sc.nextLine(); // limpiar entrada inválida
                System.out.print("Entrada inválida. Ingrese un número válido: ");
            }
        }

        return nota;
    }

    private void mostrarResultados() {
        double suma = 0;
        Alumno mejor = lista.get(0);
        Alumno peor = lista.get(0);

        for (Alumno a : lista) {
            suma += a.getNota();

            if (a.getNota() > mejor.getNota()) {
                mejor = a;
            }

            if (a.getNota() < peor.getNota()) {
                peor = a;
            }
        }

        double promedio = Math.round((suma / lista.size()) * 100.0) / 100.0;

        System.out.println("\n--- Resultados ---");
        System.out.println("Promedio del curso: " + promedio);
        System.out.println("Alumno con mayor nota: " + mejor.getNombre() + " (" + mejor.getNota() + ")");
        System.out.println("Alumno con menor nota: " + peor.getNombre() + " (" + peor.getNota() + ")");
    }
}
