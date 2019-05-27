package gradle.unit;
import gradle.cucumber.Enemigo;
import gradle.cucumber.Posicion;
import gradle.cucumber.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TableroTests {
    @Test
    public void unTableroNuevoEstaVacio() {

        int size = 10;
        Tablero tablero= new Tablero(size);

        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                assertFalse(tablero.contenidoEn(new Posicion(i, j)).esSolido());
    }

    @Test
    public void unTableroConUnEnemigoNoEstaVacio(){

        int size = 10;
        Tablero tablero= new Tablero(size);

        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                assertFalse(tablero.contenidoEn(new Posicion(i, j)).esSolido());

         tablero.agregarContenidoA(new Enemigo(), new Posicion(1,1));

         assertTrue(tablero.contenidoEn(new Posicion(1,1)).esSolido());
    }
}
