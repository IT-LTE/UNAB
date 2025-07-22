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

    public boolean claveValida(String clave, int minuto) {
        boolean esPar = minuto % 2 == 0;
        if (esPar) {
            return clave.equals(clavePar);
        } else {
            return clave.equals(claveImpar);
        }
    }
}
