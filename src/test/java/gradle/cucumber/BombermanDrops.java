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
    private Posicion posicion1;
    private Posicion posicion2;
    private Posicion posicion3;
    private Posicion posicion4;

    @Given("^Como bomberman que pone bombas")
    public void comoBombermanQuePoneBombas() throws Throwable {
        this.juego = new Juego();
        this.tablero = this.juego.getTablero();
        this.miPersonaje = juego.getPersonaje();
        this.posicionOrigen = this.juego.getPosicionDelPersonaje();
        this.posicionDestino = this.posicionOrigen.getPosicionHacia(Direccion.NORTE);
        this.posicion1 = this.posicionOrigen.getPosicionHacia(Direccion.ESTE);
        this.posicion2 = this.posicion1.getPosicionHacia(Direccion.ESTE);
        this.posicion3 = this.posicion2.getPosicionHacia(Direccion.ESTE);
        this.posicion4 = this.posicion3.getPosicionHacia(Direccion.ESTE);
    }

    //Punto 2.i.

    @When("^Arrojo una bomba cerca de paredes de melamina y me muevo 5 pasos al Norte$")
    public void arrojoUnaBombaCercaDeParedesDeMelaminaYMeMuevoCincoPasosAlNorte() throws Throwable {
        tablero.agregarContenidoA(new ParedMelamina(), posicion1);
        tablero.agregarContenidoA(new ParedMelamina(), posicion2);
        tablero.agregarContenidoA(new ParedMelamina(), posicion3);
        tablero.agregarContenidoA(new ParedMelamina(), posicion4);
        this.juego.arrojarBombaYMoverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^Destruyo las paredes de melamina en un radio de 3 casilleros$")
    public void destruyoLasParedesDeMelaminaEnUnRadioDe3Casilleros() throws Throwable {
        assertFalse(this.tablero.contenidoEn(posicion1).esSolido());
        assertFalse(this.tablero.contenidoEn(posicion2).esSolido());
        assertFalse(this.tablero.contenidoEn(posicion3).esSolido());
        assertTrue(this.tablero.contenidoEn(posicion4).esSolido());
    }

    //Punto 2.ii.

    @When("^Arrojo una bomba cerca de enemigos y me muevo 5 pasos al Norte$")
    public void arrojoUnaBombaCercaDeEnemigosYMeMuevoCincoPasosAlNorte() throws Throwable {
        tablero.agregarContenidoA(new Enemigo(), posicion1);
        tablero.agregarContenidoA(new Enemigo(), posicion2);
        tablero.agregarContenidoA(new Enemigo(), posicion3);
        tablero.agregarContenidoA(new Enemigo(), posicion4);
        this.juego.arrojarBombaYMoverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }
    @Then("^Destruyo los enemigos en un radio de 3 casilleros$")
    public void destruyoLosEnemigosEnUnRadioDe3Casilleros() throws Throwable {
        assertFalse(this.tablero.contenidoEn(posicion1).esSolido());
        assertFalse(this.tablero.contenidoEn(posicion2).esSolido());
        assertFalse(this.tablero.contenidoEn(posicion3).esSolido());
        assertTrue(this.tablero.contenidoEn(posicion4).esSolido());
    }

    //Punto 2.iii.

    @When("^Arrojo una bomba cerca de paredes de acero y me muevo 5 pasos al Norte$")
    public void arrojoUnaBombaCercaDeParedesDeAceroYMeMuevoCincoPasosAlNorte() throws Throwable {
        tablero.agregarContenidoA(new ParedAcero(), posicion1);
        tablero.agregarContenidoA(new ParedAcero(), posicion2);
        tablero.agregarContenidoA(new ParedAcero(), posicion3);
        tablero.agregarContenidoA(new ParedAcero(), posicion4);
        this.juego.arrojarBombaYMoverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
        this.juego.moverPersonajeHacia(Direccion.NORTE);
    }

    @Then("^No destruyo las paredes de acero$")
    public void destruyoLasParedesDeAceroEnUnRadioDe3Casilleros() throws Throwable {
        assertTrue(this.tablero.contenidoEn(posicion1).esSolido());
        assertTrue(this.tablero.contenidoEn(posicion2).esSolido());
        assertTrue(this.tablero.contenidoEn(posicion3).esSolido());
        assertTrue(this.tablero.contenidoEn(posicion4).esSolido());
    }

    //Punto 3.
    @When("^Arroja una bomba cerca de bagulaa y lo mata$")
    public void arrojarBombaYMatarABagulaa() throws Throwable{

    }

    @Then ("^Bomberman obtiene poder lanza bombas$")
    public void obtenerPoderLanzaBombas() throws Throwable{

    }

    //Punto 4.

    @When("^Arroja una bomba cerca de ProtoMaxJr y lo mata$")
    public void arrojarBombaYMatarAProtoMaxJr() throws Throwable{

    }
    @Then ("^Bomberman obtiene poder SaltarTodoTipoDePared$")
    public void obtenerPoderSaltarTodoTipoDePared() throws Throwable{

    }

    //Punto 5.

    @When("^Arroja una bomba cerca de ProtoMaxUnits y lo mata$")
    public void arrojarBombaYMatarAProtoMaxUnits() throws Throwable{

    }
    @Then ("^Bomberman obtiene poder SaltarOlanzarBombas$")
    public void obtenerPoderSaltarOlanzarBombas() throws Throwable{

    }


}