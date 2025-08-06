package cl.lte;

/**
 * Representa una tarea con una descripción y su estado de completitud.
 */
public class Tarea {
    private String descripcion;
    private boolean completada;

    /**
     * Constructor para crear una tarea pendiente.
     * @param descripcion Descripción de la tarea.
     */
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    /**
     * Marca la tarea como completada.
     */
    public void marcarComoCompletada() {
        this.completada = true;
    }

    /**
     * Obtiene la descripción de la tarea.
     * @return Descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Verifica si la tarea está completada.
     * @return true si está completada, false si no.
     */
    public boolean estaCompletada() {
        return completada;
    }

    /**
     * Devuelve la tarea como texto legible.
     * @return Cadena con el estado y descripción de la tarea.
     */
    public String mostrar() {
        return (completada ? "[X] " : "[ ] ") + descripcion;
    }
}
