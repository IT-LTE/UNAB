package cl.lte;


import java.util.ArrayList;
import java.util.List;

public class CajaChicaProyecto {
    private String nombre;
    private int montoInicial;
    private boolean disponible;
    private List<MovimientoCaja> movimientos;

    public CajaChicaProyecto(String nombre, int montoInicial, boolean disponible) {
        this.nombre = nombre;
        this.montoInicial = montoInicial;
        this.disponible = disponible;
        this.movimientos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getMontoInicial() {
        return montoInicial;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void agregarMovimiento(MovimientoCaja movimiento) {
        if (movimiento != null) {
            movimientos.add(movimiento);
        }
    }

    public int calcularSaldo() {
        int saldo = montoInicial;
        for (MovimientoCaja m : movimientos) {
            if (m.getTipo().equalsIgnoreCase("RETIRO")) {
                saldo -= m.getMonto();
            } else if (m.getTipo().equalsIgnoreCase("DEPOSITO")) {
                saldo += m.getMonto();
            }
        }
        return saldo;
    }

    public List<MovimientoCaja> getMovimientos() {
        return movimientos;
    }
}