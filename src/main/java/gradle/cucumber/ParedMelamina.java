package gradle.cucumber;

public class ParedMelamina extends Contenido {
    @Override
    public Boolean esSolido() {
        return true;
    }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){ /*Bomberman queda en su lugar porque hay una pared.*/ }
    @Override
    public Contenido interactuarConBomba(){ return new ContenidoVacio(); }
}
