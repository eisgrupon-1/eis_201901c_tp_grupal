package gradle.cucumber;


public class Poder extends Contenido{


    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino) {
        juego.getPersonaje().addPoder(this);
    }

    @Override
    public Contenido interactuarConBomba() {
        return new ContenidoVacio();
    }

    @Override
    public Boolean esSolido() {
        return false;
    }
}