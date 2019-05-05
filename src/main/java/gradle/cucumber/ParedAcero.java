package gradle.cucumber;

public class ParedAcero extends Contenido{
    @Override
    public Boolean esSolido(){ return true; }

    @Override
    public void interactuarCon(Bomberman bomberman, Celda celda){
        //Bomberman queda en su lugar porque hay una pared.
    }
}
