package cl.lte;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;
    private List<Integer> cantidades;

    public Pedido() {
        productos = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    public void confirmarPedido() {
        System.out.println("Pedido confirmado con " + productos.size() + " productos.");
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }
}