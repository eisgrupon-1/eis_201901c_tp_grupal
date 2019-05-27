package gradle.unit;

import gradle.cucumber.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class EstadoTests {

    @Test
    public void testEstadoVivo() {

        EstadoDelPersonaje estado = new Vivo();

        assertFalse(estado.estaMuerto());
    }

    @Test
    public void testEstadoMuerto() {

        EstadoDelPersonaje estado = new Muerto();

        assertTrue(estado.estaMuerto());
    }
}
