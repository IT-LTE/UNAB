package cl.lte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaAcademico {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Docente> docentes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Inscripcion> inscripciones = new ArrayList<>();
    private Map<String, Map<String, Double>> notas = new HashMap<>();

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void agregarDocente(Docente d) {
        docentes.add(d);
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public void inscribirEstudiante(String rutEst, String codCurso) {
        Estudiante estudiante = buscarEstudiante(rutEst);
        Curso curso = buscarCurso(codCurso);
        if (estudiante != null && curso != null && !yaInscrito(estudiante, curso)) {
            inscripciones.add(new Inscripcion(estudiante, curso));
            notas.putIfAbsent(rutEst, new HashMap<>());
        }
    }

    public void agregarEvaluacion(String codCurso, Evaluacion eval) {
        Curso curso = buscarCurso(codCurso);
        if (curso != null) {
            curso.agregarEvaluacion(eval);
        }
    }

    public void asignarNota(String rutEst, String codCurso, double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            notas.putIfAbsent(rutEst, new HashMap<>());
            notas.get(rutEst).put(codCurso, nota);
        }
    }

    public double promedioEstudiante(String rutEst) {
        Map<String, Double> notasEst = notas.get(rutEst);
        if (notasEst == null || notasEst.isEmpty()) return 0;
        double suma = 0;
        for (double nota : notasEst.values()) suma += nota;
        return Math.round((suma / notasEst.size()) * 10.0) / 10.0;
    }

    public ArrayList<Estudiante> listarEstudiantesPorCurso(String codCurso) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        for (Inscripcion ins : inscripciones) {
            if (ins.esDelCurso(codCurso)) {
                lista.add(ins.getEstudiante());
            }
        }
        return lista;
    }

    public ArrayList<Curso> cursosConPromedioAlto() {
        ArrayList<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            double suma = 0;
            int contador = 0;
            for (Inscripcion ins : inscripciones) {
                if (ins.esDelCurso(curso.getCodigo())) {
                    Double nota = obtenerNota(ins.getEstudiante().getRut(), curso.getCodigo());
                    if (nota != null) {
                        suma += nota;
                        contador++;
                    }
                }
            }
            if (contador > 0 && (suma / contador) >= 5.5) {
                resultado.add(curso);
            }
        }
        return resultado;
    }

    public ArrayList<Docente> docentesConMayorCarga() {
        int max = 0;
        Map<Docente, Integer> carga = new HashMap<>();
        for (Curso c : cursos) {
            Docente d = c.getDocente();
            if (d != null) {
                carga.put(d, carga.getOrDefault(d, 0) + 1);
                if (carga.get(d) > max) max = carga.get(d);
            }
        }
        ArrayList<Docente> resultado = new ArrayList<>();
        for (Map.Entry<Docente, Integer> entry : carga.entrySet()) {
            if (entry.getValue() == max) {
                resultado.add(entry.getKey());
            }
        }
        return resultado;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public Double obtenerNota(String rutEst, String codCurso) {
        Map<String, Double> notasEst = notas.get(rutEst);
        if (notasEst != null) {
            return notasEst.get(codCurso);
        }
        return null;
    }

    private boolean yaInscrito(Estudiante e, Curso c) {
        for (Inscripcion i : inscripciones) {
            if (i.getEstudiante().equals(e) && i.getCurso().equals(c)) {
                return true;
            }
        }
        return false;
    }

    private Estudiante buscarEstudiante(String rut) {
        for (Estudiante e : estudiantes) {
            if (e.getRut().equalsIgnoreCase(rut)) return e;
        }
        return null;
    }

    private Curso buscarCurso(String cod) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(cod)) return c;
        }
        return null;
    }
}