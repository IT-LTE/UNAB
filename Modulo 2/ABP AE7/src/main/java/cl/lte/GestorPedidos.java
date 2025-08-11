package cl.lte;

public class GestorPedidos {

    public void realizarPedido(Pedido pedido) {
        for (int i = 0; i < pedido.getProductos().size(); i++) {
            Producto p = pedido.getProductos().get(i);
            int cant = pedido.getCantidades().get(i);
            p.setStockDisponible(p.getStockDisponible() - cant);
        }
        pedido.confirmarPedido();
    }

    public void cancelarPedido(Pedido pedido) {
        System.out.println("Pedido cancelado con " + pedido.getProductos().size() + " productos.");
    }

    public boolean validarStock(Pedido pedido) {
        for (int i = 0; i < pedido.getProductos().size(); i++) {
            Producto p = pedido.getProductos().get(i);
            int cant = pedido.getCantidades().get(i);
            if (p.getStockDisponible() < cant) {
                return false;
            }
        }
        return true;
    }
}