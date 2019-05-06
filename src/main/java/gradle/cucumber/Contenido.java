package gradle.cucumber;

public abstract class Contenido {

    public abstract void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino);
    public abstract Contenido interactuarConBomba();
    public abstract Boolean esSolido();
    public void tick(Juego juego){/*Por default no hacemos nada.*/};
}
