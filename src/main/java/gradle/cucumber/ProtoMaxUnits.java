package gradle.cucumber;

public class ProtoMaxUnits extends Enemigo{
    @Override
    public Contenido interactuarConBomba() {
        return new SaltarOlanzarBombas();
    }
}

