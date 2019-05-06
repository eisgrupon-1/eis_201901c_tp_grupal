package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanSteps {

    private Juego juego;
    private Tablero tablero;
    private Bomberman miPersonaje;
    private Posicion posicionDestino;
    private Posicion posicionOrigen;

    @Given("^Como bomberman en una celda")
    public void comoBomberman() throws Throwable {
        this.juego = new Juego();
        this.tablero = this.juego.getTablero();
        this.miPersonaje = juego.getPersonaje();
        this.posicionOrigen = this.juego.getPosicionDelPersonaje();
        this.posicionDestino = this.posicionOrigen.getPosicionHacia(Direccion.NORTE);
    }

    //Punto 1.i.
    @When("^Me intento mover a una celda vacia$")
    public void meIntentoMoverAUnaCeldaVacia() throws Throwable {
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^Sigo vivo y ahora estoy en la celda$")
    public void sigoVivoYAhoraEstoyCelda() throws Throwable {
        assertTrue(this.tablero.contenidoEn(this.posicionDestino) == this.miPersonaje);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    //Punto 1.ii.
    @When("^Me intento mover a una celda con una pared de Melamina$")
    public void meIntentoMoverAUnaCeldaConUnaParedDeMelamina() throws Throwable {
        this.tablero.agregarContenidoA(new ParedMelamina(), this.posicionDestino);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^No me movi a la celda de la pared de Melamina y sigo en mi misma celda")
    public void noMeMoviALaCeldaDeLaParedDeMelaminaYSigoEnMiMismaCelda() throws Throwable {
        assertTrue(this.juego.getPosicionDelPersonaje() == this.posicionOrigen);
        assertFalse(this.juego.getPosicionDelPersonaje() == this.posicionDestino);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    @When("^Me intento mover a una celda con una pared de Acero")
    public void meIntentoMoverAUnaCeldaConUnaParedDeAcero() throws Throwable {
        this.tablero.agregarContenidoA(new ParedAcero(), this.posicionDestino);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^No me movi a la celda de la pared de Acero y sigo en mi misma celda")
    public void noMeMoviALaCeldaDeLaParedDeAceroYSigoEnMiMismaCelda() throws Throwable {
        assertTrue(this.juego.getPosicionDelPersonaje() == this.posicionOrigen);
        assertFalse(this.juego.getPosicionDelPersonaje() == this.posicionDestino);
        assertFalse(this.miPersonaje.estaMuerto());
    }

    //Punto 1.iii.
    @When("^Me intento mover a una celda con un enemigo$")
    public void meIntentoMoverAUnaCeldaConUnEnemigo() throws Throwable {
        this.tablero.agregarContenidoA(new Enemigo(), this.posicionDestino);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^Muero$")
    public void muero() throws Throwable {
        assertTrue(this.miPersonaje.estaMuerto());
    }
}
