package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanDrops {

    private Juego juego;
    private Tablero tablero;
    private Bomberman miPersonaje;
    private Posicion posicionDestino;
    private Posicion posicionOrigen;
    private Posicion posicionPared1;
    private Posicion posicionPared2;
    private Posicion posicionPared3;
    private Posicion posicionPared4;

    @Given("^Como bomberman que pone bombas")
    public void comoBombermanQuePoneBombas() throws Throwable {
        this.juego = new Juego();
        this.tablero = this.juego.getTablero();
        this.miPersonaje = juego.getPersonaje();
        this.posicionOrigen = this.juego.getPosicionDelPersonaje();
        this.posicionDestino = this.posicionOrigen.getPosicionHacia(Direccion.NORTE);
        this.posicionPared1 = this.posicionOrigen.getPosicionHacia(Direccion.ESTE);
        this.posicionPared2 = this.posicionPared1.getPosicionHacia(Direccion.ESTE);
        this.posicionPared3 = this.posicionPared2.getPosicionHacia(Direccion.ESTE);
        this.posicionPared4 = this.posicionPared3.getPosicionHacia(Direccion.ESTE);
    }

    //Punto 2.i.

    @When("^Arrojo una bomba cerca de paredes de melamina y me muevo 5 pasos al Norte$")
    public void arrojoUnaBombaCercaDeParedesDeMelaminaYMeMuevoCincoPasosAlNorte() throws Throwable {
        tablero.agregarContenidoA(new ParedMelamina(), posicionPared1);
        tablero.agregarContenidoA(new ParedMelamina(), posicionPared2);
        tablero.agregarContenidoA(new ParedMelamina(), posicionPared3);
        tablero.agregarContenidoA(new ParedMelamina(), posicionPared4);
        this.juego.arrojarBombaYMoverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^Destruyo las paredes de melamina en un radio de 3 casilleros$")
    public void destruyoLasParedesDeMelaminaEnUnRadioDe3Casilleros() throws Throwable {
        assertFalse(this.tablero.contenidoEn(posicionPared1).esSolido());
        assertFalse(this.tablero.contenidoEn(posicionPared2).esSolido());
        assertFalse(this.tablero.contenidoEn(posicionPared3).esSolido());
        assertTrue(this.tablero.contenidoEn(posicionPared4).esSolido());
    }

    //Punto 2.ii.
/*
    @When("^Arrojo una bomba Cerca de un enemigo$")
    public void arrojoUnaBomba() throws Throwable {
        this.enemigo = new Enemigo();
        this.celda1 = new Celda(2, 4, this.enemigo);
        this.miPersonaje.arrojarBomba();
    }

    @Then("^mato al enemigo que entre en contacto con la onda expansiva")
    public void matoAlEnemigoQueEntreEnContactoConLaOndaExpansiva() throws Throwable {
        assertFalse(this.celda1.getContenido().esSolido());
    }

    //Punto 1.iii.

    @When("^Arrojo una bomba cerca de una pared de acero$")
    public void arrojoUnaBombaCercaDeUnaParedDeAcero() throws Throwable {
        this.celda1 = new Celda(2, 4, new ParedAcero());
        this.miPersonaje.arrojarBomba();
    }

    @Then("^No destruyo paredes de acero$")
    public void noDestruyoParedesDeAcero() throws Throwable {
        assertTrue(this.celda1.getContenido().esSolido());
    }*/
}