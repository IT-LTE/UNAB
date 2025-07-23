package cl.lte;

public class GestionProyecto {
    private Proyecto[] proyectos;

    public GestionProyecto() {
        cargarProyectos();
    }

    public void mostrarProyectosDisponibles() {
        System.out.println("Lista de proyectos disponibles:");
        for (Proyecto p : proyectos) {
            if (p.tieneAcceso()) {
                System.out.println("- " + p.getNombre() + " (maximo: $" + p.getMontoMaximo() + ")");
            }
        }
    }

    private void cargarProyectos() {
        proyectos = new Proyecto[3];
        proyectos[0] = new Proyecto("Proyecto A", 200000, true);
        proyectos[1] = new Proyecto("Proyecto B", 500000, true);
        proyectos[2] = new Proyecto("Proyecto C", 0, false);
    }
}
