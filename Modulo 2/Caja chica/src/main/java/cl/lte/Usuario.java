package cl.lte;

public class Usuario {
    private String nombre;
    private String clavePar;
    private String claveImpar;

    public Usuario(String nombre, String clavePar, String claveImpar) {
        this.nombre = nombre;
        this.clavePar = clavePar;
        this.claveImpar = claveImpar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClavePar() {
        return clavePar;
    }

    public String getClaveImpar() {
        return claveImpar;
    }
}
