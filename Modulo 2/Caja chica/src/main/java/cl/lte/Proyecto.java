package cl.lte;

public class Proyecto {
    private String nombre;
    private int montoMaximo;
    private boolean accesoPermitido;

    public Proyecto(String nombre, int montoMaximo, boolean accesoPermitido) {
        this.nombre = nombre;
        this.montoMaximo = montoMaximo;
        this.accesoPermitido = accesoPermitido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMontoMaximo() {
        return montoMaximo;
    }

    public boolean tieneAcceso() {
        return accesoPermitido;
    }
}
