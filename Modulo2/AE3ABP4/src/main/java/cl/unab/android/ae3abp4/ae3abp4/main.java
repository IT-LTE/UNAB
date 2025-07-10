/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.android.ae3abp4.ae3abp4;

//import cl.unab.android.ae3abp4.ae3abp4.Alumno;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alejandra Flaño Fecha 26/06/2025
 *
 *
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        boolean terminarIngreso = false;

        while (!terminarIngreso) {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = sc.nextLine().trim().toUpperCase();

            if (nombre.equals("SALIR")) {
                if (alumnos.size() >= 2) {
                    terminarIngreso = true;
                } else {
                    System.out.println("⚠️ Debe ingresar al menos 2 alumnos antes de salir.");
                }
            } else if (nombre.isEmpty()) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            } else {
                Alumno alumno = new Alumno(nombre);

                System.out.println("Ingrese las notas del alumno (ingrese un número cero para terminar):");
                boolean notasValidas = false;
                boolean terminarNotas = false;

                while (!terminarNotas) {
                    System.out.print("Nota: ");
                    String entrada = sc.nextLine().trim().toUpperCase();

                    if (esNumeroValido(entrada)) {
                        double nota = Double.parseDouble(entrada);
                        if (nota <= 0) {
                            terminarNotas = true;
                        } else if (nota <= 7) {
                            alumno.notas.add(nota);
                            notasValidas = true;
                        } else {
                            System.out.println("La nota debe estar entre 0 y 7.");
                        }
                    } else {
                        System.out.println("Ingrese un número válido.");
                    }
                }

                if (!notasValidas) {
                    System.out.println("Ingrese al menos una nota.");
                } else {
                    double suma = 0;
                    for (double n : alumno.notas) {
                        suma += n;
                    }
                    alumno.promedio = suma / alumno.notas.size();

                    alumnos.add(alumno);
                }
            }
        }

        // Calcular mayor y menor promedio
        double mayorProm = -1;
        double menorProm = 8;
        String nombresMayor = "";
        String nombresMenor = "";

        for (Alumno estudiante : alumnos) {
            if (estudiante.promedio > mayorProm) {
                mayorProm = estudiante.promedio;
                nombresMayor = estudiante.nombre;
            } else if (estudiante.promedio == mayorProm) {
                nombresMayor += " - " + estudiante.nombre;
            }

            if (estudiante.promedio < menorProm) {
                menorProm = estudiante.promedio;
                nombresMenor = estudiante.nombre;
            } else if (estudiante.promedio == menorProm) {
                nombresMenor += " - " + estudiante.nombre;
            }
        }

        System.out.println("\n📊 Resultados Finales:");
        System.out.printf("Mayor promedio: %.2f\n", mayorProm);
        System.out.println("Alumno(s) con mayor promedio: " + nombresMayor);
        System.out.printf("Menor promedio: %.2f\n", menorProm);
        System.out.println("Alumno(s) con menor promedio: " + nombresMenor);

    }

    public static boolean esNumeroValido(String texto) {
        int puntos = 0;
        if (texto.isEmpty()) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '.') {
                puntos++;
                if (puntos > 1) {
                    return false;
                }
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
