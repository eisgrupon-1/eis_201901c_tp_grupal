package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanDrops {

    private Bomberman miPersonaje;
    private Celda celdaActual;
    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Celda celda4;
    private Bomba bomba;
    private Enemigo enemigo;

    @Given("^Como bomberman en una celda")
    public void comoBomberman() throws Throwable {
        this.miPersonaje = new Bomberman();
        //Por ahora a Bomberman le importa saber donde esta.
        celdaActual = new Celda(0, 0, this.miPersonaje);
        this.miPersonaje.celdaActual = celdaActual;
        bomba = new Bomba();
        this.miPersonaje.equiparBomba(this.bomba);
    }

    //Punto 2.i.

    @When("^Arrojo una bomba cerca de paredes de melamina$")
    public void arrojoUnaBombaCercaDeParedesDeMelamina() throws Throwable {
        celda1 = new Celda(1, 1, new ParedMelamina()); //Cada celda tendria una coordenada x y una coordenada y
        celda2 = new Celda(0, 1, new ParedMelamina());
        celda3 = new Celda(4, 5, new ParedMelamina());
        celda4 = new Celda(0, 3, new ParedMelamina());
        this.miPersonaje.arrojarBomba();
    }

    @Then("^Destruyo las paredes de melamina en un radio de 3 casilleros$")
    public void destruyoLasParedesDeMelaminaEnUnRadioDe3Casilleros() throws Throwable {
        assertTrue(this.celda1.estaVacia()); //compreba que despues de arrojar la bomba el estado siga siendo solido o no
        assertTrue(this.celda2.estaVacia());
        assertFalse(this.celda3.estaVacia());
        assertTrue(this.celda4.estaVacia());
    }

    //Punto 2.ii.

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
    }
}