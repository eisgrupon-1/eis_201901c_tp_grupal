package gradle.cucumber;

import gradle.cucumber.Celda;

public class Enemigo extends Contenido{

    public Enemigo(){}

    @Override
    public Boolean esSolido() {
        return true;
    }

    @Override
    public void interactuarCon(Bomberman bomberman, Celda celda){
       bomberman.morir();
    }
}
