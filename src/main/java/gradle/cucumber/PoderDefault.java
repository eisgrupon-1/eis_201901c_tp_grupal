package gradle.cucumber;

public class PoderDefault extends Poder{

    @Override
    public Boolean esPoderDefault(){ return true; }

    @Override
    public Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion){ return posicion; };
}
