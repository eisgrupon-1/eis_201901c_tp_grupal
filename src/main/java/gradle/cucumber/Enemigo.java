package gradle.cucumber;

import gradle.cucumber.Celda;

public class Enemigo extends Contenido{

    public Enemigo(){}

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public void interactuarCon(Bomberman bomberman, Celda celda){
       bomberman.morir();
    }
}
