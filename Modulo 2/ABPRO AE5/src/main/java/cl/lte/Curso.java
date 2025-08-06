package cl.lte;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;
    private Docente docente;
    private List<Estudiante> estudiantes;
    private List<Evaluacion> evaluaciones;

    public Curso(String codigo, String nombre, int creditos, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
        this.estudiantes = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public Docente getDocente() {
        return docente;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    public void agregarEvaluacion(Evaluacion evaluacion) {
        evaluaciones.add(evaluacion);
    }

    public double calcularPromedioCurso() {
        double total = 0;
        int cantidad = 0;
        for (Evaluacion e : evaluaciones) {
            total += e.calcularPromedioNotas();
            cantidad++;
        }
        if (cantidad == 0) return 0;
        return Math.round(total / cantidad * 100.0) / 100.0;
    }
}
