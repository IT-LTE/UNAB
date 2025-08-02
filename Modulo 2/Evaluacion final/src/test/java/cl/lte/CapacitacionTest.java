package cl.lte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CapacitacionTest {

    @Test
    void testToString() {
        Capacitacion cap = new Capacitacion(2, 22222222, "martes", "14:30",
                "Auditorio", "120", 40);

        assertTrue(cap.toString().contains("Capacitacion"));
        assertTrue(cap.toString().contains("Auditorio"));
    }
}
