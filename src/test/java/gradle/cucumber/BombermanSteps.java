package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanSteps {

    private Bomberman miPersonaje;
    private Celda celdaDestino;
    private Celda celdaOrigen;

    @Given("^Como bomberman en una celda")
    public void comoBomberman() throws Throwable {
        this.miPersonaje = new Bomberman();
        //Por ahora a Bomberman le importa saber donde esta.
        celdaOrigen = new Celda(this.miPersonaje);
        this.miPersonaje.celdaActual = celdaOrigen;
    }

    //Punto 1.i.

    @When("^Me intento mover a una celda vacia$")
    public void meIntentoMoverAUnaCeldaVacia() throws Throwable {
        this.celdaDestino = new Celda(new ContenidoVacio());
        this.miPersonaje.mover(this.celdaDestino);
    }

    @Then("^Sigo vivo y ahora estoy en la celda$")
    public void sigoVivoYAhoraEstoyCelda() throws Throwable {
        assertTrue(this.celdaDestino.getContenido() == this.miPersonaje);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    //Punto 1.ii.

    @When("^Me intento mover a una celda con una pared de Melamina$")
    public void meIntentoMoverAUnaCeldaConUnaParedDeMelamina() throws Throwable {
        this.celdaDestino = new Celda(new ParedMelamina());
        this.miPersonaje.mover(this.celdaDestino);
    }

    @Then("^No me movi a la celda de la pared de Melamina y sigo en mi misma celda")
    public void noMeMoviALaCeldaDeLaParedDeMelaminaYSigoEnMiMismaCelda() throws Throwable {
        assertTrue(this.miPersonaje.celdaActual == this.celdaOrigen);
        assertFalse(this.miPersonaje.celdaActual == this.celdaDestino);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    @When("^Me intento mover a una celda con una pared de Acero")
    public void meIntentoMoverAUnaCeldaConUnaParedDeAcero() throws Throwable {
        this.celdaDestino = new Celda(new ParedAcero());
        this.miPersonaje.mover(this.celdaDestino);
    }

    @Then("^No me movi a la celda de la pared de Acero y sigo en mi misma celda")
    public void noMeMoviALaCeldaDeLaParedDeAceroYSigoEnMiMismaCelda() throws Throwable {
        assertTrue(this.miPersonaje.celdaActual == this.celdaOrigen);
        assertFalse(this.miPersonaje.celdaActual == this.celdaDestino);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    //Punto 1.iii.

    @When("^Me intento mover a una celda con un enemigo$")
    public void meIntentoMoverAUnaCeldaConUnEnemigo() throws Throwable {
        this.celdaDestino = new Celda(new Enemigo());
        this.miPersonaje.mover(this.celdaDestino);
    }

    @Then("^Muero$")
    public void muero() throws Throwable {
        assertTrue(this.miPersonaje.estaMuerto());
    }
}
