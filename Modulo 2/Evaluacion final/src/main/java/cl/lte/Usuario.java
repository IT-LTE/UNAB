package cl.lte;

public class Usuario implements Asesoria {
    private String nombre;
    private String fechaNacimiento;
    private int run;

    public Usuario(String nombre, String fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    @Override
    public void analizarUsuario() {
        // Implementación del análisis del usuario
    }

    public String mostrarEdad(){
        // Lógica para calcular y mostrar la edad del usuario
        return "El usuario tiene " + calcularEdad() + " años.";
    }

    public int calcularEdad(){
        return 0;
    }
}