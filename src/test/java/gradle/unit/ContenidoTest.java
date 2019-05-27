package gradle.unit;
import gradle.cucumber.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class ContenidoTest {

    @Test
    public void testContenidoVacio() {

        Contenido contenido = new ContenidoVacio();

        assertFalse(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), contenido);
    }

    @Test
    public void testEnemigo() {

        Contenido contenido = new Enemigo();

        assertTrue(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), new ContenidoVacio());
    }

    @Test
    public void testParedMelamina() {

        Contenido contenido = new ParedMelamina();

        assertTrue(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), new ContenidoVacio());
    }

    @Test
    public void testParedAcero() {

        Contenido contenido = new ParedAcero();

        assertTrue(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), contenido);
    }

    @Test
    public void testParedBomba() {

        Contenido contenido = new Bomba(new Posicion(1,1));

        assertTrue(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), contenido);
    }

    @Test
    public void testParedBomberman() {

        Contenido contenido = new Bomberman();

        assertTrue(contenido.esSolido());
        assertEquals(contenido.interactuarConBomba(), contenido);
    }

    @Test
    public void testBagulaaYLanzarBomba() {

        Contenido contenido = new Bagulaa();

        Contenido resultadoInteraccionConBomba = contenido.interactuarConBomba();

        assertTrue(contenido.esSolido());
        assertEquals(resultadoInteraccionConBomba, new LanzarBomba());

        assertFalse(resultadoInteraccionConBomba.esSolido());
        assertEquals(resultadoInteraccionConBomba.interactuarConBomba(), new ContenidoVacio());

    }

}
