package cl.lte;

public class CajaChica {
    private String descripcion;
    private String proveedor;
    private String tipoDocumento; // boleta, factura, recibo, comprobante
    private String numeroDocumento;
    private int monto;

    public CajaChica(String descripcion, String proveedor, String tipoDocumento, String numeroDocumento, int monto) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.monto = monto;
    }

    public int getMonto() {
        return monto;
    }

    public String getResumen() {
        return tipoDocumento + ": " + descripcion + " - " + proveedor + " - Nro " + numeroDocumento + " - $" + monto;
    }
}
