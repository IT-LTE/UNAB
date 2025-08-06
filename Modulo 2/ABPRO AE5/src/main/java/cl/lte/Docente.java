package cl.lte;

public class Docente {
    private String rut;
    private String nombre;
    private String area;

    public Docente(String rut, String nombre, String area) {
        this.rut = rut;
        this.nombre = nombre;
        this.area = area;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArea() {
        return area;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "RUT: " + rut + ", Nombre: " + nombre + ", Area: " + area;
    }
}