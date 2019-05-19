package gradle.cucumber;

public abstract class Poder extends Contenido{
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino) {
        juego.setPoderDeBomberman(this);
        juego.basicMoverPersonajeA(destino);
    }
    @Override
    public Contenido interactuarConBomba() { return new ContenidoVacio(); }

    @Override
    public Boolean esSolido() {
        return false;
    }

    public Boolean esPoderDefault(){ return false; }

    public abstract Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion);

}