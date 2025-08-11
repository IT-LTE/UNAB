package cl.lte;

// Clase abstracta base de todos los vehiculos logisticos
public abstract class VehiculoLogistico {
    protected String idVehiculo;
    protected double capacidadCargaKg;
    protected String ubicacionActual;
    protected double velocidadPromedioKmH;

    public VehiculoLogistico(String idVehiculo, double capacidadCargaKg, String ubicacionActual, double velocidadPromedioKmH) {
        this.idVehiculo = idVehiculo;
        this.capacidadCargaKg = capacidadCargaKg;
        this.ubicacionActual = ubicacionActual;
        this.velocidadPromedioKmH = velocidadPromedioKmH;
    }

    // Metodos abstractos que deben implementar las subclases
    public abstract void desplazar(String destino);
    public abstract void verificarEstado();

    // Getters basicos
    public String getIdVehiculo() {
        return idVehiculo;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public double getVelocidadPromedioKmH() {
        return velocidadPromedioKmH;
    }
}
