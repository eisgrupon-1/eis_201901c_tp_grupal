package gradle.cucumber;

public class ContenidoVacio extends Contenido {
    @Override
    public Boolean esSolido() {
        return false;
    }

    @Override
    public void interactuarCon(Bomberman bomberman, Celda celda){
        bomberman.basicMover(celda);
    }
}
