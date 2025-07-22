package cl.lte;

import java.util.ArrayList;

public class Estudiante {
    String nombre = "";
    ArrayList<Double> notas = new ArrayList<>();

    public Estudiante(String nombre, ArrayList<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= 4.0;
    }
}