package cl.lte;

import java.time.LocalDateTime;

public class MovimientoCaja {
    private String tipo; // RETIRO o DEPOSITO
    private String detalle;
    private int monto;
    private boolean aprobado;
    private boolean pagado;
    private boolean rechazado;
    private LocalDateTime fecha;

    public MovimientoCaja(String tipo, String detalle, int monto, boolean aprobado, boolean pagado, boolean rechazado) {
        this.tipo = tipo;
        this.detalle = detalle;
        this.monto = monto;
        this.aprobado = aprobado;
        this.pagado = pagado;
        this.rechazado = rechazado;
        this.fecha = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getMonto() {
        return monto;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public boolean isPagado() {
        return pagado;
    }

    public boolean isRechazado() {
        return rechazado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
