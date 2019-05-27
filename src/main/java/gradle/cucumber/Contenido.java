package gradle.cucumber;

public abstract class Contenido {

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (other.getClass() == this.getClass()) return true;
        return false;
    }

    public abstract void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino);
    public abstract Contenido interactuarConBomba();
    public abstract Boolean esSolido();
}
