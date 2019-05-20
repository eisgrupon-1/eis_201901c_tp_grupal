package gradle.cucumber;

public class PoderDefault extends Poder{

    @Override
    public Boolean esPoderDefault(){ return true; }

    @Override
    public void moverPersonaje(Juego juego, Posicion posicion) {
        juego.moverPersonaje(posicion);
    }

    @Override
    public Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion){ return posicion; };
}
