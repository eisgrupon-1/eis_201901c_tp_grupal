package gradle.unit;
import gradle.cucumber.Direccion;
import gradle.cucumber.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PosicionTests {
    @Test
    public void obtenerXYDeUnaPosicion() {

        Posicion pos = new Posicion(1,2);

        assertEquals(pos.x(), 1);
        assertEquals(pos.y(), 2);
    }

    @Test
    public void comparacionExitosaDeDosPosicionesIguales() {

        Posicion pos = new Posicion(1,2);
        Posicion pos2 = new Posicion(1,2);

        assertEquals(pos, pos2);
    }

    @Test
    public void obtenerPosicionParaDireccionNorte() {

        Posicion pos = new Posicion(1,2);
        Posicion posNorte = new Posicion(1,3);


        assertEquals(posNorte, pos.getPosicionHacia(Direccion.NORTE));
    }

    @Test
    public void obtenerPosicionParaDireccionEste() {

        Posicion pos = new Posicion(1,2);
        Posicion posEste = new Posicion(2,2);


        assertEquals(posEste, pos.getPosicionHacia(Direccion.ESTE));
    }

    @Test
    public void obtenerPosicionParaDireccionSur() {

        Posicion pos = new Posicion(1,2);
        Posicion posSur = new Posicion(1,1);


        assertEquals(posSur, pos.getPosicionHacia(Direccion.SUR));
    }

    @Test
    public void obtenerPosicionParaDireccionOeste() {

        Posicion pos = new Posicion(1,2);
        Posicion posOeste = new Posicion(0,2);

        assertEquals(posOeste, pos.getPosicionHacia(Direccion.OESTE));
    }
}