package gradle.cucumber;

public class SaltarTodoTipoDePared extends Poder {

    @Override
    public void moverPersonaje(Juego juego, Posicion posicion) {
        juego.basicMoverPersonajeA(posicion);
    }

    @Override
    public Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion){ return posicion; }



}
