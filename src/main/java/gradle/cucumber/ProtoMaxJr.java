package gradle.cucumber;

public class ProtoMaxJr extends Enemigo{
    @Override
    public Contenido interactuarConBomba() {
        return new SaltarTodoTipoDePared();
    }
}

