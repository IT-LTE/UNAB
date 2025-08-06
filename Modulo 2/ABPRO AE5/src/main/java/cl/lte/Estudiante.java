package cl.lte;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String rut;
    private String nombre;
    private String carrera;
    private int anioIngreso;
    private List<Inscripcion> inscripciones;

    public Estudiante(String rut, String nombre, String carrera, int anioIngreso) {
        this.rut = rut;
        this.nombre = nombre;
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.inscripciones = new ArrayList<>();
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        if (!inscripciones.contains(inscripcion)) {
            inscripciones.add(inscripcion);
        }
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int cantidad = 0;
        for (Inscripcion inscripcion : inscripciones) {
            suma += inscripcion.calcularPromedio();
            cantidad++;
        }
        if (cantidad == 0) return 0;
        return Math.round(suma / cantidad * 100.0) / 100.0;
    }
}
