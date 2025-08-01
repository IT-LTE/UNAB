package cl.lte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    void testSetRunValido(){
        Usuario usuario = new Usuario("Javier Rojas", "12/09/1996", 123456);
        int run = 87654321;
        usuario.setRun(run);
        Assertions.assertEquals(run, usuario.getRun());
    }

    @Test
    void testSetRunInvalido(){
        int runEsperado = 123456;
        Usuario usuario = new Usuario("Javier Rojas", "12/09/1996", 123456);
        int run = 999999999;
        usuario.setRun(run);
        Assertions.assertEquals(runEsperado, usuario.getRun());
    }
}
