package gradle.cucumber;

public class ParedMelamina extends Contenido {
    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public void interactuarCon(Bomberman bomberman, Celda celda){
        //Bomberman queda en su lugar porque hay una pared.
    }
}
