package gradle.cucumber;

import gradle.cucumber.Celda;

public class Enemigo extends Contenido{
    @Override
    public Boolean esSolido() {
        return true;
    }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){
       juego.getPersonaje().morir();
    }
    @Override
    public Contenido interactuarConBomba(){ return new ContenidoVacio(); }
}
