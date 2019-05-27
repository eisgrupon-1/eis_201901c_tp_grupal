package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BombermanDrops {

    private Juego juego;
    private Tablero tablero;
    private Posicion posicion1;
    private Posicion posicion2;
    private Posicion posicion3;
    private Posicion posicion4;

    @Given("^Como bomberman que pone bombas")
    public void comoBombermanQuePoneBombas() throws Throwable {
        this.juego = new Juego();
        this.tablero = this.juego.getTablero();
        Posicion posicionOrigen = this.juego.getPosicionDelPersonaje();
        this.posicion1 = posicionOrigen.getPosicionHacia(Direccion.ESTE);
        this.posicion2 = this.posicion1.getPosicionHacia(Direccion.ESTE);
        this.posicion3 = this.posicion2.getPosicionHacia(Direccion.ESTE);
        this.posicion4 = this.posicion3.getPosicionHacia(Direccion.ESTE);
    }

    //Punto 2.i.

    @When("^Arrojo una bomba cerca de paredes de melamina y me muevo 5 pasos al Norte$")
    public void arrojoUnaBombaCercaDeParedesDeMelaminaYMeMuevoCincoPasosAlNorte() throws Throwable {
        this.agregarContenidoEn4PosicionesTirarBombaYMoverse(new ParedMelamina());
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
        this.agregarContenidoEn4PosicionesTirarBombaYMoverse(new Enemigo());
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
        this.agregarContenidoEn4PosicionesTirarBombaYMoverse(new ParedAcero());
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
        this.agregarEnemigoTirarBombaYMoverse(new Bagulaa());
    }

    @Then ("^Bomberman obtiene el poder que tiro el enemigo muerto$")
    public void obtenerPoder() throws Throwable{
        this.moverN(Direccion.SUR, 5);
        assertFalse(this.juego.bombermanTienePoder());
        this.juego.moverPersonajeHacia(Direccion.ESTE);
        assertTrue(this.juego.bombermanTienePoder());
    }

    @Then ("^Bomberman puede lanzar Bombas$")
    public void bomberbanPuedeLanzarBombas() throws Throwable{
        Bomba bomba = this.juego.arrojarBomba(Direccion.ESTE);
        assertTrue(this.sonMismaPosicion(this.juego.getPosicionDelPersonaje(), this.posicion1));
        assertTrue(this.sonMismaPosicion(bomba.getPosicion(),this.posicion3));
    }

    //Punto 4.

    @When("^Arroja una bomba cerca de ProtoMaxJr y lo mata$")
    public void arrojarBombaYMatarAProtoMaxJr() throws Throwable{
        this.agregarEnemigoTirarBombaYMoverse(new ProtoMaxJr());
    }

    @Then ("^Bomberman puede saltar todo tipo de pared$")
    public void bombermanPuedeSaltarTodoTipoDePared() throws Throwable{
        this.tablero.agregarContenidoA(new ParedAcero(), this.posicion3);
        this.juego.moverPersonajeHacia(Direccion.ESTE);
        this.juego.moverPersonajeHacia(Direccion.ESTE);
        assertTrue(this.sonMismaPosicion(this.juego.getPosicionDelPersonaje(), this.posicion3));
        this.juego.moverPersonajeHacia(Direccion.ESTE);
        assertTrue(this.sonMismaPosicion(this.juego.getPosicionDelPersonaje(), this.posicion4));
    }

    //Punto 5.

    @When("^Arroja una bomba cerca de ProtoMaxUnits y lo mata$")
    public void arrojarBombaYMatarAProtoMaxUnits() throws Throwable{
        this.agregarEnemigoTirarBombaYMoverse(new ProtoMaxUnits());
    }

    @Then ("^Bomberman puede saltar todo tipo de pared y lanzar bombas$")
    public void bomberbanPuedeSaltarTodoTipoDeParedYLanzarBombas() throws Throwable{

    }

    //Funciones privadas

    private Boolean sonMismaPosicion(Posicion pos1, Posicion pos2){
        return pos1.x() == pos2.x() && pos1.y() == pos2.y();
    }

    private void agregarContenidoEn4PosicionesTirarBombaYMoverse(Contenido contenido) {
        tablero.agregarContenidoA(contenido, posicion1);
        tablero.agregarContenidoA(contenido, posicion2);
        tablero.agregarContenidoA(contenido, posicion3);
        tablero.agregarContenidoA(contenido, posicion4);
        this.juego.arrojarBomba();
        this.moverN(Direccion.NORTE, 5);
    }

    private void agregarEnemigoTirarBombaYMoverse(Enemigo enemigo){
        tablero.agregarContenidoA(enemigo, posicion1);
        assertTrue(this.tablero.contenidoEn(posicion1).esSolido());
        this.juego.arrojarBomba();
        this.moverN(Direccion.NORTE, 5);
        assertFalse(this.tablero.contenidoEn(posicion1).esSolido());
    }

    private void moverN(Direccion direccion, int cantidad){
        for(int i = 0; i < cantidad; i++){
            this.juego.moverPersonajeHacia(direccion);
        }
    }
}