package cl.lte;

public class Revision {
    private int identificadorRevision;
    private int identificadorVisita;
    private String nombreRevision;
    private String detalle;
    private int estado; // 1: sin problemas, 2: con observaciones, 3: no aprueba

    public Revision() {}
// constructor con parametros y metodo set para validar y asignar valores
    public Revision(int identificadorRevision, int identificadorVisita, String nombreRevision, String detalle, int estado) {
        this.identificadorRevision = identificadorRevision;
        this.identificadorVisita = identificadorVisita;
        setNombreRevision(nombreRevision);
        setDetalle(detalle);
        setEstado(estado);
    }
// setter para validar que cumple con lo indicado longitud del nombre
    public void setNombreRevision(String nombreRevision) {
        if (nombreRevision == null || nombreRevision.length() < 10 || nombreRevision.length() > 50)
            throw new IllegalArgumentException("Nombre revision debe tener entre 10 y 50 caracteres.");
        this.nombreRevision = nombreRevision;
    }

    public void setDetalle(String detalle) {
        if (detalle != null && detalle.length() > 100)
            throw new IllegalArgumentException("Detalle maximo 100 caracteres.");
        this.detalle = detalle;
    }

    public void setEstado(int estado) {
        if (estado < 1 || estado > 3)
            throw new IllegalArgumentException("Estado debe ser 1 (sin problemas), 2 (con observaciones), 3 (no aprueba)");
        this.estado = estado;
    }

    public String obtenerEstado() {
        switch(estado) {
            case 1: return "Sin Problemas";
            case 2: return "Con Observaciones";
            case 3: return "No Aprueba";
            default: return "Desconocido";
        }
    }

    @Override
    public String toString() {
        return "ID Revision: " + identificadorRevision + ", ID Visita: " + identificadorVisita +
               ", Nombre: " + nombreRevision + ", Detalle: " + detalle + ", Estado: " + obtenerEstado();
    }
}    
