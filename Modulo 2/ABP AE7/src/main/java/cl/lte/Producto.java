package cl.lte;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stockDisponible;

    public Producto(int id, String nombre, double precio, int stockDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stockDisponible = stockDisponible;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
}
