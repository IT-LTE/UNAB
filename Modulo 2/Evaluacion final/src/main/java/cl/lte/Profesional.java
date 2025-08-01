package cl.lte;

public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;

    public Profesional(String nombre, String fechaNacimiento, int run, String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, run);
        setTitulo(titulo);
        setFechaIngreso(fechaIngreso);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
    }

    public void setTitulo(String titulo) {
        if (titulo.length() >= 10 && titulo.length() <= 50) {
            this.titulo = titulo;
        } else {
            System.out.println("Titulo debe tener un minimo de 10 caracteres y un maximo de 50");
        }
    }

    // Validar formato de fecha (dd/mm/yyyy)
    public void setFechaIngreso(String fechaIngreso) {
        if (fechaIngreso != null && fechaIngreso.matches("^([0][1-9]|[12][0-9]|3[01])/([0][1-9]|1[0-2])/\\d{4}$")) {
            this.fechaIngreso = fechaIngreso;
        } else {
            System.out.println("Fecha de ingreso debe estar en formato dd/MM/yyyy.");
        }
    }

}
