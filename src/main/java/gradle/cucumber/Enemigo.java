package gradle.cucumber;

import gradle.cucumber.Celda;

public class Enemigo extends Contenido{

    private Celda celda;

    public Enemigo(){

    }

    public void setCelda(Celda cell){
        this.celda = cell;
    }

    @Override
    public boolean estaVacio() {
        return false;
    }
}
