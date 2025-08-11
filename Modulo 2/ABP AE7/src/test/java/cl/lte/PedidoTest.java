package cl.lte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;
    Producto pan;
    Producto leche;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        pan = new Producto(1, "Pan", 1000, 10);
        leche = new Producto(2, "Leche", 1200, 8);
    }

    @Test
    void testAgregarProductoYCalcularTotal() {
        pedido.agregarProducto(pan, 2); // 2000
        pedido.agregarProducto(leche, 1); // 1200
        assertEquals(3200, pedido.calcularTotal());
    }

    @Test
    void testConfirmarPedido() {
        pedido.agregarProducto(pan, 1);
        // Solo verificamos que el método no lance errores
        pedido.confirmarPedido();
    }
}
