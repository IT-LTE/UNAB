package cl.lte;

import java.util.ArrayList;

public class GestionNotas {
    Estudiante[] estudiantes;
    int contador = 0;

    public GestionNotas(int capacidad) {
        estudiantes = new Estudiante[capacidad];
    }

    public void agregarEstudiante(String nombre, ArrayList<Double> notas) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = new Estudiante(nombre, notas);
            contador++;
        } else {
            System.out.println("No se pueden agregar más estudiantes.");
        }
    }

    public void mostrarTodos() {
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados.\n");
            return;
        }

        System.out.println("\n=== LISTADO DE ESTUDIANTES ===");
        for (int i = 0; i < contador; i++) {
            Estudiante e = estudiantes[i];
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Notas: " + e.getNotas());
            System.out.println("Promedio: " + String.format("%.2f", e.calcularPromedio()));
            if (e.estaAprobado()) {
                System.out.println("Estado: Aprobado");
            } else {
                System.out.println("Estado: Reprobado");
            }
            System.out.println("---------------------------");
        }
    }

    public void mostrarAprobados() {
        System.out.println("\n=== ESTUDIANTES APROBADOS ===");
        boolean hayAprobados = false;
        for (int i = 0; i < contador; i++) {
            Estudiante e = estudiantes[i];
            if (e.estaAprobado()) {
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Promedio: " + String.format("%.2f", e.calcularPromedio()));
                hayAprobados = true;
            }
        }
        if (!hayAprobados) {
            System.out.println("Ningún estudiante aprobado.");
        }
        System.out.println();
    }

    public void ordenarPorPromedioDesc() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (estudiantes[i].calcularPromedio() < estudiantes[j].calcularPromedio()) {
                    Estudiante temp = estudiantes[i];
                    estudiantes[i] = estudiantes[j];
                    estudiantes[j] = temp;
                }
            }
        }
        System.out.println("\nEstudiantes ordenados por promedio (de mayor a menor).\n");
    }
}