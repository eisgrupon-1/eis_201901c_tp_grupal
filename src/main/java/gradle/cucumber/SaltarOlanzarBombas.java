package gradle.cucumber;

public class SaltarOlanzarBombas extends Poder {

    @Override
    public Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion){ return new LanzarBomba().posicionParaLaBomba(posicion, direccion); }

}
