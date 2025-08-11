package cl.lte;

// Clase que representa una ruta de entrega
public class RutaEntrega {
    private String origen;
    private String destino;
    private double distanciaKm;
    private String nivelDificultad; // por ejemplo: baja, media, alta

    public RutaEntrega(String origen, String destino, double distanciaKm, String nivelDificultad) {
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.nivelDificultad = nivelDificultad;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    @Override
    public String toString() {
        return "Ruta de " + origen + " a " + destino +
                " | Distancia: " + distanciaKm + " km" +
                " | Dificultad: " + nivelDificultad;
    }
}
