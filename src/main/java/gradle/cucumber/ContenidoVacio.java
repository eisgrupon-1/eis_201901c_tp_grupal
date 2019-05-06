package gradle.cucumber;

public class ContenidoVacio extends Contenido {
    @Override
    public Boolean esSolido() {
        return false;
    }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){ juego.basicMoverPersonajeA(destino); }
}
