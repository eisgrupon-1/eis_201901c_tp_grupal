package gradle.cucumber;

import gradle.cucumber.Celda;

public abstract class Contenido {

    public abstract void interactuarCon(Bomberman bomberman, Celda celda);
    public abstract boolean esVacio();
}
