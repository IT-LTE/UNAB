package cl.lte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testObtenerNombre() {
        Cliente cliente = new Cliente("Juan Pérez", "01/01/1990", 12345678,
                87654321, "Juan", "Pérez", "912345678", "Habitat", 1,
                "Calle Falsa 123", "Santiago", 35);

        String nombreCompleto = cliente.obtenerNombre();
        assertEquals("Juan Pérez", nombreCompleto); // Espera "Juan Pérez"
    }
}