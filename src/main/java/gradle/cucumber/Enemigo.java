package gradle.cucumber;

import gradle.cucumber.Celda;

public class Enemigo extends Contenido{

    public Enemigo(){}

    @Override
    public Boolean esSolido() {
        return true;
    }

    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){
       juego.getPersonaje().morir();
    }
}
