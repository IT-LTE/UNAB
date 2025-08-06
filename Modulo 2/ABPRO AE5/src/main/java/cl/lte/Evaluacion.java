package cl.lte;

import java.util.HashMap;
import java.util.Map;

public class Evaluacion {
    private String tipo;
    private String fecha;
    private double puntajeMaximo;
    private Map<Estudiante, Double> notas;

    public Evaluacion(String tipo, String fecha, double puntajeMaximo) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.puntajeMaximo = puntajeMaximo;
        this.notas = new HashMap<>();
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public double getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void asignarNota(Estudiante estudiante, double nota) {
        if (nota >= 0 && nota <= puntajeMaximo) {
            notas.put(estudiante, nota);
        }
    }

    public Map<Estudiante, Double> getNotas() {
        return notas;
    }

    public double obtenerNotaEstudiante(Estudiante estudiante) {
        return notas.getOrDefault(estudiante, 0.0);
    }

    public double calcularPromedioNotas() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double nota : notas.values()) {
            suma += nota;
        }
        return Math.round(suma / notas.size() * 100.0) / 100.0;
    }
}
