package cl.lte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorPedidosTest {

    GestorPedidos gestor;
    Pedido pedido;
    Producto pan;
    Producto leche;

    @BeforeEach
    void setUp() {
        gestor = new GestorPedidos();
        pedido = new Pedido();
        pan = new Producto(1, "Pan", 1000, 10);
        leche = new Producto(2, "Leche", 1200, 8);
    }

    @Test
    void testValidarStockSuficiente() {
        pedido.agregarProducto(pan, 2);
        assertTrue(gestor.validarStock(pedido));
    }

    @Test
    void testValidarStockInsuficiente() {
        pedido.agregarProducto(leche, 20);
        assertFalse(gestor.validarStock(pedido));
    }

    @Test
    void testRealizarPedidoReduceStock() {
        pedido.agregarProducto(pan, 2);
        gestor.realizarPedido(pedido);
        assertEquals(8, pan.getStockDisponible());
    }

    @Test
    void testCancelarPedidoNoModificaStock() {
        int stockInicial = pan.getStockDisponible();
        pedido.agregarProducto(pan, 1);
        gestor.cancelarPedido(pedido);
        assertEquals(stockInicial, pan.getStockDisponible());
    }
}
