package cl.lte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto(1, "Pan", 1000, 10);
    }

    @Test
    void testGettersProducto() {
        assertEquals(1, producto.getId());
        assertEquals("Pan", producto.getNombre());
        assertEquals(1000, producto.getPrecio());
        assertEquals(10, producto.getStockDisponible());
    }

    @Test
    void testSetStockDisponible() {
        producto.setStockDisponible(5);
        assertEquals(5, producto.getStockDisponible());
    }
}
