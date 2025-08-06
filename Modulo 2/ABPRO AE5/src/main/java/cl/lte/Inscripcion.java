package cl.lte;

public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;

    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public boolean esDeEstudiante(String rut) {
        return estudiante.getRut().equalsIgnoreCase(rut);
    }

    public boolean esDelCurso(String codigo) {
        return curso.getCodigo().equalsIgnoreCase(codigo);
    }
}