package cl.lte;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void testObtenerNombre() {
        Cliente cliente = new Cliente("Alejandra Flano", "01/01/1990", 12345678,
                8674141, "Alejandra", "Flano", "912345678", "Habitat", 1,
                "Calle Iberia 123", "Vina del mar", 80);

        String nombreCompleto = cliente.obtenerNombre();
        assertEquals("Alejandra Flano", nombreCompleto); // Espera "Alejandra Flano"
    }

}
