package cl.lte;

public class GestionProyecto {
    private Proyecto[] proyectos;

    public GestionProyecto() {
        proyectos = new Proyecto[3];
        proyectos[0] = new Proyecto("Proyecto A", 200000, true);
        proyectos[1] = new Proyecto("Proyecto B", 500000, true);
        proyectos[2] = new Proyecto("Proyecto C", 0, false);
    }

    public void mostrarProyectos() {
        System.out.println("Lista de proyectos:");
        for (Proyecto p : proyectos) {
            System.out.print("- " + p.getNombre());
            if (p.tieneAcceso()) {
                System.out.println(" (acceso permitido, monto maximo: $" + p.getMontoMaximo() + ")");
            } else {
                System.out.println(" (acceso no permitido)");
            }
        }
    }

    public Proyecto[] obtenerProyectosDisponibles() {
        int count = 0;
        for (Proyecto p : proyectos) {
            if (p.tieneAcceso()) {
                count++;
            }
        }

        Proyecto[] disponibles = new Proyecto[count];
        int index = 0;
        for (Proyecto p : proyectos) {
            if (p.tieneAcceso()) {
                disponibles[index] = p;
                index++;
            }
        }

        return disponibles;
    }
}
