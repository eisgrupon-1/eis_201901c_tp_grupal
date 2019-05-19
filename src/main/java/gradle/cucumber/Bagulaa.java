package gradle.cucumber;

public class Bagulaa extends Enemigo{
    @Override
    public Contenido interactuarConBomba(){
        return new LanzarBomba();
    }
}
