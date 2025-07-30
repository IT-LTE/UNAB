/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cl.lte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfesionalTest {
    @Test
    public void testConstructor() {
        Profesional prof = new Profesional("Rodrigo Cañas ", "01/01/2020", 12345678, "Kinesiologo", "30/12/2020");
        assertNotNull(prof);
    }
}