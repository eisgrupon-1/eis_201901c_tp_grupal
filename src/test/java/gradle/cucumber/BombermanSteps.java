package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanSteps {

    private Bomberman bomberman;
    private Celda cell;

    @Given("^Como bomberman")
    public void como_bomberman() throws Throwable {
        this.bomberman = new Bomberman();
    }

    @When("^Veo una celda vacia$")
    public void veoUnaCeldaVacia() throws Throwable {
        this.cell = new Celda(new ContenidoVacio());
    }

    @Then("^Me puedo mover a esa celda$")
    public void mePuedoMoverAEsaCelda() throws Throwable {
        assertTrue(this.bomberman.puedeMoverseA(this.cell));
    }

    @When("^Veo una celda con una pared$")
    public void veoUnaCeldaConUnaPared() throws Throwable {
        this.cell = new Celda(new ParedMelamina());
    }

    @Then("^No me puedo mover a esa celda$")
    public void noMePuedoMoverAEsaCelda() throws Throwable {
        assertFalse(this.bomberman.puedeMoverseA(this.cell));
    }

    @When("^Veo una celda con un enemigo$")
    public void meMuevoAUnaCeldaConUnEnemigo() throws Throwable {
        this.cell = new Celda(new Enemigo());
        this.bomberman.mover(this.cell);
    }

    @Then("^Muero$")
    public void muero() throws Throwable {
        assertTrue(this.bomberman.estaMuerto());
    }

    @When("^Me muevo a esa celda$")
    public void meMuevoAEsaCelda() throws Throwable {
        this.bomberman.mover(this.cell);
        this.bomberman.setEstado(new Muerto());
    }

    @Then("^bomberman esta en una celda vacia$")
    public void bombermanEnCeldaVacia() throws Throwable {
        assertTrue(this.bomberman.estaEnCeldaVacia());
    }
}
