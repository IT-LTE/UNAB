package cl.lte;

import java.util.List;

public class GestionCajaChica {
    private CajaChicaProyecto[] cajas;

    public GestionCajaChica() {
        cajas = new CajaChicaProyecto[3];
        cajas[0] = new CajaChicaProyecto("PROYECTO A", 200000, true);
        cajas[1] = new CajaChicaProyecto("PROYECTO B", 500000, true);
        cajas[2] = new CajaChicaProyecto("PROYECTO C", 300000, false);
    }

    public void mostrarCajasDisponibles(Usuario usuario) {
        System.out.println("Proyectos disponibles para " + usuario.getNombre() + ":");
        for (CajaChicaProyecto caja : cajas) {
            if (caja.isDisponible()) {
                System.out.println("- " + caja.getNombre() + " | Monto Inicial: $" + caja.getMontoInicial());
            }
        }
    }

    public void simularRegistrosCaja() {
        CajaChicaProyecto caja = cajas[0];

        caja.agregarMovimiento(new MovimientoCaja("RETIRO", "Compra útiles oficina", 30000, true, true, false));
        caja.agregarMovimiento(new MovimientoCaja("DEPOSITO", "Reintegro fondos", 10000, true, true, false));
        caja.agregarMovimiento(new MovimientoCaja("RETIRO", "Pago taxi", 40000, false, false, true));

        mostrarResumenCaja(caja);
    }

    public void mostrarResumenCaja(CajaChicaProyecto caja) {
        System.out.println("\n=== Registro Caja Chica: " + caja.getNombre() + " ===");
        System.out.printf("%-20s %-10s %-8s %-10s %-10s %-10s %-20s\n",
                "DETALLE", "TIPO", "MONTO", "APROBADO", "PAGADO", "RECHAZADO", "FECHA");
        for (MovimientoCaja mov : caja.getMovimientos()) {
            System.out.printf("%-20s %-10s %-8d %-10s %-10s %-10s %-20s\n",
                    mov.getDetalle(),
                    mov.getTipo(),
                    mov.getMonto(),
                    mov.isAprobado(),
                    mov.isPagado(),
                    mov.isRechazado(),
                    mov.getFecha());
        }
        System.out.println("Saldo actual: $" + caja.calcularSaldo());
    }
}